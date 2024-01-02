package ru.gorodnyuk;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gorodnyuk.command.ArgumentExtractor;
import ru.gorodnyuk.command.CommandProcessor;

@SpringBootApplication
@RequiredArgsConstructor
public class Main implements CommandLineRunner {

    private final CommandProcessor commandProcessor;
    private final ArgumentExtractor argumentExtractor;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        // todo add help
        commandProcessor.process(argumentExtractor.extract(args));
    }
}
