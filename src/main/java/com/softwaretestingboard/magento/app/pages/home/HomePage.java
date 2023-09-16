package com.softwaretestingboard.magento.app.pages.home;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import com.softwaretestingboard.magento.app.pages.abstractpage.AbstractPage;
import io.qameta.allure.Step;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;

public class HomePage extends AbstractPage {

    private static final Map<String, Role> map = new HashMap<>();

    private static final Map<String, SelenideElement> eventFieldKeys = new HashMap<>();

    static {
        eventFieldKeys.put("email", HomeLocators.getElement().FIELD_EMAIL);
        eventFieldKeys.put("password", FIELD_PASSWORD);
    }

    @Step("Button click")
    public void clickButtonHomePage(HomeLocators locator) {locator.getElement().click();}

    @Step("Check if user authorized")
    public void checkIfUserAuthorized(String username) {
        HomeLocators.STRING_WELCOME.getElement().shouldHave(text(username));
    }


    public String generateRandomName() {
        // Use a library Faker to generate a random firstname/lastname
        Faker faker = new Faker();
        return faker.regexify("[A-Z]{1}[a-z]{10}");
    }

    public String generateRandomEmail() {
        // Use a library Faker to generate a random email adress
        Faker faker = new Faker();
        return faker.regexify("[a-z]{6}[@]{1}[a-z]{10}[.]{1}[c-m]{3}");
    }

    public static void checkIfUserRegistrated() {
        HomeLocators.NOTIFICATION_THANKS_FOR_REGISTRATION.getElement().shouldBe(exist);
    }

    public static void checkIfUserNotRegistrated() {
        HomeLocators.NOTIFICATION_THANKS_FOR_REGISTRATION.getElement().shouldNotBe(exist);
    }




    public void checkIfUserNotAuthorized() {
        HomeLocators.NOTIFICATION_USER_NOT_AUTHORIZED.getElement().shouldBe(exist);
    }

    @Step("Filling fields {fieldName}")
    public void setFieldHomePage() {

        SelenideElement element = eventFieldKeys.get(fieldName.toLowerCase());
        setValueClearField(element, text);

    }

    public void fillRegistrationForm(String firstName, String lastName, String email, String password, String confirmPassword) {
        setFieldAbstractPage(HomeLocators.FIELD_FIRSTNAME, firstName);
        setFieldAbstractPage(String.valueOf(HomeLocators.FIELD_LASTNAME), lastName);
        setFieldAbstractPage(String.valueOf(HomeLocators.FIELD_EMAIL_ADRESS), email);
        setFieldAbstractPage(String.valueOf(HomeLocators.FIELD_PASSWORD), password);
        setFieldAbstractPage(String.valueOf(HomeLocators.FIELD_PASSWORD_CONFIRM), confirmPassword);
    }
}
