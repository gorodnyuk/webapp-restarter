package ru.gorodnyuk.command;

public class CommandFactory {

    public static CommandExecutor getCommandExecutor() {
        return new CommandExecutor();
    }

    public static CommandProcessor getCommandProcessor() {
        return new CommandProcessor(getCommandExecutor());
    }
}
