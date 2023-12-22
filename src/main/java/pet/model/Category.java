package pet.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public class Category {
    @JsonProperty
    public int id;
    @JsonProperty
    public String name;
}
