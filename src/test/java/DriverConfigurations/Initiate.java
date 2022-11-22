package DriverConfigurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Initiate {
    public static ThreadLocal<WebDriver> chromeDriver = new ThreadLocal<>();
    public static ThreadLocal<SoftAssert> assertion = new ThreadLocal<>();
    public static final int defaultWait = 5;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");

        System.setProperty("webdriver.chrome.driver", "C:\\Coding\\FiveBakery\\src\\test\\java\\DriverConfigurations\\chromedriver.exe");
        chromeDriver.set(new ChromeDriver(options));
        chromeDriver.get().manage().window().maximize();
        chromeDriver.get().manage().timeouts().pageLoadTimeout(defaultWait, TimeUnit.SECONDS);
        chromeDriver.get().manage().timeouts().setScriptTimeout(defaultWait, TimeUnit.SECONDS);
        chromeDriver.get().manage().timeouts().implicitlyWait(defaultWait, TimeUnit.SECONDS);
        chromeDriver.get().navigate().to("https://bakeronline.be/be-en/demo-shop");
        assertion.set(new SoftAssert());
    }

    public static WebDriver getChromeDriver(){
        return chromeDriver.get();
    }
}

