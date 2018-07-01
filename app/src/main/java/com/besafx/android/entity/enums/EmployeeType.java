package com.besafx.android.entity.enums;

public enum EmployeeType {
    Original("اساسية"),
    Extra("فرعية");

    private String name;

    EmployeeType(String name) {
        this.name = name;
    }

    public static EmployeeType findByName(String name) {
        for (EmployeeType v : values()) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }

    public static EmployeeType findByValue(String value) {
        for (EmployeeType v : values()) {
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
