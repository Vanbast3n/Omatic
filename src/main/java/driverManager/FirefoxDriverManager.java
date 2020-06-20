package driverManager;


import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager{

    @Override
    public void createDriver(){
        System.setProperty("webdriver.gecko.driver","./src/test/resources/driver/firefox/geckodriver.exe");
        driver = new FirefoxDriver();
    }

}
