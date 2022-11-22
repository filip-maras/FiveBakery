package Methods;

import DriverConfigurations.ElementActions;
import DriverConfigurations.Initiate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Selectors.HomePage.*;

public class DateTimeMethods extends ElementActions {

    public static WebElement getFirstAvailableDay() {
        WebElement firstAvailableDay = null;
        elementLocate(daysDatePicker);
        WebElement allDaysContainer = Initiate.getChromeDriver().findElement(daysDatePicker);
        List<WebElement> days = allDaysContainer.findElements(By.tagName("div"));
        for (WebElement e: days) {
            if(e.getAttribute("class").equals("available")) {
                firstAvailableDay = e;
                break;
            }
        }
        return firstAvailableDay;
    }

    public static WebElement getFirstAvailableHour() {
        WebElement firstAvailableDay = null;
        elementLocate(hourPicker);
        WebElement allHoursContainer = Initiate.getChromeDriver().findElement(hourPicker);
        List<WebElement> hours = allHoursContainer.findElements(By.tagName("div"));
        for (WebElement e: hours) {
            if(e.getAttribute("class").equals("available")) {
                firstAvailableDay = e;
                break;
            }
        }
        return firstAvailableDay;
    }

    public static WebElement getFirstAvailableMinute() {
        WebElement firstAvailableDay = null;
        elementLocate(minutePicker);
        WebElement allMinutesContainer = Initiate.getChromeDriver().findElement(minutePicker);
        List<WebElement> minutes = allMinutesContainer.findElements(By.tagName("div"));
        for (WebElement e: minutes) {
            if(e.getAttribute("class").equals("available")) {
                firstAvailableDay = e;
                break;
            }
        }
        return firstAvailableDay;
    }
}
