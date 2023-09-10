package com.softwaretestingboard.magento.app.helpers;

public class TestConfig {

    public static String browser = "";
    public static String headless = "1";

    public static boolean isHeadless() { return headless.contains("0"); }

    public static void initCofig() {
        browser = System.getProperty("browser") == null ? browser : System.getProperty("browser");
        headless = System.getProperty("headless") == null ? "1" : System.getProperty("headless");
    }
}
