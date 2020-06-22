package runner;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import utilities.LibDriverUtilities;

public class Hooks {

    @Before
    public void setUp() throws Exception {
        DriverManager.getInstance().createWebDriver(LibDriverUtilities.getBrowserFromParameter());
    }

    @After
    public void tearDown(){
        DriverManager.getInstance().quitWebDriver();
    }


}
