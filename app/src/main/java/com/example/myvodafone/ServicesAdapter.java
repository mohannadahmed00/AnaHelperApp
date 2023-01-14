package com.example.myvodafone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myvodafone.model.ServiceModel;

import java.util.ArrayList;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.CodesVH> {
    ArrayList<ServiceModel> list;
    Context context;

    @NonNull
    @Override
    public CodesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new CodesVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.mi_bundle, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CodesVH holder, int position) {
        if (list.get(position).type.equals("in")){
            //holder.linearLayout.setBackgroundColor(context.getResources().getColor(android.R.color.holo_green_light));
            holder.linearLayout.setBackgroundResource(R.drawable.button_background_green);

        }else if (list.get(position).type.equals("out")){
            //holder.linearLayout.setBackgroundColor(context.getResources().getColor(android.R.color.holo_red_light));
            holder.linearLayout.setBackgroundResource(R.drawable.button_background_red);

        }else {
            //holder.linearLayout.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
            holder.linearLayout.setBackgroundResource(R.drawable.button_background_gray);

        }
        holder.tvCode.setText(list.get(position).code);
        holder.tvPrice.setText(list.get(position).price);
        holder.tvNote.setText(list.get(position).overView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CodesVH extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        TextView tvCode,tvPrice,tvNote;

        public CodesVH(@NonNull View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.l_mi_bundle);
            tvCode=itemView.findViewById(R.id.tv_price_mi);
            tvPrice=itemView.findViewById(R.id.tv_mb_mi);
            tvNote=itemView.findViewById(R.id.tv_code_mi);

        }
    }

    public void setList(ArrayList<ServiceModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
