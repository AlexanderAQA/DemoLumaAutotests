package com.softwaretestingboard.magento.app.pages.women;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public enum WomenLocators {

    TITLE_SHOP_BY($(Selectors.byText("Shop By"))),
    TITLE_TOPS($(Selectors.byXpath("//*/main[1]//strong[1]/span"))),
    CATEGORY_TOPS($(Selectors.byXpath("//a[contains(text(),'Tops')]"))),
    CATEGORY_BOTTOMS($(Selectors.byXpath("//a[contains(text(),'Bottoms')]"))),
    TITLE_CATEGORY($(Selectors.byText("Category")));

    private final SelenideElement element;
    WomenLocators(SelenideElement element) {this.element = element;}

    /**     Method for getting locators */
    public SelenideElement getElement() {return element;}
}
