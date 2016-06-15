package com.kalia.bhaskar.parth.activities;

import java.util.ArrayList;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.kalia.bhaskar.parth.R;
import com.kalia.bhaskar.parth.robo.Mappings;
import com.kalia.bhaskar.parth.robo.Robo;


public class MainActivity extends Activity implements OnClickListener {

    private final int REQUEST_OK = 1;

    // this is soul of robot
    private Robo robo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //create new robo instance
        robo = new Robo(getApplicationContext());

        findViewById(R.id.getaudio).setOnClickListener(this);
        TextView commandBox = (TextView) findViewById(R.id.commandsText);

        String commands = "Commands:\n\n";

        Map<String,String> map = new Mappings().getKeyToTypeMap();

        for(Map.Entry<String, String> entry : map.entrySet()){
            commands += entry.getKey() + "\n";
        }

        commandBox.setMovementMethod(new ScrollingMovementMethod());
        commandBox.setText(commands);
    }


    //click listener for views
    @Override
    public void onClick(View view) {
        listen();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_OK && resultCode == RESULT_OK) {
            ArrayList<String> speech = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            robo.interpret(speech.get(0),getApplicationContext());
        }
    }

    private void listen(){
        /*
        * Listen what user says using RecongnizerIntent
        * */
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
        try {
            //this will return result from the called activity which
            //can be captured at onActivityResult method
            startActivityForResult(i, REQUEST_OK);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error initializing Robo's text to speech engine!!", Toast.LENGTH_LONG).show();
        }
    }
}