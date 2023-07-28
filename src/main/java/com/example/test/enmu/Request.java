package com.example.test.enmu;

public enum Request {
    SUCCESS(200),
    ERROR(400),
    NOTFOUND(404),
    SERVERERROR(500);

    private int code;

    Request(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
