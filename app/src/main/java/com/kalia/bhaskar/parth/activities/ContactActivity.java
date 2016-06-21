package com.kalia.bhaskar.parth.activities;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.kalia.bhaskar.parth.R;

public class ContactActivity extends AppCompatActivity {
    static final int PICK_CONTACT_REQUEST = 1;
    static final int RESULT_OK=1;
    private String contactID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_contact);
        final Uri uriContact = ContactsContract.Contacts.CONTENT_URI;
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK,uriContact);
        //pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PICK_CONTACT_REQUEST) {

            if (resultCode == RESULT_OK) {

                Uri contactUri = data.getData();
                // We only need the NUMBER column, because there will be only one row in the result
                String contactNumber = null;

                // getting contacts ID
                Cursor cursorID = getContentResolver().query(contactUri,
                        new String[]{ContactsContract.Contacts._ID},
                        null, null, null);

                if (cursorID.moveToFirst()) {

                    contactID = cursorID.getString(cursorID.getColumnIndex(ContactsContract.Contacts._ID));
                }

                cursorID.close();

                Log.d("loda", "Contact ID: " + contactID);

                // Using the contact ID now we will get contact phone number
                Cursor cursorPhone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},

                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ? AND " +
                                ContactsContract.CommonDataKinds.Phone.TYPE + " = " +
                                ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE,

                        new String[]{contactID},
                        null);

                if (cursorPhone.moveToFirst()) {
                    contactNumber = cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }

                cursorPhone.close();

                Log.d("chus", "Contact Phone Number: " + contactNumber);
                // Do something with the phone number...
            }

            }
        }
    }

