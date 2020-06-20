package pages;

import common.Constants;
import libs.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


public class RoomTypePage {

    WebDriverActions perform = new WebDriverActions();
    Constants cte = new Constants();

    //Titulos
    public final By roomsTitle = By.xpath("//div[@class='IconButton-wrapper']/span[@class='ng-binding']");
    public final By addMoreRooms = By.xpath("//div[@class='gsplash-details header-multiroom-info  ng-scope']/span");

    //Time and Date
    public final Integer timeout = 5;
    public final Integer loadedPageTimeOut = 15;

    //Botones
    public final By firstBookButton = By.xpath("//div[@id='0multirate']/div[@class='CardList-wrapper']/div[@class='CardList-summary CardList-summary-multirate']/div[@class='CardList-actions ng-scope']/button[@class='btn btn-primary CardList-action btn-primary-cta book-button-background ng-binding ng-scope' and @ng-if='!enableUpfrontEnhancementsIsActive']");

    public void clickOnButtonToBookTheFirstType(WebDriver driver) throws Exception {
        perform.clickOnElement(driver,firstBookButton,loadedPageTimeOut);
    }
}
