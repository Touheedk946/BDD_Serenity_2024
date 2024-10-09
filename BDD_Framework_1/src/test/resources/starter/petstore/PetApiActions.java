/*
package starter.petstore;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;

public class PetApiActions extends UIInteractions {

    @Given("Kitty is available in the pet store")
    public Long givenKittyIsAvailableInPetStore() {
        Pet pet = new Pet("Kitty", "available");

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
        return newId;
    }

    @When("I ask for a pet using Kitty's ID: {0}")
    public void whenIAskForAPetWithId(Long id) {
        when().get("/" + id);
    }

    @Then("I get Kitty as result")
    public void thenISeeKittyAsResult() {
        then().body("name", Matchers.equalTo("Kitty"));
    }
}
*/
