package com.creativestoreid.arf.holidayinsukabumi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailHoliday extends AppCompatActivity {

    ImageView photo;
    TextView lokasi,namatempat,desc,jambuka,fasiitas,hargatiket;
    private String title = "Detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_holiday);
        getSupportActionBar().setTitle(title);

        photo = findViewById(R.id.dt_photo);
        lokasi = findViewById(R.id.dt_lokasi);
        namatempat = findViewById(R.id.dt_nama);
        desc = findViewById(R.id.dt_deksripsi);
        jambuka = findViewById(R.id.dt_jambuka);
        fasiitas = findViewById(R.id.dt_fasilitas);
        hargatiket = findViewById(R.id.dt_hargatiket);

        Intent intent = getIntent();
        String strphoto = intent.getStringExtra("AmbilPhoto");
        String strlokasi = intent.getStringExtra("AmbilLokasi");
        String strnama = intent.getStringExtra("AmbilNama");
        String strdesc = intent.getStringExtra("AmbilDeskripsi");
        String strjam = intent.getStringExtra("AmbilJam");
        String strharga = intent.getStringExtra("AmbilHarga");
        String strfasilitas = intent.getStringExtra("AmbilFasilitas");

        Glide.with(this)
                .load(strphoto)
                .into(photo);
        lokasi.setText(strlokasi);
        namatempat.setText(strnama);
        desc.setText(strdesc);
        jambuka.setText(strjam);
        fasiitas.setText(strfasilitas);
        hargatiket.setText(strharga);

    }


}
