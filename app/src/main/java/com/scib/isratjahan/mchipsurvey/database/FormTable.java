package com.scib.isratjahan.mchipsurvey.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 *  Created by israt.jahan on 3/6/2016.
 *
 * @author israt
 */
public class FormTable {
    private static final String TAG = FormTable.class.getSimpleName();

    private static final String TABLE_NAME = DatabaseHelper.FORM;

    private static final String KEY_QID = "_qid"; // 0 -integer
    private static final String KEY_QDETAILS = "_qdetails"; // 1 - text
    private static final String KEY_QSTATUS = "_qstatus"; // 2 - text


    private Context tContext;

    public FormTable (Context context) {
        tContext = context;
        createTable();
    }

    private void createTable() {
        SQLiteDatabase db = openDB();
        String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + "( "
                + KEY_QID + " INTEGER PRIMARY KEY, " // 0 - int
                + KEY_QDETAILS + " TEXT, "              // 1 - text
                + KEY_QSTATUS + " TEXT "          // 2 - text
                + " )";
        db.execSQL(CREATE_TABLE_SQL);
        closeDB();
    }

    private SQLiteDatabase openDB() {
        return DatabaseManager.getInstance(tContext).openDatabase();
    }

    private void closeDB() {
        DatabaseManager.getInstance(tContext).closeDatabase();
    }

    public long insertRecords(int id, String det,boolean status){
        ContentValues values = new ContentValues();
        values.put(KEY_QID, id);
        values.put(KEY_QDETAILS, det);
        values.put(KEY_QSTATUS, status);
        SQLiteDatabase db = openDB();
        return db.insert(TABLE_NAME, null, values);
    }



    private long updateRecords(int id, String det, boolean status) {
        ContentValues values = new ContentValues();
        values.put(KEY_QID, id);
        values.put(KEY_QDETAILS, det);
        values.put(KEY_QSTATUS, status);
        SQLiteDatabase db = openDB();
        long ret = db.update(TABLE_NAME, values, KEY_QID + " = ?",
                new String[]{id + ""});
        closeDB();
        return ret;
    }




    public void dropTable() {
        SQLiteDatabase db = openDB();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        createTable();
        //Lg.d(TAG, "Table dropped and recreated.");
        closeDB();
    }
}
