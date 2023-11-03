package com.tekir.veritabaniodev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OgrenciLoginActivity extends AppCompatActivity {
    Connection connection;
    static String ogrenciNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_login);

        EditText ogrenciLoginNoTxt;
        Button ogrenciLoginBtn;

        ogrenciLoginNoTxt = (EditText) findViewById(R.id.ogrenciLoginNoTxt);
        ogrenciLoginBtn = (Button) findViewById(R.id.ogrenciLoginBtn);

        ogrenciLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConSQL c = new ConSQL();
                connection = c.conClass();

                if (c != null){
                    try {
                        String sqlQuery = "select * from ogrenciBilgi where ogrenciNo='" + ogrenciLoginNoTxt.getText().toString() + "'";
                        Statement statement = connection.createStatement();
                        ResultSet set = statement.executeQuery(sqlQuery);

                        ogrenciNo = ogrenciLoginNoTxt.getText().toString();

                        Intent intent = new Intent(OgrenciLoginActivity.this, OgrenciMainActivity.class);
                        startActivity(intent);
                        connection.close();
                    }
                    catch (Exception e){
                        Toast.makeText(OgrenciLoginActivity.this,"Yanlış Öğrenci Numarası",Toast.LENGTH_SHORT).show();
                        Log.e("Hata!", e.getMessage());
                    }
                }
            }
        });
    }
}