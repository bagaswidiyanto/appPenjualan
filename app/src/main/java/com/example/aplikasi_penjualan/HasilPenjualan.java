package com.example.aplikasi_penjualan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HasilPenjualan extends AppCompatActivity {

    private TextView namapelanggan, namabarang, jmlbarang, hargabarang, jmluang, totalsemua, kembalian, bonus, keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_penjualan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = null;
        bundle = this.getIntent().getExtras();
        namapelanggan = (TextView) findViewById(R.id.nama_pelanggan);
        namabarang = (TextView) findViewById(R.id.nama_barang);
        jmlbarang = (TextView) findViewById(R.id.jml_barang);
        hargabarang = (TextView) findViewById(R.id.harga_barang);
        jmluang = (TextView) findViewById(R.id.jml_uang);
        totalsemua = (TextView) findViewById(R.id.total);
        kembalian = (TextView) findViewById(R.id.kembalian);
        bonus = (TextView) findViewById(R.id.bonus);
        keterangan = (TextView) findViewById(R.id.keterangan);

        namapelanggan.setText(bundle.getString("nama_pelanggan"));
        namabarang.setText(bundle.getString("nama_barang"));
        jmlbarang.setText(bundle.getString("jumlah_barang"));
        hargabarang.setText(bundle.getString("harga_barang"));
        jmluang.setText(bundle.getString("jumlah_uang"));
        totalsemua.setText(bundle.getString("total_belanja"));
        bonus.setText(bundle.getString("bonus"));
        kembalian.setText(bundle.getString("kembalian"));
        keterangan.setText(bundle.getString("keterangan"));
    }
}
