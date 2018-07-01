package com.besafx.android.entity.enums;

public enum TicketType {
    Personal("شخصية"),
    Formal("عملية");

    private String name;

    TicketType(String name) {
        this.name = name;
    }

    public static TicketType findByName(String name) {
        for (TicketType v : values()) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }

    public static TicketType findByValue(String value) {
        for (TicketType v : values()) {
            if (v.name().equals(value)) {
                return v;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
