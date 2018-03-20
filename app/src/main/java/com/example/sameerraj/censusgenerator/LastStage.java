package com.example.sameerraj.censusgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LastStage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_stage);
    }
    public void goHome(View view){
        Intent intent=new Intent(this,Dashboard.class);
        startActivity(intent);
    }
}
