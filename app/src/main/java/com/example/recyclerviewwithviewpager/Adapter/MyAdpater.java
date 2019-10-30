package com.example.recyclerviewwithviewpager.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewwithviewpager.R;
import com.example.recyclerviewwithviewpager.Utils.MyDiffUtilCallback;

import java.util.List;

public class MyAdpater extends RecyclerView.Adapter<MyAdpater.MyViewHolder> {
    List<String> mylist;

    public MyAdpater(List<String> mylist) {
        this.mylist = mylist;
    }

    public void insertData(List<String> insertList){
        MyDiffUtilCallback myDiffUtilCallback=new MyDiffUtilCallback(mylist,insertList);
        DiffUtil.DiffResult diffResult=DiffUtil.calculateDiff(myDiffUtilCallback);

        mylist.addAll(insertList);
        diffResult.dispatchUpdatesTo(this);
    }
    public void updateData(List<String> newList){
        MyDiffUtilCallback myDiffUtilCallback=new MyDiffUtilCallback(mylist,newList);
        DiffUtil.DiffResult diffResult=DiffUtil.calculateDiff(myDiffUtilCallback);

        mylist.clear();
        mylist.addAll(newList);
        diffResult.dispatchUpdatesTo(this);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(mylist.get(position));

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textview1);

        }
    }
}
