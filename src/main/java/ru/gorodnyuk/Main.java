package ru.gorodnyuk;

import ru.gorodnyuk.command.CommandExecutor;
import ru.gorodnyuk.command.CommandValidator;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CommandValidator commandValidator = new CommandValidator();
        commandValidator.validate(args);

        CommandExecutor commandExecutor = new CommandExecutor();

        while (true) {
//            TimeUnit.SECONDS.sleep(5); // поменять на с задержкой ExecutorService или Scheduler
            commandExecutor.execute(args);
        }
    }
}
