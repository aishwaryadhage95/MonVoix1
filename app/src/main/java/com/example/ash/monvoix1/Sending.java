package com.example.ash.monvoix1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Sending extends AppCompatActivity {

    String uriString;
    private EditText msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending);
        msg = (EditText) findViewById(R.id.editText);

        Bundle extras = getIntent().getExtras();
        String title= extras.getString("title");
        msg.setText(title, EditText.BufferType.EDITABLE);

    }
}
