package com.softwaretestingboard.magento.app;


import com.softwaretestingboard.magento.app.pages.home.HomePage;
import com.softwaretestingboard.magento.app.pages.whatsnew.WhatsnewPage;

public class App {

    public HomePage homePage;
    public WhatsnewPage whatsnewPage;


    public App() {

        homePage = PageBuilder.buildHomePage();
        whatsnewPage = PageBuilder.buildWhatsnewPage();

    }
}
