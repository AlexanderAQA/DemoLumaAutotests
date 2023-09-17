package app.autotests.home;

import app.autotests.BaseTest;
import com.softwaretestingboard.magento.app.helpers.Driver;
import com.softwaretestingboard.magento.app.pages.home.HomeLocators;
import com.softwaretestingboard.magento.app.pages.home.HomePage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selenide.$;
import static com.softwaretestingboard.magento.app.helpers.Driver.refresh;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @DisplayName("Test case 20 checking sign in (negative)")
    @Description("Checking sign in (negative)")
    @Link(name = "test case 20", url = "https://jira.com/blablabla/blabla/testcase/20")
    @Severity(SeverityLevel.NORMAL)
    @Story("Sign in")
    public void signInNegative() {

        // click sign in button
        app.homePage.clickButtonAbstractPage("sign in");
        // authorization with "fakeUser" (which is never exist) role from users.csv
        authorizationWithCurrentUser("fakeUser");
        // checking if name "mrTester" exists in the Welcome string
        app.homePage.checkIfUserNotAuthorized();

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/parameterized/signInNegative.csv")
    @DisplayName("Test case 22 checking sign in (negative)")
    @Description("Checking sign in (negative)")
    @Link(name = "test case 22", url = "https://jira.com/blablabla/blabla/testcase/22")
    @Severity(SeverityLevel.NORMAL)
    @Story("Sign in")
    public void signInEmptyNegative(String login, String password) {

        // click sign in button
        app.homePage.clickButtonAbstractPage("sign in");

        // authorization with empty login/password
        app.homePage.setFieldAbstractPage("email", login);
        app.homePage.setFieldAbstractPage("password", password);

        // click enter
        app.homePage.clickButtonAbstractPage("enter");

        // checking if error message about empty field exists
        HomePage.checkIfRequiredFieldErrorExists();
        HomePage.checkIfUserUnsuccessfullyAuthorized();



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
        HomePage.checkIfUserRegistrated();
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/parameterized/signUpNegative.csv")
    @DisplayName("Test case 21 Checking sign up (negative)")
    @Description("Checking sign up (negative)")
    @Link(name = "test case 21", url = "https://jira.com/blablabla/blabla/testcase/21")
    @Severity(SeverityLevel.NORMAL)
    @Story("Sign up")
    public void signUpNegative(String firstName, String lastName, String email, String password, String confirmPassword) {

        // Click create an account
        app.homePage.clickButtonAbstractPage("sign up");

        // Fill in the sign-up form
        HomeLocators.FIELD_FIRSTNAME.getElement().setValue(firstName);
        HomeLocators.FIELD_LASTNAME.getElement().setValue(lastName);
        HomeLocators.FIELD_EMAIL_ADRESS.getElement().setValue(email);
        HomeLocators.FIELD_PASSWORD.getElement().setValue(password);
        HomeLocators.FIELD_PASSWORD_CONFIRM.getElement().setValue(confirmPassword);

        // Click Create an account
        app.homePage.clickButtonHomePage(HomeLocators.BUTTON_CREATE_AN_ACCOUNT);

        // Check if registration error message "This is a required field" exists
        HomePage.checkIfRequiredFieldErrorExists();
        // Check if user not registrated
        HomePage.checkIfUserNotRegistrated();

    }






}
