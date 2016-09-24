package package_lab2;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import package_lab2.pages_object.FindPage;
import package_lab2.pages_object.LoginPage;
import package_lab2.pages_object.StartPage;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by USER on 24.09.2016.
 */
public class TestPages {
    private static String chromeDriverProperty = "webdriver.chrome.driver";
    private static String pathToDriver = "D:\\Programming\\7sem\\Testing\\chromedriver.exe";
    private static String browserType = "chrome";
    private static String siteToTest = "https://ru.wikipedia.org/wiki/%D0%A1%D0%B0%D0%B9%D1%82/";

    private static void configSelenide() {
        System.setProperty(chromeDriverProperty, pathToDriver);
        Configuration.browser = browserType;
    }

    @Test
    public void testPages() {
        configSelenide();
        open(siteToTest);

        StartPage startPage = new StartPage();
        startPage.clickByLink();

        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin("pes").inputPassword("gau").submit().checkIncorrect();

        FindPage findPage = new FindPage();
        String findingText = "Интересное";
        findPage.inputSearchField(findingText).submitSearch().checkResult(findingText);
        close();
    }
}
