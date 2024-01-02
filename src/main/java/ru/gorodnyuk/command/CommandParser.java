package ru.gorodnyuk.command;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandParser {

    public Map<String, String> parse(String[] args) {
        Map<String, String> kvArgs = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            kvArgs.put(args[i], args[i + 1]);
        }
        return kvArgs;
    }
}
