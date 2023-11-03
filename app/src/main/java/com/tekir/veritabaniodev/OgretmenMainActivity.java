package com.tekir.veritabaniodev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OgretmenMainActivity extends AppCompatActivity {
    Connection connection;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogretmen_main);

        EditText ogrenciEkleNoTxt, ogrenciEkleAdTxt, ogrenciEkleSoyadTxt, ogrenciDuzenleNoTxt, ogrenciDuzenleVizeTxt, ogrenciDuzenleFinalTxt;
        Button ogrenciEkleBtn, ogrenciSilBtn, ogrenciDuzenleBtn;

        ogrenciEkleNoTxt = (EditText) findViewById(R.id.ogrenciEkleNoTxt);
        ogrenciEkleAdTxt = (EditText) findViewById(R.id.ogrenciEkleAdTxt);
        ogrenciEkleSoyadTxt = (EditText) findViewById(R.id.ogrenciEkleSoyadTxt);
        ogrenciDuzenleNoTxt = (EditText) findViewById(R.id.ogrenciDuzenleNoTxt);
        ogrenciDuzenleVizeTxt = (EditText) findViewById(R.id.ogrenciDuzenleVizeTxt);
        ogrenciDuzenleFinalTxt = (EditText) findViewById(R.id.ogrenciDuzenleFinalTxt);
        ogrenciEkleBtn = (Button) findViewById(R.id.ogrenciEkleBtn);
        ogrenciSilBtn = (Button) findViewById(R.id.ogrenciSilBtn);
        ogrenciDuzenleBtn = (Button) findViewById(R.id.ogrenciDuzenleBtn);

        ogrenciEkleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConSQL c = new ConSQL();
                connection = c.conClass();

                if (c != null){
                    try {
                        String sqlQuery = "insert into ogrenciBilgi (ogrenciNo, ogrenciAd, ogrenciSoyad) values ('" + ogrenciEkleNoTxt.getText().toString() + "','" + ogrenciEkleAdTxt.getText().toString() + "','" + ogrenciEkleSoyadTxt.getText().toString() + "')";
                        Statement statement = connection.createStatement();
                        Toast.makeText(OgretmenMainActivity.this,"Öğrenci Eklendi!",Toast.LENGTH_SHORT).show();
                        ResultSet set = statement.executeQuery(sqlQuery);

                        connection.close();
                    }
                    catch (Exception e){
                        Log.e("Hata!", e.getMessage());
                    }
                    ogrenciEkleNoTxt.setText("");
                    ogrenciEkleAdTxt.setText("");
                    ogrenciEkleSoyadTxt.setText("");
                }
            }
        });
        ogrenciSilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConSQL c = new ConSQL();
                connection = c.conClass();

                if (c != null){
                    try {
                        String sqlQuery = "delete from ogrenciBilgi where ogrenciNo = '" + ogrenciEkleNoTxt.getText().toString() + "'";
                        Statement statement = connection.createStatement();
                        Toast.makeText(OgretmenMainActivity.this,"Öğrenci Silindi!",Toast.LENGTH_SHORT).show();
                        ResultSet set = statement.executeQuery(sqlQuery);

                        connection.close();
                    }
                    catch (Exception e){
                        Log.e("Hata!", e.getMessage());
                    }
                    ogrenciEkleNoTxt.setText("");
                    ogrenciEkleAdTxt.setText("");
                    ogrenciEkleSoyadTxt.setText("");
                }
            }
        });
        ogrenciDuzenleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConSQL c = new ConSQL();
                connection = c.conClass();

                if (c != null){
                    try {
                        String sqlQuery = "update ogrenciBilgi set ogrenciVize = " + ogrenciDuzenleVizeTxt.getText().toString() + ", ogrenciFinal = " + ogrenciDuzenleFinalTxt.getText().toString() + " where ogrenciNo = '" + ogrenciDuzenleNoTxt.getText().toString() + "'";
                        Statement statement = connection.createStatement();
                        Toast.makeText(OgretmenMainActivity.this,"Öğrenci Bilgileri Düzenlendi!",Toast.LENGTH_SHORT).show();
                        ResultSet set = statement.executeQuery(sqlQuery);

                        connection.close();
                    }
                    catch (Exception e){
                        Log.e("Hata!", e.getMessage());
                    }
                    ogrenciDuzenleNoTxt.setText("");
                    ogrenciDuzenleVizeTxt.setText("");
                    ogrenciDuzenleFinalTxt.setText("");
                }
            }
        });
    }
}