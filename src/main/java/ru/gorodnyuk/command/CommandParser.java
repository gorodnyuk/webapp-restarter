package ru.gorodnyuk.command;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {

    public Map<String, String> parse(String[] args) {
        Map<String, String> kvArgs = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            kvArgs.put(args[i], args[i + 1]);
        }
        return kvArgs;
    }
}
