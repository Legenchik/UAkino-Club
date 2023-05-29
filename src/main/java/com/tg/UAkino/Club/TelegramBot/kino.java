package com.tg.UAkino.Club.TelegramBot;

import com.tg.UAkino.Club.DateBase.Movies;
import com.tg.UAkino.Club.DateBase.MoviesPopulary;
import com.tg.UAkino.Club.DateBase.MoviesPopularyRepository;
import com.tg.UAkino.Club.DateBase.MoviesRepository;
import com.tg.UAkino.Club.ParserSites.Parser;
import com.tg.UAkino.Club.ParserSites.ParserPopulary;
import com.tg.UAkino.Club.TelegramBot.CallBackData.InlineKeyboard;
import com.tg.UAkino.Club.configBot.BotConfig;
import lombok.SneakyThrows;
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
    Parser parser = new Parser();
    @Autowired
    ParserPopulary ParserP = new ParserPopulary();

    @Autowired
    MoviesRepository resp;
    @Autowired
    MoviesPopularyRepository respPopulary;

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
        InlineKeyboard inlineKeyboard = new InlineKeyboard(config);
        //SortCallbackData sortData = new SortCallbackData(config);
        if (update.hasMessage() && update.getMessage().hasText()){
            Message message =update.getMessage();
            long chatId = message.getChatId();
            String messageText = message.getText();
            switch (messageText){
                case "/start":
                    Head(message);
                    break;
                case"Рандомний":
                    RandomaiserKino(chatId);
                    break;
                case"Популярний":
                    inlineKeyboard.ChosenPopulary(chatId);
                    break;
                default:
                    //parser.parseJson();// НЕЗАПУСКАТЬ СКРИПТ
                    //ParserP.parseJsonPopulary();// НЕЗАПУСКАТЬ СКРИПТ
                    sendMovieByCountry(chatId,"Япония",1);
            }
        }else if(update.hasCallbackQuery()) {
            String callbackDataSTR = update.getCallbackQuery().getData().toString();
            Message callbackData = update.getCallbackQuery().getMessage();
            long messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            System.out.println(callbackDataSTR);
            switch (callbackDataSTR) {
                case "TOP_Films":
                    inlineKeyboard.PopularyChoiceTop(chatId,messageId);
                    break;
                case "TOP_Films_By_Country":
                    inlineKeyboard.PopularyChoiceTopCountry(chatId,messageId);
                    break;
                case "TOP-10":
                    Top_10(chatId);
                    break;
                case "TOP-50":
                    Top_50(chatId);
                    break;
                case "TOP-ALL":
                    Top_All(chatId);
                    break;
                case "TOP-10-Country":
                    inlineKeyboard.PopularyChoiceTop_10_CountryNames(chatId,messageId);
                    break;
                case "TOP-50-Country":
                    inlineKeyboard.PopularyChoiceTop_50_CountryNames(chatId,messageId);        
                    break;
                case "TOP-ALL-Country":
                    inlineKeyboard.PopularyChoiceTop_All_CountryNames(chatId,messageId);
                    break;
                case "":
                    break;
                default:
                    sort(chatId,callbackDataSTR);
            }
        }
    }

    public void sort(long chatId,String data){
        switch (data){
            case"Australia_10":
                sendMovieByCountry(chatId,"Австралия",10);
                break;
            case"Bubbles_10":
                sendMovieByCountry(chatId,"Беларусь",10);
                break;
            case"Great_Britain_10":
                sendMovieByCountry(chatId,"Великобритания",10);
                break;
            case"Vietnam_10":
                sendMovieByCountry(chatId,"Вьетнам",10);
                break;
            case"Germany_10":
                sendMovieByCountry(chatId,"Германия",10);
                break;
            case"India_10":
                sendMovieByCountry(chatId,"Индия",10);
                break;
            case"Spain_10":
                sendMovieByCountry(chatId,"Испания",10);
                break;
            case"Italy_10":
                sendMovieByCountry(chatId,"Италия",10);
                break;
            case"Kazakhstan_10":
                sendMovieByCountry(chatId,"Казахстан",10);
                break;
            case"Canada_10":
                sendMovieByCountry(chatId,"Канада",10);
                break;
            case"China_10":
                sendMovieByCountry(chatId,"Китай",10);
                break;
            case"South_Korea_10":
                sendMovieByCountry(chatId,"Корея Южная",10);
                break;
            case"Lithuania_10":
                sendMovieByCountry(chatId,"Литва",10);
                break;
            case"Mexico_10":
                sendMovieByCountry(chatId,"Мексика",10);
                break;
            case"Nigeria_10":
                sendMovieByCountry(chatId,"Нигерия",10);
                break;
            case"Netherlands_10":
                sendMovieByCountry(chatId,"Нидерланды",10);
                break;
            case"Norway_10":
                sendMovieByCountry(chatId,"Норвегия",10);
                break;
            case"Poland_10":
                sendMovieByCountry(chatId,"Польша",10);
                break;
            case"Terorist_10":
                sendMovieByCountry(chatId,"Россия",10);
                break;
            case"USA_10":
                sendMovieByCountry(chatId,"США",10);
                break;
            case"Thailand_10":
                sendMovieByCountry(chatId,"Таиланд",10);
                break;
            case"Turkey_10":
                sendMovieByCountry(chatId,"Турция",10);
                break;
            case"Ukraine_10":
                sendMovieByCountry(chatId,"Украина",10);
                break;
            case"Philippines_10":
                sendMovieByCountry(chatId,"Филиппины",10);
                break;
            case"France_10":
                sendMovieByCountry(chatId,"Франция",10);
                break;
            case"Chile_10":
                sendMovieByCountry(chatId,"Чили",10);
                break;
            case"Sweden_10":
                sendMovieByCountry(chatId,"Швеция",10);
                break;
            case"Japan_10":
                sendMovieByCountry(chatId,"Япония",10);
                break;
            case"Australia_50":
                sendMovieByCountry(chatId,"Австралия",50);
                break;
            case"Bubbles_50":
                sendMovieByCountry(chatId,"Беларусь",50);
                break;
            case"Great_Britain_50":
                sendMovieByCountry(chatId,"Великобритания",50);
                break;
            case"Vietnam_50":
                sendMovieByCountry(chatId,"Вьетнам",50);
                break;
            case"Germany_50":
                sendMovieByCountry(chatId,"Германия",50);
                break;
            case"India_50":
                sendMovieByCountry(chatId,"Индия",50);
                break;
            case"Spain_50":
                sendMovieByCountry(chatId,"Испания",50);
                break;
            case"Italy_50":
                sendMovieByCountry(chatId,"Италия",50);
                break;
            case"Kazakhstan_50":
                sendMovieByCountry(chatId,"Казахстан",50);
                break;
            case"Canada_50":
                sendMovieByCountry(chatId,"Канада",50);
                break;
            case"China_50":
                sendMovieByCountry(chatId,"Китай",50);
                break;
            case"South_Korea_50":
                sendMovieByCountry(chatId,"Корея Южная",50);
                break;
            case"Lithuania_50":
                sendMovieByCountry(chatId,"Литва",50);
                break;
            case"Mexico_50":
                sendMovieByCountry(chatId,"Мексика",50);
                break;
            case"Nigeria_50":
                sendMovieByCountry(chatId,"Нигерия",50);
                break;
            case"Netherlands_50":
                sendMovieByCountry(chatId,"Нидерланды",50);
                break;
            case"Norway_50":
                sendMovieByCountry(chatId,"Норвегия",50);
                break;
            case"Poland_50":
                sendMovieByCountry(chatId,"Польша",50);
                break;
            case"Terorist_50":
                sendMovieByCountry(chatId,"Россия",50);
                break;
            case"USA_50":
                sendMovieByCountry(chatId,"США",50);
                break;
            case"Thailand_50":
                sendMovieByCountry(chatId,"Таиланд",50);
                break;
            case"Turkey_50":
                sendMovieByCountry(chatId,"Турция",50);
                break;
            case"Ukraine_50":
                sendMovieByCountry(chatId,"Украина",50);
                break;
            case"Philippines_50":
                sendMovieByCountry(chatId,"Филиппины",50);
                break;
            case"France_50":
                sendMovieByCountry(chatId,"Франция",50);
                break;
            case"Chile_50":
                sendMovieByCountry(chatId,"Чили",50);
                break;
            case"Sweden_50":
                sendMovieByCountry(chatId,"Швеция",50);
                break;
            case"Japan_50":
                sendMovieByCountry(chatId,"Япония",50);
                break;
            case"Australia_200":
                sendMovieByCountry(chatId,"Австралия",200);
                break;
            case"Bubbles_200":
                sendMovieByCountry(chatId,"Беларусь",200);
                break;
            case"Great_Britain_200":
                sendMovieByCountry(chatId,"Великобритания",200);
                break;
            case"Vietnam_200":
                sendMovieByCountry(chatId,"Вьетнам",200);
                break;
            case"Germany_200":
                sendMovieByCountry(chatId,"Германия",200);
                break;
            case"India_200":
                sendMovieByCountry(chatId,"Индия",200);
                break;
            case"Spain_200":
                sendMovieByCountry(chatId,"Испания",200);
                break;
            case"Italy_200":
                sendMovieByCountry(chatId,"Италия",200);
                break;
            case"Kazakhstan_200":
                sendMovieByCountry(chatId,"Казахстан",200);
                break;
            case"Canada_200":
                sendMovieByCountry(chatId,"Канада",200);
                break;
            case"China_200":
                sendMovieByCountry(chatId,"Китай",200);
                break;
            case"South_Korea_200":
                sendMovieByCountry(chatId,"Корея Южная",200);
                break;
            case"Lithuania_200":
                sendMovieByCountry(chatId,"Литва",200);
                break;
            case"Mexico_200":
                sendMovieByCountry(chatId,"Мексика",200);
                break;
            case"Nigeria_200":
                sendMovieByCountry(chatId,"Нигерия",200);
                break;
            case"Netherlands_200":
                sendMovieByCountry(chatId,"Нидерланды",200);
                break;
            case"Norway_200":
                sendMovieByCountry(chatId,"Норвегия",200);
                break;
            case"Poland_200":
                sendMovieByCountry(chatId,"Польша",200);
                break;
            case"Terorist_200":
                sendMovieByCountry(chatId,"Россия",200);
                break;
            case"USA_200":
                sendMovieByCountry(chatId,"США",200);
                break;
            case"Thailand_200":
                sendMovieByCountry(chatId,"Таиланд",200);
                break;
            case"Turkey_200":
                sendMovieByCountry(chatId,"Турция",200);
                break;
            case"Ukraine_200":
                sendMovieByCountry(chatId,"Украина",200);
                break;
            case"Philippines_200":
                sendMovieByCountry(chatId,"Филиппины",200);
                break;
            case"France_200":
                sendMovieByCountry(chatId,"Франция",200);
                break;
            case"Chile_200":
                sendMovieByCountry(chatId,"Чили",200);
                break;
            case"Sweden_200":
                sendMovieByCountry(chatId,"Швеция",200);
                break;
            case"Japan_200":
                sendMovieByCountry(chatId,"Япония",200);
                break;
            default:

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
    public void ExecuteSendMessage(SendMessage sendMessage){
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
    private void RandomaiserKino(long chatId){
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

    private void Top_10(long chatId){
        int ten = 10;
        var moviesPopulary = respPopulary.findAll();
        for(MoviesPopulary moviePopulary:moviesPopulary){
            if(ten>=moviePopulary.getMovieID()){
                String toSend="Назва фільму: "+moviePopulary.getName()+"\n"+
                        "Країна: "+moviePopulary.getCountry()+"\n"+
                        "Рік: "+moviePopulary.getYear()+"\n"+
                        "Жанр: "+moviePopulary.getZanr()+"\n"+
                        moviePopulary.getUrl();
                sendMessage(chatId,toSend);
            }else{
                break;
            }
        }
    }

    public void Top_50(long chatId){
        int fift = 50;
        var moviesPopulary = respPopulary.findAll();
        for(MoviesPopulary moviePopulary:moviesPopulary){
            if(fift>=moviePopulary.getMovieID()){
                String toSend="Назва фільму: "+moviePopulary.getName()+"\n"+
                        "Країна: "+moviePopulary.getCountry()+"\n"+
                        "Рік: "+moviePopulary.getYear()+"\n"+
                        "Жанр: "+moviePopulary.getZanr()+"\n"+
                        moviePopulary.getUrl();
                sendMessage(chatId,toSend);
            }else{
                break;
            }
        }
    }

    @SneakyThrows
    private void Top_All(long chatId){
        var moviesPopulary = respPopulary.findAll();
        for(MoviesPopulary moviePopulary:moviesPopulary){
            String toSend="Назва фільму: "+moviePopulary.getName()+"\n"+
                    "Країна: "+moviePopulary.getCountry()+"\n"+
                    "Рік: "+moviePopulary.getYear()+"\n"+
                    "Жанр: "+moviePopulary.getZanr()+"\n"+
                    moviePopulary.getUrl();
            sendMessage(chatId,toSend);
            Thread.sleep(100);
        }
    }//TODO зробити сторінки для виведення фільмів ошибка кількості відправлення телеграм.

    @SneakyThrows
    public void sendMovieByCountry(long chatId, String Country, int numbersTop){
        int checkSend=1;
        var moviesPopulary = respPopulary.findAll();
        for(MoviesPopulary moviePopulary:moviesPopulary){
            if(moviePopulary.getCountry().contains(Country)){
                if(numbersTop>=checkSend){
                    String toSend="Назва фільму: "+moviePopulary.getName()+"\n"+
                            "Країна: "+moviePopulary.getCountry()+"\n"+
                            "Рік: "+moviePopulary.getYear()+"\n"+
                            "Жанр: "+moviePopulary.getZanr()+"\n"+
                            moviePopulary.getUrl();
                    sendMessage(chatId,toSend);
                    Thread.sleep(100);
                    checkSend++;
                }else{
                    break;
                }
            }
        }
    }
}
