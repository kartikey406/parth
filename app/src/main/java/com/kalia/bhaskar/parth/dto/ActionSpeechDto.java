package com.kalia.bhaskar.parth.dto;

/**
 * Created by bhaskar on 17/6/16.
 */
public class ActionSpeechDto {
    private String keyword;
    private String text;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ActionSpeechDto{" +
                "keyword='" + keyword + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
