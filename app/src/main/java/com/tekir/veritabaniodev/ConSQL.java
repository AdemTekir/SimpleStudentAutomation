package com.tekir.veritabaniodev;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConSQL {
    Connection con;

    @SuppressLint("NewApi")
    public Connection conClass(){
        String ip = "159.146.38.239", port = "1433", db = "VeriTabaniOdevi", username = "sa", password = "1234adem";

        StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(a);
        String ConnectURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectURL = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + db + ";user=" + username + ";password=" + password + ";";
            con = DriverManager.getConnection(ConnectURL);
        }
        catch (Exception e){
            Log.e("Hata!", e.getMessage());
        }
        return con;
    }
}
