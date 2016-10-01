package package_lab3.cucumber;

import com.codeborne.selenide.Condition;
import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by USER on 01.10.2016.
 */

@CucumberOptions(features = "src/main/resources/features/login.feature")
public class LoginTests extends AbstractTestNGCucumberTests {
    By loginButton = By.xpath(".//*[@id='login']");
    By loginFiled = By.xpath(".//*[@id='email_field']");
    By passField = By.xpath(".//*[@id='login_form']/div[4]/div/input");
    By loginSubmit = By.xpath(".//*[@id='login_form']/div[6]/button");

    By successLoginField = By.xpath("html/body/div[1]/div[2]/div/div[2]/div/button");
    By errorLoginField = By.xpath(".//*[@id='global_notices']/div");

    By logoutButton = By.xpath("html/body/div[1]/div[2]/div/div[2]/div/div/ul/li[6]/a");

    @Test
    public void feature() {

    }

    @Before
    public void startBrowser() {
        ConfigurateTest.configSelenide();
    }

    @Given("^I open habrahabr$")
    public void start() {
        open(ConfigurateTest.siteToTest);
    }

    @Given("^I select login$")
    public void login() {
        $(loginButton).click();
    }

    @Given("^I input \"([^\"]*)\" login$")
    public void iInputLogin(String login) throws Throwable {
        $(loginFiled).sendKeys(login);
    }

    @Given("^I input \"([^\"]*)\" password$")
    public void iInputPassword(String password) throws Throwable {
        $(passField).sendKeys(password);
    }

    @When("^I submit login$")
    public void iSubmitLogin() throws Throwable {
        $(loginSubmit).click();
    }

    @Then("^I should see success \"([^\"]*)\"$")
    public void iShouldSeeLoginSuccess(String loginName) throws Throwable {
        $(successLoginField).shouldHave(Condition.attribute("title", loginName));
    }

    @Then("^I should see error \"([^\"]*)\"$")
    public void iShouldSeeLoginError(String error) throws Throwable {
        $(errorLoginField).shouldHave(Condition.text(error));
    }


    @Given("^I open context menu$")
    public void iOpenContextMenu() throws Throwable {
        $(successLoginField).click();
    }

    @When("^I click logout$")
    public void iClickLogout() throws Throwable {
        $(logoutButton).click();
    }

    @Then("^I should see the login button")
    public void iShouldSeeTheButton() throws Throwable {
        Assert.assertTrue($(By.tagName("body")).findElements(loginButton).size() != 0);
    }
}
