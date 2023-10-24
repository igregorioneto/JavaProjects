package com._aux.backend.enums;

public enum AdminLevel {
    NIVEL_1("Nível 1"),
    NIVEL_2("Nível 2"),
    NIVEL_3("Nível 3"),
    NIVEL_4("Nível 4");

    private final String level;

    AdminLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
