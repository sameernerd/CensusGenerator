package com.example.sameerraj.censusgenerator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.CheckBox;
import android.widget.EditText;

public class EnrollmentForm extends AppCompatActivity {
    Database_Enroll de=new Database_Enroll(this);
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollment_form);
        Intent intent=getIntent();
        alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Data Missing");
        alertDialog.setMessage("All fileds are mandatory");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Go Back", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int id){
                dialog.cancel();
            }
        });
        if(intent.hasExtra("info")){
            ((EditText)findViewById(R.id.name)).setText("here");
            String s[]=intent.getStringArrayExtra("info");
            ((EditText)findViewById(R.id.name)).setText(s[0]);
            if(s[1].equals("Male")){
                ((CheckBox)findViewById(R.id.cb_male)).setEnabled(true);
            }
            else ((CheckBox)findViewById(R.id.cb_female)).setEnabled(true);
            ((EditText)findViewById(R.id.pob)).setText(s[2]);
            ((EditText)findViewById(R.id.dob)).setText(s[3]);
            ((EditText)findViewById(R.id.father_name)).setText(s[4]);
            ((EditText)findViewById(R.id.mother_name)).setText(s[5]);
        }
    }
    public void onSubmit(View view){
        Intent intent=new Intent(this,LastStage.class);
        String name=((EditText)findViewById(R.id.name)).toString();
        String gender="";
        if(((CheckBox)findViewById(R.id.cb_male)).isChecked())gender="Male";
        else if(((CheckBox)findViewById(R.id.cb_female)).isChecked())gender="Female";
        String pob=((EditText)findViewById(R.id.pob)).toString();
        String dob=((EditText)findViewById(R.id.dob)).toString();
        String father_name=((EditText)findViewById(R.id.father_name)).toString();
        String mother_name=((EditText)findViewById(R.id.mother_name)).toString();
        if(name.equals("")||gender.equals("")||pob.equals("")||dob.equals("")||father_name.equals("")||mother_name.equals("")){
            alertDialog.show();
        }
        else if(de.insertData(name,gender,dob,pob,father_name,mother_name)){
            startActivity(intent);
        }
        else{
            //Still underconstruction
        }
    }
}
