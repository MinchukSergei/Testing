package package_lab3.pages_object;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by USER on 24.09.2016.
 */
public class StartPage {
    private By loginLink = By.xpath(".//*[@id='login']");

    public StartPage clickByLink() {
        $(loginLink).click();
        return this;
    }
}
