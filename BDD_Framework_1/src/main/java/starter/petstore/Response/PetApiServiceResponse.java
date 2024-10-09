package starter.petstore.Response;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.petstore.Request.Pet;
import starter.petstore.Interface.PetApiService;
import starter.petstore.util.RestClient;

public class PetApiServiceResponse implements PetApiService {

    private static final String BASE_URI = "https://petstore.swagger.io";
    private static final String BASE_PATH = "/v2/pet";
    private static final Logger logger = LoggerFactory.getLogger(PetApiServiceResponse.class);

    @Override
    public Long createPet(Pet pet) {
        logger.info("Sending request to create pet with name: {}", pet.getName());
        Response response = RestClient.postRequest(BASE_URI, BASE_PATH, pet);

        if (response.getStatusCode() != 200 && response.getStatusCode() != 201) {
            logger.error("Failed to create pet: {}", response.getStatusLine());
            throw new RuntimeException("Failed to create pet: " + response.getStatusLine());
        }

        Long petId = response.getBody().as(Pet.class, ObjectMapperType.GSON).getId();
        logger.info("Successfully created pet with ID: {}", petId);
        return petId;
    }

    @Override
    public Pet getPetById(Long petId) {
        logger.info("Fetching pet details for ID: {}", petId);
        Response response = RestClient.getRequest(BASE_URI, BASE_PATH + "/" + petId);

        if (response.getStatusCode() != 200) {
            logger.error("Failed to fetch pet: {}", response.getStatusLine());
            throw new RuntimeException("Failed to fetch pet: " + response.getStatusLine());
        }

        Pet pet = response.getBody().as(Pet.class, ObjectMapperType.GSON);
        logger.info("Successfully fetched pet details: {}", pet);
        return pet;
    }
}
