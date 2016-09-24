package package_lab2.pages_object;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by USER on 24.09.2016.
 */
public class StartPage {
    private By loginLink = By.xpath(".//*[@id='pt-login']/a");

    public StartPage clickByLink() {
        $(loginLink).click();
        return this;
    }
}
