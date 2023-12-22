package helpers.pet;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public class TagDTO {
    public int id;
    public String name;
}
