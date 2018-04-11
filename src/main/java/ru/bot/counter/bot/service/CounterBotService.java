package ru.bot.counter.bot.service;

import ru.bot.counter.action.Action;

public interface CounterBotService {
    Action getActionByName(String txt);

    boolean isCommand(String txt);

    Integer getCupsCount(Long chatId);
}
