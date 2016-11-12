import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by USER on 24.09.2016.
 */
public class LoginPage {
    By loginField = By.xpath(".//*[@id='index_email']");
    By passwordField = By.xpath(".//*[@id='index_pass']");
    By submitLogin = By.xpath(".//*[@id='index_login_button']");

    public LoginPage inputLogin(String login) {
        $(loginField).sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String password) {
        $(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage submit() {
        $(submitLogin).click();
        return this;
    }
}
