package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory_Grid;

import java.time.Duration;


public class Hooks {
    private  final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    public  static WebDriver driver;

    @Before
    public void initialize(Scenario scenario){
        LOGGER.info(String.format("-----Scenario : %s------",scenario.getName()));
        driver = DriverFactory_Grid.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void cleanup(Scenario scenario){
        DriverFactory_Grid.getInstance().removeDriver();
        LOGGER.info(String.format("-----End Scenario : %s------",scenario.getName()));
    }
}
