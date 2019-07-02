package com.example.bookshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.lang.String;

public class DBHelperClass extends SQLiteOpenHelper {
    public DBHelperClass(Context context) {
        super(context, Book.DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Book.CRAETE_TABLE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Book.TABLE_NAME);

        onCreate(db);

    }
    //add values to my database
    public long addBooks(Book book) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //2 conent values
        ContentValues contentValues = new ContentValues();
        contentValues.put(Book.COLUMN_BOOKNAME,book.getBookname());
        contentValues.put(Book.COLUMN_AUTHORNAME,book.getAuthorname());

        //pushed row to database table
        long id=sqLiteDatabase.insert(Book.TABLE_NAME,null,contentValues);
        return id;
    }
}
