package com.softwaretestingboard.magento.app.pages.home;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public enum HomeLocators {

    FIELD_SEARCH($(Selectors.byId("search"))),
    FIELD_FIRSTNAME($(Selectors.byId("firstname"))),
    FIELD_LASTNAME($(Selectors.byId("lastname"))),
    FIELD_EMAIL_ADRESS($(Selectors.byId("email_address"))),
    FIELD_PASSWORD($(Selectors.byId("password"))),
    FIELD_PASSWORD_CONFIRM($(Selectors.byId("password-confirmation"))),

    BUTTON_CREATE_AN_ACCOUNT($(Selectors.byTitle("Create an Account"))),
    NOTIFICATION_THANKS_FOR_REGISTRATION($(Selectors.byText("Thank you for registering with Main Website Store."))),
    STRING_WELCOME($(Selectors.byClassName("logged-in"))),
    NOTIFICATION_USER_NOT_AUTHORIZED($(Selectors.byText("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.")));

    private final SelenideElement element;
    HomeLocators(SelenideElement element) {this.element = element;}

    /**     Method for getting locators */
    public SelenideElement getElement() {return element;}

}
