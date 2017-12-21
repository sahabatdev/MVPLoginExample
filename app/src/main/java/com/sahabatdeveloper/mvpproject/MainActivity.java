package com.sahabatdeveloper.mvpproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginView{

    EditText etUsername,etPassword;
    Button btnLogin;
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText)findViewById(R.id.et_username);
        etPassword = (EditText)findViewById(R.id.et_password);
        btnLogin = (Button)findViewById(R.id.btn_login);

        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.prosesLogin(etUsername.getText().toString(),etPassword.getText().toString());
            }
        });
    }

    @Override
    public void onUsernameEmpty() {
        etUsername.setError("Username Harus Diisi");
    }

    @Override
    public void onPasswordEmpty() {
        etPassword.setError("Password Harus Diisi");
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure() {
        Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();
    }
}
