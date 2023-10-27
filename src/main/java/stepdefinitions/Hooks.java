package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

    protected static final Logger LOGGER = LogManager.getLogger("stepdefinitions.Hooks");
    @Before
    public void beforeHook(Scenario scenario){
        LOGGER.info("+-----------------------------------+");
        LOGGER.info(scenario.getName());
        LOGGER.info("+-----------------------------------+");
    }
    @After
    public void afterHook(Scenario scenario){
        if(scenario.isFailed()){
            LOGGER.error("||The test has failed!||");
        }
        else
            LOGGER.info("||The test has passed||");

    }
}
