package com.tg.UAkino.Club.TelegramBot;

import com.tg.UAkino.Club.DateBase.Movies;
import com.tg.UAkino.Club.DateBase.MoviesRepository;
import com.tg.UAkino.Club.ParserSites.Parser;
import com.tg.UAkino.Club.configBot.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class kino extends TelegramLongPollingBot {
    final BotConfig config;
    @Autowired
    Parser p = new Parser();

    @Autowired
    MoviesRepository resp;

    public kino(BotConfig config) {
        this.config = config;
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            Message message =update.getMessage();
            long chatId = message.getChatId();
            String messageText = message.getText();
            switch (messageText){
                case "/start":
                    Head(message);
                case"Рандомний":
                    Randomaiser(chatId);
                default:
                    //p.parseJson(); НЕЗАПУСКАТЬ СКРИПТ
                    //p.registerUser();
            }
        }
    }
    public void sendMessage(long chatId,String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(chatId);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private void Head(Message message) {
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup reply = new ReplyKeyboardMarkup();
        reply.setResizeKeyboard(true);
        List<KeyboardRow> keyRowList = new ArrayList<>();
        KeyboardRow keyRow1 = new KeyboardRow();
        keyRow1.add("За назвою");
        keyRow1.add("Популярний");
        keyRow1.add("Рандомний");
        keyRowList.add(keyRow1);

        reply.setKeyboard(keyRowList);
        sendMessage.setReplyMarkup(reply);
        sendMessage.setText("Виберіть");
        sendMessage.setChatId(message.getChatId());
        try {
            execute(sendMessage);
        } catch (TelegramApiException e1) {
            e1.printStackTrace();
        }
    }
    private void Randomaiser(long chatId){
        long ran = (long) (Math.random() * 38556);
        var movies = resp.findAll();
        for(Movies movie:movies){
            if(ran==movie.getMovieID()){
                String toSend="Назва фільму: "+movie.getName()+"\n"+
                        "Країна: "+movie.getCountry()+"\n"+
                        "Рік: "+movie.getYear()+"\n"+
                        "Жанр: "+movie.getZanr()+"\n"+
                        movie.getUrl();
                sendMessage(chatId,toSend);
            }
        }
    }
}
