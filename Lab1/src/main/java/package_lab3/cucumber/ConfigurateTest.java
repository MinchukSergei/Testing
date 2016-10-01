package package_lab3.cucumber;

import com.codeborne.selenide.Configuration;

/**
 * Created by USER on 01.10.2016.
 */
public class ConfigurateTest {
    private static String chromeDriverProperty = "webdriver.chrome.driver";
    private static String pathToDriver = "D:\\Programming\\7sem\\Testing\\chromedriver.exe";
    private static String browserType = "chrome";
    public static String siteToTest = "https://habrahabr.ru/";

    public static void configSelenide() {
        System.setProperty(chromeDriverProperty, pathToDriver);
        Configuration.browser = browserType;
    }
}
