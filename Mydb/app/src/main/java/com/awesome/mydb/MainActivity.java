package com.awesome.mydb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.mariadb.jdbc.*;
import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbResultSet;
import org.mariadb.jdbc.MariaDbStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/testapp";
    private static final String user = "test";
    private static final String pass = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1  = (Button)findViewById(R.id.button);
        b1.setOnClickListener(new Display());
    }

    private class Display implements View.OnClickListener{

        public void onClick(View clickedButton){
            TextView tv = (TextView)findViewById(R.id.textView);
            try {
                Toast.makeText(MainActivity.this,"Starting..",Toast.LENGTH_SHORT).show();
                Class.forName("org.mariadb.jdbc.Driver");
                Toast.makeText(MainActivity.this,"Class Found",Toast.LENGTH_SHORT).show();
                MariaDbConnection c = (MariaDbConnection) DriverManager.getConnection(url,user,pass);
                //Connection con = DriverManager.getConnection(url,user,pass);
                Toast.makeText(MainActivity.this,"Database Connected",Toast.LENGTH_LONG).show();

                String result = "Database Successfully Connected...\n";

                MariaDbStatement st = (MariaDbStatement) c.createStatement();
                MariaDbResultSet rs = (MariaDbResultSet) st.executeQuery("Select * FROM Accounts");
                MariaDbResultSetMetaData rsmd = (MariaDbResultSetMetaData) rs.getMetaData();
                int i = 0;

                while(rs.next()){
                    int j=1;
                    while(j<4){
                        result+= rsmd.getColumnName(j)+": "+rs.getString(j)+"\t";
                        j++;
                    }
                    result+="\n";
                    i++;
                }

                tv.setText(result);
            } catch (ClassNotFoundException | SQLException e) {
                String err = e.toString();
                //tv.setText(err);
                Toast.makeText(MainActivity.this,err,Toast.LENGTH_LONG).show();
            }
        }

    }


}
