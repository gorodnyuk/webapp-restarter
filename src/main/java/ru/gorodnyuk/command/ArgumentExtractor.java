package ru.gorodnyuk.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
        return Optional.ofNullable(kvArgs.get(key));
    }

    public Optional<Long> getLong(Map<String, String> kvArgs, String key) {
        String value = kvArgs.get(key);
        if (StringUtils.hasText(value)) {
            return Optional.of(Long.parseLong(kvArgs.get(key)));
        }
        return Optional.empty();
    }

    public Optional<Integer> getInteger(Map<String, String> kvArgs, String key) {
        String value = kvArgs.get(key);
        if (StringUtils.hasText(value)) {
            return Optional.of(Integer.parseInt(kvArgs.get(key)));
        }
        return Optional.empty();
    }
}
