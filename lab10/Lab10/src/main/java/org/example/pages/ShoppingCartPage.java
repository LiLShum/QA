package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShoppingCartPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"simplecheckout_cart\"]/div[1]/table/tbody/tr/td[4]/div/button")
    private WebElement removeButton;
    @FindBy(xpath = "//*[@id=\"cart\"]/button")
    private WebElement busketButton;

    @FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/span/span[2]/a")
    private WebElement SecondBusketButton;
    @FindBy(xpath = "//*[@id=\"simplecheckout_cart\"]/div[1]/table")
    private WebElement emptyCartMessage;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void removeItem() {
        busketButton.click();
        SecondBusketButton.click();
        removeButton.click();
    }

    public void assertCartIsEmpty() {
        Assert.assertTrue(emptyCartMessage.isDisplayed());
    }
}
