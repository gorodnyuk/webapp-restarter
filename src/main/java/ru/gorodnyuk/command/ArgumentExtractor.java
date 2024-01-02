package ru.gorodnyuk.command;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ArgumentExtractor {

    public String getString(Map<String, String> kvArgs, String key) {
        return kvArgs.get(key);
    }

    public Integer getInteger(Map<String, String> kvArgs, String key) {
        return Integer.valueOf(kvArgs.get(key));
    }
}
