package app.autotests;

import com.softwaretestingboard.magento.app.App;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.softwaretestingboard.magento.app.helpers.Driver;
import com.softwaretestingboard.magento.app.pages.abstractpage.AbstractPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class BaseTest extends AbstractPage {

    private static final String HOST = "https://magento.softwaretestingboard.com/";

    protected App app;

    @BeforeEach
    @DisplayName("Opening web page")
    public void setUp() {
        // Settings for generating allure-report with screenshot and html-page
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        // Page initialization
        app = new App();
        // Driver initialization with custom settings
        Driver.initDriver();
        // HOST page opens
        Driver.open(HOST);
    }

    @AfterEach
    @DisplayName("Closing web page")
    public void close() {
        //Driver.currentDriver().quit();
        Driver.currentDriver().close();
    }
}
