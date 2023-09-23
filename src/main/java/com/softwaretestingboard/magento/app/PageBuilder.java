package com.softwaretestingboard.magento.app;



import com.softwaretestingboard.magento.app.pages.home.HomePage;
import com.softwaretestingboard.magento.app.pages.women.WomenPage;

public class PageBuilder {

    public static HomePage buildHomePage() {    return new HomePage();  }
    public static WomenPage buildWhatsnewPage() { return new WomenPage(); }



}
