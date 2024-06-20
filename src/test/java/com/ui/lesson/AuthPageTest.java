package com.ui.lesson;

import com.ui.BaseTest;
import org.testng.annotations.*;
import pages.AuthPage;
import pages.MainPage;

import static org.testng.Assert.*;
import static com.codeborne.selenide.Condition.visible;

public class AuthPageTest extends BaseTest {
    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();

    @Test
    public void login() {
        authPage.userNameInput.sendKeys("standard_user");
        authPage.passwordInput.sendKeys("secret_sauce");
        authPage.loginButton.click();

        mainPage.title.shouldBe(visible);
        assertEquals(mainPage.title.getText(), "Products");
    }
}


