package com.ui.lesson2;

import com.codeborne.selenide.Selenide;
import com.ui.BaseTest;
import org.openqa.selenium.Keys;
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
    public void adToCart() throws InterruptedException {
        authPage.userNameInput.sendKeys("standard_user");
        authPage.passwordInput.sendKeys("secret_sauce");
        authPage.loginButton.click();
        Thread.sleep(100);
        Selenide.actions().sendKeys(Keys.ENTER);

        mainPage.title.shouldBe(visible);
        assertEquals(mainPage.title.getText(), "Products");

        mainPage.shoppingCartLink.shouldBe(hidden);

        mainPage.addToCartBackpack.click();
        mainPage.shoppingCartLink.shouldBe(visible);
        assertEquals(mainPage.shoppingCartLink.getText(), "1");

        mainPage.burgerMenu.click();
        mainPage.logout.click();
        authPage.userNameInput.shouldBe(visible);
        authPage.passwordInput.shouldBe(visible);
        assertEquals(authPage.loginLogo.getText(), "Swag Labs");

    }
}
