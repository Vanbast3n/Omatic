package runner;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import driverManager.DriverManager;
import driverManager.DriverManagerFactory;
import driverManager.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    private static WebDriver driver;
    private DriverManager driverManager;

    @Before
    public void setUp(){
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get("https://www.hesperia.com/es/es.html");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driverManager.quitDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }



}
