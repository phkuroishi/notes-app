package com.phk.notes.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.phk.notes.R;
import com.phk.notes.entity.User;
import com.phk.notes.repository.UserRepository;

public class SigninActivity extends AppCompatActivity {

    private EditText newUser, password, repeatPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        newUser = findViewById(R.id.signin_user);
        password = findViewById(R.id.signin_pass);
        repeatPassword = findViewById(R.id.signin_pass_repeat);

        insertNewUserAction();
    }

    private void insertNewUserAction() {
        findViewById(R.id.button_new_user).setOnClickListener((view) -> {
            insertNewUser();
        });
    }

    private void insertNewUser() {
        String user = newUser.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String repeatPass = repeatPassword.getText().toString().trim();

        if (user.isEmpty()) {
            newUser.setError("Enter your username");
            newUser.requestFocus();
            return;
        } else {
            if (!pass.equals(repeatPass) && (!pass.isEmpty()) && !repeatPass.isEmpty()) {
                repeatPassword.setError("The password must be the same");
                repeatPassword.requestFocus();
                return;
            } else {
                if (pass.isEmpty()) {
                    password.setError("Enter your password");
                    password.requestFocus();
                    return;
                } else if (repeatPass.isEmpty()) {
                    repeatPassword.setError("Repeat password");
                    repeatPassword.requestFocus();
                    return;
                }
            }
        }

        UserRepository.insertUser(new User(user, pass));
        finish();
    }
}
