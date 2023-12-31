package ru.gorodnyuk.enums;

public enum Keys {
    START_DELAY("-d"),
    TIME("-t"),
    COMMAND("-c");

    private String key;

    Keys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
