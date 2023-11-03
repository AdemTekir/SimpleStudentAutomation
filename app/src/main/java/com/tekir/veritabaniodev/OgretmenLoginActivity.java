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

public class OgretmenLoginActivity extends AppCompatActivity {
    Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogretmen_login);

        EditText ogretmenLoginEmailTxt, ogretmenLoginPasswordTxt;
        Button ogretmenLoginBtn;

        ogretmenLoginEmailTxt = (EditText) findViewById(R.id.ogretmenLoginEmailTxt);
        ogretmenLoginPasswordTxt = (EditText) findViewById(R.id.ogretmenLoginPasswordTxt);
        ogretmenLoginBtn = (Button) findViewById(R.id.ogretmenLoginBtn);

        ogretmenLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConSQL c = new ConSQL();
                connection = c.conClass();

                if (c != null){
                    try {
                        String sqlQuery = "select * from ogretmenBilgi where ogretmenEmail='" + ogretmenLoginEmailTxt.getText().toString() + "'and ogretmenPassword = '" + ogretmenLoginPasswordTxt.getText().toString() + "'";
                        Statement statement = connection.createStatement();
                        ResultSet set = statement.executeQuery(sqlQuery);

                        Intent intent = new Intent(OgretmenLoginActivity.this, OgretmenMainActivity.class);
                        startActivity(intent);
                        connection.close();
                    }
                    catch (Exception e){
                        Toast.makeText(OgretmenLoginActivity.this,"Yanlış E-mail Veya Parola",Toast.LENGTH_SHORT).show();
                        Log.e("Hata!", e.getMessage());
                    }
                }
            }
        });
    }
}