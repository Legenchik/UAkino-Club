package com.tg.UAkino.Club.configBot;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@Data
@PropertySource("application.properties") //підключення файла з найсторйками
public class BotConfig {

    @Value("${bot.name}")  //присвоєння змінні значення з файлу з настройками
    String botName;

    @Value("${bot.token}")  //присвоєння змінні значення з файлу з настройками
    String token;

    @Value("${bot.owner}")  //присвоєння змінні значення з файлу з настройками
    Long ownerId;
}
