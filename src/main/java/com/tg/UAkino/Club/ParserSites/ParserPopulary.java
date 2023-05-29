package com.tg.UAkino.Club.ParserSites;

import com.tg.UAkino.Club.DateBase.Movies;
import com.tg.UAkino.Club.DateBase.MoviesPopulary;
import com.tg.UAkino.Club.DateBase.MoviesPopularyRepository;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;

;

@Repository
@Component
public class ParserPopulary {
    @Autowired
    MoviesPopularyRepository MoviesPopulary;
    @SneakyThrows
    public void parseJsonPopulary(){
        MoviesPopulary moviePopulary = new MoviesPopulary();
        long MoviesID=1;
        Document documet = null;
        String url = "https://rezka.ag/films/best/2023/";
        for(long i=0; i<=8;i++){
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
                moviePopulary.setMovieID(MoviesID);
                moviePopulary.setName(elemnt.selectFirst("a").text());
                if(splits.length>=3){
                    moviePopulary.setYear(splits[0]);
                    moviePopulary.setCountry(splits[1]);
                    moviePopulary.setZanr(splits[2]);
                }else{
                    moviePopulary.setYear(splits[0]);
                    moviePopulary.setZanr(splits[1]);
                }

                moviePopulary.setUrl(elemnt.getElementsByAttribute("href").attr("href"));
                MoviesPopulary.save(moviePopulary);
                MoviesID++;
            }
            System.out.println(Elements);
            Thread.sleep(600);
        }
    }
}
