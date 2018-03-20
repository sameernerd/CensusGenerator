package com.example.sameerraj.censusgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Verification extends AppCompatActivity {
    private static ArrayList<String> ar=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ar.add("0xxx");ar.add("0123");ar.add("1729"); //Stimulate this as fingerprint
        setContentView(R.layout.activity_verification);
    }
    public void onVerify(View view){
        String secretKey=((EditText)findViewById(R.id.sec_key)).getText().toString();
        Intent intent=new Intent(this,EnrollmentForm.class);
        if(ar.contains(secretKey)){
            intent.putExtra("info",new String[]{"Ravi","Male","Patna,Bihar","22-12-19","Vilas","Vimla"});
        }
        startActivity(intent);
    }
}
