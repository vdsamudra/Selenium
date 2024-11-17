package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishPage extends BasePage{
    public FinishPage(WebDriver driver){
        super(driver);
    }

    // Elemen locators
    By tittlePage = By.className("subheader");
    By thanksText = By.className("complete-header");
    By ponyExpress = By.className("pony_express");

    public String getTittlePage(){
        return readText(tittlePage);
    }

    public String getThanksText(){
        return readText(thanksText);
    }

    public String getImagePonyExpress(){
        return readAttribute(ponyExpress,"src" );
    }
}
