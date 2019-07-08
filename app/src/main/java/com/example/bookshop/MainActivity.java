package com.example.bookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import java.lang.String;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameOfBook,authorName;
    Button addBooks,deleteBooks,updateBooks,ViewBooks;
    int buttonclickcount;
    String nam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        authorName=findViewById(R.id.editText);
        nameOfBook=findViewById(R.id.editText2);
        addBooks=findViewById(R.id.button);
        updateBooks=findViewById(R.id.button2);
        deleteBooks=findViewById(R.id.button3);
        ViewBooks=findViewById(R.id.button4);

       addBooks.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DBHelperClass dbHelperClass = new DBHelperClass(MainActivity.this);
               Book book=new Book();
               book.setAuthorName(authorName.getText().toString().toLowerCase());
      //         book.setAuthorame(name.getText().toString());
               book.setBookName(nameOfBook.getText().toString().toLowerCase());
          //     book.setBookname(pass.getText().toString());
               long id = dbHelperClass.addBooks(book);

               Toast.makeText(MainActivity.this,"the book has been stored with id"+id,Toast.LENGTH_SHORT).show();
           }
       });
       ViewBooks.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent =new Intent(MainActivity.this,ViewBookActivity.class);
               intent.putExtra("SIGNAL","VIEW");
               startActivity(intent);
           }
       });
       deleteBooks.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
//               Book book=new Book();
//               book.setAuthorName(authorName.getText().toString().toLowerCase());
//               book.setBookName(nameOfBook.getText().toString().toLowerCase());
//
//               DBHelperClass dbHelperClass=new DBHelperClass(MainActivity.this);
//               dbHelperClass.deleteBook(book);
               Intent intent;
               intent = new Intent(MainActivity.this,ViewBookActivity.class);
               intent.putExtra("SIGNAL","DELETE");
               startActivity(intent);

           }
       });

       buttonclickcount=0;

       updateBooks.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            Book book = new Book();
            book.setBookName(nameOfBook.getText().toString());
            book.setAuthorName(authorName.getText().toString());
            DBHelperClass dbHelperClass=new DBHelperClass(MainActivity.this);
            dbHelperClass.updateBook(book);
            Toast.makeText(MainActivity.this,"Author name is updated as "+book.getAuthorName(),Toast.LENGTH_SHORT).show();

           }
       });
    }
}
