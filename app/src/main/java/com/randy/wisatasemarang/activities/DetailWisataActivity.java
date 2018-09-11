package com.randy.wisatasemarang.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.randy.wisatasemarang.R;
import com.randy.wisatasemarang.helper.Constants;

public class DetailWisataActivity extends AppCompatActivity {

    ImageView ivGambarWisata;
    TextView tvAlamatWisata, tvDeskripsiWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivGambarWisata = (ImageView) findViewById(R.id.iv_detail_gambar);
        tvAlamatWisata = (TextView) findViewById(R.id.tv_detail_alamat);
        tvDeskripsiWisata = (TextView) findViewById(R.id.tv_detail_deskripsi);

        Bundle b = getIntent().getExtras();
        String namaWisata = b.getString(Constants.NAMA_WISATA);
        String gambarWisata = b.getString(Constants.GAMBAR_WISATA);
        String alamatWisata = b.getString(Constants.ALAMAT_WISATA);
        String deskripsiWisata = b.getString(Constants.DESKRIPSI_WISATA);

        getSupportActionBar().setTitle(namaWisata);
        Glide.with(this).load("https://drive.google.com/thumbnail?id=" + gambarWisata).into(ivGambarWisata);
        tvAlamatWisata.setText(alamatWisata);
        tvDeskripsiWisata.setText(deskripsiWisata);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
