package com.kalia.bhaskar.parth.interfaces;

import android.content.Context;

import com.kalia.bhaskar.parth.dto.CommandTypeDto;

import java.util.List;

/**
 * Created by bhaskar on 17/6/16.
 */
public interface DataServiceInterface {
    String getCommandTypeText(String keyword, Context context);
    String getActionSpeechText(String keyword, Context context);
    List<CommandTypeDto> getCommandTypeRows(Context context);
    void addFromTeachMeActivity(String keyword, String text, Context context);
    void deleteRowsWithKeyword(String keyword, Context context); // to delete rows from both tables where keyword is argument
}
