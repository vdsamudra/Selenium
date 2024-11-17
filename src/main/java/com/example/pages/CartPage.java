package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    // Constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Element locators
    By cartItemName = By.className("inventory_item_name");
    By cartItemDescription = By.className("inventory_item_desc");
    By cartItemPrice = By.className("inventory_item_price");
    By removeButton = By.xpath("//button[text()='REMOVE']");
    By continueShoppingButton = By.xpath("//a[text()='Continue Shopping']"); 
    By checkoutButton = By.className("checkout_button");

    public String getCartItemName(){
        return readText(cartItemName);
    }

    public String getCartItemDescription(){
        return readText(cartItemDescription);
    }

    public String getCartItemPrice(){
        return readText(cartItemPrice);
    }

    public void clickRemoveButton(){
        clickElement(removeButton);
    }

    public void clickContinueShoppingButton(){
        clickElement(continueShoppingButton);
    }

    public void clickCheckoutButton(){
        clickElement(checkoutButton);
    }

}
