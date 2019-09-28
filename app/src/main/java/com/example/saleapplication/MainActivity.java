package com.example.saleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogin;

    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = edtUsername.getText().toString();
                password = edtPassword.getText().toString();

                startActivity(new Intent(getBaseContext(), HomeActivity.class));
//                if (username.equals("admin") && password.equals("admin")) {
//                    startActivity(new Intent(getBaseContext(), HomeActivity.class));
//                } else {
//                    Toast.makeText(getBaseContext(), "Username and password invalid!", Toast.LENGTH_LONG).show();
//                }
            }
        });

    }
}
