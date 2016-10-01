package package_lab3.cucumber;

import com.codeborne.selenide.Condition;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by USER on 01.10.2016.
 */
@CucumberOptions(features = "src/main/resources/features/search.feature")
public class SearchTests extends AbstractTestNGCucumberTests {
    By searchButton = By.xpath(".//*[@id='search-form-btn']");
    By searchField = By.xpath(".//*[@id='search-form-field']");

    By resultSearchField = By.xpath(".//*[@id='inner_search_form']/div/input");
    By resultField = By.xpath("html/body/div[1]/div[3]/div[1]/div[1]/div[2]/h2");

    By typeMenu = By.xpath(".//*[@id='flow']");
    By developmentType = By.xpath(".//*[@id='flow']/option[2]");
    By resultChangeType = By.xpath("//a[starts-with(@class, 'post__flow')]");


    @Test
    public void feature() {

    }

    @Before
    public void startBrowser() {
        ConfigurateTest.configSelenide();
    }

    @Given("^I click search button$")
    public void iClickSearchButton() throws Throwable {
        $(searchButton).click();
    }


    @Given("^I input \"([^\"]*)\" text$")
    public void iInputText(String searchText) throws Throwable {
        $(searchField).sendKeys(searchText);
    }


    @When("^I submit search$")
    public void iSubmitSearch() throws Throwable {
        $(searchField).pressEnter();
    }


    @Then("^I should see result success \"([^\"]*)\"$")
    public void iShouldSeeResultSuccess(String result) throws Throwable {
        $(resultSearchField).shouldHave(Condition.attribute("value", result));
    }

    @Then("^I should see result \"([^\"]*)\"$")
    public void iShouldSeeResultEmpty(String result) throws Throwable {
        $(resultField).shouldHave(Condition.text(result));
    }

    @Given("^I open type menu$")
    public void iOpenTypeMenu() throws Throwable {
        $(typeMenu).click();
    }

    @Given("^I choose type dev$")
    public void iChooseType() throws Throwable {
        $(developmentType).click();
    }

    @Given("^I push enter$")
    public void iFocusedInSearchLine() throws Throwable {
        $(resultSearchField).pressEnter();
    }

    @Then("^I should see result with \"([^\"]*)\"$")
    public void iShouldSeeResultWith(String result) throws Throwable {
        $(resultChangeType).shouldHave(Condition.text(result));
    }
}
