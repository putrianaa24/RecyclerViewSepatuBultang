package com.example.sepatu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

abstract class ListSepatuAdapter extends RecyclerView.Adapter<ListSepatuAdapter.ListViewHolder>{
    private ArrayList<Data_Sepatu> listSepatu;

    public ListSepatuAdapter(ArrayList<Data_Sepatu> list) {
        this.listSepatu = list; }


    @NonNull @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listsepatu, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Data_Sepatu dataSepatu =listSepatu.get(position);
        Glide.with(holder.itemView.getContext()).load(dataSepatu.getFoto())
                .apply(new RequestOptions())
                .into(holder.FotoSepatu);

        holder.NamaSepatu.setText(dataSepatu.getNama());
        holder.tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), "Berhasil memesan " + dataSepatu.getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listSepatu.size(); }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView FotoSepatu;
        TextView NamaSepatu;
        Button tambah;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            FotoSepatu = itemView.findViewById(R.id.fotosepatu);
            NamaSepatu = itemView.findViewById(R.id.namasepatu);
            tambah = itemView.findViewById(R.id.tambah); }

    }
}
