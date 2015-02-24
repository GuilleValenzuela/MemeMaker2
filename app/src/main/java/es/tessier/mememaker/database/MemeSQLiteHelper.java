package es.tessier.mememaker.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Evan Anger on 8/17/14.
 */
public class MemeSQLiteHelper extends SQLiteOpenHelper {
    private static final String TAG= MemeSQLiteHelper.class.getName();
    public static String DB_NAME = "meme.db";
    public static int DB_VERSION=1;

    public MemeSQLiteHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
   Log.d(TAG,CREATE_TABLE_ANNOTATIONS);

    db.execSQL(CREATE_TABLE_MEMES);
    db.execSQL(CREATE_TABLE_ANNOTATIONS);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Meme Table functionality

    public static final String TABLE_NAME="memes";
    public static final String CN_MEMES_ASSETS="assets";
    public static final String CN_NAME="name";
    public static final String CN_ID="_id";

    public static final String CREATE_TABLE_MEMES = "CREATE TABLE " + TABLE_NAME + "("
            + CN_ID +" integer  primary key autoincrement , "
            + CN_MEMES_ASSETS + " text not null,"
            + CN_NAME + " text not null)";

    //Meme Table Annotations functionality
    public static final String TABLE_NAMEA="annotations";
    public static final String CN_IDA="id";
    public static final String CN_TITTLE="titulo";
    public static final String CN_Y="ejex";
    public static final String CN_X="ejey";
    public static final String CN_COLOR="color";
    public static final String CN_MEME_ID="meme_id";


    public static final String CREATE_TABLE_ANNOTATIONS = "CREATE TABLE " + TABLE_NAMEA + "("
            + CN_IDA + " integer primary key autoincrement, "
            + CN_TITTLE + " text not null,"
            + CN_Y + " integer not null,"
            + CN_X + " integer not null,"
            + CN_COLOR + " integer not null,"
            + CN_MEME_ID + " integer ADD FOREIGN KEY (fk_meme_id) REFERENCE MEMES( " + CN_ID +"))";
}

