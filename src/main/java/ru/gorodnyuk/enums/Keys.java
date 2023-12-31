package ru.gorodnyuk.enums;

public enum Keys {
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
