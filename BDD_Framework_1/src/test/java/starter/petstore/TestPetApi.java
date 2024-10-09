package starter.petstore;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import starter.petstore.Interface.PetApiService;
import starter.petstore.Request.Pet;
import starter.petstore.Response.PetApiServiceResponse;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestPetApi {

    private Long newPetId;
    private PetApiService petApiService;

    @BeforeEach
    public void setup() {
        // Initialize the PetApiService implementation
        petApiService = new PetApiServiceResponse();
    }

    @Test
    public void fetchPetDetails() {
        // Create a new pet in the store and retrieve its ID
        Pet newPet = new Pet("Kitty", "available");
        newPetId = petApiService.createPet(newPet);
        System.out.println("New Pet ID: " + newPetId);

        // Fetch the details of the created pet using the ID
        Pet retrievedPet = petApiService.getPetById(newPetId);
        System.out.println("Retrieved Pet: " + retrievedPet);

        // Verify the name of the retrieved pet
        assert "Kitty".equals(retrievedPet.getName()) : "Pet name does not match";
    }
}
