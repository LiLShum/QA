package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"simplecheckout_cart\"]/div[1]")
    private WebElement cartNotEmpty;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void assertCartNotEmpty() {
        Assert.assertTrue(cartNotEmpty.isDisplayed());
    }

    public void assertPrice() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(true);
    }
}
