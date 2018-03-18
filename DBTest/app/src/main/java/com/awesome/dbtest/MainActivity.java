package com.awesome.dbtest;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.*;




public class MainActivity extends AppCompatActivity {


    private static final String url = "jdbc:mysql://173.194.242.83:3306/testapp";
    private static final String user = "root";
    private static final String pass = "ourproject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1  = (Button)findViewById(R.id.button);
        b1.setOnClickListener(new Display());

    }

    private class Display implements View.OnClickListener{

            public void onClick(View clickedButton){
                EditText tv = (EditText)findViewById(R.id.editText);
                try {
                    Toast.makeText(MainActivity.this,"Starting..",Toast.LENGTH_SHORT).show();
                    Class.forName("com.mysql.jdbc.Driver");
                    Toast.makeText(MainActivity.this,"Class Found",Toast.LENGTH_SHORT).show();
                    Connection con = DriverManager.getConnection(url,user,pass);
                    //Connection con  = DriverManager.getConnection("jdbc:mysql://173.194.242.83:3306/testapp?user=root");
                    Toast.makeText(MainActivity.this,"Database Connected",Toast.LENGTH_LONG).show();

                    String result = "Database Successfully Connected...\n";

                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("Select * FROM Accounts");
                    ResultSetMetaData rsmd = rs.getMetaData();
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
