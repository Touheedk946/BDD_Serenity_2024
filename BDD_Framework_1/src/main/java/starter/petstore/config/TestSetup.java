package starter.petstore.config;

import net.serenitybdd.core.steps.UIInteractions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.petstore.Interface.PetApiService;
import starter.petstore.Response.PetApiServiceResponse;

public class TestSetup extends UIInteractions {

    protected PetApiService petApiService;
    protected static final Logger logger = LoggerFactory.getLogger(TestSetup.class);

    public TestSetup() {
        this.petApiService = new PetApiServiceResponse();
        logger.info("PetApiService initialized.");
    }

    public PetApiService getPetApiService() {
        return this.petApiService;
    }
}
