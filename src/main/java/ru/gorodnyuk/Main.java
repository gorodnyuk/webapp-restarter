package ru.gorodnyuk;

import ru.gorodnyuk.command.CommandFactory;
import ru.gorodnyuk.command.CommandParser;
import ru.gorodnyuk.command.CommandProcessor;
import ru.gorodnyuk.command.CommandValidator;

public class Main {

    public static void main(String[] args) {
        // todo add help
        CommandValidator commandValidator = CommandFactory.getCommandValidator();
        commandValidator.validate(args);

        CommandProcessor commandProcessor = CommandFactory.getCommandProcessor();
        CommandParser commandParser = CommandFactory.getCommandParser();
        commandProcessor.process(commandParser.parse(args));
    }
}
