package helpers;

import constants.Constants;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import logger.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class Settings implements Constants.Endpoints, Constants.Schemes,
        Constants.PositiveData, Constants.NegativeData {
    protected static Response response;
    private static final AllureRestAssured ALLURE_REQUEST_RESPONSE_TEMPLATE = new AllureRestAssured()
        .setRequestTemplate("http-request.ftl")
        .setResponseTemplate("http-response.ftl");

    @BeforeAll
    public static void setup() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri(PET)
            .addFilter(ALLURE_REQUEST_RESPONSE_TEMPLATE)
            .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .build();
    }

    @BeforeEach
    public void beforeEach(){
        Logger.LOG4J_LOGGER.info("--- NEW TEST ---");
    }
}
