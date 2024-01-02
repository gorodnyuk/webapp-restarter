package ru.gorodnyuk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        // todo add help
        SpringApplication.run(Main.class, args);
//        CommandValidator commandValidator = CommandFactory.getCommandValidator();
//        commandValidator.validate(args);
//
//        CommandProcessor commandProcessor = CommandFactory.getCommandProcessor();
//        CommandParser commandParser = CommandFactory.getCommandParser();
//        commandProcessor.process(commandParser.parse(args));
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("asdasdasdad");
    }
}
