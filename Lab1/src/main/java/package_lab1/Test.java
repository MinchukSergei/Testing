package package_lab1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.internal.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class Test {

    @org.testng.annotations.Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programming\\7sem\\Testing\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.habrahabr.ru/");
        WebElement findButton = driver.findElement(By.xpath(".//*[@id='layout']/div[3]/div[1]/form/button"));
        WebElement findText = driver.findElement(By.xpath(".//*[@id='layout']/div[3]/div[1]/form/input"));
        findText.sendKeys("fuck");
        findButton.click();
        driver.quit();
    }

    @org.testng.annotations.Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programming\\7sem\\Testing\\chromedriver.exe");
        com.codeborne.selenide.Configuration.browser = "chrome";
        open("https://www.habrahabr.ru/");
        $(By.xpath(".//*[@id='layout']/div[3]/div[1]/form/input")).sendKeys("SELENIDE");
        $(By.xpath(".//*[@id='layout']/div[3]/div[1]/form/button")).click();
        close();
    }
}
