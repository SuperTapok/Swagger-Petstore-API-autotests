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

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Settings implements Constants.Endpoints, Constants.Schemes,
        Constants.PositiveData, Constants.NegativeData {
    private static Boolean readEnv = false;
    protected static Response response;
    protected static HashMap<String, Object> headers,
                                             body,
                                             params;
    protected static LinkedHashMap<String, Object> queryParams;
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
        response = null;

        headers = new HashMap<>();
        body = new HashMap<>();
        params = new HashMap<>();

        queryParams = new LinkedHashMap<>();

        Logger.LOG4J_LOGGER.info("--- NEW TEST ---");
    }
}
