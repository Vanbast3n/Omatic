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
    public void acceptCookiesPolicy() throws Exception {
        perform.clickOnElement(popupCookies, timeout);
    }

    public void closeCovidPopup() throws Exception {
        perform.clickOnElement(popupCovid19, timeout);
    }

    public void extractHotelListFromDropDownAndSelectHotel(String hotel) throws Exception {
        perform.clickOnElement(destinationBox, timeout);
        By hotelListSelector = By.xpath(String.format(hotelListSelectorXpath, hotel));
        perform.clickOnElement(hotelListSelector, timeout);
    }

    public void selectDateOneYearAhead(DataTable dates) throws Exception {
        List<Map<String, String>> datesMap = perform.convertDataTableIntoMapList(dates);

        for (Map<String, String> date : datesMap) {
            String checkIn = String.format(daysSelector, date.get("checkIn"));
            String checkOut = String.format(daysSelector, date.get("checkOut"));
            perform.clickOnElement(calendarBox, timeout);
            advanceMonths(nextMonthButton, Integer.parseInt(date.get("monthsAhead")));
            selectStayDays(checkIn, checkOut);
        }


    }

    private void selectStayDays(String checkIn, String checkOut) throws Exception {
        By checkInLocator = By.xpath(checkIn);
        By checkOutLocator = By.xpath(checkOut);
        perform.clickOnElement(checkInLocator, timeout);
        perform.clickOnElement(checkOutLocator, timeout);
    }

    private void advanceMonths(By locator, int months) throws Exception {
        for (int i = 0; i < months; i++) {
            perform.clickOnElement(locator, timeout);
        }
    }

    public void clickOnButtonToBook() throws Exception {
        perform.clickOnElement(bookButton, timeout);
        perform.switchToNextTab();
    }
}
