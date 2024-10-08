package starter.petstore;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestPetApi {

    Long newPetId = null;
    PetApiActions petApi = new PetApiActions();

    @Test
    public void fetchPetDetails() {
        newPetId = petApi.createPetID();
        petApi.getPetDetails(newPetId);
        petApi.verifyResults();
    }
}
