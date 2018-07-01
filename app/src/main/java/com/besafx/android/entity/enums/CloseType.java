package com.besafx.android.entity.enums;

public enum CloseType {
    Pending("تحت التنفيذ"),
    Auto("تلقائي"),
    Manual("يدوي");

    private String name;

    CloseType(String name) {
        this.name = name;
    }

    public static CloseType findByName(String name) {
        for (CloseType v : values()) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }

    public static CloseType findByValue(String value) {
        for (CloseType v : values()) {
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
