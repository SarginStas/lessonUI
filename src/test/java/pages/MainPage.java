package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainPage {
    public SelenideElement title = Selenide.$x("//span[@class='title']");
    public SelenideElement shopping_cart_link = Selenide.$x("//*[@data-test='shopping-cart-badge']");
    public SelenideElement add_to_cart_backpack = Selenide.$x("//*[@data-test='add-to-cart-sauce-labs-backpack']");
}
