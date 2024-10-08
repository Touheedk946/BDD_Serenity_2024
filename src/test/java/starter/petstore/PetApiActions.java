package starter.petstore;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.core.steps.UIInteractions;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.*;

public class PetApiActions extends UIInteractions {

    @Given("Kitty is available in the pet store")
    public Long givenKittyIsAvailableInPetStore() {
        Pet pet = new Pet("Kitty", "available"); // Create a new Pet object

        // Send a POST request to create the pet and return its ID
        Long newId = given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet")
                .body(pet, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post()
                .getBody()
                .as(Pet.class, ObjectMapperType.GSON)
                .getId();
        return newId; // Return the newly created pet ID
    }

    @When("I ask for a pet using Kitty's ID: {0}")
    public void whenIAskForAPetWithId(Long id) {
        when().get("/" + id); // Call the GET API with the pet ID
    }

    @Then("I get Kitty as result")
    public void thenISeeKittyAsResult() {
        then().body("name", Matchers.equalTo("Kitty")); // Assert that the pet's name is "Kitty"
    }
}
