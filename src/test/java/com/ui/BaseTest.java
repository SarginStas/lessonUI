package com.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.AuthPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://www.saucedemo.com/");
    }
}
