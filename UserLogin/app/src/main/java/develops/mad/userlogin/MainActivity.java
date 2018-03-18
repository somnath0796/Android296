package develops.mad.userlogin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    CheckBox rem;
    Button login;
    Auth au;
    SharedPreferences loggin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.unInput);
        password = (EditText) findViewById(R.id.pwdinput);
        rem = (CheckBox) findViewById(R.id.remCheck);
        login = (Button) findViewById(R.id.buttonLogin);

        loggin = getSharedPreferences("LogPref", Context.MODE_PRIVATE);

        boolean chk = loggin.getBoolean("rem",false);
        if(chk){
            String name = loggin.getString("name","");
            String pw = loggin.getString("pass","");
            username.setText(name);
            password.setText(pw);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rem.isChecked()){
                    String un = username.getText().toString();
                    String pw = password.getText().toString();


                    SharedPreferences.Editor editor = loggin.edit();

                    editor.putString("name",un);
                    editor.putString("pass",pw);
                    editor.putBoolean("rem", true);
                    editor.commit();
                }
                String un = username.getText().toString();
                String pw = password.getText().toString();
                au = new Auth();
                if(au.auth(un,pw)){
                    Toast.makeText(MainActivity.this, "Login Success!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

class Auth{
    String users[] = {"Somnath96","Raj22341", "ZeoKeep"};
    String pws[] = {"123","456","678"};
    private String encrypt(String p){
        int l = p.length();
        int i=0;
        while(i<l){
            char ch = p.charAt(i);
            ch = (char)((int)ch+l);
            i++;
        }
        return p;
    }


    public boolean auth(String name, String pw){
        String a = encrypt(pw);
        int pos=0;
        for(int i=0; i<users.length;i++){
            if(name.equals(users[i]))
                pos = i;
        }
        String b = encrypt(pws[pos]);

        return (a.equals(b))?true:false;
    }
}
