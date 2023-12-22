package helpers;

import constants.Constants;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;

public class Settings implements Constants.Endpoints, Constants.Schemes,
        Constants.PositiveData, Constants.NegativeData {
    @BeforeAll
    public static void setup() {
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .setBaseUri(PET).addFilter(new AllureRestAssured()).build();

        RestAssured.responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
    }
}
