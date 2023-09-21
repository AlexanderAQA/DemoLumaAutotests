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
        WomenLocators.CATEGORY_HOODIES_SWEATSHIRTS.getElement().shouldBe(exist);
        WomenLocators.CATEGORY_JACKETS.getElement().shouldBe(exist);
        WomenLocators.CATEGORY_TEES.getElement().shouldBe(exist);
        WomenLocators.CATEGORY_BRAS_AND_TANKS.getElement().shouldBe(exist);
        WomenLocators.TITLE_BOTTOMS.getElement().shouldBe(exist);
        WomenLocators.CATEGORY_PANTS.getElement().shouldBe(exist);
        WomenLocators.CATEGORY_SHORTS.getElement().shouldBe(exist);

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
