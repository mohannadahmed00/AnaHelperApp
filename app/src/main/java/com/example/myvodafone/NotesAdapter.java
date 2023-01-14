package com.example.myvodafone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesVH> {
    ArrayList<String> list;

    @NonNull
    @Override
    public NotesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesVH holder, int position) {
        holder.textView.setText("-"+list.get(position)+".");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class NotesVH extends RecyclerView.ViewHolder {
        TextView textView;
        public NotesVH(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.simple_text);
        }
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
