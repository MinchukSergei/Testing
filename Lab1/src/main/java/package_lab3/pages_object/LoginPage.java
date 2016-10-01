package package_lab3.pages_object;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by USER on 24.09.2016.
 */
public class LoginPage {
    By loginField = By.xpath(".//*[@id='email_field']");
    By passwordField = By.xpath(".//*[@id='login_form']/div[4]/div/input");
    By submitLogin = By.xpath(".//*[@id='login_form']/div[6]/button");
    By errorField = By.xpath(".//*[@id='global_notices']/div");
    By successField = By.xpath("html/body/div[1]/div[2]/div/div[2]/div/button");

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

    public LoginPage checkIncorrect(boolean result) {
        if (!result) {
            $(errorField).shouldHave(Condition.text("Пользователь с такой электронной почтой или паролем не найден"));
        } else {
            $(successField).shouldHave(Condition.attribute("title", "MinchukSergei"));
        }
        return this;
    }
}
