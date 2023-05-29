package com.tg.UAkino.Club.ParserSites;
import com.tg.UAkino.Club.DateBase.Movies;
import com.tg.UAkino.Club.DateBase.MoviesRepository;
import lombok.SneakyThrows;
import org.jsoup.nodes.Document;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class Parser { //Клас для збирання даних з сайту

    //Створення зміної та конструкцій для неї(БД)
    @Autowired
    MoviesRepository resp;
    @SneakyThrows //Анотація яка при компіляції заміняє обробку помилок щоб легше було читати код
    public void parseJsonFilms(){
        Movies movie = new Movies(); //Створення нового обєкта класс Movies(БД)
        long MoviesID=1; //Змінна для позначення ID фільму в БД
        Document documet = null; // Створення та ініциалізація зміної для подальшої роботи з нею
        String url = "https://rezka.ag/films/"; //Змінна типу String для посилання щоб зайти на сайт
        for(long i=0; i<=1071;i++){ //Цикл яку буде повторюватися 1070 раз для того щоб зібрати данні зі всіх потрібних сторінок
            String urlPage = url+"page/"+i+"/"; //Змінення поислання для переходу на іншу сторінку
            try { //попитка Підключитися до сайту та отримати данні в змінну Document з бібліотеки Jsoup
                documet = Jsoup.connect(urlPage).userAgent("Mozilla/5.0").get();
            } catch (IOException e) { //Якщо вийшла помилка то вивести її в консоль
                throw new RuntimeException(e);
            }
            var Elements = documet.select("div.b-content__inline_item-link"); //Створення зміної типу Elements та
                                                             // присвоєння їй ЗНАЧЕНЬ з Html коду з потрібний класом

            for(var elemnt :Elements){ //Цикл буду робити стільки скільки елементів в змінні Elements, та присвоїти Новій змінні
                                        //змінні один лемент для подальшого його опрацювання
                String str = elemnt.select("div").get(1).text(); //Доставання з нового елементу потрібний елемент
                                                        //який знаходиться в другому "div" та перетворення його в текст
                String[] splits = str.split(", ");  //Створення масиву типу String та розділення тексту на окремі
                                                            //частинки для запису в БД
                movie.setMovieID(MoviesID);  //Присвоєння фільму Айди
                movie.setName(elemnt.selectFirst("a").text()); //Присвоєння фільму Імя з елементу та перетворення на текст
                if(splits.length>=3){ //Якщо в масиві 3 елементи то Присвоїти фільму Рік Країну та Жанр
                    movie.setYear(splits[0]);
                    movie.setCountry(splits[1]);
                    movie.setZanr(splits[2]);
                }else{ //Інакже тільки Рік так Жанр(В деяких не було країни)
                    movie.setYear(splits[0]);
                    movie.setZanr(splits[1]);
                }

                movie.setUrl(elemnt.getElementsByAttribute("href").attr("href"));//присвоєння фільму
                                                        // посилання з елементу "href"(html kod)
                resp.save(movie);//Збереження фільму з данними в БД
                System.out.println(MoviesID); //Вивести в консоль ID фільму для зручності
                MoviesID++; // добавити до зміної MoviesId 1 для наступного фільму
            }
            Thread.sleep(600); //Затримка для того щоб сайт не дав ошибку що працю бот а не людина
        }
    }
}
