package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Element locators
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");

    // Constructor
    //public LoginPage(WebDriver driver) {
        //this.driver = driver;
    //}

    // Methods to interact with elements
    public void entryUsername(String username) {
        writeText(usernameField, username);
    }

    public void entryPassword(String password) {
        writeText(passwordField, password);
    }

    public void clickLogin() {
        clickElement(loginButton);
    }

    public boolean usernameFieldIsDisplayed(){
        elementIsDisplay(usernameField);
                return true;
    }

    public boolean passwordFieldDisplayed(){
        elementIsDisplay(passwordField);
                return true;
    }

    public boolean loginButtonIsDisplayed(){
        elementIsDisplay(loginButton);
                return true;
    }
}
