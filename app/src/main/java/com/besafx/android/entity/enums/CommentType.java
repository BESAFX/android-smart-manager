package com.besafx.android.entity.enums;

public enum CommentType {
    Day("يومي"),
    Week("اسبوعي"),
    Month("شهري");

    private String name;

    CommentType(String name) {
        this.name = name;
    }

    public static CommentType findByName(String name) {
        for (CommentType v : values()) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }

    public static CommentType findByValue(String value) {
        for (CommentType v : values()) {
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
