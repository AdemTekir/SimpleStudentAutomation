package com.tekir.veritabaniodev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OgrenciMainActivity extends AppCompatActivity {
    Connection connection;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_main);

        TextView ogrenciAd, ogrenciSoyad, ogrenciVize, ogrenciFinal;

        ogrenciAd = (TextView) findViewById(R.id.ogrenciAdTxt);
        ogrenciSoyad = (TextView) findViewById(R.id.ogrenciSoyadTxt);
        ogrenciVize = findViewById(R.id.ogrenciVizeTxt);
        ogrenciFinal = findViewById(R.id.ogrenciFinalTxt);

        ConSQL c = new ConSQL();
        connection = c.conClass();

        if (c != null){
            try {
                String sqlQuery = "select * from ogrenciBilgi where ogrenciNo ='" + OgrenciLoginActivity.ogrenciNo + "'";
                Statement statement = connection.createStatement();
                ResultSet set = statement.executeQuery(sqlQuery);

                while (set.next()){
                    ogrenciAd.setText(set.getString("ogrenciAd").toString());
                    ogrenciSoyad.setText(set.getString("ogrenciSoyad").toString());
                    ogrenciVize.setText(set.getString("ogrenciVize").toString());
                    ogrenciFinal.setText(set.getString("ogrenciFinal").toString());
                }
                connection.close();
            }
            catch (Exception e){
                Log.e("Hata!", e.getMessage());
            }
        }
    }
}