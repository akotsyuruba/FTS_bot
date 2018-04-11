package ru.bot.counter.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import ru.bot.counter.action.Action;
import ru.bot.counter.bot.service.CounterBotService;
import ru.bot.counter.bot.service.CounterBotServiceImpl;
import ru.bot.counter.cup.pl.CupView;

public class CounterBot extends TelegramLongPollingBot {
    private CounterBotService counterBotService = new CounterBotServiceImpl();


    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage(); // Это нам понадобится
        String txt = msg.getText();

        if (!counterBotService.isCommand(txt)) {
            return;
        }
        Action botAction = counterBotService.getActionByName(txt);
        botAction.execute();
        sendMsg(msg, getCups(msg));
    }

    private String getCups(Message msg) {
        String res = new String();
        for (int i = 0; i < counterBotService.getCupsCount(msg.getChatId()); i++) {
            res += CupView.getTemplate();
        }
        return res;
    }

    private void sendMsg(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId()); // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
        s.setText(text);
        try { //Чтобы не крашнулась программа при вылете Exception
            sendMessage(s);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "MasonClubBot";
    }

    public String getBotToken() {
        return "553418234:AAHihnZ5bI6175SueU_BEWbVchgQmOKy9mY";
    }
}
