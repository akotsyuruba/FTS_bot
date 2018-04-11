package ru.bot.counter.bot.service;

import ru.bot.counter.action.Action;
import ru.bot.counter.action.AddAction;

public class CounterBotServiceImpl implements CounterBotService {
    public Action getActionByName(String txt) {
        return new AddAction();
    }

    public boolean isCommand(String txt) {
        return txt!=null && txt.startsWith("/");
    }
}
