package com.example.bookshop;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Myadapter extends ArrayAdapter {
    Activity context;
    String[] authorname;
    String[] bookname;

    public Myadapter(Context context, int resource, Activity context1, String[] authorname, String[] bookname) {
        super(context, resource,bookname);
        this.context = context1;
        this.authorname = authorname;
        this.bookname = bookname;
    }
    @Override
   public View getView(int position, View convertView,  ViewGroup parent) {

        View view =LayoutInflater.from(getContext()).inflate(R.layout.list_row_layout,null);
        TextView bookTV=view.findViewById(R.id.textView2);
        TextView author=view.findViewById(R.id.textView);


        bookTV.setText(bookname[position]);
        author.setText(authorname[position]);
        return view;
   }
   void notifyDataset()
   {
       notifyDataSetChanged();
   }



}
