package pet;

import helper.PetsHelper;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.File;

import static org.apache.http.HttpStatus.*;

public class PetNegativeTest extends BaseTest{
    @ParameterizedTest
    @CsvFileSource(resources = "test_data/Negative/GetPetData.csv", numLinesToSkip = 1)
    void getPetTest (String id) {
        PetsHelper.getPetTest(id)
                .statusCode(SC_NOT_FOUND)
                .body(JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("pet/Schemes/BasicResponseScheme.json"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "test_data/Negative/PostUploadImageData.csv", numLinesToSkip = 1)
    public void postUploadImageTest (Integer id, String fileName) {
        PetsHelper.postUploadImageTest(id, new File(fileName))
                .statusCode(SC_UNSUPPORTED_MEDIA_TYPE)
                .body(JsonSchemaValidator
                .matchesJsonSchemaInClasspath("pet/Schemes/BasicResponseScheme.json"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "test_data/Negative/GetFindByStatusData.csv", numLinesToSkip = 1)
    void getFindByStatusTest (String status) {
        PetsHelper.getFindByStatus(status).statusCode(SC_OK)
                .body(JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("pet/Schemes/FindByStatusScheme.json"));
    }
}
