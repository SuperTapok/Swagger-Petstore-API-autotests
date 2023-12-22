package pet;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;

import static configuration.Settings.URL;


public class BaseTest {
    public static String PET            = URL + "/pet",
                         FIND_BY_STATUS = PET + "/findByStatus";

    @BeforeAll
    public static void setup() {
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .setBaseUri(PET).addFilter(new AllureRestAssured()).build();

        RestAssured.responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
    }
}
