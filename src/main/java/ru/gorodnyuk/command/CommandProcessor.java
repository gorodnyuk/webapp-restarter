package ru.gorodnyuk.command;

public class CommandProcessor {

    private final CommandExecutor commandExecutor;

    public CommandProcessor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public void process(String[] args) {
        while (true) {
//            TimeUnit.SECONDS.sleep(5); // поменять на с задержкой ExecutorService или Scheduler
            commandExecutor.execute(args);
        }
    }
}
