package ru.gorodnyuk.command;

public class CommandFactory {

    public static CommandParser getCommandParser() {
        return new CommandParser();
    }

    public static CommandProcessor getCommandProcessor() {
        return new CommandProcessor();
    }

    public static CommandValidator getCommandValidator() {
        return new CommandValidator(getCommandParser());
    }
}
