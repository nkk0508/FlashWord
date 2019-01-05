package com.websarva.wings.android.flashword;

import android.provider.BaseColumns;

/**
 * Created by keita0508 on 2019/01/04.
 */
public final class WordsContract {

    public WordsContract() {}

    public static abstract class Words implements BaseColumns { // _id
        public static final String TABLE_NAME = "words";
        public static final String COL_ENGLISH = "english";
        public static final String COL_JAPANESE = "japanese";
        public static final String COL_PART = "part";
        public static final String COL_LEVEL = "level";
    }
}