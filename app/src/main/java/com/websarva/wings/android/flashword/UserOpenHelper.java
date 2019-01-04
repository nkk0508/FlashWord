package com.websarva.wings.android.flashword;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by keita0508 on 2019/01/04.
 */
public class UserOpenHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "myapp.db";
    public static final int DB_VERSION = 1;
    public static final String CREATE_TABLE =
            "create table " + UserContract.Users.TABLE_NAME + " (" +
                    UserContract.Users._ID + " integer primary key autoincrement, " +
                    UserContract.Users.COL_NAME + " text," +
                    UserContract.Users.COL_SCORE + " integer)";
    public static final String INIT_TABLE =
            "insert into users (name, score) values " +
                    "('taguchi', 42), " +
                    "('fkoji', 82), " +
                    "('dotinstall', 62)";
    public static final String DROP_TABLE =
            "drop table if exists users";

    public UserOpenHelper(Context c) {
        super(c, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // create table
        sqLiteDatabase.execSQL(CREATE_TABLE);
        // init table
        sqLiteDatabase.execSQL(INIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // drop table
        sqLiteDatabase.execSQL(DROP_TABLE);
        // onCreate
        onCreate(sqLiteDatabase);
    }
}