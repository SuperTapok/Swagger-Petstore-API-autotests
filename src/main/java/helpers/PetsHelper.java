package helpers;

import models.pet.PetDTO;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.params.provider.Arguments;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class PetsHelper extends Settings {

    public static ValidatableResponse postPetResponse(PetDTO pet) {
        return
            given()
                .body(pet)
            .when()
                .post(PET)
            .then()
                .log().ifValidationFails(LogDetail.ALL);
    }

    public static ValidatableResponse putPetResponse(PetDTO pet) {
        return
            given()
                .body(pet)
            .when()
                .put(PET)
            .then()
                .log().ifValidationFails(LogDetail.ALL);
    }

    public static ValidatableResponse postUploadImageTest(Integer id, File file) {
        return
            given()
                .contentType(ContentType.MULTIPART)
                .multiPart("file", file)
                .pathParam("petId", id)
            .when()
                .post(UPLOAD_IMAGE)
            .then()
                .log().ifValidationFails(LogDetail.ALL);
    }

    public static ValidatableResponse getPetTest(String id) {
        return
            given()
                .header("api_key", "special-key")
                .pathParam("petId", id)
            .when()
                .get(PET_ID)
            .then()
                .log().ifValidationFails(LogDetail.ALL);
    }

    public static ValidatableResponse getFindByStatus (String status) {
        return
            given()
                .queryParam("status", status)
            .when()
                .get(FIND_BY_STATUS)
            .then()
                .log().ifValidationFails(LogDetail.ALL);
    }

    public static ValidatableResponse postUpdatePetByFormDataTest (Integer id, String name, String status) {
        return
            given()
                .contentType(ContentType.URLENC)
                .formParam("name", name)
                .formParam("status", status)
                .pathParam("petId", id)
            .when()
                .post(PET_ID)
            .then()
                .log().ifValidationFails(LogDetail.ALL);
    }

    public static ValidatableResponse deletePetTest (Integer id) {
        return
            given()
                .pathParam("petId", id)
            .when()
                .delete(PET_ID)
            .then()
                .log().ifValidationFails(LogDetail.ALL);
    }

    private static Stream<Arguments> postPetSupplier () {
        return Stream.of(
            Arguments.of(15, "Bullet", new ArrayList<>(Arrays.asList("url1", "url2"))),
            Arguments.of(16, "Romeo", new ArrayList<>(Arrays.asList("url1", "url2"))),
            Arguments.of(17, "Julia", new ArrayList<>(Arrays.asList("url1", "url2"))),
            Arguments.of(18, "Andrew", new ArrayList<>(Arrays.asList("url1", "url2")))
        );
    }

    private static Stream<Arguments> putPetSupplier () {
        return Stream.of(
            Arguments.of(15, "BulleT", new ArrayList<>(Arrays.asList("url1", "url2"))),
            Arguments.of(16, "RomEo", new ArrayList<>(Arrays.asList("url1", "url2"))),
            Arguments.of(17, "JuliA", new ArrayList<>(Arrays.asList("url1", "url2"))),
            Arguments.of(18, "AnDrew", new ArrayList<>(Arrays.asList("url1", "url2")))
        );
    }
}
