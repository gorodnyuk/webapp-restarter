package ru.gorodnyuk.command;

import org.apache.commons.collections4.CollectionUtils;
import ru.gorodnyuk.enums.Keys;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandValidator {

    public static void validate(String[] args) {

        //todo обязательно нужна команда
        if (args.length == 0) {
            throw new IllegalArgumentException("At least one command key and one command value must be specified");
        }

        List<String> unknownCommands = getUnknownCommands(args);
        if (CollectionUtils.isNotEmpty(unknownCommands)) {
            throw new IllegalArgumentException(String.format(
                    "There are unknown commands: %s", String.join(", ", unknownCommands))
            );
        }

        if (getKeyCount(args) != getValueCount(args)) {
            throw new IllegalArgumentException("Amount command key and command value must be match");
        }
    }

    private static long getKeyCount(String[] args) {
        return getCommands(args).size();
    }

    private static long getValueCount(String[] args) {
        return Arrays.stream(args)
                .filter(f -> !f.startsWith("-"))
                .count();
    }

    private static List<String> getUnknownCommands(String[] args) {
        return getCommands(args).stream()
                .filter(command -> !command.equals(Keys.START_DELAY.getKey())
                        && !command.equals(Keys.COMMAND.getKey())
                        && !command.equals(Keys.TIMEOUT.getKey()))
                .collect(Collectors.toList());
    }

    private static List<String> getCommands(String[] args) {
        return Arrays.stream(args)
                .filter(f -> f.startsWith("-"))
                .collect(Collectors.toList());
    }
}
