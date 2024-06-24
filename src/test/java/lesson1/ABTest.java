package lesson1;

import com.ui.BaseTest;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.MainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class ABTest extends BaseTest {
    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();

    @Test
    public void manageShoppingCart() {
        authPage.userNameInput.sendKeys("standard_user");
        authPage.passwordInput.sendKeys("secret_sauce");
        authPage.loginButton.click();

        mainPage.title.shouldBe(visible);
        assertEquals(mainPage.title.getText(), "Products");

        mainPage.backpackAddToCartButton.click();
        assertEquals(mainPage.shoppingCartBadge.getText(), "1");
        mainPage.backpackRemoveButton.click();
        mainPage.shoppingCartBadge.shouldBe(hidden);

        mainPage.buttonBurgerMenu.click();
        mainPage.logoutSidebarLink.click();
        authPage.userNameInput.shouldBe(visible);
        authPage.passwordInput.shouldBe(visible);
        assertEquals(url(), "https://www.saucedemo.com/");
    }
}
