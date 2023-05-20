package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edUsername, edPassword;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.editTextLoginUsername);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewNewUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                database db =new database(getApplicationContext(),"Kesehatan",null,"version" 1);
                if(username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(), "harap isi semua",Toast.LENGTH_SHORT).show();
                }else{
                    if (db.Login(username,password,)==1){
                        Toast.makeText(getApplicationContext(), "Login Sukses",Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences =getSharedPreferences("shsred_preferefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = getSharedPreferences().edit();
                        editor.putString("Username", username);
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    }else {
                        Toast.makeText(getApplicationContext(), "username dan password salah",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        tv.setOnClickListener(new View.OnClickListener(){
        @ Override
        public void onClickli(View view);{
            startActivity(new Intent(PackageContext; LoginActivity.this, RegisterActivity,Class));
        }
        });
        }
    }
}