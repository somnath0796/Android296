package develops.mad.testbackground; /**
 * Created by Somnath on 23-06-2016.
 * Contains all database addition modules
 * for all activities
 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "planner.db";

    //Table Notes Data
    public static final String TABLE_NOTES = "notes";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_TITLE = "Title";
    public static final String COLUMN_NOTEVAL = "NoteVal ";

    //Table Tasks Data
    public static final String TABLE_TASKS = "TASKS";
    public static final String TASKS_ID = "T_ID";
    public static final String TASKS_NAME = "T_NAME";
    public static final String TASKS_DATE = "T_DATE";
    public static final String TASKS_TIME = "T_TIME";
    public static final String TASKS_TYPE = "T_TYPE";
    public static final String TASKS_COMPLETION = "T_COMP";

    //Table Reminders Data
    public static final String TABLE_REMINDERS = "REMINDERS";
    public static final String REMIND_ID = "R_ID";
    public static final String REMIND_VAL = "R_VAL";
    public static final String REMIND_DATE = "R_DATE";
    public static final String REMIND_TIME = "R_TIME";





    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //table creation for Notes
        String query = "CREATE TABLE " + TABLE_NOTES + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_NOTEVAL + " TEXT " +
                ");";
        db.execSQL(query);

        //table creation for Tasks
        query = "CREATE TABLE " + TABLE_TASKS + "(" +
                TASKS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TASKS_NAME+ " TEXT, " +
                TASKS_DATE + " TEXT, " +
                TASKS_TIME + " TEXT, " +
                TASKS_TYPE + " TEXT, " +
                TASKS_COMPLETION + " INTEGER " +
                ");";
        db.execSQL(query);

        //table creation for Reminders
        query = "CREATE TABLE " + TABLE_REMINDERS + "(" +
                REMIND_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                REMIND_VAL + " TEXT, " +
                REMIND_DATE + " TEXT, " +
                REMIND_TIME + " TEXT " +
                ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NOTES);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_TASKS);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_REMINDERS);
        onCreate(db);

    }

    //gets the current Date
    public String getCurrentDate(){
        String date = "";
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT DATE('NOW')";
        Cursor c = db.rawQuery(query,null);

        c.moveToFirst();

        date  = c.getString(c.getColumnIndex("DATE('NOW')"));
        return date;
    }

    //gets Yesterday's Date
    public String getYesterday(){
        String date = "";
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT DATE('NOW','-1')";
        Cursor c = db.rawQuery(query,null);

        c.moveToFirst();

        date  = c.getString(c.getColumnIndex("DATE('NOW','-1')"));
        return date;
    }

    //gets Tomorrow's Date
    public String getTomorrow(){
        String date = "";
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT DATE('NOW','+1')";
        Cursor c = db.rawQuery(query,null);

        c.moveToFirst();

        date  = c.getString(c.getColumnIndex("DATE('NOW','+1')"));
        return date;
    }

    public String getNowTime(){
        String time="";
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT strftime('%H:%M','now','localtime');";
        Cursor c = db.rawQuery(query,null);

        c.moveToFirst();

        time = c.getString(c.getColumnIndex("strftime('%H:%M','now','localtime')"));
        return time;
    }

}
