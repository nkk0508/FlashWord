package com.websarva.wings.android.flashword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        // users (name, score)

        // open helper

        // open db
        UserOpenHelper userOpenHelper = new UserOpenHelper(this);
        SQLiteDatabase db = userOpenHelper.getWritableDatabase();

        // 処理 select, insert, update, delete
        Cursor c = null;
        c = db.query(
                UserContract.Users.TABLE_NAME,
                null, // fields
                UserContract.Users.COL_SCORE + " > ?", // where
                new String[] { "50" }, // where arg
                null, // groupBy
                null, // having
                UserContract.Users.COL_SCORE + " desc",  // order by
                "1"
        );
        Log.v("DB_TEST", "Count: " + c.getCount());
        while(c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex(UserContract.Users._ID));
            String name = c.getString(c.getColumnIndex(UserContract.Users.COL_NAME));
            int score = c.getInt(c.getColumnIndex(UserContract.Users.COL_SCORE));
            Log.v("DB_TEST", "id: " + id + " name: " + name + " score: " + score);
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