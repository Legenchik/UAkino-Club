package com.tg.UAkino.Club.Sender;

import com.tg.UAkino.Club.configBot.BotConfig;
import com.tg.UAkino.Club.TelegramBot.kino;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
public class ExecuteMessageSender {
    final BotConfig config;
    public ExecuteMessageSender(BotConfig config) {
        this.config = config;
        kino = new kino(this.config);
    }
    kino kino;



    public void ExecuteSendMessage(SendMessage sendMessage){
        try {
            kino.execute (sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
