package package_lab1;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SiteTester {
    private static String chromeDriverProperty = "webdriver.chrome.driver";
    private static String pathToDriver = "D:\\Programming\\7sem\\Testing\\chromedriver.exe";

    private static String siteToTest = "https://www.habrahabr.ru/";
    private static String browserType = "chrome";

    private void configSelenide() {
        System.setProperty(chromeDriverProperty, pathToDriver);
        Configuration.browser = browserType;
    }

    @Test
    public void findText() {
        configSelenide();
        String textToTest = "Selenide";
        open(siteToTest);
        $(By.xpath(".//*[@id='layout']/div[3]/div[1]/form/input")).sendKeys(textToTest);
        $(By.xpath(".//*[@id='layout']/div[3]/div[1]/form/button")).click();
        $(By.xpath(".//*[@id='layout']/div[3]/div[1]/div[1]/div[2]")).shouldHave(Condition.text(textToTest));
        close();
    }

    @Test
    public void changePage() {
        configSelenide();
        open(siteToTest);
        String textToCheck = "Хабы";
        $(By.xpath(".//*[@id='navbar']/div[1]/a[2]")).click();
        $(By.xpath(".//*[@id='menu_tab']/div[2]/a[2]")).click();
        $(By.xpath(".//*[@id='layout']/div[3]/div[1]/h1")).should(Condition.text(textToCheck));
        close();
    }

    @Test
    public void checkCheckBox() {
        configSelenide();
        open(siteToTest);
        String attrToCheck = "class";
        String valToCheck = "content-list__item content-list__item_habrahabr";
        $(By.xpath(".//*[@id='filter']/li[1]/label/span")).click();
        SelenideElement dataPostList = $(By.xpath(".//*[@id='list']"));
        List<WebElement> listElements = dataPostList.findElements(By.tagName("li"));
        for (int i = 0; i < listElements.size(); i++) {
            WebElement elem = listElements.get(i);
            String val = elem.getAttribute(attrToCheck);
            Assert.assertNotEquals(val, valToCheck);
        }
        close();
    }

    @Test
    public void auth() { //check authorization on Фрилансим
        configSelenide();
        open(siteToTest);
        String yourEmail = "EMAIL"; //your email
        String yourPassword = "PASSWORD"; //your password
        String yourLogin = "LOGIN"; //your login
        $(By.xpath(".//*[@id='TMpanel']/div/div[1]/a[6]")).click();
        $(By.xpath("html/body/header/div/div[1]/a")).click();
        $(By.xpath(".//*[@id='user_email']")).sendKeys(yourEmail);
        $(By.xpath(".//*[@id='user_password']")).sendKeys(yourPassword);
        $(By.xpath(".//*[@id='new_user']/div[2]/button")).click();
        $(By.xpath("html/body/header/div/div[1]/div[3]/div[1]")).shouldHave(Condition.text(yourLogin));
        close();
    }

    @Test
    public void comment() { //left comment
        configSelenide();
        open(siteToTest);
        String yourEmail = "EMAIL"; //your email
        String yourPassword = "PASSWORD"; //your password
        String yourComment = "COMMENT";

        $(By.xpath(".//*[@id='login']/span")).click();
        $(By.xpath(".//*[@id='email_field']")).sendKeys(yourEmail);
        $(By.xpath(".//*[@id='login_form']/div[4]/div/input")).sendKeys(yourPassword);
        $(By.xpath(".//*[@id='login_form']/div[6]/button")).click();
        $(By.xpath(".//*[@id='layout']/div[3]/div[1]/form/input")).sendKeys("Как мы неделю чинили compaction в Cassandra");
        $(By.xpath(".//*[@id='layout']/div[3]/div[1]/form/button")).click();
        $(By.xpath(".//*[@id='post_310000']/div[1]/h2/a[2]")).click();
        $(By.xpath(".//*[@id='comment_text']")).sendKeys(yourComment);
        $(By.xpath(".//*[@id='comments_form']/div[3]/div/input[2]")).click();
        close();
    }
}
