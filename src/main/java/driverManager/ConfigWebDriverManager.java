package driverManager;

import cucumber.api.Scenario;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;


import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class ConfigWebDriverManager {

    private static final String PATH_PROPERTIES = "src/global.properties";
    private static final String PATH_WEB_URL_PROPERTIES = "webUrl";
    private static final String PATH_HEADLESS_PROPERTY_CHROME = "headlessChrome";
    private static final String PATH_HEADLESS_PROPERTY_FIREFOX = "headlessFirefox";
    private static final String DESKTOP = "Desktop";

    public static final String NAVEGAR_A_LA_PAGINA = "Se navega a la página ";
    public static final String CHROME_HEADLESS_MODE = "Ejecutando CHROME driver en modo headless";
    public static final String FIREFOX_HEADLESS_MODE = "Ejecutando FIREFOX driver en modo headless";
    public static final String CHROME_NORMAL_MODE = "Ejecutando CHROME driver en modo normal";
    public static final String FIREFOX_NORMAL_MODE = "Ejecutando FIREFOX driver en modo normal";
    public static final String INICIAR_EJECUCION_CHROME = "Se inicia la ejecución con CHROME";
    public static final String INICIAR_EJECUCION_FIREFOX = "Se inicia la ejecución con FIREFOX";
    public static final String INICIAR_EJECUCION_IE = "Se inicia la ejecución con INTERNET EXPLORER";
    public static final String CHROME_DRIVER_OK = "CHROME driver creado satisfactoriamente";
    public static final String FIREFOX_DRIVER_OK = "FIREFOX driver creado satisfactoriamente";
    public static final String IE_DRIVER_OK = "INTERNET EXPLORER driver creado satisfactoriamente";
    public static final String DRIVER_CERRADO_OK = "Se ha cerrado el driver correctamente";

    public static WebDriver createChromeDriver(Scenario scenario) throws Exception {
        WebDriver driver;


        try {

            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(PATH_PROPERTIES);
            properties.load(fileInputStream);
            String url = (String) properties.get(PATH_WEB_URL_PROPERTIES);
            ChromeOptions capabilities = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            String headlessParameterChrome = System.getProperty(PATH_HEADLESS_PROPERTY_CHROME);

            if (headlessParameterChrome.equalsIgnoreCase("true")) {

                capabilities.setHeadless(true);

            } else {
                capabilities.setHeadless(false);

            }
            driver = new ChromeDriver(capabilities);
            driver.get(url);

            return driver;

        } catch (Exception e) {

            throw new WebDriverException();
        }
    }

    public static WebDriver createChromeDriver() throws Exception {
        WebDriver driver;
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/global.properties");
            properties.load(fileInputStream);
            String url = (String) properties.get("webUrl");
            ChromeOptions capabilities = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            String headlessParameterChrome = System.getProperty("headlessChrome");
            if (headlessParameterChrome.equalsIgnoreCase("true")) {
                capabilities.addArguments("--window-size=1920,1080");
                capabilities.setHeadless(true);

            } else {
                capabilities.addArguments("--start-maximized");
                capabilities.setHeadless(false);

            }
            driver = new ChromeDriver(capabilities);
            driver.get(url);
            return driver;
        } catch (Exception e) {
            throw new Exception("Error creating Chrome driver", e);
        }
    }


    public static WebDriver createFirefoxDriver() throws WebDriverException {
        WebDriver driver;
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(PATH_PROPERTIES);
            properties.load(fileInputStream);
            String url = (String) properties.get(PATH_WEB_URL_PROPERTIES);
            FirefoxOptions firefoxOptions = new FirefoxOptions();

            WebDriverManager.firefoxdriver().setup();

            String headlessParameterFirefox = System.getProperty(PATH_HEADLESS_PROPERTY_FIREFOX);

            if (headlessParameterFirefox.equals("true")) {
                firefoxOptions.setHeadless(true);

            } else {
                firefoxOptions.setHeadless(false);

            }

            driver = new FirefoxDriver(firefoxOptions);
            driver.get(url);

            return driver;

        } catch (Exception e) {

            throw new WebDriverException();
        }
    }

    public static WebDriver createIEDriver() throws WebDriverException {
        WebDriver driver;
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(PATH_PROPERTIES);
            properties.load(fileInputStream);
            String url = (String) properties.get(PATH_WEB_URL_PROPERTIES);

            InternetExplorerOptions capabilities = new InternetExplorerOptions();

            WebDriverManager.iedriver().setup();

            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
            capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
            capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, false);
            capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);

            driver = new InternetExplorerDriver(capabilities);
            driver.manage().window().maximize();
            driver.get(url);

            return driver;

        } catch (Exception e) {

            throw new WebDriverException();
        }
    }

}


