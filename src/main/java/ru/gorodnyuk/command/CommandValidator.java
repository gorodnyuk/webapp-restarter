package ru.gorodnyuk.command;

import java.util.Arrays;

public class CommandValidator {

    public void validate(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("At least one command key and one command value must be specified");
        }
        if (getKeyCount(args) != getValueCount(args)) {
            throw new IllegalArgumentException("Amount command key and command value must be match");
        }
    }

    private long getKeyCount(String[] args) {
        return Arrays.stream(args)
                .filter(f -> f.startsWith("-"))
                .count();
    }

    private long getValueCount(String[] args) {
        return Arrays.stream(args)
                .filter(f -> !f.startsWith("-"))
                .count();
    }
}