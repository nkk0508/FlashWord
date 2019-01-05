package com.websarva.wings.android.flashword;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by keita0508 on 2019/01/04.
 */
public class WordOpenHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "myapp.db";
    public static final int DB_VERSION = 1;
    public static final String CREATE_TABLE = "create table " + UserContract.Words.TABLE_NAME + " (" +
            UserContract.Words._ID + " integer primary key autoincrement, " +
            UserContract.Words.COL_ENGLISH + " text," +
            UserContract.Words.COL_JAPANESE + " text," +
            UserContract.Words.COL_PART + " text," +
            UserContract.Words.COL_LEVEL + " text)";
    public static final String INIT_TABLE = "insert into words (english, japanese, part, level) values " +
             "('accept', 'を受け入れる', 'verb', 'h1'), " +
             "('achieve', 'を達成する', 'verb', 'h1'), " +
             "('acquire', 'を身につける', 'verb', 'h1'), " +
             "('add', 'を付け加える', 'verb', 'h1'), " +
             "('advance', '前進する', 'verb', 'h1'), " +
             "('affect', 'に影響を与える', 'verb', 'h1'), " +
             "('agree', '同意する', 'verb', 'h1'), " +
             "('allow', 'を許可する', 'verb', 'h1') ";
    public static final String DROP_TABLE = "drop table if exists Words";

    public WordOpenHelper(Context c) {
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