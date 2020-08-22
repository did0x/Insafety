package com.eroh.mit.insafety.detection.arch.model;

import java.util.Date;

public class Archive {
    private String date;
    private String countWorker;

    public Archive(String date, String countWorker) {
        this.date = date;
        this.countWorker = countWorker;
    }

    public String getDate() {
        return date;
    }

    public String getCountWorker() {
        return countWorker;
    }
}
