package com.softwaretestingboard.magento.app;


import com.softwaretestingboard.magento.app.pages.home.HomePage;
import com.softwaretestingboard.magento.app.pages.women.WomenPage;

public class App {

    public HomePage homePage;
    public WomenPage womenPage;


    public App() {

        homePage = PageBuilder.buildHomePage();
        womenPage = PageBuilder.buildWhatsnewPage();

    }
}
