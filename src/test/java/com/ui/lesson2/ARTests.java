package com.ui.lesson2;

import com.ui.BaseTest;
import org.testng.annotations.*;
import pages.AuthPage;
import pages.MainPage;

import static org.testng.Assert.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.hidden;

public class ARTests extends BaseTest {
    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();

    @Test
    public void adToCart() {
        authPage.userNameInput.sendKeys("standard_user");
        authPage.passwordInput.sendKeys("secret_sauce");
        authPage.loginButton.click();

        mainPage.title.shouldBe(visible);
        assertEquals(mainPage.title.getText(), "Products");

        mainPage.shopping_cart_link.shouldBe(hidden);

        mainPage.add_to_cart_backpack.click();
        mainPage.shopping_cart_link.shouldBe(visible);
        assertEquals(mainPage.shopping_cart_link.getText(), "1");

    }
}
