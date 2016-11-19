package testi;

import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.ProxyServer;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by USER on 19.11.2016.
 */
public class CoolTest {

    @Test
    public void testMobProxyServer() throws Exception {
        // запуск прокси сервера
        ProxyServer server = new ProxyServer(4444);
        server.start();

        // получение Selenium proxy
        Proxy proxy = server.seleniumProxy();

        // конфигурация FirefoxDriver для использования прокси
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        WebDriver driver = new ChromeDriver(capabilities);

        // создание HAR с меткой "yandex.ru"
        server.newHar("adukacyja.by");

        // открытие страницы
        driver.get("http://www.adukacyja.by/");
        driver.findElement(By.xpath(".//*[@id='essentialnavbar']/div/div/div[2]/div[1]/ul/li/a/em")).click();
        driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("login");
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("pass*");
        driver.findElement(By.xpath(".//*[@id='loginbtn']")).click();

        driver.findElement(By.xpath(".//*[@id='inst4']/div[2]/ul/li/ul/li[1]/p/a")).click();
        driver.findElement(By.xpath(".//*[@id='expandable_branch_0_courses']/a")).click();

        // получение данных HAR
        Har har = server.getHar();
        File file = new File(ClassLoader.getSystemResource("Test.har").getFile());
        try (FileOutputStream fos = new FileOutputStream(file)) {
            har.writeTo(fos);
        } finally {
            driver.quit();
            server.stop();
        }
    }
}
