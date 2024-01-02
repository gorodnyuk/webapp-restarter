package ru.gorodnyuk.command;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import ru.gorodnyuk.enums.Keys;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandValidator {

    private final CommandParser commandParser;

    public CommandValidator(CommandParser commandParser) {
        this.commandParser = commandParser;
    }

    public void validate(String[] args) {
        checkEmptyArgs(args);
        checkUnknownCommands(args);
        checkRequiredCommands(args);
        checkMatchCommandsAndValues(args);
    }

    private void checkMatchCommandsAndValues(String[] args) {
        // todo пропуск команды -h (HELP)
        if (getKeyCount(args) != getValueCount(args)) {
            throw new IllegalArgumentException("Amount command key and command value must be match");
        }
    }

    private void checkRequiredCommands(String[] args) {
        Map<String, String> availableCommands = commandParser.parse(args);
        String cCommand = availableCommands.get(Keys.COMMAND.getKey());
        String errorMessage = "'%s' command keys with their value must be specified";
        if (StringUtils.isEmpty(cCommand)) {
            throw new IllegalArgumentException(errorMessage.formatted("-c"));
        }
        String pCommand = availableCommands.get(Keys.PORT.getKey());
        if (StringUtils.isEmpty(pCommand)) {
            throw new IllegalArgumentException(errorMessage.formatted("-p"));
        }
    }

    private void checkUnknownCommands(String[] args) {
        List<String> unknownCommands = getUnknownCommands(args);
        if (CollectionUtils.isNotEmpty(unknownCommands)) {
            throw new IllegalArgumentException(String.format(
                    "There are unknown commands: %s", String.join(", ", unknownCommands))
            );
        }
    }

    private static void checkEmptyArgs(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("At least one '-p' and one '-c' command keys with their values must be specified");
        }
    }

    private long getKeyCount(String[] args) {
        return getCommands(args).size();
    }

    private long getValueCount(String[] args) {
        return Arrays.stream(args)
                .filter(f -> !f.startsWith("-"))
                .count();
    }

    private List<String> getUnknownCommands(String[] args) {
        return getCommands(args).stream()
                .filter(command -> !command.equals(Keys.START_DELAY.getKey())
                        && !command.equals(Keys.COMMAND.getKey())
                        && !command.equals(Keys.TIMEOUT.getKey())
                        && !command.equals(Keys.PORT.getKey()))
                .collect(Collectors.toList());
    }

    private static List<String> getCommands(String[] args) {
        return Arrays.stream(args)
                .filter(f -> f.startsWith("-"))
                .collect(Collectors.toList());
    }
}
