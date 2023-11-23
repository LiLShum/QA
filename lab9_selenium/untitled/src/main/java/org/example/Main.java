package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {
    private WebDriver driver;
    private static final String BASE_URL = "https://candyshop.by"; // Замените на реальный URL вашего сайта

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @Test
    public void testAddToCart() {

        WebElement menuElement = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul[2]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(menuElement).perform();

        WebElement currentMenuItem = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul[2]/li/ul/li[1]/ul/li[1]/a"));
        currentMenuItem.click();

        WebElement product = driver.findElement(By.xpath("//*[@id=\"page\"]/div[4]/div/div[2]/div[3]/div/div[1]/div/div/button"));
        product.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"page\"]/div[4]/div/div[2]/span/div/div[3]/div/div[2]/a"));
        addToCartButton.click();

        WebElement cartNotEmpty = driver.findElement(By.xpath("//*[@id=\"simplecheckout_cart\"]/div[1]"));
        Assert.assertEquals(cartNotEmpty.isDisplayed(), true);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
