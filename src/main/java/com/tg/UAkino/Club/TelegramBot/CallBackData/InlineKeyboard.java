package com.tg.UAkino.Club.TelegramBot.CallBackData;

import com.tg.UAkino.Club.Sender.EditMessageSender;
import com.tg.UAkino.Club.Sender.ExecuteMessageSender;
import com.tg.UAkino.Club.TelegramBot.kino;
import com.tg.UAkino.Club.configBot.BotConfig;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineKeyboard {
    final BotConfig config;
    public InlineKeyboard(BotConfig config) {
        this.config = config;
        executeMessageSender = new ExecuteMessageSender(this.config);
        editMessageSender = new EditMessageSender(this.config);
    }
    ExecuteMessageSender executeMessageSender;
    EditMessageSender editMessageSender;
    public void ChosenPopulary(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Виберіть що більше вам підходить");
        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();
        var TopFilms = new InlineKeyboardButton();
        var TopFilmsByCountry = new InlineKeyboardButton();
        TopFilms.setText("Топ");
        TopFilms.setCallbackData("TOP_Films");
        TopFilmsByCountry.setText("Топ за країною");
        TopFilmsByCountry.setCallbackData("TOP_Films_By_Country");
        rowInLine.add(TopFilms);
        rowInLine.add(TopFilmsByCountry);
        rowsInLine.add(rowInLine);
        markupInLine.setKeyboard(rowsInLine);
        message.setReplyMarkup(markupInLine);
        executeMessageSender.ExecuteSendMessage(message);
    }

    public void PopularyChoiceTop(long chatId,long messageId) {
        EditMessageText messageText = new EditMessageText();
        messageText.setChatId(String.valueOf(chatId));
        messageText.setText("Виберіть");
        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();
        var Top10 = new InlineKeyboardButton();
        var Top50 = new InlineKeyboardButton();
        var AllTop = new InlineKeyboardButton();
        Top10.setText("Топ-10");
        Top10.setCallbackData("TOP-10");
        Top50.setText("Топ-50");
        Top50.setCallbackData("TOP-50");
        AllTop.setText("Весь Топ");
        AllTop.setCallbackData("TOP-ALL");
        rowInLine.add(Top10);
        rowInLine.add(Top50);
        rowInLine.add(AllTop);
        rowsInLine.add(rowInLine);
        markupInLine.setKeyboard(rowsInLine);
        messageText.setReplyMarkup(markupInLine);
        messageText.setMessageId((int)messageId);
        editMessageSender.editMessageSender(messageText);
    }

    public void PopularyChoiceTopCountry(long chatId,long messageId) {
        EditMessageText messageText = new EditMessageText();
        messageText.setChatId(String.valueOf(chatId));
        messageText.setText("Виберіть");
        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();
        var Top10 = new InlineKeyboardButton();
        var Top50 = new InlineKeyboardButton();
        var AllTop = new InlineKeyboardButton();
        Top10.setText("Топ-10");
        Top10.setCallbackData("TOP-10-Country");
        Top50.setText("Топ-50");
        Top50.setCallbackData("TOP-50-Country");
        AllTop.setText("Весь Топ");
        AllTop.setCallbackData("TOP-ALL-Country");
        rowInLine.add(Top10);
        rowInLine.add(Top50);
        rowInLine.add(AllTop);
        rowsInLine.add(rowInLine);
        markupInLine.setKeyboard(rowsInLine);
        messageText.setReplyMarkup(markupInLine);
        messageText.setMessageId((int)messageId);
        editMessageSender.editMessageSender(messageText);
    }

    public void PopularyChoiceTop_10_CountryNames(long chatId,long messageId) {
        EditMessageText messageText = new EditMessageText();
        messageText.setChatId(String.valueOf(chatId));
        messageText.setText("Виберіть країну");
        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();

        List<InlineKeyboardButton> rowInLine = new ArrayList<>();
        var CountryName1 = new InlineKeyboardButton();
        var CountryName2 = new InlineKeyboardButton();
        var CountryName3 = new InlineKeyboardButton();

        CountryName1.setText("Австралия");
        CountryName1.setCallbackData("Australia_10");
        CountryName2.setText("Бульбаші");
        CountryName2.setCallbackData("Bubbles_10");
        CountryName3.setText("Великобритания");
        CountryName3.setCallbackData("Great_Britain_10");

        rowInLine.add(CountryName1);
        rowInLine.add(CountryName2);
        rowInLine.add(CountryName3);

        rowsInLine.add(rowInLine);

        List<InlineKeyboardButton> rowInLine2 = new ArrayList<>();
        var CountryName4 = new InlineKeyboardButton();
        var CountryName5 = new InlineKeyboardButton();
        var CountryName6 = new InlineKeyboardButton();

        CountryName4.setText("Вьетнам");
        CountryName4.setCallbackData("Vietnam_10");
        CountryName5.setText("Германия");
        CountryName5.setCallbackData("Germany_10");
        CountryName6.setText("Индия");
        CountryName6.setCallbackData("India_10");

        rowInLine2.add(CountryName4);
        rowInLine2.add(CountryName5);
        rowInLine2.add(CountryName6);

        rowsInLine.add(rowInLine2);

        List<InlineKeyboardButton> rowInLine3 = new ArrayList<>();
        var CountryName7 = new InlineKeyboardButton();
        var CountryName8 = new InlineKeyboardButton();
        var CountryName9 = new InlineKeyboardButton();

        CountryName7.setText("Испания");
        CountryName7.setCallbackData("Spain_10");
        CountryName8.setText("Италия");
        CountryName8.setCallbackData("Italy_10");
        CountryName9.setText("Казахстан");
        CountryName9.setCallbackData("Kazakhstan_10");

        rowInLine3.add(CountryName7);
        rowInLine3.add(CountryName8);
        rowInLine3.add(CountryName9);

        rowsInLine.add(rowInLine3);

        List<InlineKeyboardButton> rowInLine4 = new ArrayList<>();
        var CountryName10 = new InlineKeyboardButton();
        var CountryName11= new InlineKeyboardButton();
        var CountryName12 = new InlineKeyboardButton();

        CountryName10.setText("Канада");
        CountryName10.setCallbackData("Canada_10");
        CountryName11.setText("Китай");
        CountryName11.setCallbackData("China_10");
        CountryName12.setText("Корея Южная");
        CountryName12.setCallbackData("South_Korea_10");

        rowInLine4.add(CountryName10);
        rowInLine4.add(CountryName11);
        rowInLine4.add(CountryName12);

        rowsInLine.add(rowInLine4);

        List<InlineKeyboardButton> rowInLine5 = new ArrayList<>();
        var CountryName13 = new InlineKeyboardButton();
        var CountryName14= new InlineKeyboardButton();
        var CountryName15 = new InlineKeyboardButton();

        CountryName13.setText("Литва");
        CountryName13.setCallbackData("Lithuania_10");
        CountryName14.setText("Мексика");
        CountryName14.setCallbackData("Mexico_10");
        CountryName15.setText("Нигерия");
        CountryName15.setCallbackData("Nigeria_10");

        rowInLine5.add(CountryName13);
        rowInLine5.add(CountryName14);
        rowInLine5.add(CountryName15);

        rowsInLine.add(rowInLine5);

        List<InlineKeyboardButton> rowInLine6 = new ArrayList<>();
        var CountryName16 = new InlineKeyboardButton();
        var CountryName17= new InlineKeyboardButton();
        var CountryName18 = new InlineKeyboardButton();

        CountryName16.setText("Нидерланды");
        CountryName16.setCallbackData("Netherlands_10");
        CountryName17.setText("Норвегия");
        CountryName17.setCallbackData("Norway_10");
        CountryName18.setText("Польша");
        CountryName18.setCallbackData("Poland_10");

        rowInLine6.add(CountryName16);
        rowInLine6.add(CountryName17);
        rowInLine6.add(CountryName18);

        rowsInLine.add(rowInLine6);

        List<InlineKeyboardButton> rowInLine7 = new ArrayList<>();
        var CountryName19 = new InlineKeyboardButton();
        var CountryName20= new InlineKeyboardButton();
        var CountryName21 = new InlineKeyboardButton();

        CountryName19.setText("Терористи");
        CountryName19.setCallbackData("Terorist_10");
        CountryName20.setText("США");
        CountryName20.setCallbackData("USA_10");
        CountryName21.setText("Таиланд");
        CountryName21.setCallbackData("Thailand_10");

        rowInLine7.add(CountryName19);
        rowInLine7.add(CountryName20);
        rowInLine7.add(CountryName21);

        rowsInLine.add(rowInLine7);

        List<InlineKeyboardButton> rowInLine8 = new ArrayList<>();
        var CountryName22 = new InlineKeyboardButton();
        var CountryName23= new InlineKeyboardButton();
        var CountryName24 = new InlineKeyboardButton();

        CountryName22.setText("Турция");
        CountryName22.setCallbackData("Turkey_10");
        CountryName23.setText("Рідна Україна");
        CountryName23.setCallbackData("Ukraine_10");
        CountryName24.setText("Филиппины");
        CountryName24.setCallbackData("Philippines_10");

        rowInLine8.add(CountryName22);
        rowInLine8.add(CountryName23);
        rowInLine8.add(CountryName24);

        rowsInLine.add(rowInLine8);

        List<InlineKeyboardButton> rowInLine9 = new ArrayList<>();
        var CountryName25 = new InlineKeyboardButton();
        var CountryName26= new InlineKeyboardButton();
        var CountryName27 = new InlineKeyboardButton();

        CountryName25.setText("Франция");
        CountryName25.setCallbackData("France_10");
        CountryName26.setText("Чили");
        CountryName26.setCallbackData("Chile_10");
        CountryName27.setText("Швеция");
        CountryName27.setCallbackData("Sweden_10");

        rowInLine9.add(CountryName25);
        rowInLine9.add(CountryName26);
        rowInLine9.add(CountryName27);

        rowsInLine.add(rowInLine9);

        List<InlineKeyboardButton> rowInLine10 = new ArrayList<>();
        var CountryName28 = new InlineKeyboardButton();

        CountryName28.setText("Япония");
        CountryName28.setCallbackData("Japan_10");

        rowInLine10.add(CountryName28);

        rowsInLine.add(rowInLine10);

        markupInLine.setKeyboard(rowsInLine);
        messageText.setReplyMarkup(markupInLine);
        messageText.setMessageId((int)messageId);
        editMessageSender.editMessageSender(messageText);
    }

    public void PopularyChoiceTop_50_CountryNames(long chatId,long messageId) {
        EditMessageText messageText = new EditMessageText();
        messageText.setChatId(String.valueOf(chatId));
        messageText.setText("Виберіть країну");
        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();

        List<InlineKeyboardButton> rowInLine = new ArrayList<>();
        var CountryName1 = new InlineKeyboardButton();
        var CountryName2 = new InlineKeyboardButton();
        var CountryName3 = new InlineKeyboardButton();

        CountryName1.setText("Австралия");
        String s = "50";
        CountryName1.setCallbackData("Australia_" + s);
        CountryName2.setText("Бульбаші");
        CountryName2.setCallbackData("Bubbles_" + s);
        CountryName3.setText("Великобритания");
        CountryName3.setCallbackData("Great_Britain_" + s);

        rowInLine.add(CountryName1);
        rowInLine.add(CountryName2);
        rowInLine.add(CountryName3);

        rowsInLine.add(rowInLine);

        List<InlineKeyboardButton> rowInLine2 = new ArrayList<>();
        var CountryName4 = new InlineKeyboardButton();
        var CountryName5 = new InlineKeyboardButton();
        var CountryName6 = new InlineKeyboardButton();

        CountryName4.setText("Вьетнам");
        CountryName4.setCallbackData("Vietnam_" + s);
        CountryName5.setText("Германия");
        CountryName5.setCallbackData("Germany_" + s);
        CountryName6.setText("Индия");
        CountryName6.setCallbackData("India_" + s);

        rowInLine2.add(CountryName4);
        rowInLine2.add(CountryName5);
        rowInLine2.add(CountryName6);

        rowsInLine.add(rowInLine2);

        List<InlineKeyboardButton> rowInLine3 = new ArrayList<>();
        var CountryName7 = new InlineKeyboardButton();
        var CountryName8 = new InlineKeyboardButton();
        var CountryName9 = new InlineKeyboardButton();

        CountryName7.setText("Испания");
        CountryName7.setCallbackData("Spain_" + s);
        CountryName8.setText("Италия");
        CountryName8.setCallbackData("Italy_" + s);
        CountryName9.setText("Казахстан");
        CountryName9.setCallbackData("Kazakhstan_" + s);

        rowInLine3.add(CountryName7);
        rowInLine3.add(CountryName8);
        rowInLine3.add(CountryName9);

        rowsInLine.add(rowInLine3);

        List<InlineKeyboardButton> rowInLine4 = new ArrayList<>();
        var CountryName10 = new InlineKeyboardButton();
        var CountryName11= new InlineKeyboardButton();
        var CountryName12 = new InlineKeyboardButton();

        CountryName10.setText("Канада");
        CountryName10.setCallbackData("Canada_" + s);
        CountryName11.setText("Китай");
        CountryName11.setCallbackData("China_" + s);
        CountryName12.setText("Корея Южная");
        CountryName12.setCallbackData("South_Korea_" + s);

        rowInLine4.add(CountryName10);
        rowInLine4.add(CountryName11);
        rowInLine4.add(CountryName12);

        rowsInLine.add(rowInLine4);

        List<InlineKeyboardButton> rowInLine5 = new ArrayList<>();
        var CountryName13 = new InlineKeyboardButton();
        var CountryName14= new InlineKeyboardButton();
        var CountryName15 = new InlineKeyboardButton();

        CountryName13.setText("Литва");
        CountryName13.setCallbackData("Lithuania_" + s);
        CountryName14.setText("Мексика");
        CountryName14.setCallbackData("Mexico_" + s);
        CountryName15.setText("Нигерия");
        CountryName15.setCallbackData("Nigeria_" + s);

        rowInLine5.add(CountryName13);
        rowInLine5.add(CountryName14);
        rowInLine5.add(CountryName15);

        rowsInLine.add(rowInLine5);

        List<InlineKeyboardButton> rowInLine6 = new ArrayList<>();
        var CountryName16 = new InlineKeyboardButton();
        var CountryName17= new InlineKeyboardButton();
        var CountryName18 = new InlineKeyboardButton();

        CountryName16.setText("Нидерланды");
        CountryName16.setCallbackData("Netherlands_" + s);
        CountryName17.setText("Норвегия");
        CountryName17.setCallbackData("Norway_" + s);
        CountryName18.setText("Польша");
        CountryName18.setCallbackData("Poland_" + s);

        rowInLine6.add(CountryName16);
        rowInLine6.add(CountryName17);
        rowInLine6.add(CountryName18);

        rowsInLine.add(rowInLine6);

        List<InlineKeyboardButton> rowInLine7 = new ArrayList<>();
        var CountryName19 = new InlineKeyboardButton();
        var CountryName20= new InlineKeyboardButton();
        var CountryName21 = new InlineKeyboardButton();

        CountryName19.setText("Терористи");
        CountryName19.setCallbackData("Terorist_" + s);
        CountryName20.setText("США");
        CountryName20.setCallbackData("USA_" + s);
        CountryName21.setText("Таиланд");
        CountryName21.setCallbackData("Thailand_" + s);

        rowInLine7.add(CountryName19);
        rowInLine7.add(CountryName20);
        rowInLine7.add(CountryName21);

        rowsInLine.add(rowInLine7);

        List<InlineKeyboardButton> rowInLine8 = new ArrayList<>();
        var CountryName22 = new InlineKeyboardButton();
        var CountryName23= new InlineKeyboardButton();
        var CountryName24 = new InlineKeyboardButton();

        CountryName22.setText("Турция");
        CountryName22.setCallbackData("Turkey_" + s);
        CountryName23.setText("Рідна Україна");
        CountryName23.setCallbackData("Ukraine_" + s);
        CountryName24.setText("Филиппины");
        CountryName24.setCallbackData("Philippines_" + s);

        rowInLine8.add(CountryName22);
        rowInLine8.add(CountryName23);
        rowInLine8.add(CountryName24);

        rowsInLine.add(rowInLine8);

        List<InlineKeyboardButton> rowInLine9 = new ArrayList<>();
        var CountryName25 = new InlineKeyboardButton();
        var CountryName26= new InlineKeyboardButton();
        var CountryName27 = new InlineKeyboardButton();

        CountryName25.setText("Франция");
        CountryName25.setCallbackData("France_" + s);
        CountryName26.setText("Чили");
        CountryName26.setCallbackData("Chile_" + s);
        CountryName27.setText("Швеция");
        CountryName27.setCallbackData("Sweden_" + s);

        rowInLine9.add(CountryName25);
        rowInLine9.add(CountryName26);
        rowInLine9.add(CountryName27);

        rowsInLine.add(rowInLine9);

        List<InlineKeyboardButton> rowInLine10 = new ArrayList<>();
        var CountryName28 = new InlineKeyboardButton();

        CountryName28.setText("Япония");
        CountryName28.setCallbackData("Japan_" + s);

        rowInLine10.add(CountryName28);

        rowsInLine.add(rowInLine10);

        markupInLine.setKeyboard(rowsInLine);
        messageText.setReplyMarkup(markupInLine);
        messageText.setMessageId((int)messageId);
        editMessageSender.editMessageSender(messageText);
    }

    public void PopularyChoiceTop_All_CountryNames(long chatId,long messageId) {
        EditMessageText messageText = new EditMessageText();
        messageText.setChatId(String.valueOf(chatId));
        messageText.setText("Виберіть країну");
        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();

        List<InlineKeyboardButton> rowInLine = new ArrayList<>();
        var CountryName1 = new InlineKeyboardButton();
        var CountryName2 = new InlineKeyboardButton();
        var CountryName3 = new InlineKeyboardButton();

        CountryName1.setText("Австралия");
        String s = "200";
        CountryName1.setCallbackData("Australia_" + s);
        CountryName2.setText("Бульбаші");
        CountryName2.setCallbackData("Bubbles_" + s);
        CountryName3.setText("Великобритания");
        CountryName3.setCallbackData("Great_Britain_" + s);

        rowInLine.add(CountryName1);
        rowInLine.add(CountryName2);
        rowInLine.add(CountryName3);

        rowsInLine.add(rowInLine);

        List<InlineKeyboardButton> rowInLine2 = new ArrayList<>();
        var CountryName4 = new InlineKeyboardButton();
        var CountryName5 = new InlineKeyboardButton();
        var CountryName6 = new InlineKeyboardButton();

        CountryName4.setText("Вьетнам");
        CountryName4.setCallbackData("Vietnam_" + s);
        CountryName5.setText("Германия");
        CountryName5.setCallbackData("Germany_" + s);
        CountryName6.setText("Индия");
        CountryName6.setCallbackData("India_" + s);

        rowInLine2.add(CountryName4);
        rowInLine2.add(CountryName5);
        rowInLine2.add(CountryName6);

        rowsInLine.add(rowInLine2);

        List<InlineKeyboardButton> rowInLine3 = new ArrayList<>();
        var CountryName7 = new InlineKeyboardButton();
        var CountryName8 = new InlineKeyboardButton();
        var CountryName9 = new InlineKeyboardButton();

        CountryName7.setText("Испания");
        CountryName7.setCallbackData("Spain_" + s);
        CountryName8.setText("Италия");
        CountryName8.setCallbackData("Italy_" + s);
        CountryName9.setText("Казахстан");
        CountryName9.setCallbackData("Kazakhstan_" + s);

        rowInLine3.add(CountryName7);
        rowInLine3.add(CountryName8);
        rowInLine3.add(CountryName9);

        rowsInLine.add(rowInLine3);

        List<InlineKeyboardButton> rowInLine4 = new ArrayList<>();
        var CountryName10 = new InlineKeyboardButton();
        var CountryName11= new InlineKeyboardButton();
        var CountryName12 = new InlineKeyboardButton();

        CountryName10.setText("Канада");
        CountryName10.setCallbackData("Canada_" + s);
        CountryName11.setText("Китай");
        CountryName11.setCallbackData("China_" + s);
        CountryName12.setText("Корея Южная");
        CountryName12.setCallbackData("South_Korea_" + s);

        rowInLine4.add(CountryName10);
        rowInLine4.add(CountryName11);
        rowInLine4.add(CountryName12);

        rowsInLine.add(rowInLine4);

        List<InlineKeyboardButton> rowInLine5 = new ArrayList<>();
        var CountryName13 = new InlineKeyboardButton();
        var CountryName14= new InlineKeyboardButton();
        var CountryName15 = new InlineKeyboardButton();

        CountryName13.setText("Литва");
        CountryName13.setCallbackData("Lithuania_" + s);
        CountryName14.setText("Мексика");
        CountryName14.setCallbackData("Mexico_" + s);
        CountryName15.setText("Нигерия");
        CountryName15.setCallbackData("Nigeria_" + s);

        rowInLine5.add(CountryName13);
        rowInLine5.add(CountryName14);
        rowInLine5.add(CountryName15);

        rowsInLine.add(rowInLine5);

        List<InlineKeyboardButton> rowInLine6 = new ArrayList<>();
        var CountryName16 = new InlineKeyboardButton();
        var CountryName17= new InlineKeyboardButton();
        var CountryName18 = new InlineKeyboardButton();

        CountryName16.setText("Нидерланды");
        CountryName16.setCallbackData("Netherlands_" + s);
        CountryName17.setText("Норвегия");
        CountryName17.setCallbackData("Norway_" + s);
        CountryName18.setText("Польша");
        CountryName18.setCallbackData("Poland_" + s);

        rowInLine6.add(CountryName16);
        rowInLine6.add(CountryName17);
        rowInLine6.add(CountryName18);

        rowsInLine.add(rowInLine6);

        List<InlineKeyboardButton> rowInLine7 = new ArrayList<>();
        var CountryName19 = new InlineKeyboardButton();
        var CountryName20= new InlineKeyboardButton();
        var CountryName21 = new InlineKeyboardButton();

        CountryName19.setText("Терористи");
        CountryName19.setCallbackData("Terorist_" + s);
        CountryName20.setText("США");
        CountryName20.setCallbackData("USA_" + s);
        CountryName21.setText("Таиланд");
        CountryName21.setCallbackData("Thailand_" + s);

        rowInLine7.add(CountryName19);
        rowInLine7.add(CountryName20);
        rowInLine7.add(CountryName21);

        rowsInLine.add(rowInLine7);

        List<InlineKeyboardButton> rowInLine8 = new ArrayList<>();
        var CountryName22 = new InlineKeyboardButton();
        var CountryName23= new InlineKeyboardButton();
        var CountryName24 = new InlineKeyboardButton();

        CountryName22.setText("Турция");
        CountryName22.setCallbackData("Turkey_" + s);
        CountryName23.setText("Рідна Україна");
        CountryName23.setCallbackData("Ukraine_" + s);
        CountryName24.setText("Филиппины");
        CountryName24.setCallbackData("Philippines_" + s);

        rowInLine8.add(CountryName22);
        rowInLine8.add(CountryName23);
        rowInLine8.add(CountryName24);

        rowsInLine.add(rowInLine8);

        List<InlineKeyboardButton> rowInLine9 = new ArrayList<>();
        var CountryName25 = new InlineKeyboardButton();
        var CountryName26= new InlineKeyboardButton();
        var CountryName27 = new InlineKeyboardButton();

        CountryName25.setText("Франция");
        CountryName25.setCallbackData("France_" + s);
        CountryName26.setText("Чили");
        CountryName26.setCallbackData("Chile_" + s);
        CountryName27.setText("Швеция");
        CountryName27.setCallbackData("Sweden_" + s);

        rowInLine9.add(CountryName25);
        rowInLine9.add(CountryName26);
        rowInLine9.add(CountryName27);

        rowsInLine.add(rowInLine9);

        List<InlineKeyboardButton> rowInLine10 = new ArrayList<>();
        var CountryName28 = new InlineKeyboardButton();

        CountryName28.setText("Япония");
        CountryName28.setCallbackData("Japan_" + s);

        rowInLine10.add(CountryName28);

        rowsInLine.add(rowInLine10);

        markupInLine.setKeyboard(rowsInLine);
        messageText.setReplyMarkup(markupInLine);
        messageText.setMessageId((int)messageId);
        editMessageSender.editMessageSender(messageText);
    }
}

