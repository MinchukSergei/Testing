package package_lab2.pages_object;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by USER on 24.09.2016.
 */
public class FindPage {
    By searchField = By.xpath(".//*[@id='searchInput']");
    By submitSearchButton = By.xpath(".//*[@id='searchButton']");
    By resultSearch = By.xpath(".//*[@id='searchText']/input");

    public FindPage inputSearchField(String text) {
        $(searchField).sendKeys(text);
        return this;
    }

    public FindPage submitSearch() {
        $(submitSearchButton).click();
        return this;
    }

    public FindPage checkResult(String text) {
        $(resultSearch).shouldHave(Condition.value(text));
        return this;
    }
}
