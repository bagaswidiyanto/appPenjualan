package com.example.aplikasi_penjualan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText editnamapel, editnamabar,
            editjumlahbar, editharga, edituangbay;
    private Button btnproses;
    private Button btnreset;
    private Button btnexit;
    private TextView txtnamapel;
    private TextView txtnamabar;
    private TextView txtjumlahbar;
    private TextView txtharga;
    private TextView txtuangbay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Aplikasi Penjualan");
        editnamapel   = (EditText)findViewById(R.id.nama_pelanggan);
        editnamabar   = (EditText)findViewById(R.id.nama_barang);
        editjumlahbar = (EditText)findViewById(R.id.jml_barang);
        editharga     = (EditText)findViewById(R.id.harga_barang);
        edituangbay   = (EditText)findViewById(R.id.jml_uang);

        btnproses     = (Button)findViewById(R.id.proses);
        btnreset      = (Button)findViewById(R.id.reset);
        btnexit       = (Button)findViewById(R.id.exit);

        txtnamapel    = (TextView)findViewById(R.id.nama_pelanggan);
        txtnamabar    = (TextView)findViewById(R.id.nama_barang);
        txtjumlahbar  = (TextView)findViewById(R.id.jml_barang);
        txtharga      = (TextView)findViewById(R.id.harga_barang);
        txtuangbay    = (TextView)findViewById(R.id.jml_uang);

        //setelah prosses
//        txttotalbelanja = (TextView)findViewById(R.id.total);
//        txtkembali      = (TextView)findViewById(R.id.kembalian);
//        txtketerangan   = (TextView)findViewById(R.id.keterangan);
//        txtbonus        = (TextView)findViewById(R.id.bonus);

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String namapelanggan = editnamapel.getText().toString().trim();
                String namabarang    = editnamabar.getText().toString().trim();
                String jumlahbarang  = editjumlahbar.getText().toString().trim();
                String hargabarang   = editharga.getText().toString().trim();
                String uangbayar     = edituangbay.getText().toString().trim();

                if(namapelanggan.equals("") || namabarang.equals("") || jumlahbarang.equals("") || hargabarang.equals("") || uangbayar.equals("")) {
                    Toast.makeText(getApplicationContext(), "Mohon Lengkapi Data", Toast.LENGTH_SHORT).show();
                } else {
                    double jb    = Double.parseDouble(jumlahbarang);
                    double h     = Double.parseDouble(hargabarang);
                    double ub    = Double.parseDouble(uangbayar);
                    double total = (jb*h);

                    Bundle b = new Bundle();
                    b.putString("nama_pelanggan", "Nama Pelanggan :" + namapelanggan);
                    b.putString("nama_barang", "Nama Barang : " + namabarang);
                    b.putString("jumlah_barang","Jumlah Barang : " + jumlahbarang);
                    b.putString("harga_barang", "Harga Barang : "+hargabarang);
                    b.putString("jumlah_uang", "Uang Bayar : "+uangbayar);
                    b.putString("total_belanja", "Total Belanja : "+total);


                    if (total >= 2000000){
                        b.putString("bonus", "Bonus : Hardisk");
                    }
                    else if (total >= 1500000){
                        b.putString("bonus", "Bonus : Keyboard");
                    }
                    else if (total >= 1000000){
                        b.putString("bonus", "Bonus : Mouse");
                    }
                    else if (total >= 500000){
                        b.putString("bonus", "bonus : Flash Disk");
                    }
                    else {
                        b.putString("bonus", "Bonus : Tidak Ada Bonus");
                    }


                    double uangkembalian = (ub-total);
                    if (ub<total){
                        b.putString("keterangan", "Keterangan : uang bayar kurang Rp. "+(-uangkembalian));
                        b.putString("kembalian", "Uang Kembalian : Rp. 0");
                    }
                    else {
                        b.putString("keterangan", "Keterangan : Tunggu Kembalian ");
                        b.putString("kembalian", "Uang Kembalian : "+uangkembalian);
                    }

                    Intent intent = new Intent( v.getContext(), HasilPenjualan.class);
                    intent.putExtras(b);
                   v.getContext().startActivity(intent);
                }






            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtnamapel.setText(" ");
                txtnamabar.setText(" ");
                txtjumlahbar.setText(" ");
                txtharga.setText(" ");
                txtuangbay.setText(" ");

                Toast.makeText(getApplicationContext(), "Data sudah direset", Toast.LENGTH_LONG).show();
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack( true);
            }
        });

    }
}
