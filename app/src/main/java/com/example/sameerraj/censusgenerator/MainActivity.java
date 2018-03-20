package com.example.sameerraj.censusgenerator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Database db=new Database(this);
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Something phishy is going on!");
        alertDialog.setMessage("Username or password is invalid");
        alertDialog.setIcon(R.mipmap.go_back);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Go Back", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int id){
                dialog.cancel();
            }
        });
    }
    public void onClick(View view){
        EditText name=(EditText) findViewById(R.id.user_name);
        EditText pass=(EditText)findViewById(R.id.user_pass);
        String user_name=name.getText().toString();
        String user_pass=pass.getText().toString();
        if(user_name.equals("")||user_pass.equals("")){
            alertDialog.show();
        }
        else if(db.getData(user_name,user_pass)){
            Intent intent=new Intent(this,Dashboard.class);
            startActivity(intent);
        }
    }
}
