package com.example.bookshop;

public class Book {
    static String TABLE_NAME = "BOOKS";
    static String DATABASE_NAME= "BOOKS_DATABASE";
    static String COLUMN_ID= "id";
    static String COLUMN_BOOKNAME= "bookName";
    static  String COLUMN_AUTHORNAME= "authorName";
    static String CRAETE_TABLE_QUERY= "CREATE TABLE "+TABLE_NAME+" ("+COLUMN_ID+" INTEGER PRIMARY AUTOINCREMENT, "+COLUMN_BOOKNAME+" TEXT, "+COLUMN_AUTHORNAME +"TEXT)";
    int id;
    String bookname;
    String authorname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }
}
