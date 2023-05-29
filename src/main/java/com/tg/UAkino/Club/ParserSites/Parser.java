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
public class Parser {
    @Autowired
    MoviesRepository resp;
    @SneakyThrows
    public void parseJsonFilms(){
        Movies movie = new Movies();
        long MoviesID=1;
        Document documet = null;
        String url = "https://rezka.ag/films/";
        for(long i=0; i<=1071;i++){
            String urlPage = url+"page/"+i+"/";
            try {
                documet = Jsoup.connect(urlPage).userAgent("Mozilla/5.0").get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            var Elements = documet.select("div.b-content__inline_item-link");
            for(var elemnt :Elements){
                String str = elemnt.select("div").get(1).text();
                String[] splits = str.split(", ");
                movie.setMovieID(MoviesID);
                movie.setName(elemnt.selectFirst("a").text());
                if(splits.length>=3){
                    movie.setYear(splits[0]);
                    movie.setCountry(splits[1]);
                    movie.setZanr(splits[2]);
                }else{
                    movie.setYear(splits[0]);
                    movie.setZanr(splits[1]);
                }

                movie.setUrl(elemnt.getElementsByAttribute("href").attr("href"));
                resp.save(movie);
                System.out.println(MoviesID);
                MoviesID++;
            }
            Thread.sleep(600);
        }
    }
}
