package pet.model;
import java.util.ArrayList;
import java.util.Arrays;

public class PetBuilder {

    public static Pet getPet (Integer id, String name, ArrayList<String> photoUrls) {
        return Pet.builder()
                .id(id)
                .name(name)
                .photoUrls(photoUrls)
                .build();
    }
}
