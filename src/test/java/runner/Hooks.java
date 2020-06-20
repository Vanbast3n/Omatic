package runner;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    private static ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/driver/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.hesperia.com/es/es.html");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public static ChromeDriver getDriver(){
        return driver;
    }



}
