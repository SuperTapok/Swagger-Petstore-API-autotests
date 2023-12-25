package helpers;
import models.pet.PetDTO;

import java.util.ArrayList;

public class PetBuilder {

    public static PetDTO getPet (Integer id, String name, ArrayList<String> photoUrls) {
        return PetDTO.builder()
            .id(id)
            .name(name)
            .photoUrls(photoUrls)
            .build();
    }
}
