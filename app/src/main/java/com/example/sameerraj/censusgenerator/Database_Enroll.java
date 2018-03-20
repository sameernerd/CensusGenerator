package com.example.sameerraj.censusgenerator;
/**
 * Created by Sameer Raj on 20-03-2018.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database_Enroll extends SQLiteOpenHelper{
    public static String Database_Name="enroll_data";
    public static String TABLE_NAME="enrolls";
    public static String Name="name";
    public static String Gender="gender";
    public static String Place_Of_Birth="pob";
    public static String Date_Of_Birth="dob";
    public static String Father_Name="father_name";
    public static String Mother_Name="mother_name";
    public Database_Enroll(Context context){
        super(context,Database_Name,null,1);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"( "+
        Name+" TEXT "+Gender+" TEXT "+Place_Of_Birth+" TEXT "+Father_Name+" TEXT "+Mother_Name+" TEXT )"
        );
    }
    public void onUpgrade(SQLiteDatabase db,int a,int b){

    }

    public boolean insertData(String name,String gender,String dob,String pob,String fname,String mname){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(Name,name);
        content.put(Gender,gender);
        content.put(Date_Of_Birth,dob);
        content.put(Place_Of_Birth,pob);
        content.put(Father_Name,fname);
        content.put(Mother_Name,mname);
        db.insert(TABLE_NAME,null,content);
        return true;
    }

        public StringBuilder getData(){
            StringBuilder ans=new StringBuilder();
            SQLiteDatabase db=this.getReadableDatabase();
            Cursor cur=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
            if(cur.moveToFirst()){
                do{
                    ans.append(1);
                }while(cur.moveToNext());
            }
            return ans;
        }
}
