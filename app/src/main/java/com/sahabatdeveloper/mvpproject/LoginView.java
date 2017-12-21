package com.sahabatdeveloper.mvpproject;

/**
 * Created by Sahabat Developer on 20/12/2017.
 */

public interface LoginView {
    public void onUsernameEmpty();
    public void onPasswordEmpty();
    public void onLoginSuccess();
    public void onLoginFailure();
}
