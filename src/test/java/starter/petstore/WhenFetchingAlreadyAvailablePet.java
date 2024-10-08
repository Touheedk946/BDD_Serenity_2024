package starter.petstore;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenFetchingAlreadyAvailablePet {

    Long newPetId = null; // Variable to hold the newly created pet ID
    PetApiActions petApi = new PetApiActions(); // Instantiate the PetApiActions class

    @Test
    public void fetchAlreadyAvailablePet() {
        newPetId = petApi.givenKittyIsAvailableInPetStore(); // Create a pet and get its ID
        petApi.whenIAskForAPetWithId(newPetId); // Fetch the pet using its ID
        petApi.thenISeeKittyAsResult(); // Verify the result
    }
}
