package com.softwaretestingboard.magento.app;



import com.softwaretestingboard.magento.app.pages.home.HomePage;
import com.softwaretestingboard.magento.app.pages.whatsnew.WhatsnewPage;

public class PageBuilder {

    public static HomePage buildHomePage() {    return new HomePage();  }
    public static WhatsnewPage buildWhatsnewPage() { return new WhatsnewPage(); }



}
