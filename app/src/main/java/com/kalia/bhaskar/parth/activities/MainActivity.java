package com.kalia.bhaskar.parth.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.kalia.bhaskar.parth.R;
import com.kalia.bhaskar.parth.robo.Robo;
import com.kalia.bhaskar.parth.services.DataService;


public class MainActivity extends Activity implements OnClickListener {

    private final int REQUEST_OK = 1;
    private Robo robo ; //robo remote
    private DataService dataService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //create new robo instance
        robo = new Robo(getApplicationContext());

        //create data service
        dataService = new DataService();

        findViewById(R.id.getaudio).setOnClickListener(this);
        findViewById(R.id.teachMeButton).setOnClickListener(this);
    }


    //click listener for views
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.getaudio){
            listen();
        }else {
            teachMe();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("requestcode", "" + requestCode);
        Log.i("resultcode",""+resultCode);
        if (requestCode == REQUEST_OK && resultCode == RESULT_OK) {
            ArrayList<String> speech = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            Log.e("game", "game"+speech.get(0));
            if(speech.get(0).substring(0,4).equals("call")){
                Log.i("content resolversrt", "start");
                ContentResolver resolver=getContentResolver();
                String[] projection    = new String[] {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER};
                Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                Cursor cursor=resolver.query(uri,projection,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + "=? COLLATE NOCASE", new String[]{speech.get(0).substring(5,speech.get(0).length()).toLowerCase()}, null);
                Log.i("cursor","retrive begins"+cursor);
                String phone="";
                if(cursor!=null) {
                    while (cursor.moveToNext()) {
                        phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                        Log.i("myname", "" + phone + ":" + name);
                        Log.i("slice", "" + name.substring(0, 4));
                    }
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phone));
                    startActivity(callIntent);
                }
                else{
                    Log.i("nothing","nothing");
                    robo.interpret(speech.get(0), getApplicationContext());
                }
            } else {
                robo.interpret(speech.get(0), getApplicationContext());
            }
        }
    }

    private void listen(){
        /*
        * Listen what user says using RecongnizerIntent
        * */
        Log.e("entered in listen","listen");
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

    private void teachMe(){
        Intent i = new Intent(getApplicationContext(),TeachMeActivity.class);
        startActivity(i);
    }
}