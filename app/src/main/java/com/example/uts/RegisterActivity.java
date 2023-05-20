package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername,edEmail,edPassword,edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextRegUsername);
        edPassword = findViewById(R.id.editTextRegPassword);
        edEmail = findViewById(R.id.editTextRegEmail);
        edConfirm = findViewById(R.id.editTextRegConfirmPassword);
        btn = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.textViewExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                database db =new database(getApplicationContext(),"Kesehatan",null,"version" 1);
                if (username.length()==0 || email.length()==0 || password.length()==0 || confirm.length()==0){
                    Toast.makeText(RegisterActivity.this, "Tolong ini detail ini", Toast.LENGTH_SHORT).show();

                }
                else {
                    if (password.compareTo(confirm) ==0){
                        if (isValid(password)){
                            database(username,email,password);
                            Toast.makeText(RegisterActivity.this, "catatan di masukan", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent( RegisterActivity.this, LoginActivity.class));
                        }
                        else {

                            Toast.makeText(RegisterActivity.this, "pasword harus memiliki 8 karakter", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(RegisterActivity.this, "pasword tidak sama", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
    public static boolean isValid(String passworddisini){
        int f1=0,f2=0,f3=0;
        if (passworddisini.length() < 8){
            return false;
        }else {
            for (int p = 0; p < passworddisini.length(); p++){
                if(Character.isLetter(passworddisini.charAt(p))){
                    f1=1;
                }
            }
            for (int r = 0; r < passworddisini.length(); r++){
                if(Character.isDigit(passworddisini.charAt(r))){
                    F2=1;
                }
            }
            for (int s = 0; s < passworddisini.length(); s++){
                char c =passworddisini.charAt(s);
                if (c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if (f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }
    }
}