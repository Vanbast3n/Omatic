package utilities;

import enums.EnumWebDrivers;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LibDriverUtilities {

    public static String getWebBrowserName(WebDriver driver) {
        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        return capabilities.getBrowserName().toLowerCase();
    }

    public static String getWebBrowserOs(WebDriver driver) {
        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        return capabilities.getVersion().toLowerCase();
    }

    public static EnumWebDrivers getBrowserFromParameter() throws Exception {
        EnumWebDrivers webDrivers;
        String browser = System.getProperty("browser");

        switch (EnumWebDrivers.getEnumWebDriver(browser.toUpperCase())) {
            case CHROME:
                webDrivers = EnumWebDrivers.CHROME;
                break;
            case INTERNETEXPLORER:
                webDrivers = EnumWebDrivers.INTERNETEXPLORER;
                break;
            case FIREFOX:
                webDrivers = EnumWebDrivers.FIREFOX;
                break;
            default:
                throw new Exception("Parameter not supported");
        }

        return webDrivers;
    }


}
