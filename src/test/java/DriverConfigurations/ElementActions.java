package DriverConfigurations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import java.util.List;

public class ElementActions extends Initiate {

    public static Integer miliSecondsWait = 200;

    public static void report(String message) {
        System.out.println(message);
    }

    public static void elementClick(By selector, int waitFor){
        report("Clicking on element with selector: " + selector.toString());
        threadSleepMiliSec(miliSecondsWait);
        getElement(selector, waitFor).click();
    }

    public static void elementClick(By selector){
        elementClick(selector, defaultWait);
    }

    public static void elementLocate(By selector, int waitFor){
        report("Locating element with selector: " + selector.toString());
        threadSleepMiliSec(miliSecondsWait);
        getElement(selector, waitFor);
    }

    public static void elementLocate(By selector){
        elementLocate(selector, defaultWait);
    }

    public static void sendKeys(By selector, String keys){
        report("Sending keys: " + keys + " to element with selector: " + selector.toString());
        threadSleepMiliSec(miliSecondsWait);
        getElement(selector, defaultWait).sendKeys(keys);
    }

    public static Boolean elementPresent(By selector, int waitFor){
        report("Checking if element present with selector: " + selector.toString());
        threadSleepMiliSec(miliSecondsWait);
        List<WebElement> elements = getChromeDriver().findElements(selector);
        if(elements.size() == 0){
            return false;
        }
        return true;
    }

    public static void verifyText(By selector, String text){
        String elementTxt = getElement(selector).getText();
        assertion.get().assertEquals(elementTxt, text, "FOUND: " + elementTxt + " EXPECTED: " + text);
    }

    public static void verifyWDElementText(WebElement element, String text){
        String elementTxt = element.getText();
        assertion.get().assertEquals(elementTxt, text, "FOUND: " + elementTxt + " EXPECTED: " + text);
    }

    public static void containsText(By selector, String text){
        String elementTxt = getElement(selector).getText();
        if(!elementTxt.contains(text)){
            failTest("Expected text " + text + " does not contain " + elementTxt);
        }
    }

    public static void clearElement(By selector){
        threadSleepMiliSec(miliSecondsWait);
        getElement(selector).clear();
    }

    public static WebElement getElement(By selector, int waitFor){
        new WebDriverWait(getChromeDriver(), waitFor).until(ExpectedConditions.visibilityOfElementLocated(selector));
        return getChromeDriver().findElement(selector);
    }

    public static WebElement getElement(By selector){
        return getElement(selector, defaultWait);
    }

    public static void threadSleepSec(Integer time){
        time = time * 1000;
        try{
            Thread.sleep(time);
        }
        catch (Exception e){
            System.out.println("Sleeping for %d seconds" + time);
        }
    }

    public static void threadSleepMiliSec(Integer time){
        try{
            Thread.sleep(time);
        }
        catch (Exception e){
            System.out.println("Sleeping for %d miliseconds" + time);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void killDriver(){
        if(chromeDriver != null){
            chromeDriver.get().quit();
        }
    }

    public static void failTest(String message){
        throw new TestException(message);
    }
}
