package com.softwaretestingboard.magento.app.pages.abstractpage;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class AbstractPage {

    public static final Faker engFaker = new Faker();

    private static final SelenideElement TAB_WHATSNEW = $(byId("ui-id-3"));
    private static final SelenideElement TAB_WOMEN = $(byId("ui-id-4"));
    private static final SelenideElement TAB_MEN = $(byId("ui-id-5"));
    private static final SelenideElement TAB_GEAR = $(byId("ui-id-6"));
    private static final SelenideElement TAB_TRAINING = $(byId("ui-id-7"));
    private static final SelenideElement FIELD_EMAIL = $(byId("email"));
    private static final SelenideElement FIELD_PASSWORD = $(byId("pass"));
    private static final SelenideElement TAB_SALE = $(byId("ui-id-8"));
    private static final SelenideElement SIGNIN = $(byId("send2"));
    private static final SelenideElement BUTTON_SIGN_IN = $(byXpath("//*[contains(@class,'authorization-link')]"));
    private static final SelenideElement BUTTON_CREATE_AN_ACCOUNT = $(byXpath("//*[contains(@class,'authorization-link')]/following-sibling::li"));

    // path to csv file with login/password for different users
    private static final String CONF_FILE = System.getProperty("user.dir") + "/src/test/resources/users" + File.separator + "users.csv";
    private static final Map<String, Role> map = new HashMap<>();
    private static final Map<String, SelenideElement> eventFieldKeys = new HashMap<>();

    static {
        eventFieldKeys.put("email", FIELD_EMAIL);
        eventFieldKeys.put("password", FIELD_PASSWORD);
    }

    @Step("Clearing the fields and input value")
    public static void setValueClearField(SelenideElement element, String value) {
        String elementForClear = element.getAttribute("value");
        if (elementForClear != null) {
            for (int i = 0; i < elementForClear.length(); i++) {
                element.sendKeys(Keys.BACK_SPACE);
            }
        }
        element.setValue(value);
    }

    private static final Map<String, SelenideElement> eventClickKeys = new HashMap<>();
    static {
        eventClickKeys.put("email", FIELD_EMAIL);
        eventClickKeys.put("password", FIELD_PASSWORD);
        eventClickKeys.put("enter", SIGNIN);
        eventClickKeys.put("sign in", BUTTON_SIGN_IN);
        eventClickKeys.put("sign up", BUTTON_CREATE_AN_ACCOUNT);
        eventClickKeys.put("women tab", TAB_WOMEN);
    }

    @Step("Filling fields {fieldName}")
    public void setFieldAbstractPage(String fieldName, String text) {
        SelenideElement element = eventFieldKeys.get(fieldName.toLowerCase());
        setValueClearField(element, text);
    }

    @Step("Press space button")
    public void pressSpace() {
        try {
            new Actions(getWebDriver()).sendKeys(Keys.SPACE).build().perform();
        } catch (Exception e) {
            throw new Error("Error while plessing SPACE", e);
        }
    }


    @Step("Authorization with current user role")
    public void authorizationWithCurrentUser(String role) {

        Role currentRoleSetting = new Role();
        readCSV();
        if (map.containsKey(role.toLowerCase())) {
            currentRoleSetting = map.get(role.toLowerCase());
            setFieldAbstractPage("email", currentRoleSetting.LOGIN);
            setFieldAbstractPage("password", currentRoleSetting.PASSWORD);
        }
        clickButtonAbstractPage("enter");

    }

    public void clickButtonAbstractPage(String btnName) {
        SelenideElement element = eventClickKeys.get(btnName.toLowerCase());
        element.click();
    }

    public static class Role {
        private final String LOGIN;
        private final String PASSWORD;

        public Role(String login, String password) {
            LOGIN = login;
            PASSWORD = password;
        }

        public Role() {
            LOGIN = "";
            PASSWORD = "";
        }
    }

    @Step("Checking if all tabs exists from homepage")
    public void checkIfAllTabsExists() {
        TAB_WHATSNEW.shouldBe(exist);
        TAB_WOMEN.shouldBe(exist);
        TAB_MEN.shouldBe(exist);
        TAB_GEAR.shouldBe(exist);
        TAB_TRAINING.shouldBe(exist);
        TAB_SALE.shouldBe(exist);
        BUTTON_SIGN_IN.shouldBe(exist);
        BUTTON_CREATE_AN_ACCOUNT.shouldBe(exist);
    }


    public void readCSV() {
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(CONF_FILE))) {

            while ((line = br.readLine()) != null) {
                String[] csv = line.split(csvSplitBy);
                map.put(csv[0].toLowerCase(), new Role(csv[1], csv[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
