package com.tg.UAkino.Club.ParserSites;
import com.tg.UAkino.Club.DateBase.Movies;
import com.tg.UAkino.Club.DateBase.MoviesRepository;
import org.jsoup.nodes.Document;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class Parser {
    @Autowired
    MoviesRepository resp;
    public static void main(String[] args) {
        //parseJson();
    }
    public void parseJson(){
        Movies movie = new Movies();
        long MoviesID=1;
        Document documet = null;
        String url = "https://rezka.ag/films/";
        for(long i=850; i<=1071;i++){
            String urlPage = url+"page/"+i+"/";
            try {
                documet = Jsoup.connect(urlPage).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
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
                /*System.out.println(elemnt.selectFirst("a").text());
                System.out.println(elemnt.select("div").get(1).text());

                System.out.println(splits[0]);ll
                System.out.println(splits[1]);
                System.out.println(splits[2]);
                System.out.println(elemnt.getElementsByAttribute("href").attr("href"));*/
                MoviesID++;
            }
        }
    }
    public void registerUser(){
        long i = 53932523523l;
        Movies movie = new Movies();
        movie.setMovieID(i);
        movie.setName("fghfyctyuyfhgctyyy");
        System.out.println(movie);
        resp.save(movie);
    }
}
