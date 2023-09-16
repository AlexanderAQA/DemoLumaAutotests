package com.softwaretestingboard.magento.app.pages.home;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import com.softwaretestingboard.magento.app.pages.abstractpage.AbstractPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;

public class HomePage extends AbstractPage {

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


    public void checkifUserNotAuthorized() {
        HomeLocators.NOTIFICATION_USER_NOT_AUTHORIZED.getElement().shouldBe(exist);
    }
}
