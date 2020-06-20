package libs;

import common.Constants;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.Constants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WebDriverActions extends Constants {

    public void waitForAnyCondition(WebDriver driver, By locator, Integer timeout, String condition) throws Exception {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        switch (condition) {
            case PRESENCE_OF_ELEMENT_LOCATED:
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
                break;
            case ELEMENT_TO_BE_CLICKABLE:
                webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
            case VISIBILITY_OF:
                webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
                break;
            case FRAME_TO_BE_AVAILABLE_AND_SWITCH_TO_IT:
                webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
                break;
            case PRESENCE_OF_ALL_ELEMENTS_LOCATED_BY:
                webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
                break;
            case INVISIVILITY_OF:
                webDriverWait.until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));
                break;
            default:
                throw new Exception("Parameter not supported");
        }

    }


    public void clickOnElement(WebDriver driver, By locator, Integer timeout) throws Exception {
        waitForAnyCondition(driver, locator, timeout, ELEMENT_TO_BE_CLICKABLE);
        driver.findElement(locator).click();
    }

    public List<String> getWebElementListStr(WebDriver driver, By locator) {
        List<String> hotelList = new ArrayList<>();
        for (WebElement element : driver.findElements(locator)) {
            hotelList.add(element.getText());
        }
        return hotelList;
    }

    public Boolean isDisplayed(WebDriver driver, By locator){
        return driver.findElement(locator).isDisplayed();
    }

    public List<WebElement> getWebElementList(WebDriver driver, By locator) {
        return new ArrayList<>(driver.findElements(locator));
    }


    public Map<String, String> convertDataTableIntoMap(DataTable dates) {
        return dates.asMap(String.class, String.class);
    }

    public List<Map<String,String>> convertDataTableIntoMapList(DataTable dates){
        return dates.asMaps(String.class,String.class);
    }

    public void switchToNextTab(WebDriver driver) {
            String oldTab = driver.getWindowHandle();
            ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
            newTab.remove(oldTab);
            driver.switchTo().window(newTab.get(0));

    }

    public void moveOverElement(WebDriver driver, By locator,Integer timeout) throws Exception {
        Actions actions = new Actions(driver);
        waitForAnyCondition(driver, locator, timeout, ELEMENT_TO_BE_CLICKABLE);
        actions.moveToElement(driver.findElement(locator)).build().perform();
    }


}
