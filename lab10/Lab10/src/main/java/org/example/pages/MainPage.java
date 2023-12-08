package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {
    private WebDriver driver;
    private boolean resultOfChat = true;

    @FindBy(xpath = "//*[@id=\"menu\"]/ul[2]")
    private WebElement menuElement;

    @FindBy(xpath = "//*[@id=\"subscribe_form\"]/input")
    private WebElement EmailerInput;

    @FindBy(xpath = "//*[@id=\"subscribe_form\"]/button")
    private WebElement EmailerButton;
    @FindBy(xpath = "//*[@id=\"supportTrigger\"]/div[1]/div[2]")
    private WebElement HelpChat;
    @FindBy(xpath = "//*[@id=\"menu\"]/ul[2]/li/ul/li[1]/ul/li[1]/a")
    private WebElement currentMenuItem;

    @FindBy(xpath = "//*[@id=\"page\"]/div[4]/div/div[2]/div[3]/div/div[1]/div/div/button")
    private WebElement product;

    @FindBy(xpath = "//*[@id=\"page\"]/div[4]/div/div[2]/span/div/div[3]/div/div[2]/a")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"top\"]/ul/li[3]/div/button")
    private WebElement ServiceAndInfoMenu;

    @FindBy(xpath = "//*[@id=\"top\"]/ul/li[3]/div/ul/li[5]/a")
    private WebElement CommmentsButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[3]/button")
    private WebElement AddCommentButton;
    @FindBy(xpath = "//*[@id=\"input-name\"]")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"input-email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"input-comment\"]")
    private WebElement commentInput;

    @FindBy(xpath = "//*[@id=\"mm-0\"]/div[6]/div/form/button[2]")
    private WebElement submitCommentButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]")
    private WebElement commentsList;
    @FindBy(xpath = "//*[@id=\"widget-inner-dOwqxaFcEm\"]/div/span/div/div[2]/div/div[2]/div/div/textarea[1]")
    private WebElement ChatInput;
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToMenuItem() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(menuElement).perform();
        Thread.sleep(2000);
        currentMenuItem.click();
    }

    public void selectProduct() {
        product.click();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void leaveComment(String name, String email, String comment) throws InterruptedException {
        // Предполагается, что кнопка "Оставить комментарий" представлена элементом product
        ServiceAndInfoMenu.click();
        CommmentsButton.click();
        AddCommentButton.click();
        Thread.sleep(1000);
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        commentInput.sendKeys(comment);
        submitCommentButton.click();
    }

    public boolean searchComment(String comment) {
        boolean result = false;
        java.util.List<WebElement> innerDivs = commentsList.findElements(By.tagName("div"));
        for (WebElement innerDiv : innerDivs) {
            WebElement nestedDiv = innerDiv.findElement(By.tagName("div"));
            if(nestedDiv.getText().trim().equalsIgnoreCase(comment.trim()))
                result = true;
        }
        return result;
    }
    public void assertSearchResultContains(String expectedText) {
        Assert.assertTrue(searchComment(expectedText));
    }

    public void AskQuestion() throws InterruptedException {
        Thread.sleep(5000);
        HelpChat.click();
        Assert.assertTrue(resultOfChat);
    }

    public void GetMailer() {
        EmailerInput.sendKeys("hochuvpopu@gmail.com");
        EmailerButton.click();
        Assert.assertTrue(resultOfChat);
    }
}
