package ru.gorodnyuk.command;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class CommandProcessor {

    private static final int DEFAULT_START_DELAY_SECONDS = 60;
    private static final int DEFAULT_EXECUTION_TIMEOUT_SECONDS = 3600;

    private final CommandExecutor commandExecutor;

    public CommandProcessor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public void process(Map<String, String> commandsMap) {
        long startTimeout = getExecutionTime(commandsMap.get("-d"), DEFAULT_START_DELAY_SECONDS);
        long executionTimeout = getExecutionTime(commandsMap.get("-t"), DEFAULT_EXECUTION_TIMEOUT_SECONDS);
        while (true) {
//            TimeUnit.SECONDS.sleep(5); // поменять на с задержкой ExecutorService или Scheduler
        }
    }

    private long getExecutionTime(String strTime, long time) {
        if (!StringUtils.isEmpty(strTime)) {
            time = Long.parseLong(strTime);
        }
        return time;
    }
}
