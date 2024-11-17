package com.example.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class ProductPage extends BasePage {
    // Constructor
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // Element locators
    By tittleProductPage = By.className("product_label");
    By burgerMenuButton = By.className("bm-burger-bars");
    By logoutButton = By.id("logout_sidebar_link");
    By cartIcon = By.id("shopping_cart_container");
    By sortButton = By.className("product_sort_container");
    By allItemNames = By.className("inventory_item_name");
    By allItemDescription = By.className("inventory_item_desc");
    By allPrices = By.className("inventory_item_price");
    By allAddToCartButtons = By.xpath("//button[text()='ADD TO CART']");


    
    public String readTittle(){
        return readText(tittleProductPage); 
    }

    public void openBurgerMenu(){
        clickElement(burgerMenuButton);
    }

    public void clickLogoutButton(){
        clickElement(logoutButton);
    }

    public void clickCartIcon(){
        clickElement(cartIcon);
    }

    public void sortAToZ(){
        sortElement(sortButton, 0);
    }

    public void sortZToA(){
        sortElement(sortButton, 1);
    }

    public void sortLowToHighPrice(){
        sortElement(sortButton, 2);
    }

    public void sortHighToLowPrice(){
        sortElement(sortButton, 3);
    }

    String selectedProductName;
    String selectedProductDescription;
    String selectedProductPrice;

    List<WebElement> names = driver.findElements(allItemNames);
    List<WebElement> descriptions = driver.findElements(allItemDescription);
    List<WebElement> prices = driver.findElements(allPrices);
    List<WebElement> buttons = driver.findElements(allAddToCartButtons);

    List<String> itemNames = new ArrayList<>();
    List<Double> itemPrices = new ArrayList<>();

    // fungsi untuk melakukan add to cart product random
    public void addItemRandomToCart(){
        List<WebElement> names = driver.findElements(allItemNames);
        List<WebElement> descriptions = driver.findElements(allItemDescription);
        List<WebElement> prices = driver.findElements(allPrices);
        List<WebElement> buttons = driver.findElements(allAddToCartButtons);

        Random random = new Random();
        int randomIndex = random.nextInt(names.size());
        WebElement randomAddToCartButton = buttons.get(randomIndex);

        // Menyimpan detail produk yang dipilih secara acak
        selectedProductName = names.get(randomIndex).getText();
        selectedProductDescription = descriptions.get(randomIndex).getText();
        selectedProductPrice = prices.get(randomIndex).getText().replace("$", "").trim();

        // melakukan add to cart product random yang terpilih
        randomAddToCartButton.click();
    }

    // Getter untuk nama produk yang dipilih
    public String getSelectedProductName() {
        waitVisibility(allAddToCartButtons);
                return selectedProductName;
    }

    // Getter untuk deskripsi produk yang dipilih
    public String getSelectedProductDescription() {
        waitVisibility(allAddToCartButtons);
                return selectedProductDescription;
    }

    // Getter untuk HARGA produk yang dipilih
    public String getSelectedProductPrice() {
        waitVisibility(allAddToCartButtons);
                 return selectedProductPrice;
    }

    public List<String> actualSortNames(){
        waitVisibility(allItemNames);
        for(WebElement name : names){
            String itemName = name.getText().trim();
            itemNames.add(itemName);
        }
                return itemNames;
        
    }

    public List<Double> actualSortPrice(){
        waitVisibility(allPrices);
        for(WebElement price : prices){
            String priceText = price.getText().replace("$", "").trim();
            Double itemPrice = Double.parseDouble(priceText);
            itemPrices.add(itemPrice);
        }
                return itemPrices;
    }

    public List<String> expectedSortAtoZ(){
        waitVisibility(allAddToCartButtons);
        List<String> itemNamesExpected = new ArrayList<>(itemNames);
        Collections.sort(itemNamesExpected);

                return itemNamesExpected;
    }

    public List<String> expectedSortZtoA(){
        waitVisibility(allAddToCartButtons);
        List<String> itemNamesExpected = new ArrayList<>(itemNames);
        Collections.sort(itemNamesExpected);
        Collections.reverse(itemNamesExpected);

                return itemNamesExpected;
    }

    public List<Double> expectedSortLowtoHigh(){
        waitVisibility(allAddToCartButtons);
        List<Double> itemPriceExpected = new ArrayList<>(itemPrices);
        Collections.sort(itemPriceExpected);

                return itemPriceExpected;
    }

    public List<Double> expectedSortHightoLow(){
        waitVisibility(allAddToCartButtons);
        List<Double> itemPriceExpected = new ArrayList<>(itemPrices);
        Collections.sort(itemPriceExpected);
        Collections.reverse(itemPriceExpected);

                return itemPriceExpected;
    }






    

    
    

}
