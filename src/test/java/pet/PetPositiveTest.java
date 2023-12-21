package pet;

import helper.PetsHelper;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import pet.model.*;

import java.io.File;
import java.util.ArrayList;

import static org.apache.http.HttpStatus.SC_OK;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetPositiveTest extends BaseTest{
    @Order(1)
    @ParameterizedTest
    @MethodSource("helper.PetsHelper#postPetSupplier")
    public void postPetTest (Integer id, String name, ArrayList<String> photoUrls){
        Pet pet = PetBuilder.getPet(id, name, photoUrls);

        PetsHelper.postPetResponse(pet)
            .statusCode(SC_OK)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("pet/Schemes/PetScheme.json"));
    }

    @Order(2)
    @ParameterizedTest
    @MethodSource("helper.PetsHelper#putPetSupplier")
    public void putPetTest (Integer id, String name, ArrayList<String> photoUrls) {
        Pet pet = PetBuilder.getPet(id, name, photoUrls);

        PetsHelper.putPetResponse(pet)
                .statusCode(SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("pet/Schemes/PetScheme.json"));
    }

    @Order(3)
    @ParameterizedTest
    @CsvFileSource(resources = "test_data/Positive/PostUploadImageData.csv", numLinesToSkip = 1)
    public void postUploadImageTest (Integer id, String fileName) {
        PetsHelper.postUploadImageTest(id, new File(fileName))
                .statusCode(SC_OK)
                .body(JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("pet/Schemes/BasicResponseScheme.json"));
    }

    @Order(4)
    @ParameterizedTest
    @CsvFileSource(resources = "test_data/Positive/GetPetData.csv", numLinesToSkip = 1)
    void getPetTest (String id) {
        PetsHelper.getPetTest(id)
                .statusCode(SC_OK)
                .body(JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("pet/Schemes/PetScheme.json"));
    }

    @Order(5)
    @ParameterizedTest
    @CsvFileSource(resources = "test_data/Positive/GetFindByStatusData.csv", numLinesToSkip = 1)
    void getFindByStatusTest (String status) {
        PetsHelper.getFindByStatus(status).statusCode(SC_OK)
                .body(JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("pet/Schemes/FindByStatusScheme.json"));
    }

    @Order(6)
    @ParameterizedTest
    @CsvFileSource(resources = "test_data/Positive/PostPetWithFormData.csv", numLinesToSkip = 1)
    void postUpdatePetByFormDataTest (Integer id, String name, String status) {
        PetsHelper.postUpdatePetByFormDataTest(id, name, status)
                .statusCode(SC_OK)
                .body(JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("pet/Schemes/BasicResponseScheme.json"));
    }

    @Order(7)
    @ParameterizedTest
    @CsvFileSource(resources = "test_data/Positive/DeletePetData.csv", numLinesToSkip = 1)
    void deletePetTest (Integer id) {
        PetsHelper.deletePetTest(id)
                .statusCode(SC_OK)
                .body(JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("pet/Schemes/BasicResponseScheme.json"));
    }
}
