package com.softwaretestingboard.magento.app.pages.abstractpage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.softwaretestingboard.magento.app.pages.abstractpage.AbstractLocators.FIELD_EMAIL;
import static com.softwaretestingboard.magento.app.pages.abstractpage.AbstractLocators.FIELD_PASSWORD;

public class AbstractPage {



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


    @Step("Authorization with current user")
    public void authororzationWithCurrentUser(String user) {

        User currentUserSetting = new User();
        readCSV();
        if (map.containsKey(user.toLowerCase())) {
            currentUserSetting = map.get(user.toLowerCase());
            setFieldAbstractPage(FIELD_EMAIL, currentUserSetting.LOGIN);
            setFieldAbstractPage(FIELD_PASSWORD, currentUserSetting.PASSWORD);
        }
        AbstractLocators.BUTTON_SIGNIN.getElement().click();

    }

    public static void User {
        private final String LOGIN;
        private final String PASSWORD;

        User(String login, String password) {
            LOGIN = login;
            PASSWORD = password;
        }

        User() {
            LOGIN = "";
            PASSWORD = "";
        }
    }

    public void readCSV() {
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferReader(new FileReader(CONF_FILE))) {
            while ((line = br.readLine()) != null) {
                String[] csv = line.split(csvSplitBy);
                map.put(csv[0].toLowerCase(), new User(csv[1], csv[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
