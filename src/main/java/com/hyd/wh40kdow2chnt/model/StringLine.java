package com.hyd.wh40kdow2chnt.model;

public class StringLine {

    public static final StringLine EMPTY = new StringLine();

    public static StringLine parse(String line, String splitter) {
        if (line == null || line.isBlank() || !line.contains(splitter)) {
            return EMPTY;
        }

        String[] parts = line.split(splitter, 2);
        int key = Integer.parseInt(parts[0]);
        if (parts.length < 2) {
            return new StringLine(key, "", splitter);
        } else {
            return new StringLine(key, parts[1], splitter);
        }
    }

    ///////////////////////

    public StringLine() {
    }

    public StringLine(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public StringLine(int key, String value, String splitter) {
        this.key = key;
        this.value = value;
        this.splitter = splitter;
    }

    private int key;
    private String value;
    private String splitter = "\t";

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

    public String getSplitter() {
        return splitter;
    }

    public void setSplitter(String splitter) {
        this.splitter = splitter;
    }

    @Override
    public String toString() {
        return key + splitter + value;
    }
}
