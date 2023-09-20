package app.autotests.women;

import app.autotests.BaseTest;
import com.softwaretestingboard.magento.app.helpers.Driver;
import com.softwaretestingboard.magento.app.pages.home.HomeLocators;
import com.softwaretestingboard.magento.app.pages.women.WomenLocators;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class TestWomenPage extends BaseTest {
    @BeforeEach
    @DisplayName("Open Women page")
    public void enterWomenPage() {
        app.homePage.clickButtonAbstractPage("women tab");
    }

    @Test
    @DisplayName("Test case 23 Checking if all tabs exists on Women page")
    @Description("Checking if all tabs exists on Women page")
    @Link(name = "test case 23", url = "https://jira.com/blablabla/blabla/testcase/23")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Women page")
    public void checkIfAllTabsExistsWomenPage() {

        app.womenPage.checkIfAllTabsExistsWomenPage(); // TODO: add existing tabs!



    }
}
