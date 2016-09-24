package package_lab2.pages_object;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by USER on 24.09.2016.
 */
public class LoginPage {
    By loginField = By.xpath(".//*[@id='wpName1']");
    By passwordField = By.xpath(".//*[@id='wpPassword1']");
    By submitLogin = By.xpath(".//*[@id='wpLoginAttempt']");
    By errorField = By.xpath(".//*[@id='userloginForm']/form/div[1]/p");

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

    public LoginPage checkIncorrect() {
        $(errorField).shouldHave(Condition.text("Введённый вами пароль неверен. Попробуйте ещё раз. "));
        return this;
    }
}
