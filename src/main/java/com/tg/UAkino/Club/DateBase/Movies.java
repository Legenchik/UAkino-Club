package com.tg.UAkino.Club.DateBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter //Антотація для створення конструкцій Get, створить після того як запуститься проект
@Setter //Антотація для створення конструкцій Set
@Entity(name = "Movies")  //Назва для таблиці в БД
public class Movies {


    //Змінні яку будуть відображати та для хапису в БД
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
