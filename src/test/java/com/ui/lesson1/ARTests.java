package com.ui.lesson1;

import com.ui.BaseTest;
import org.testng.annotations.*;
import pages.AuthPage;
import pages.MainPage;

import static org.testng.Assert.*;
import static com.codeborne.selenide.Condition.visible;

public class ARTests extends BaseTest {
    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();

    @Test
    public void login() {
        authPage.userNameInput.sendKeys("locked_out_user");
        authPage.passwordInput.sendKeys("secret_sauce");
        authPage.loginButton.click();

        authPage.dataTestError.shouldBe(visible);
        assertEquals(authPage.dataTestError.getText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
