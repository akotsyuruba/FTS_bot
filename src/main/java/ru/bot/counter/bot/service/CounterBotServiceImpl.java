package ru.bot.counter.bot.service;

import ru.bot.counter.action.Action;
import ru.bot.counter.action.AddAction;
import ru.bot.counter.bot.dao.CounterBotDaoService;
import ru.bot.counter.bot.dao.CounterBotDaoServiceImpl;

public class CounterBotServiceImpl implements CounterBotService {

    CounterBotDaoService counterBotDaoService = new CounterBotDaoServiceImpl();

    public Action getActionByName(String txt) {
        return new AddAction();
    }

    public boolean isCommand(String txt) {
        return txt != null && txt.startsWith("/");
    }

    public Integer getCupsCount(Long chatId) {
        return counterBotDaoService.getCupsCount(chatId);
    }
}
