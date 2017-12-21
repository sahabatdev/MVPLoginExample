package com.sahabatdeveloper.mvpproject;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Mock
    LoginPresenter loginPresenter;
    @Mock
    LoginView loginView;

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void ifUsernameEmpty(){
        MockitoAnnotations.initMocks(this);
        loginPresenter = new LoginPresenter(loginView);
        loginPresenter.prosesLogin("","jagdjadgaj");
        verify(loginView).onUsernameEmpty();
    }
    @Test
    public void ifPasswordEmpty(){
        MockitoAnnotations.initMocks(this);
        loginPresenter = new LoginPresenter(loginView);
        loginPresenter.prosesLogin("sssss","");
        verify(loginView).onPasswordEmpty();
    }
    @Test
    public void ifLoginSuccess(){
        MockitoAnnotations.initMocks(this);
        loginPresenter = new LoginPresenter(loginView);
        loginPresenter.prosesLogin("advinity","advinity");
        verify(loginView).onLoginSuccess();
    }
    @Test
    public void ifLoginFailure(){
        MockitoAnnotations.initMocks(this);
        loginPresenter = new LoginPresenter(loginView);
        loginPresenter.prosesLogin("adadadd","jagdjadgaj");
        verify(loginView).onLoginFailure();
    }

}