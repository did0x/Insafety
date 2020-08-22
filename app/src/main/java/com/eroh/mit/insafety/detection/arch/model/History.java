package com.eroh.mit.insafety.detection.arch.model;

public class History {
    private String name, detail, result;

    public History(String name, String detail, String result) {
        this.name = name;
        this.detail = detail;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public String getResult() {
        return result;
    }
}
