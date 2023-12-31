package ru.gorodnyuk;

import ru.gorodnyuk.enums.Keys;
import ru.gorodnyuk.utils.StringUtils;

import java.util.Arrays;

public class Main {

    private static int DEFAULT_START_DELAY_SECONDS = 10;

    public static void main(String[] args) throws InterruptedException {
        CommandExecutor commandExecutor = new CommandExecutor();
        long startDelay;
        boolean isDelayPresent = Arrays.stream(args)
                .filter(key -> key.equals(Keys.START_DELAY.getKey()))
                .findFirst()
                .map(StringUtils::hasText)
                .orElse(false);
        if (!isDelayPresent) {
            startDelay = DEFAULT_START_DELAY_SECONDS;
        }

        commandExecutor.validate(args);
        commandExecutor.convert(args);
        while (true) {
//            TimeUnit.SECONDS.sleep(5); // поменять на с задержкой ExecutorService или Scheduler
            commandExecutor.execute();
        }
    }
}
