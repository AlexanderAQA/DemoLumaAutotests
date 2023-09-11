package app.autotests.home;

import app.autotests.BaseTest;
import com.softwaretestingboard.magento.app.helpers.Driver;
import com.softwaretestingboard.magento.app.pages.home.HomeLocators;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;
import org.junit.jupiter.params.ParameterizedTest;

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
    @DisplayName("Test case 18 Checking sign in (positive)")
    @Description("Checking sign in (positive)")
    @Link(name = "test case 18", url = "https://jira.com/blablabla/blabla/testcase/18")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Sign in")
    public void signIn() {

        // click sign in button
        app.homePage.clickButtonAbstractPage("sign in");
        // authorization with "mrTester" role from users.csv
        authorizationWithCurrentUser("mrTester");
        // checking if name "mrTester" exists in the Welcome string
        app.homePage.checkIfUserAuthorized("mrTester");

    }

    @Test
    @DisplayName("Test case 19 Checking sign up (positive)")
    @Description("Checking sign up (positive)")
    @Link(name = "test case 19", url = "https://jira.com/blablabla/blabla/testcase/19")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Sign up")
    public void signUp() {
        // Generate a random firstname
        String firstname = app.homePage.generateRandomName();
        String lastname = app.homePage.generateRandomName();
        String email = app.homePage.generateRandomEmail();

        // Click create an account
        app.homePage.clickButtonAbstractPage("sign up");

        // Fill required fields with the generated data
        HomeLocators.FIELD_FIRSTNAME.getElement().setValue(firstname);
        HomeLocators.FIELD_LASTNAME.getElement().setValue(lastname);
        HomeLocators.FIELD_EMAIL_ADRESS.getElement().setValue(email);

        // Fill password fields
        HomeLocators.FIELD_PASSWORD.getElement().setValue("Qqwe123Snd123");
        HomeLocators.FIELD_PASSWORD_CONFIRM.getElement().setValue("Qqwe123Snd123");

        // Click create account
        HomeLocators.BUTTON_CREATE_AN_ACCOUNT.getElement().click();
        Driver.wait(2000);

        // Checking if user registered successfully and authorized
        app.homePage.checkIfUserAuthorized(firstname);
        app.homePage.checkIfUserRegistrated();
    }







}
