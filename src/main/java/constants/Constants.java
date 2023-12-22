package constants;

public interface Constants {
    interface Endpoints {
        String
            BASE_URL       = "https://petstore.swagger.io/v2",
            PET            = BASE_URL + "/pet",
            FIND_BY_STATUS = PET + "/findByStatus",
            UPLOAD_IMAGE = "/uploadImage";
    }

    interface Schemes {
        String
            PATH_SCHEMES   = "pet/schemes",
            ARRAY_OF_PETS  = PATH_SCHEMES + "/ArrayOfPets.json",
            BASIC_RESPONSE = PATH_SCHEMES + "/BasicResponse.json",
            PET_SCHEME     = PATH_SCHEMES + "/Pet.json";
    }

    interface PositiveData {
        String
                PATH_DATA = "test_data/positive",
                DELETE_PET_POSITIVE = PATH_DATA + "/DeletePet.csv",
                GET_FIND_BY_STATUS_POSITIVE = PATH_DATA + "/GetFindByStatus.csv",
                GET_PET_POSITIVE = PATH_DATA + "/GetPet.csv",
                POST_PET_WITH_FORM_DATA_POSITIVE = PATH_DATA + "/PostPetWithFormData.csv",
                POST_UPLOAD_IMAGE_POSITIVE = PATH_DATA + "/PostUploadImage.csv";
    }

    interface NegativeData {
        String
                PATH_DATA = "test_data/negative",
                GET_FIND_BY_STATUS_NEGATIVE = PATH_DATA + "/GetFindByStatus.csv",
                GET_PET_NEGATIVE = PATH_DATA + "/GetPet.csv",
                POST_UPLOAD_IMAGE_NEGATIVE = PATH_DATA + "/PostUploadImage.csv";
    }
}
