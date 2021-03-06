package com.scib.isratjahan.mchipsurvey.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by israt.jahan on 3/6/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DB_NAME = "mchip.db";

    public static  String DB_PATH ;
    public static final int DB_VERSION = 1;

    public static final String FORM= "form";

    public Context context;
    public boolean mDataBaseExist;



    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        if(android.os.Build.VERSION.SDK_INT >= 17){
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }
        else
        {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    public static int getDbVersion() {
        return DB_VERSION;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + FORM);

        // TODO Write drop commands for all the available tables

        onCreate(db);
    }

}

