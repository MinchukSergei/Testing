package package_lab4;

import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created by USER on 05.11.2016.
 */
public class RestAssured {

    @Test
    public void getAccountInfo() {
        given().when()
                .get("http://jsonplaceholder.typicode.com")
                .then()
                .statusCode(200);
    }
}
