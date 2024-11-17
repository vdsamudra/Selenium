package com.example.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.pages.CartPage;
import com.example.pages.CheckoutStepOnePage;
import com.example.pages.CheckoutStepTwoPage;
import com.example.pages.FinishPage;
import com.example.pages.LoginPage;
import com.example.pages.ProductPage;



public class OrderTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutStepOnePage checkoutStepOnePage;
    CheckoutStepTwoPage checkoutStepTwoPage;
    FinishPage finishPage;
    

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vdsam\\OneDrive\\Desktop\\my-app\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        finishPage = new FinishPage(driver);
    }

    @Test
    public void straightFlow(){
        // buka halaman login
        driver.get("https://www.saucedemo.com/v1/index.html");

        // melakukan login
        loginPage.entryUsername("standard_user");
        loginPage.entryPassword("secret_sauce");
        loginPage.clickLogin();

        // Verifikasi login berhasil (misalnya, dengan mengecek URL atau elemen yang muncul setelah login)
        String expectedUrl = "https://www.saucedemo.com/v1/inventory.html";
        String expectedTittleProductPage = "Products";
        assertEquals(expectedUrl, driver.getCurrentUrl());
        assertEquals(expectedTittleProductPage, productPage.readTittle());

        // lakukan dan cek sort
        productPage.sortZToA();
        assertEquals(productPage.actualSortNames(), productPage.expectedSortZtoA());
        productPage.sortHighToLowPrice();
        assertEquals(productPage.actualSortPrice(), productPage.expectedSortLowtoHigh());
        productPage.sortLowToHighPrice();
        assertEquals(productPage.actualSortPrice(), productPage.expectedSortHightoLow());

        // melakukan pemilihan item random
        productPage.addItemRandomToCart();

        // menyimpan nama, deskrpsi dan harga  atas item yang dipilih
        String chooseItemName = productPage.getSelectedProductName();
        String chooseItemDescription = productPage.getSelectedProductDescription();
        String chooseItemPrice= productPage.getSelectedProductPrice();

        // klik cart
        productPage.clickCartIcon();

        // Validasi bahwa nama dan harga di keranjang sama dengan yang di produk acak
        assertEquals(chooseItemName,cartPage.getCartItemName());
        assertEquals(chooseItemDescription, cartPage.getCartItemDescription());
        assertEquals(chooseItemPrice,cartPage.getCartItemPrice());

        // klik cehck out
        cartPage.clickCheckoutButton();

        // validasi kalau sudah masuk ke checkout step one page
        String expectedTittlePageStepOne = "Checkout: Your Information";
        assertEquals(expectedTittlePageStepOne, checkoutStepOnePage.getTittlePage());

        // checkout step one, isi data diri
        checkoutStepOnePage.entryFirstname("nama pertama");
        checkoutStepOnePage.entryLastname("nama belakang");
        checkoutStepOnePage.entryPostalCode("kode pos");

        // klik continue
        checkoutStepOnePage.clickContinueButton();

        // validasi sudah masuk ke checkout step two page
        String expectedTittlePageStepTwo = "Checkout: Overview";
        assertEquals(expectedTittlePageStepTwo, checkoutStepTwoPage.getTittlePage());

        // validasi iteM, yamg akan checkout sesuai dengan item yang dipilih
        assertEquals(cartPage.getCartItemName(), checkoutStepTwoPage.getItemName());
        assertEquals(cartPage.getCartItemDescription(), checkoutStepTwoPage.getItemDescription());
        assertEquals(cartPage.getCartItemPrice(), checkoutStepTwoPage.getItemPrice());

        // checkout step two, klik finish checkout
        checkoutStepTwoPage.clickFinsihButton();

        // validasi sudah masuk ke finish page
        String expectedTittlePageFinish = "Finish";
        String expectedThankText = "THANK YOU FOR YOUR ORDER";
        String expectedImagePonyExpresAtr = "https://www.saucedemo.com/v1/img/pony-express.png";

        assertEquals(expectedTittlePageFinish, finishPage.getTittlePage());
        assertEquals(expectedThankText, finishPage.getThanksText());
        assertEquals(expectedImagePonyExpresAtr, finishPage.getImagePonyExpress());

    }

    @After
    public void tearDown(){
        // Tutup browser setalah test selesai
        if (driver != null) {
            driver.quit();
        }
    }
    
}
