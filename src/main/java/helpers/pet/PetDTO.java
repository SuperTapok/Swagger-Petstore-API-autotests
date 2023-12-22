package helpers.pet;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;

@Jacksonized
@Builder
@Setter
@Getter
public class PetDTO {
    Integer id;
    CategoryDTO category;
    String name;
    ArrayList<String> photoUrls;
    ArrayList<TagDTO> tags;
    String status;
}
