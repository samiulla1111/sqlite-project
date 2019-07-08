package com.example.bookshop;

public class Book {
    static String TABLE_NAME = "BOOKS";
    static String DATABASE_NAME= "BOOKS_DATABASE";
    static String COLUMN_ID= "id";
    static String COLUMN_BOOKNAME= "bookName";
    static  String COLUMN_AUTHORNAME= "authorName";
    static String CRAETE_TABLE_QUERY= "CREATE TABLE "+TABLE_NAME+" ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+COLUMN_BOOKNAME+" TEXT, "+COLUMN_AUTHORNAME +" TEXT)";

    int id;
    String bookName;
    String authorName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
