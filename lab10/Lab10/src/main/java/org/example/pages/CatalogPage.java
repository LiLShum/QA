package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.plaf.TableHeaderUI;

public class CatalogPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"menu\"]/ul[2]")
    private WebElement menuElement;

    @FindBy(xpath = "//*[@id=\"menu\"]/ul[2]/li/ul/li[1]/ul/li[1]/a")
    private WebElement chocolateFilterCheckbox;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/span/b")
    private WebElement Value;
    @FindBy(xpath = "//*[@id=\"rdrf79-fil47-263\"]/label")
    private WebElement filterButton;
    @FindBy(xpath = "//*[@id=\"rdrf-form79\"]/div[2]/button[2]")
    private WebElement ConfirmFilter;
    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToCatalog() throws InterruptedException {
        Thread.sleep(15000);
        Actions actions = new Actions(driver);
        actions.moveToElement(menuElement).perform();
        chocolateFilterCheckbox.click();
    }

    public void applyChocolateFilter() throws InterruptedException {
        Thread.sleep(5000);
        String oldValue = Value.getText().trim().toLowerCase();
        filterButton.click();
        ConfirmFilter.click();
        Assert.assertNotEquals(oldValue, Value.getText().trim().toLowerCase());
    }

}
