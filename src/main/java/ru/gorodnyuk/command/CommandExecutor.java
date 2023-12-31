package ru.gorodnyuk.command;

import ru.gorodnyuk.enums.Keys;
import ru.gorodnyuk.utils.StringUtils;

import java.util.Arrays;
import java.util.Map;

public class CommandExecutor {

    private static int DEFAULT_START_DELAY_SECONDS = 10;

    public void execute(String[] args) {
        Map<String, String> commandMap = convert(args);
        long startDelay;
        boolean isDelayPresent = Arrays.stream(args)
                .filter(key -> key.equals(Keys.START_DELAY.getKey()))
                .findFirst()
                .map(StringUtils::hasText)
                .orElse(false);
        if (!isDelayPresent) {
            startDelay = DEFAULT_START_DELAY_SECONDS;
        }
    }

    private Map<String, String> convert(String[] args) {
        return null;
    }
}
