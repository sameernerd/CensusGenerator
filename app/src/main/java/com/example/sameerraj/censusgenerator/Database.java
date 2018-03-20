package com.example.sameerraj.censusgenerator; /**
 * Created by Sameer Raj on 20-03-2018.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper{
    public static String Database_Name="LoginData.db";
    private static final int Database_Version=1;
    public static String Table_Name="logins";
    public static String Login_Name="username";
    public static String Login_Pass="pass";
//    public static String Name="name";
    public static String Id="_id";
//    public static String Gender="gender";
//    public static String DOB="dob";
//    public static String POB="pob";
//    public static String Permanent_Address="permanent_add"

    public Database(Context context){
        super(context,Database_Name,null,1);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+Table_Name+"("+
        Id+" INTEGER PRIMARY KEY,"+Login_Name+" TEXT ,"+Login_Pass+" TEXT )");
        ContentValues content=new ContentValues();
        content.put(Login_Name,"Sameer");
        content.put(Login_Pass,"sameer_hack");
        db.insert(Table_Name,null,content);
    }
    public void onUpgrade(SQLiteDatabase db,int a,int b){

    }
    public boolean getData(String username,String userpass){
        SQLiteDatabase db=this.getReadableDatabase();
        System.out.println("Here "+db);
        Cursor cur=db.rawQuery("SELECT * FROM "+Table_Name+" WHERE "+Login_Name+" = ? AND "
                +Login_Pass+" = ?",new String[]{username,userpass},null);
        if(cur.getCount()>=1)return true;
        else return false;
    }
}
