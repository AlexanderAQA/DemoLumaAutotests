package com.softwaretestingboard.magento.app.pages.women;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public enum WomenLocators {

    TITLE_SHOP_BY($(Selectors.byText("Shop By"))),
    TITLE_TOPS($(Selectors.byXpath("//*/main[1]//strong[1]/span"))),
    TITLE_BOTTOMS($(Selectors.byXpath("//*/strong[2]/span"))),
    CATEGORY_HOODIES_SWEATSHIRTS($(Selectors.byXpath("//a[contains(text(),'Hoodies & Sweatshirts')]"))),
    CATEGORY_JACKETS($(Selectors.byXpath("//a[contains(text(),'Jackets')]"))),
    CATEGORY_TEES($(Selectors.byXpath("//a[contains(text(),'Tees')]"))),
    CATEGORY_PANTS($(Selectors.byXpath("//a[contains(text(),'Pants')]"))),
    CATEGORY_SHORTS($(Selectors.byXpath("//a[contains(text(),'Shorts')]"))),
    CATEGORY_BRAS_AND_TANKS($(Selectors.byXpath("//a[contains(text(),'Bras & Tanks')]"))),
    CATEGORY_TOPS($(Selectors.byXpath("//a[contains(text(),'Tops')]"))),
    CATEGORY_BOTTOMS($(Selectors.byXpath("//a[contains(text(),'Bottoms')]"))),
    TITLE_CATEGORY($(Selectors.byText("Category")));

    private final SelenideElement element;
    WomenLocators(SelenideElement element) {this.element = element;}

    /**     Method for getting locators */
    public SelenideElement getElement() {return element;}
}
