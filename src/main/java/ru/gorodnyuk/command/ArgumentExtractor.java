package ru.gorodnyuk.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ArgumentExtractor {

    private final CommandParser commandParser;
    private final CommandValidator commandValidator;

    public Map<String, String> extract(String[] args) {
        commandValidator.validate(args);
        return commandParser.parse(args);
    }

    public Optional<String> getString(Map<String, String> kvArgs, String key) {
        return Optional.of(kvArgs.get(key));
    }

    public Optional<Long> getLong(Map<String, String> kvArgs, String key) {
        return Optional.of(Long.parseLong(kvArgs.get(key)));
    }

    public Optional<Integer> getInteger(Map<String, String> kvArgs, String key) {
        return Optional.of(Integer.parseInt(kvArgs.get(key)));
    }
}
