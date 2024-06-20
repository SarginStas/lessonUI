package lesson1;

import com.ui.BaseTest;
import org.testng.annotations.Test;
import pages.AuthPage;

import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertEquals;

public class AuthPageTestBurnaeva extends BaseTest {
    AuthPage authPage = new AuthPage();
    @Test
    public void loginWithLockedOutUser() {
        authPage.userNameInput.sendKeys("locked_out_user");
        authPage.passwordInput.sendKeys("secret_sauce");
        authPage.loginButton.click();

        authPage.dataTestError.shouldBe(visible);
        assertEquals(authPage.dataTestError.getText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
