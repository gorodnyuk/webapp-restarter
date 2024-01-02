package ru.gorodnyuk.command;

import org.apache.commons.lang3.StringUtils;
import ru.gorodnyuk.enums.Keys;
import ru.gorodnyuk.utils.PortUtils;

import java.io.IOException;
import java.util.Map;

public class CommandProcessor {

    private static final int DEFAULT_START_DELAY_SECONDS = 60;
    private static final int DEFAULT_EXECUTION_TIMEOUT_SECONDS = 3600;

    public void process(Map<String, String> commandsMap) {
        String helpKey = commandsMap.get(Keys.HELP.getKey());
        if (!StringUtils.isEmpty(helpKey)) {
            // выдать помощь
            return;
        }

        long startDelay = getExecutionTime(commandsMap.get(Keys.START_DELAY.getKey()), DEFAULT_START_DELAY_SECONDS);
        long executionTimeout = getExecutionTime(commandsMap.get(Keys.TIMEOUT.getKey()), DEFAULT_EXECUTION_TIMEOUT_SECONDS);
        int port = Integer.parseInt(commandsMap.get(Keys.PORT.getKey()));
        String command = commandsMap.get(Keys.COMMAND.getKey());

        while (true) {
//            TimeUnit.SECONDS.sleep(5); // поменять на с задержкой ExecutorService или Scheduler
            if (!PortUtils.isAvailable(port)) {
                executeCommand(command);
            }
        }
    }

    private long getExecutionTime(String strTime, long timeout) {
        if (!StringUtils.isEmpty(strTime)) {
            timeout = Long.parseLong(strTime);
        }
        return timeout;
    }

    private void executeCommand(String command) {
        try {
            new ProcessBuilder(command).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
