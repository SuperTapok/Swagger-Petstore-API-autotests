package pet.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;

@Jacksonized
@Builder
@Setter
@Getter
public class Pet {
    @JsonProperty()
    Integer id;
    @JsonProperty()
    Category category;
    @JsonProperty()
    String name;
    @JsonProperty()
    ArrayList<String> photoUrls;
    @JsonProperty()
    ArrayList<Tag> tags;
    @JsonProperty()
    String status;
}
