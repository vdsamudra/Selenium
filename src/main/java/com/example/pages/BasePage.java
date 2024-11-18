package com.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void waitVisibility(By elementLocator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public void writeText(By elementLocator, String text){
        waitVisibility(elementLocator);
        driver.findElement(elementLocator).sendKeys(text);
    }

    public String readText(By elementLocator){
        waitVisibility(elementLocator);
        return driver.findElement(elementLocator).getText();
    }

    public void clickElement(By elementLocator){
        waitVisibility(elementLocator);
        driver.findElement(elementLocator).click();
    }

    public String readAttribute(By elementLocator, String attribute){
        waitVisibility(elementLocator);
        return driver.findElement(elementLocator).getAttribute(attribute);
    }

    public void sortElement(By elementLocator, int index){
        waitVisibility(elementLocator);
        Select selectSort = new Select(driver.findElement(elementLocator));
        selectSort.selectByIndex(index);
    }

    public void elementIsDisplay(By elementLocator){
        waitVisibility(elementLocator);
        driver.findElement(elementLocator).isDisplayed();
    }

   
    
    
}
