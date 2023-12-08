package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"search\"]/span/input")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"search\"]/span/div/div")
    private WebElement resultOfSearch;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForItem(String itemName) {
        searchInput.sendKeys(itemName);
    }

    public void assertSearchResultContains(String expectedText) {
        Assert.assertTrue(resultOfSearch.getText().contains(expectedText));
    }
}
