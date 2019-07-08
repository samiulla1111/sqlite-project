package com.example.bookshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;
public class DBHelperClass extends SQLiteOpenHelper {
    public DBHelperClass(Context context) {
        super(context, Book.DATABASE_NAME, null, 7);
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
        contentValues.put(Book.COLUMN_BOOKNAME,book.getBookName());
        contentValues.put(Book.COLUMN_AUTHORNAME,book.getAuthorName());

        //pushed row to database table
        long id=sqLiteDatabase.insert(Book.TABLE_NAME,null,contentValues);
       // sqLiteDatabase.close();
        return id;

    }

    public List<Book> REDABOOK()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+Book.TABLE_NAME,null);
        List<Book> booklist= new ArrayList<Book>();
        if(cursor.moveToFirst())
        {
            Book book;
            do {
                book=new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setBookName(cursor.getString(1));
            //    book.setBookname(cursor.getString(1));
                book.setAuthorName(cursor.getString(2));
        //        book.setAuthorname(cursor.getString(2));


                booklist.add(book);

            }while(cursor.moveToNext());

        }
        return booklist;

    }
    public int deleteBook(Book book)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        int t=sqLiteDatabase.delete(Book.TABLE_NAME,Book.COLUMN_BOOKNAME+"=?",new String[]{book.getBookName()});
        sqLiteDatabase.close();

        return t;
    }
    public int updateBook(Book book)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(Book.COLUMN_AUTHORNAME,book.getAuthorName());
        contentValues.put(Book.COLUMN_BOOKNAME,book.getBookName());

        int t=sqLiteDatabase.update(Book.TABLE_NAME,contentValues,Book.COLUMN_BOOKNAME+"=?",new String[]{book.getBookName()});
        sqLiteDatabase.close();

        return t;

    }

}
