package com.kalia.bhaskar.parth.dto;

/**
 * Created by bhaskar on 17/6/16.
 */
public class CommandTypeDto {
    private String keyword;
    private String type;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "CommandTypeDto{" +
                "keyword='" + keyword + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }
}
