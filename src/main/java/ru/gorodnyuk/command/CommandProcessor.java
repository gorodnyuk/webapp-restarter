package ru.gorodnyuk.command;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class CommandProcessor {

    private static int DEFAULT_START_DELAY_SECONDS = 10;
    private static int DEFAULT_TIMEOUT_MINUTES = 60;

    private final CommandExecutor commandExecutor;

    public CommandProcessor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public void process(Map<String, String> commandsMap) {
        long executionTimeout = getExecutionTimeout(commandsMap.get("-t"));
        while (true) {
//            TimeUnit.SECONDS.sleep(5); // поменять на с задержкой ExecutorService или Scheduler
        }
    }

    private long getExecutionTimeout(String strTime) {
        long startDelay = DEFAULT_START_DELAY_SECONDS;
        if (!StringUtils.isEmpty(strTime)) {
            startDelay = Long.parseLong(strTime);
        }
        return startDelay;
    }
}
