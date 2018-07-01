package com.besafx.android.entity.enums;

public enum DeductionType {
    Tasks("حسميات المهام"),
    Absence("حسميات الغياب"),
    Others("حسميات اخرى");

    private String name;

    DeductionType(String name) {
        this.name = name;
    }

    public static DeductionType findByName(String name) {
        for (DeductionType v : values()) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }

    public static DeductionType findByValue(String value) {
        for (DeductionType v : values()) {
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
