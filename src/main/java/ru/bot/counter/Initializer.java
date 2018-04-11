package ru.bot.counter;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import ru.bot.counter.bot.CounterBot;

public class Initializer {

    public static void main(String[] args) {
        ApiContextInitializer.init(); // Инициализируем апи
        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            botapi.registerBot(new CounterBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
