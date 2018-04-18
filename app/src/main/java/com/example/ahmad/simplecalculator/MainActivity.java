package com.example.ahmad.simplecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText bil1,bil2;
    private TextView hasil;
    private Button btntambah,btnkurang,btnkali,btnbagi;
    private Double angka1,angka2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();

    }

    private void initial(){
        bil1 = (EditText) findViewById(R.id.angka1);
        bil2 = (EditText) findViewById(R.id.angka2);
        hasil = (TextView) findViewById(R.id.hasil);
        btntambah = (Button) findViewById(R.id.btn_tambah);
        btnkurang = (Button) findViewById(R.id.btn_kurang);
        btnkali = (Button) findViewById(R.id.btn_kali);
        btnbagi = (Button) findViewById(R.id.btn_bagi);

        btntambah.setOnClickListener(this);
        btnkurang.setOnClickListener(this);
        btnkali.setOnClickListener(this);
        btnbagi.setOnClickListener(this);
    }

    public void onClick (View view){
        if(TextUtils.isEmpty(bil1.getText().toString()) && TextUtils.isEmpty(bil2.getText().toString())){
            hasil.setText("0");
        }else if(!TextUtils.isEmpty(bil1.getText().toString()) && TextUtils.isEmpty(bil2.getText().toString())){
            hasil.setText(bil1.getText().toString());
        }else if(TextUtils.isEmpty(bil1.getText().toString()) && !TextUtils.isEmpty(bil2.getText().toString())){
            hasil.setText(bil2.getText().toString());
        }else{
            angka1 = Double.parseDouble(bil1.getText().toString());
            angka2 = Double.parseDouble(bil2.getText().toString());
            Perhitungan hitung = new Perhitungan(angka1,angka2);
            switch(view.getId()){
                case R.id.btn_tambah:
                    hasil.setText(String.valueOf(hitung.tambah()));
                    break;
                case R.id.btn_kurang:
                    hasil.setText(String.valueOf(hitung.kurang()));
                    break;
                case R.id.btn_kali:
                    hasil.setText(String.valueOf(hitung.kali()));
                    break;
                case R.id.btn_bagi:
                    hasil.setText(hitung.bagi());
                    break;
            }
        }
    }
}
