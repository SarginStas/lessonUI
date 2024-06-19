package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainPage {
    public SelenideElement title = Selenide.$x("//span[@class='title']");
}
