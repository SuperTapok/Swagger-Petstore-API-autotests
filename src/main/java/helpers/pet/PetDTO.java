package helpers.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;

@Jacksonized
@Builder
public class PetDTO {
    @JsonProperty
    Integer id;
    @JsonProperty
    CategoryDTO category;
    @JsonProperty
    String name;
    @JsonProperty
    ArrayList<String> photoUrls;
    @JsonProperty
    ArrayList<TagDTO> tags;
    @JsonProperty
    String status;
}
