package com.example.sameerraj.censusgenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class History extends AppCompatActivity {
    Database_Enroll de=new Database_Enroll(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ((TextView)findViewById(R.id.history_text)).setText(de.getData());
    }
}
