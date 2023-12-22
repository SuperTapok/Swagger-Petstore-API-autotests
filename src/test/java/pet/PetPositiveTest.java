package pet;

import helpers.PetsHelper;
import helpers.Settings;
import helpers.pet.PetBuilder;
import helpers.pet.PetDTO;
import io.qameta.allure.Description;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.ArrayList;

import static org.apache.http.HttpStatus.SC_OK;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetPositiveTest extends Settings {
    @Order(1)
    @ParameterizedTest
    @MethodSource("helpers.PetsHelper#postPetSupplier")
    @DisplayName("POST " + PET + " code " + SC_OK)
    @Description("Добавление валидного питомца")
    public void postPetTest (Integer id, String name, ArrayList<String> photoUrls){
        PetDTO pet = PetBuilder.getPet(id, name, photoUrls);

        PetsHelper.postPetResponse(pet)
            .statusCode(SC_OK)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(PET_SCHEME));
    }

    @Order(2)
    @ParameterizedTest
    @MethodSource("helpers.PetsHelper#putPetSupplier")
    @DisplayName("PUT " + PET + " code " + SC_OK)
    @Description("Изменение питомца валидными данными")
    public void putPetTest (Integer id, String name, ArrayList<String> photoUrls) {
        PetDTO pet = PetBuilder.getPet(id, name, photoUrls);

        PetsHelper.putPetResponse(pet)
            .statusCode(SC_OK)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(PET_SCHEME));
    }

    @Order(3)
    @ParameterizedTest
    @CsvFileSource(resources = POST_UPLOAD_IMAGE_POSITIVE)
    @DisplayName("POST " +  UPLOAD_IMAGE + " code " + SC_OK)
    @Description("Загрузка изображений для питомца")
    public void postUploadImageTest (Integer id, String fileName) {
        PetsHelper.postUploadImageTest(id, new File(fileName))
            .statusCode(SC_OK)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(BASIC_RESPONSE));
    }

    @Order(4)
    @ParameterizedTest
    @CsvFileSource(resources = GET_PET_POSITIVE)
    @DisplayName("GET " + PET_ID + " code " + SC_OK)
    @Description("Поиск питомца по валидному id")
    void getPetTest (String id) {
        PetsHelper.getPetTest(id)
            .statusCode(SC_OK)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(PET_SCHEME));
    }

    @Order(5)
    @ParameterizedTest
    @CsvFileSource(resources = GET_FIND_BY_STATUS_POSITIVE)
    @DisplayName("GET " + FIND_BY_STATUS + " code " + SC_OK)
    @Description("Поиск и фильтрация питомцев по валидному статусу")
    void getFindByStatusTest (String status) {
        PetsHelper.getFindByStatus(status).statusCode(SC_OK)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(ARRAY_OF_PETS));
    }

    @Order(6)
    @ParameterizedTest
    @CsvFileSource(resources = POST_PET_WITH_FORM_DATA_POSITIVE)
    @DisplayName("POST " + PET_ID + " code " + SC_OK)
    @Description("Обновление питомца валидными данными формы")
    void postUpdatePetByFormDataTest (Integer id, String name, String status) {
        PetsHelper.postUpdatePetByFormDataTest(id, name, status)
            .statusCode(SC_OK)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(BASIC_RESPONSE));
    }

    @Order(7)
    @ParameterizedTest
    @CsvFileSource(resources = DELETE_PET_POSITIVE)
    @DisplayName("DELETE " + PET_ID + " code " + SC_OK)
    @Description("Удаление питомца по существующему id")
    void deletePetTest (Integer id) {
        PetsHelper.deletePetTest(id)
            .statusCode(SC_OK)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(BASIC_RESPONSE));
    }
}
