package ru.gorodnyuk;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gorodnyuk.command.CommandParser;
import ru.gorodnyuk.command.CommandProcessor;
import ru.gorodnyuk.command.CommandValidator;

@SpringBootApplication
@RequiredArgsConstructor
public class Main implements CommandLineRunner {

    private final CommandValidator commandValidator;
    private final CommandProcessor commandProcessor;
    private final CommandParser commandParser;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        // todo add help
        commandValidator.validate(args);
        commandProcessor.process(commandParser.parse(args));
    }
}
