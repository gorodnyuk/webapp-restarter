package ru.gorodnyuk;

import org.apache.commons.lang3.StringUtils;
import ru.gorodnyuk.enums.Keys;

import java.util.Arrays;

public class Main {

    private static int DEFAULT_START_DELAY_SECONDS = 10;

    public static void main(String[] args) throws InterruptedException {
        long startDelay;
        boolean isDelayPresent = Arrays.stream(args)
                .filter(key -> key.equals(Keys.START_DELAY.getKey()))
                .findFirst()
                .map(key -> !StringUtils.isEmpty(key))
                .orElse(false);
        if (!isDelayPresent) {
            startDelay = DEFAULT_START_DELAY_SECONDS;
        }

        while (true) {
//            TimeUnit.SECONDS.sleep(5); // поменять на с задержкой ExecutorService или Scheduler
        }
    }
}
