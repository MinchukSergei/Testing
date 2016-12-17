import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.ResourceBundle;


public class VeryCoolTest {
    public static final String USERNAME = "sergei137";
    public static final String AUTOMATE_KEY = "sTm1juBjWFTK8ysdhVqn";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public DesiredCapabilities caps;
    public ResourceBundle resourceBundle;




    @Before
    public void prepare() {
        resourceBundle = ResourceBundle.getBundle("browser-stack");
        caps = new DesiredCapabilities();
    }

    private void setSettings(DesiredCapabilities caps, int browser, int version) {
        caps.setCapability("browser", resourceBundle.getString(String.format("browser%d", browser)));
        caps.setCapability("browser_version", resourceBundle.getString(String.format("browser%d.version%d", browser, version)));
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "7");
        caps.setCapability("resolution", "1366x768");
    }

    @Test
    public void habrTest() throws Exception {
        for (int browser = 1; browser < 3; browser++) {
            for (int version = 1; version < 4; version++) {
                DesiredCapabilities caps = new DesiredCapabilities();
                setSettings(caps, browser, version);
                WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
                driver.get("https://habrahabr.ru/");

                WebElement searchButton = driver.findElement(By.xpath(".//*[@id='search-form-btn']"));
                searchButton.click();

                WebElement searchField = driver.findElement(By.xpath(".//*[@id='search-form-field']"));
                searchField.sendKeys("HeloBrat");
                searchField.submit();

                System.out.println(driver.getTitle());
                driver.quit();
            }
        }
    }

    @Test
    public void googleTest() throws Exception {
        for (int browser = 1; browser < 4; browser++) {
            for (int version = 1; version < 4; version++) {
                DesiredCapabilities caps = new DesiredCapabilities();
                setSettings(caps, browser, version);
                WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
                driver.get("http://www.google.com");

                WebElement element = driver.findElement(By.name("q"));

                element.sendKeys("BrowserStack");
                element.submit();

                System.out.println(driver.getTitle());
                driver.quit();
            }
        }
    }


}
