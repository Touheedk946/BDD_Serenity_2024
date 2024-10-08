package starter.petstore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private Long id;
    private String name;
    private String status;

    public Pet(String name, String status) {
        this.name = name;
        this.status = status;
    }
}
