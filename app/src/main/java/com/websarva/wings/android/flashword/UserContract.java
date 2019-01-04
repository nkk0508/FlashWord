package com.websarva.wings.android.flashword;

import android.provider.BaseColumns;

/**
 * Created by keita0508 on 2019/01/04.
 */
public final class UserContract {

    public UserContract() {}

    public static abstract class Users implements BaseColumns { // _id
        public static final String TABLE_NAME = "users";
        public static final String COL_NAME = "name";
        public static final String COL_SCORE = "score";
    }
}