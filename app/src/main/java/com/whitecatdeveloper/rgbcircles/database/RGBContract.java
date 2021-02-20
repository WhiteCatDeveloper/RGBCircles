package com.whitecatdeveloper.rgbcircles.database;

import android.provider.BaseColumns;

public class RGBContract {
    public static final class RGBEntry implements BaseColumns{
        public static final String TABLE_NAME = "achievements";
        public static final String COLUMN_MODE = "mode";
        public static final String COLUMN_LEVEL_OF_DIFFICULTY = "levelOfDifficulty";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_SCORE = "score";
        public static final String COLUMN_TIME_GAME = "timeGame";

        public static final String TYPE_TEXT = "TEXT";
        public static final String TYPE_INTEGER = "INTEGER";


        public static final String CREATE_COMMAND = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(" + _ID + " " + TYPE_INTEGER + "PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MODE + " " + TYPE_TEXT + ", " +
                COLUMN_LEVEL_OF_DIFFICULTY + " " + TYPE_TEXT + ", " +
                COLUMN_DATE + " " + TYPE_TEXT + ", " +
                COLUMN_SCORE + " " + TYPE_INTEGER +
                COLUMN_TIME_GAME + " " + TYPE_INTEGER +
                ")";

        public static final String DROP_COMMAND = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
