package ru.bot.counter.bot.dao;

import java.util.HashMap;
import java.util.Map;

public class CounterBotDaoServiceImpl implements CounterBotDaoService {

    Map<String, Integer> cupsMap = new HashMap<String, Integer>();

    public Integer getCupsCount(Long chatId) {
        return 10;
//        return cupsMap.get(chatId);
    }
}
