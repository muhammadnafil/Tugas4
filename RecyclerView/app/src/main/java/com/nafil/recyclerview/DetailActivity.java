package com.nafil.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    //Deklarasi object
    ImageView img;
    TextView tvNama, tvTanggal, tvJulukan, tvDaerah, tvDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Memberikan nilai dengan memanggil ID setiap object
        img = findViewById(R.id.img);
        tvNama = findViewById(R.id.tvNama);
        tvTanggal = findViewById(R.id.tvTanggal);
        tvJulukan = findViewById(R.id.tvJulukan);
        tvDaerah = findViewById(R.id.tvDaerah);
        tvDeskripsi = findViewById(R.id.tvDeskripsi);

        //Menjalankan pegambilan data
        getIncomingExtra();
    }
    //Method untuk mengambil data yang dikirimkan
    private void getIncomingExtra() {
        //Pengecekan apakah memiliki Extra
        if(getIntent().hasExtra("logo_klub") && getIntent().hasExtra("nama_klub")
                && getIntent().hasExtra("tanggal_klub") && getIntent().hasExtra("julukan_klub")
                && getIntent().hasExtra("daerah_klub") & getIntent().hasExtra("deskripsi_klub")){

            //Membuat variable untuk mengambil nilai string
            String logoklub = getIntent().getStringExtra("logo_klub");
            String namaklub = getIntent().getStringExtra("nama_klub");
            String tanggalklub = getIntent().getStringExtra("tanggal_klub");
            String julukanklub = getIntent().getStringExtra("julukan_klub");
            String daerahklub = getIntent().getStringExtra("daerah_klub");
            String deskripsiklub = getIntent().getStringExtra("deskripsi_klub");

            //Menjalankan
            setDataActivity(logoklub, namaklub, tanggalklub, julukanklub, daerahklub, deskripsiklub);
        }
    }
    //Method untuk mengirimkan data
    private void setDataActivity(
            String logoklub, String namaklub, String tanggalklub,
            String julukanklub, String daerahklub,String deskripsiklub){

        //Memasukkan data ke dalam objek sesuai dengan tempatnya
        Glide.with(this).asBitmap().load(logoklub).into(img);
        tvNama.setText(namaklub);
        tvTanggal.setText(tanggalklub);
        tvJulukan.setText(julukanklub);
        tvDaerah.setText(daerahklub);
        tvDeskripsi.setText(deskripsiklub);

    }
}