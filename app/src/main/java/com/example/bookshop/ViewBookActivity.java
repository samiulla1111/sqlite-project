package com.example.bookshop;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Intent;
import android.widget.Toast;

import java.util.List;

public class ViewBookActivity extends AppCompatActivity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book);
        listview = findViewById(R.id.listView);

        Intent intent=getIntent();
        String signal =intent.getStringExtra("SIGNAL");

        Log.d("TESTNEW","COMING FROM "+signal);

        DBHelperClass dbHelperClass=new DBHelperClass(this);
        List<Book> bookisFetched =dbHelperClass.REDABOOK();


        final String authorname[] =new String[bookisFetched.size()];
        final String bookname[] =new String[bookisFetched.size()];
        int i=0;
        for(Book eachbook:bookisFetched)
        {
            authorname[i]=eachbook.getAuthorName();
            bookname[i]=eachbook.getBookName();
            i++;

        }
        final Myadapter myadapter = new Myadapter(this,R.layout.list_row_layout,ViewBookActivity.this,authorname,bookname);
        listview.setAdapter(myadapter);

        if(signal.equals("DELETE")) {
          listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  Book book=new Book();

                  book.setBookName(bookname[position]);


                 DBHelperClass dbHelperClass=new DBHelperClass(ViewBookActivity.this);
                 dbHelperClass.deleteBook(book);
                 myadapter.notifyDataSetChanged(); //delegation

                  Toast.makeText(ViewBookActivity.this, "Book deleted : "+bookname[position], Toast.LENGTH_SHORT).show();
              }
          });
      }


    }

}
