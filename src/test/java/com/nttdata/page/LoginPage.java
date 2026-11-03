package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {
    //Localizadores de elementos
    public static By btnIngresoLogin = By.id("_desktop_user_info");
    public static By userInput = By.xpath("//input[@id='field-email']");
    public static By passInput = By.xpath("//input[@id='field-password']");
    public static By loginButton = By.id("submit-login");
}
