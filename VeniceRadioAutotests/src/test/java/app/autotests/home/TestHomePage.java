package app.autotests.home;

import app.autotests.BaseTest;
import com.softwaretestingboard.magento.app.helpers.Driver;
import com.softwaretestingboard.magento.app.pages.abstractpage.AbstractLocators;
import com.softwaretestingboard.magento.app.pages.abstractpage.AbstractPage;
import com.softwaretestingboard.magento.app.pages.home.HomeLocators;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.softwaretestingboard.magento.app.helpers.Driver.refresh;

@Epic("Component LUMA")
@Feature("Homepage")
@DisplayName("Homepage")
public class TestHomePage extends BaseTest {

    @BeforeEach
    @DisplayName("Refresh")
    public void refreshing() {
        refresh();
    }

    @Test
    @DisplayName("Test case 17 Checking if all tabs exists")
    @Description("Checking if all tabs exists")
    @Link(name = "test case 17", url = "https://jira.com/blablabla/blabla/testcase/17")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Tabs")
    public void checkIfAllTabsExistsHomePage() {

        // checking if all tabs exists from homepage
        app.homePage.checkIfAllTabsExists();

    }

    @Test
    @DisplayName("Test case 18 Checking sign in")
    @Description("Checking sign in")
    @Link(name = "test case 18", url = "https://jira.com/blablabla/blabla/testcase/18")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Tabs")
    public void signIn() {

        AbstractLocators.BUTTON_SIGN_IN.getElement().click();
        Driver.wait(5000);

    }


}
