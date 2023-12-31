package ru.gorodnyuk;

import ru.gorodnyuk.command.CommandFactory;
import ru.gorodnyuk.command.CommandProcessor;
import ru.gorodnyuk.command.CommandValidator;

public class Main {

    public static void main(String[] args) {
        CommandValidator.validate(args);

        CommandProcessor commandProcessor = CommandFactory.getCommandProcessor();
        commandProcessor.process(args);
    }
}
