package starter.petstore;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.core.steps.UIInteractions;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.*;

public class PetApiActions extends UIInteractions {

    private Long createdPetId;

    @Given("Kitty is available in the pet store")
    public Long createPetID() {
        Pet pet = new Pet("Kitty", "available");

        Response response = given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet")
                .body(pet)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post();

        if (response.getStatusCode() != 200 && response.getStatusCode() != 201) {
            throw new RuntimeException("Failed to create pet: " + response.getStatusLine());
        }

        System.out.println("Response Body: " + response.getBody().asString());

        createdPetId = response.getBody().as(Pet.class, ObjectMapperType.GSON).getId();
        System.out.println("Created Pet ID: " + createdPetId);
        return createdPetId;
    }

    @When("I ask for a pet using Kitty's ID: {0}")
    public void getPetDetails(Long id) {
        when().get("/" + id);
    }

    @Then("I get Kitty as result")
    public void verifyResults() {
        Pet retrievedPet = when().get("/" + createdPetId)
                .then()
                .statusCode(200)
                .extract()
                .as(Pet.class, ObjectMapperType.GSON);

        then().body("name", Matchers.equalTo(retrievedPet.getName()));
    }
}
