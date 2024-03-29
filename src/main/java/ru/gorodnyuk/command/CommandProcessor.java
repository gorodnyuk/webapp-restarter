package ru.gorodnyuk.command;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.gorodnyuk.enums.Keys;
import ru.gorodnyuk.utils.PortUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class CommandProcessor {

    private static final long DEFAULT_START_DELAY_SECONDS = 60;
    private static final long DEFAULT_EXECUTION_TIMEOUT_SECONDS = 3600;

    private final ArgumentExtractor argumentExtractor;

    @SneakyThrows
    public void process(Map<String, String> commandsMap) {
        Optional<String> maybeHelpKey = argumentExtractor.getString(commandsMap, Keys.HELP.getKey());
        if (maybeHelpKey.isPresent()) {
            // выдать помощь
            return;
        }

        long startDelay = argumentExtractor.getLong(commandsMap, Keys.START_DELAY.getKey()).orElse(DEFAULT_START_DELAY_SECONDS);
        long executionTimeout = argumentExtractor.getLong(commandsMap, Keys.TIMEOUT.getKey()).orElse(DEFAULT_EXECUTION_TIMEOUT_SECONDS);
        int port = argumentExtractor.getInteger(commandsMap, Keys.PORT.getKey())
                .orElseThrow(() -> new RuntimeException("Unexpected exception when extract port. Port must be present!"));
        String command = argumentExtractor.getString(commandsMap, Keys.COMMAND.getKey())
                .orElseThrow(() -> new RuntimeException("Unexpected exception when extract command. Command must be present!"));

        TimeUnit.SECONDS.sleep(startDelay);
        while (true) {
            TimeUnit.SECONDS.sleep(executionTimeout);
            if (!PortUtils.isAvailable(port)) {
                executeCommand(command);
            }
        }
    }

    private void executeCommand(String command) {
        try {
            new ProcessBuilder("java", "-jar", command).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
