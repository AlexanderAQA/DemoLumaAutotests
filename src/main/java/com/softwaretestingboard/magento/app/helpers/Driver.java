package com.softwaretestingboard.magento.app.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
public class Driver {
    public static void initDriver() {

        TestConfig.initCofig();

        Configuration.pageLoadStrategy = "normal";
        Configuration.browserSize = "1920x1200";
        Configuration.holdBrowserOpen = false;
        Configuration.screenshots = false;

        if(TestConfig.isHeadless()) {
            Configuration.headless = true;
        } else {
            Configuration.headless = false;
        }

         switch (TestConfig.browser) {

        default:
            System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/windows_117/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--ignore-certificate-errors", "--disable-dev-shm-usage", "start-maximized");
            WebDriver driver = new ChromeDriver(options);
            setWebDriver(driver);
            break;
        }
    }

    public static WebDriver currentDriver() {return WebDriverRunner.getWebDriver();}

    @Step("Open application page")
    public static void open(String url) { Selenide.open(url); }

    @Step("Page refresh")
    public static void refresh() { Selenide.refresh(); }

    public static void executeJs(String script) {
        JavascriptExecutor js = (JavascriptExecutor) currentDriver();
        try {
            js.executeScript(script);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        currentDriver().quit();
    }

    public static void wait(int mills){
        try {
            Thread.sleep(mills); //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenshot() {
        File scrFile = ((TakesScreenshot) currentDriver()).getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir")
                + File.separator + "test-output"
                + File.separator + "screenshots"
                + File.separator + " " + "screenshot_" + (new SimpleDateFormat("HHmmssSSS").format(new Date())) + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}