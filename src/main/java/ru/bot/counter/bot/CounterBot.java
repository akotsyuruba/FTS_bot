package ru.bot.counter.bot;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import ru.bot.counter.action.Action;
import ru.bot.counter.bot.service.CounterBotService;

public class CounterBot extends TelegramLongPollingBot {
    private CounterBotService counterBotService;


    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage(); // Это нам понадобится
        String txt = msg.getText();

        if (!counterBotService.isCommand(txt)) {
            return;
        }
        Action botAction = counterBotService.getActionByName(txt);
        botAction.execute();

    }

    public String getBotUsername() {
        return "MasonClubBot";
    }

    public String getBotToken() {
        return "553418234:AAHihnZ5bI6175SueU_BEWbVchgQmOKy9mY";
    }
}
