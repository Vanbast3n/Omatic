package driverManager;

import enums.EnumWebDrivers;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static DriverManager driverManager;
    private ThreadLocal<AndroidDriver<AndroidElement>> androidDriverThread = new ThreadLocal<>();
    private ThreadLocal<WebDriver> webDriverThread = new ThreadLocal();

    private DriverManager() {
    }

    public synchronized static DriverManager getInstance() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    public void createWebDriver(EnumWebDrivers webDrivers) throws Exception {
        switch (webDrivers) {
            case CHROME:

                webDriverThread.set(ConfigWebDriverManager.createChromeDriver());

                break;
            case FIREFOX:

                webDriverThread.set(ConfigWebDriverManager.createFirefoxDriver());

                break;
            case INTERNETEXPLORER:
                webDriverThread.set(ConfigWebDriverManager.createIEDriver());
                break;
        }
    }

    public void quitAndroidDriver() {
        if (androidDriverThread.get() != null) {
            androidDriverThread.get().quit();
            androidDriverThread.remove();
        }
    }

    public void quitWebDriver() {
        if (webDriverThread.get() != null) {
            webDriverThread.get().quit();
            webDriverThread.remove();

        }
    }

    public WebDriver getWebDriver() {
        return webDriverThread.get();
    }




}
