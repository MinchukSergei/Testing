package package_lab3.cucumber;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.CollectionElement;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Created by USER on 01.10.2016.
 */
@CucumberOptions(features = "src/main/resources/features/redirection.feature")
public class RedirectionTest extends AbstractTestNGCucumberTests {
    By sandboxLink = By.xpath(".//*[@id='navbar-links']/li[5]/a");

    By secondPageLink = By.xpath(".//*[@id='nav-pages']/li[2]/a");
    By allLinks = By.xpath(".//*[@id='nav-pages']");

    By publicationsLink = By.xpath(".//*[@id='navbar-links']/li[1]/a");

    By checkBox = By.xpath(".//*[@id='filter']/li[1]/label/span");
    By noHabrPosts = By.xpath(".//*[@id='list']");

    By usersLink = By.xpath(".//*[@id='navbar-links']/li[4]/a");

    By userList = By.xpath(".//*[@id='peoples']");


    @Test
    public void feature() {

    }

    @Before
    public void startBrowser() {
        ConfigurateTest.configSelenide();

    }


    @When("^I redirect to sandbox articles$")
    public void iRedirectToSandboxArticles() throws Throwable {
        $(sandboxLink).click();
    }

    @Then("^I want to be in \"([^\"]*)\"$")
    public void iWantToBeIn(String url) throws Throwable {
        Assert.assertEquals(url(), url);
    }


    @When("^I click on the second page$")
    public void iClickOnTheNdPage() throws Throwable {
        $(secondPageLink).click();
    }

    @Then("^I want to be on the second page$")
    public void iWantToBeOnTheNdPage() throws Throwable {
        $(allLinks).findAll(By.tagName("li")).get(0).shouldHave(Condition.text("1"));
    }

    @Given("^I redirect to publications$")
    public void iRedirectToPublications() throws Throwable {
        $(publicationsLink).click();
    }

    @When("^I click on ckeckbox$")
    public void iClickOnCkeckbox() throws Throwable {
        $(checkBox).click();
    }

    @Then("^I want it disabled$")
    public void iWantItDisabled() throws Throwable {
        ElementsCollection list = $(noHabrPosts).findAll(By.tagName("li"));
        for (SelenideElement elem : list) {
            if (elem.getAttribute("data-type").equals("habrahabr")) {
                elem.shouldHave(Condition.attribute("class", "content-list__item content-list__item_habrahabr hidden"));
            }
        }
    }

    @When("^I redirect to users$")
    public void iRedirectToUsers() throws Throwable {
        $(usersLink).click();
    }

    @Then("^I want to see users list$")
    public void iWantToSeeUsersList() throws Throwable {
        Assert.assertTrue($(userList).findAll(By.tagName("div")).size() != 0);
    }
}
