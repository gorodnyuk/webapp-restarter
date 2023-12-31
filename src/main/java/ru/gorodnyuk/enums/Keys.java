package ru.gorodnyuk.enums;

/**
 * Ключи, предаваемые в терминале перед их значениями
 * -d - начальная задержка перед выполнением проверок
 * -t - время, через которое нужно выполнять проверку занятости порта
 * -c - команда, которую нужно выполнить, если порт свободен
 * -p - прослушиваемый порт
 */
public enum Keys {
    START_DELAY("-d"),
    TIMEOUT("-t"),
    COMMAND("-c"),
    PORT("-p");

    private String key;

    Keys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
