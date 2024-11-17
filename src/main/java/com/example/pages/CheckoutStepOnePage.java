package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage {
    public CheckoutStepOnePage(WebDriver driver){
        super(driver);
    }

    // Element locators
    By firstnameField = By.id("first-name");
    By lastnameField = By.id("last-name");
    By postalcodeField = By.id("postal-code");
    By continueButton = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input");
    By cancelButton = By.className("cart_cancel_link");
    By tittlePage = By.className("subheader");

    public void entryFirstname(String firstname){
        writeText(firstnameField, firstname);
    }

    public void entryLastname(String lastname){
        writeText(lastnameField, lastname);
    }

    public void entryPostalCode(String postalcode){
        writeText(postalcodeField, postalcode);
    }

    public void clickContinueButton(){
        clickElement(continueButton);
    }

    public void clickCancelButton(){
        clickElement(cancelButton);
    }

    public String getTittlePage(){
        return readText(tittlePage);
    }

    
}
