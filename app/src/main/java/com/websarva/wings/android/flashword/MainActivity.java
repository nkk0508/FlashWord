package com.websarva.wings.android.flashword;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by keita0508 on 2018/12/01.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // tableの定義 - contract class
        // Words (name, score)

        // open helper

        // open db
        WordsOpenHelper wordsOpenHelper = new WordsOpenHelper(this);
        SQLiteDatabase db = wordsOpenHelper.getWritableDatabase();

        // 処理 select, insert, update, delete
        Cursor c = null;
        c = db.query(
                WordsContract.Words.TABLE_NAME,
                null, // fields
                null, // where
                null, // where arg
                null, // groupBy
                null, // having
                null  // order by
        );
        Log.v("DB_TEST", "Count: " + c.getCount());
        while(c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex(WordsContract.Words._ID));
            String english = c.getString(c.getColumnIndex(WordsContract.Words.COL_ENGLISH));
            String japanese = c.getString(c.getColumnIndex(WordsContract.Words.COL_JAPANESE));
            String part = c.getString(c.getColumnIndex(WordsContract.Words.COL_PART));
            String level = c.getString(c.getColumnIndex(WordsContract.Words.COL_LEVEL));
            Log.v("DB_TEST", "id: " + id + " english: " + english + " japanese: " + japanese + " part: " + part + " level: " + level);
        }
        c.close();

        // close db
        db.close();
    }

    public void onStartButtonClick(View v) {
        Intent intent = new Intent(this, FlashActivity.class);
        startActivity(intent);
    }
}