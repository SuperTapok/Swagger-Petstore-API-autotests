package helpers.pet;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public class CategoryDTO {
    public int id;
    public String name;
}
