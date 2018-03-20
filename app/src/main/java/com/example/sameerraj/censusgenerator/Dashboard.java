package com.example.sameerraj.censusgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void onEnroll(View view){
        Intent intent=new Intent(this,Verification.class);
        startActivity(intent);
    }
    public void onHistory(View view){
        Intent intent=new Intent(this,History.class);
        startActivity(intent);
    }

}
