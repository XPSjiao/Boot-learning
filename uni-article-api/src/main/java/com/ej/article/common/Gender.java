package com.ej.article.common;

public enum Gender {
    DEFAULT(-1, "默认"),
    MALE(0, "男"),
    FEMALE(1, "女"),
    SECRET(2, "保密");

    private int key;
    private String value;

    Gender(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
