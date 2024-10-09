package starter.petstore;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.petstore.Request.Pet;
import starter.petstore.config.TestSetup;

public class PetApiActions extends TestSetup {

    private Long createdPetId;

    @Given("Kitty is available in the pet store")
    public void createPetID() {
        Pet pet = new Pet("Kitty", "available");
        createdPetId = getPetApiService().createPet(pet);
        logger.info("Created Pet ID: {}", createdPetId);
    }

    @When("I ask for a pet using Kitty's ID")
    public void getPetDetails() {
        Pet pet = getPetApiService().getPetById(createdPetId);
        logger.info("Retrieved Pet: {}", pet);
    }

    @Then("I get Kitty as result")
    public void verifyResults() {
        Pet retrievedPet = getPetApiService().getPetById(createdPetId);
        assert "Kitty".equals(retrievedPet.getName()) : "Pet name does not match";
        logger.info("Verified Pet Name: {}", retrievedPet.getName());
    }
}
