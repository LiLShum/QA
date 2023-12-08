package org.example.test;

import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.example.driver.DriverFactory;

public class MainTest {
    private WebDriver driver;
    private static final String BASE_URL = "https://candyshop.by";

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @Test
        public void testSearchItemOnTheSite() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);

        Thread.sleep(5000);
        searchPage.searchForItem("Перезаряжаемый вибратор Pretty Love Chris с клиторальной стимуляцией, бирюзовый");
        Thread.sleep(2000); // Подождите, чтобы результаты поиска успели обновиться
        searchPage.assertSearchResultContains("Показать все результаты");
    }

    @Test(priority = -999)
    public void testAddToCart() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        CartPage cartPage = new CartPage(driver);
        mainPage.navigateToMenuItem();
        Thread.sleep(5000);
        mainPage.selectProduct();
        Thread.sleep(5000); // Подождите, чтобы корзина успела обновиться
        mainPage.addToCart(); // Добавить в корзину
        Thread.sleep(2000); // Подождите, чтобы корзина успела обновиться
        cartPage.assertCartNotEmpty();
    }

    @Test
    public void testLeaveComment() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        Thread.sleep(5000);
        mainPage.leaveComment("Билли", "hochuvpopu@gmail.com", "horocho");
        mainPage.assertSearchResultContains("horocho");

    }

    @Test
    public void testComparePrice() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        CartPage cartPage = new CartPage(driver);

        mainPage.navigateToMenuItem();
        mainPage.selectProduct();
        Thread.sleep(5000);
        mainPage.addToCart();
        Thread.sleep(2000);
        cartPage.assertPrice();
    }

    @Test
    public void testRemoveItemFromCart() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.removeItem();
        shoppingCartPage.assertCartIsEmpty();
    }

    @Test(priority = -998)
    public void testApplyFilterInCatalog() throws InterruptedException {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.goToCatalog();
        catalogPage.applyChocolateFilter();
    }

    @Test
    public void TestChat() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.AskQuestion();
    }

    @Test()
    public void TestEmailer() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.GetMailer();
        Thread.sleep(4000);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
