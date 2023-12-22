package pet;

import helpers.PetsHelper;
import helpers.Settings;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.File;

import static org.apache.http.HttpStatus.*;

@Feature("Pet")
public class PetNegativeTest extends Settings {
    @ParameterizedTest
    @CsvFileSource(resources = GET_PET_NEGATIVE)
    @DisplayName("GET " + PET_ID + " code " + SC_NOT_FOUND)
    @Description("Поиск питомца с невалидным id")
    void getPetTest (String id) {
        PetsHelper.getPetTest(id)
            .statusCode(SC_NOT_FOUND)
            .body(JsonSchemaValidator
                    .matchesJsonSchemaInClasspath(BASIC_RESPONSE));
    }

    @ParameterizedTest
    @CsvFileSource(resources = POST_UPLOAD_IMAGE_NEGATIVE)
    @DisplayName("POST " + UPLOAD_IMAGE + " code " + SC_UNSUPPORTED_MEDIA_TYPE)
    @Description("Загрузка файлов других форматов вместо изображений для питомца")
    public void postUploadImageTest (Integer id, String fileName) {
        PetsHelper.postUploadImageTest(id, new File(fileName))
            .statusCode(SC_UNSUPPORTED_MEDIA_TYPE)
            .body(JsonSchemaValidator
                .matchesJsonSchemaInClasspath(BASIC_RESPONSE));
    }

    @ParameterizedTest
    @CsvFileSource(resources = GET_FIND_BY_STATUS_NEGATIVE)
    @DisplayName("GET " + FIND_BY_STATUS + " code " + SC_OK)
    @Description("Поиск питомцев с невалидными статусами")
    void getFindByStatusTest (String status) {
        PetsHelper.getFindByStatus(status)
            .statusCode(SC_OK)
            .body(JsonSchemaValidator
                .matchesJsonSchemaInClasspath(ARRAY_OF_PETS));
    }
}
