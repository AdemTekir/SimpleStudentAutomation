package com.tekir.veritabaniodev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ogretmenLoginBtn, ogrenciLoginBtn;

        ogretmenLoginBtn = (Button) findViewById(R.id.ogretmenActivityLoginBtn);
        ogrenciLoginBtn = (Button) findViewById(R.id.ogrenciActivityLoginBtn);

        ogretmenLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OgretmenLoginActivity.class);
                startActivity(intent);
            }
        });
        ogrenciLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OgrenciLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}