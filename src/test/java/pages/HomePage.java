package pages;

import io.cucumber.datatable.DataTable;
import libs.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;


public class HomePage {

    WebDriverActions perform = new WebDriverActions();

    //Pop ups
    public final By popupCovid19 = By.className("closeModal");
    public final By popupCookies = By.id("cookies-advise-accept");
    //Trip menu
    public final By destinationBox = By.xpath("(//input[@id = 'destination--input'])[1]");
    public final By calendarBox = By.xpath("//div[@class='hesperia-datepicker__input desktop']");
    public final By nextMonthButton = By.xpath("//table[@id='month-2-1']/thead/tr[@class='datepicker__month-caption']/th/span[@class='datepicker__month-button datepicker__month-button--next']");
    public String daysSelector = "//table[@id='month-1-1']//td[text()='%s']";
    public final By bookButton = By.xpath("//div/button[@class='btn btn-primary uppercase search']");

    //Hotel List
    public final By hotelListLocator = By.xpath("//div[@class='hotel-wrapper']");
    public String hotelListSelectorXpath = "//div[@class='hotel-wrapper' and text()='%s']";


    //Constants
    private final Integer timeout = 5;

    //Métodos sobre la web
    public void acceptCookiesPolicy(WebDriver driver) throws Exception {
        perform.clickOnElement(driver, popupCookies, timeout);
    }

    public void closeCovidPopup(WebDriver driver) throws Exception {
        perform.clickOnElement(driver, popupCovid19, timeout);
    }

    public void extractHotelListFromDropDownAndSelectHotel(WebDriver driver, String hotel) throws Exception {
        perform.clickOnElement(driver, destinationBox, timeout);
        By hotelListSelector = By.xpath(String.format(hotelListSelectorXpath, hotel));
        perform.clickOnElement(driver, hotelListSelector, timeout);
    }

    public void selectDateOneYearAhead(WebDriver driver, DataTable dates) throws Exception {
        List<Map<String, String>> datesMap = perform.convertDataTableIntoMapList(dates);

        for (Map<String, String> date : datesMap) {
            String checkIn = String.format(daysSelector, date.get("checkIn"));
            String checkOut = String.format(daysSelector, date.get("checkOut"));
            perform.clickOnElement(driver, calendarBox, timeout);
            advanceMonths(driver, nextMonthButton, Integer.parseInt(date.get("monthsAhead")));
            selectStayDays(driver, checkIn, checkOut);
        }


    }

    private void selectStayDays(WebDriver driver, String checkIn, String checkOut) throws Exception {
        By checkInLocator = By.xpath(checkIn);
        By checkOutLocator = By.xpath(checkOut);
        perform.clickOnElement(driver, checkInLocator, timeout);
        perform.clickOnElement(driver, checkOutLocator, timeout);
    }

    private void advanceMonths(WebDriver driver, By locator, int months) throws Exception {
        for (int i = 0; i < months; i++) {
            perform.clickOnElement(driver, locator, timeout);
        }
    }

    public void clickOnButtonToBook(WebDriver driver) throws Exception {
        perform.clickOnElement(driver, bookButton, timeout);
        perform.switchToNextTab(driver);
    }
}
