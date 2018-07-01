package com.besafx.android.entity.enums;

public enum PersonDegree {
    A("ممتاز"),
    B("جيد جداً"),
    C("جيد"),
    D("مقبول"),
    F("سيء");

    private String name;

    PersonDegree(String name) {
        this.name = name;
    }

    public static PersonDegree findByName(String name) {
        for (PersonDegree v : values()) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }

    public static PersonDegree findByValue(String value) {
        for (PersonDegree v : values()) {
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
