package starter.petstore.Interface;

import starter.petstore.Request.Pet;

public interface PetApiService {

    /**
     * Create a new pet in the pet store.
     *
     * @param pet The pet object to create.
     * @return The ID of the created pet.
     */
    Long createPet(Pet pet);

    /**
     * Retrieve pet details using the pet's ID.
     *
     * @param petId The ID of the pet to retrieve.
     * @return The Pet object containing pet details.
     */
    Pet getPetById(Long petId);
}
