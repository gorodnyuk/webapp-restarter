package ru.gorodnyuk.command;

public class CommandFactory {

    public static CommandExecutor getCommandExecutor() {
        return new CommandExecutor();
    }

    public static CommandValidator getCommandValidator() {
        return new CommandValidator();
    }
}
