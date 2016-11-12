import com.codeborne.selenide.Configuration;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.junit.Test;
import org.sikuli.script.Key;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by USER on 12.11.2016.
 */
public class TestKAKULI {
    private static String chromeDriverProperty = "webdriver.chrome.driver";
    private static String pathToDriver = "D:\\Programming\\7sem\\Testing\\chromedriver.exe";
    private static String browserType = "chrome";
    private static String siteToTest = "https://vk.com";

    private static void configSelenide() {
        System.setProperty(chromeDriverProperty, pathToDriver);
        Configuration.browser = browserType;
    }

    @Test
    public void gigi() {
        configSelenide();
        open(siteToTest);
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin("login").inputPassword("pass").submit();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Desktop desktop = new Desktop();
        try {
            IImageElement friends = new ImageElement(ClassLoader.getSystemResource("friends.png").getPath(), 0.75f);
            IImageElement general = new ImageElement(ClassLoader.getSystemResource("general.png").getPath(), 0.75f);
            IImageElement send = new ImageElement(ClassLoader.getSystemResource("send.png").getPath(), 0.75f);
            IImageElement textField = new ImageElement(ClassLoader.getSystemResource("textField.png").getPath(), 0.75f);
            IImageElement sendMsg = new ImageElement(ClassLoader.getSystemResource("sendMsg.png").getPath(), 0.75f);

            desktop.clickAll(new IImageElement[]{friends, general, send}, 50);
            Thread.sleep(3000);
            desktop.type(textField, "PREVET", 50);
            Thread.sleep(3000);
            desktop.clickAll(new IImageElement[]{sendMsg}, 50);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

}
