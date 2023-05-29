package com.tg.UAkino.Club.Sender;

import com.tg.UAkino.Club.configBot.BotConfig;
import com.tg.UAkino.Club.TelegramBot.kino;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MessageSender {
    final BotConfig config;
    public MessageSender(BotConfig config) {
        this.config = config;
        kino = new kino(this.config);
    }
    kino kino;



    public void sendMessage(long chatId,String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(chatId);
        try {
            kino.execute (sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
