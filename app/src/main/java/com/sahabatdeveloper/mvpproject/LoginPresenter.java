package com.sahabatdeveloper.mvpproject;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Sahabat Developer on 20/12/2017.
 */

public class LoginPresenter {
    LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void prosesLogin(String username, String password){
        if(username.isEmpty()){
            loginView.onUsernameEmpty();
        }else if(password.isEmpty()){
            loginView.onPasswordEmpty();
        }else{
            if(username.equals("advinity") && password.equals("advinity")){
                loginView.onLoginSuccess();
            }else{
                loginView.onLoginFailure();
            }
        }
    }
}
