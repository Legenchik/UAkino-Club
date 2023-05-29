package com.tg.UAkino.Club.Sender;


import com.tg.UAkino.Club.configBot.BotConfig;
import com.tg.UAkino.Club.TelegramBot.kino;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EditMessageSender {
    final BotConfig config;
    public EditMessageSender(BotConfig config) {
        this.config = config;
        kino = new kino(this.config);
    }
    kino kino;



    public void editMessageSender(EditMessageText msg){
        try {
            kino.execute (msg);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
