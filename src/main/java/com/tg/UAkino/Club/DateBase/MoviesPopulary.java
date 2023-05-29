package com.tg.UAkino.Club.DateBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "MoviesPopulary")
public class MoviesPopulary {

    @Id
    private Long MovieID;

    private String Name;

    private String Year;
    private String Country;

    private String Zanr;
    private String url;



    @Override
    public String toString() {
        return "User{" +
                "chatId=" + MovieID +
                ", Name movie='" + Name + '\'' +
                ", Year movie='" + Year + '\'' +
                ", Country ='" + Country + '\'' +
                ", Zanr ='" + Zanr + '\'' +
                ", url=" + url +
                '}';
    }
}
