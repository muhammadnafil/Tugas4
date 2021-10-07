package com.nafil.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder>{

    //Menambahkan properti ArrayList
    private ArrayList<String> logoklub = new ArrayList<>();
    private ArrayList<String> namaklub = new ArrayList<>();
    private ArrayList<String> tanggalklub = new ArrayList<>();
    private ArrayList<String> julukanklub = new ArrayList<>();
    private ArrayList<String> daerahklub = new ArrayList<>();
    private ArrayList<String> deskripsiklub = new ArrayList<>();
    private Context context;
    //Menambahkan adapter
    public RecyclerViewAdapter(ArrayList<String> logoklub, ArrayList<String> namaklub, ArrayList<String> tanggalklub, ArrayList<String> julukanklub, ArrayList<String> daerahklub, ArrayList<String> deskripsiklub, Context context) {
        this.logoklub = logoklub;
        this.namaklub = namaklub;
        this.tanggalklub = tanggalklub;
        this.julukanklub = julukanklub;
        this.daerahklub = daerahklub;
        this.deskripsiklub = deskripsiklub;
        this.context = context;
    }

    //Layout
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        viewHolder holder = new viewHolder(view);
        return holder;
    }

    //Mengambil data dari setiap item
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).asBitmap().load(logoklub.get(position)).into(holder.logo);
        holder.nama.setText(namaklub.get(position));
        holder.tanggal.setText(tanggalklub.get(position));

        //Menambahkan event klik
        holder.linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Berpindah ke DetailActivity
                Intent intent = new Intent(context, DetailActivity.class);

                //Menyimpan data di dalam memori terlehi dahulu kemudian diterima oleh DetailActtivity
                intent.putExtra("logo_klub", logoklub.get(position));
                intent.putExtra("nama_klub", namaklub.get(position));
                intent.putExtra("tanggal_klub", tanggalklub.get(position));
                intent.putExtra("julukan_klub", julukanklub.get(position));
                intent.putExtra("daerah_klub", daerahklub.get(position));
                intent.putExtra("deskripsi_klub", deskripsiklub.get(position));

                //mengirimkan data
                context.startActivity(intent);
            }
        });
    }

    //Menentukan urutan item
    @Override
    public int getItemCount() {
        return namaklub.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        //Menambahkan property
        ImageView logo;
        TextView nama, tanggal;
        LinearLayout linearlayout;

        //Membuat constructor class viewHolder
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.img);
            nama = itemView.findViewById(R.id.tvNama);
            tanggal = itemView.findViewById(R.id.tvTanggal);
            linearlayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
