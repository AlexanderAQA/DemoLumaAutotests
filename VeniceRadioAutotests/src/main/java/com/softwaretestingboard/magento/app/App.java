package com.softwaretestingboard.magento.app;


import com.softwaretestingboard.magento.app.pages.home.HomePage;

public class App {

    public HomePage homePage;


    public App() {

        homePage = PageBuilder.buildHomePage();

    }
}
