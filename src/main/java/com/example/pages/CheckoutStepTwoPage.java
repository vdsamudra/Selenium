package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage {
    public CheckoutStepTwoPage(WebDriver driver){
        super(driver);
    }

    // Elemen locators
    By finsihButton = By.className("btn_action");
    By cancelButton = By.className("cart_cancel_link");
    By itemName = By.className("inventory_item_name");
    By itemDescription = By.className("inventory_item_desc");
    By itemPrice = By.className("inventory_item_price");
    By tittlePage = By.className("subheader");


    public void clickFinsihButton(){
        clickElement(finsihButton);
    }

    public void clickCancelButton(){
        clickElement(cancelButton);
    }

    public String getItemName(){
            return readText(itemName);
    }

    public String getItemDescription(){
            return readText(itemDescription);
    }

    public String getItemPrice(){
            return readText(itemPrice);
        
    }

    public String getTittlePage(){
        return readText(tittlePage);
    }
    
}
