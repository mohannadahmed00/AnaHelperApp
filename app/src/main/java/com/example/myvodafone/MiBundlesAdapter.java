package com.example.myvodafone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myvodafone.model.BundleMI;

import java.util.ArrayList;

public class MiBundlesAdapter extends RecyclerView.Adapter<MiBundlesAdapter.MiBundlesHolder> {
    ArrayList<BundleMI> list;

    @NonNull
    @Override
    public MiBundlesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MiBundlesHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mi_bundle, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MiBundlesHolder holder, int position) {
        holder.tvPrice.setText(list.get(position).price);
        holder.tvMb.setText(list.get(position).mb);
        holder.tvCode.setText(list.get(position).code);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MiBundlesHolder extends RecyclerView.ViewHolder {
        TextView tvPrice,tvMb,tvCode;

        public MiBundlesHolder(@NonNull View itemView) {
            super(itemView);
            tvPrice=itemView.findViewById(R.id.tv_price_mi);
            tvMb=itemView.findViewById(R.id.tv_mb_mi);
            tvCode=itemView.findViewById(R.id.tv_code_mi);

        }
    }

    public void setList(ArrayList<BundleMI> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
