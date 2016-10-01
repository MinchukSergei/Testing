package package_lab3;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import package_lab3.pages_object.LoginPage;
import package_lab3.pages_object.StartPage;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by USER on 01.10.2016.
 */
public class TestDDT {
    private static String chromeDriverProperty = "webdriver.chrome.driver";
    private static String pathToDriver = "D:\\Programming\\7sem\\Testing\\chromedriver.exe";
    private static String browserType = "chrome";
    private static String siteToTest = "https://habrahabr.ru/";

    private static void configSelenide() {
        System.setProperty(chromeDriverProperty, pathToDriver);
        Configuration.browser = browserType;
    }

    @BeforeTest
    public void setUp() {
        configSelenide();
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                new Object[] {"email", "pass", true},
                new Object[] {"FAILemail", "failPass", false},
        };
    }

    @Test(dataProvider = "testData")
    public void testPages(String login, String password, boolean expected) {
        open(siteToTest);
        StartPage startPage = new StartPage();
        startPage.clickByLink();

        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(login).inputPassword(password).submit().checkIncorrect(expected);
        close();
    }
}
