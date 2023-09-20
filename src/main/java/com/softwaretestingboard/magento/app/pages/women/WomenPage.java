package com.softwaretestingboard.magento.app.pages.women;


import com.softwaretestingboard.magento.app.pages.abstractpage.AbstractPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;

public class WomenPage extends AbstractPage {

    @Step("Checking if titles Shop By, Category exists")
    public void checkIfAllTabsExistsWomenPage() {

        WomenLocators.TITLE_SHOP_BY.getElement().shouldBe(exist);
        WomenLocators.TITLE_CATEGORY.getElement().shouldBe(exist);
        WomenLocators.CATEGORY_TOPS.getElement().shouldBe(exist);
        WomenLocators.CATEGORY_BOTTOMS.getElement().shouldBe(exist);
        WomenLocators.TITLE_TOPS.getElement().shouldBe(exist);

    }


    @Step("Check if women are strong")
    public void checkIfWomenStrong () {
        int a = 5;
        while (a >= 1) {
            System.out.println("Women are strong");
            a--;
        }

    }

}
