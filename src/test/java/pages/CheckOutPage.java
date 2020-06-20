package pages;

import common.Constants;
import libs.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckOutPage {

    WebDriverActions perform = new WebDriverActions();
    Constants cte = new Constants();

    //Buttons
    public final By bookNowButton = By.xpath("//button[@id='book-button-id']");

    //Time and Date
    public final Integer timeout = 10;

    //Headers
    public final By roomTypeHeader = By.xpath("//div[@class='accommodations-text-tab-desk ng-binding']");


    public void moveMouseOverHeader(WebDriver driver) throws Exception {
        perform.waitForAnyCondition(driver,bookNowButton,timeout,cte.PRESENCE_OF_ELEMENT_LOCATED);
        perform.waitForAnyCondition(driver,bookNowButton,timeout,cte.ELEMENT_TO_BE_CLICKABLE);
        perform.moveOverElement(driver,roomTypeHeader,timeout);
    }
}
