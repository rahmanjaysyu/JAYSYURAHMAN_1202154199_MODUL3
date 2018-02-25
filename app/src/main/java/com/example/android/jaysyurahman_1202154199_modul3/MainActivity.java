package com.example.android.jaysyurahman_1202154199_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public TextView User, Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User = (TextView)findViewById(R.id.txtUsername);
        Pass = (TextView)findViewById(R.id.txtPassword);
    }

    public void login(){
        String strUser,strPass;
        strUser = User.getText().toString();
        strPass = Pass.getText().toString();
        if(!(strUser.equals("EAD") && strPass.equals("MOBILE"))){
            Toast.makeText(this,"Username atau Password Salah",Toast.LENGTH_SHORT).show();
            return;
        }else{
            Toast.makeText(this,"Berhasil Sign-In",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,daftarair.class));
        }
    }

    public void login(View v){
        login();
    }
}
