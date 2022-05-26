package com.phk.notes.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.phk.notes.R;
import com.phk.notes.entity.User;
import com.phk.notes.repository.UserRepository;

public class LoginActivity extends AppCompatActivity {

    private EditText login, password;
    private TextView loginError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login_text);
        password = findViewById(R.id.password_text);
        loginError = findViewById(R.id.login_error);

        findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        findViewById(R.id.signin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login() {
        final String user = login.getText().toString().trim();
        String passw = password.getText().toString().trim();

        if (user.isEmpty()) {
            login.setError("Username required");
            login.requestFocus();
            return;
        } else if (passw.isEmpty()) {
            password.setError("Password required");
            password.requestFocus();
            return;
        }

        User u = UserRepository.getUser(user, passw);

        if (u != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("username", u.getLogin());
            startActivity(intent);
        } else {
            loginError.setText("Invalid username/password");
            login.setText("");
            password.setText("");
        }
    }
}