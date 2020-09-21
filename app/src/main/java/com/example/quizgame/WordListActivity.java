package com.example.quizgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizgame.model.WordItem;

public class WordListActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_word_list);

      // สร้าง Layout manager
      LinearLayoutManager lm = new LinearLayoutManager(WordListActivity.this);

      // สร้าง Adapter object
      MyAdapter adapter = new MyAdapter();

      // เข้าถึง  RecyclerView ใน layout
      RecyclerView rv = findViewById(R.id.word_list_recycler_view);
      rv.setLayoutManager(lm); // กำหนด layout manager ให้กับ RecyclerView
      rv.setAdapter(adapter); // กำหนด adapter ให้กับ RecyclerView

   }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

   private WordItem[] items = {
         new WordItem(R.drawable.purple, "PURPLE","สีม่วง"),
         new WordItem(R.drawable.cyan, "CYAN","สีเทา"),
         new WordItem(R.drawable.red, "RED","สีแดง"),
         new WordItem(R.drawable.black, "BLACK","สีดำ"),
         new WordItem(R.drawable.yellow, "YELLOW","สีเหลือง"),
         new WordItem(R.drawable.lime, "LIME","สีเขียวมะนาว"),
         new WordItem(R.drawable.green, "GREEN","สีเขียว"),
         new WordItem(R.drawable.orange, "ORANGE","สีส้ม"),
         new WordItem(R.drawable.white, "WHITE","สีขาว"),
         new WordItem(R.drawable.brown, "BROWN","สีน้ำตาล"),
         new WordItem(R.drawable.bule, "BULE","สีน้ำเงิน"),
         new WordItem(R.drawable.pink, "PINK","สีชมพู")

   };


   MyAdapter() {

   }

   @NonNull
   @Override
   public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_word, parent, false);
      MyViewHolder vh = new MyViewHolder(v);
      return vh;
   }

   @Override
   public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.imageView.setImageResource(items[position].imageResId);
      holder.wordTextView.setText(items[position].word);
      holder.THwordTextview.setText(items[position].THword);

   }

   @Override
   public int getItemCount() {
      return items.length;
   }

   static class MyViewHolder extends RecyclerView.ViewHolder {
     public ImageView imageView;
     public TextView wordTextView;
     public TextView THwordTextview;

      MyViewHolder(@NonNull View itemView) {
         super(itemView);
         imageView = itemView.findViewById(R.id.image_view);
         wordTextView = itemView.findViewById(R.id.word_text_view);
         THwordTextview = itemView.findViewById(R.id.THword_text_view);
      }
   }
}