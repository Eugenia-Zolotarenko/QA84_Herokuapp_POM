package com.herokuapp.core;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    public static JavascriptExecutor js;
    public static SoftAssertions softly;
    public static Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js =(JavascriptExecutor) driver;
        softly = new SoftAssertions();
        actions = new Actions(driver);
    }

    public void scrollWithJS(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickWithJS(WebElement element){
        scrollWithJS(element);
        js.executeScript("arguments[0].click();", element);
    }
    public void typeWithJS(WebElement element, String text){
        scrollWithJS(element);
        type(element, text);
    }

    public void type(WebElement element, String text){
        if(text!=null){
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void  click(WebElement element){
        element.click();
    }
    public boolean isAlertPresent(int time){
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.alertIsPresent());
        if (alert==null){
            return false;
        } else {
            driver.switchTo().alert().accept();//click OK in alert
            return true;
        }
    }

    public boolean isContainsText(String text, WebElement element) {
        return element.getText().contains(text);
    }

    public WebDriverWait getWait(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return getWait(time).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    @FindBy(css="h3")
    WebElement h3;
    public void isPageTitleCorrect(String title) {
       Assertions.assertTrue(isContainsText(title, h3));
    }

    public boolean isElementVisible(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            e.getMessage();
            return false;
        }
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void verifyLinks(String url) {
        try {
            URL linkUrl = new URL(url);
            HttpURLConnection connection =(HttpURLConnection) linkUrl
                    .openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            int statusCode = connection.getResponseCode();

            if(statusCode >= 400) {
                softly.fail(url + " --> " + connection.getResponseMessage() + " is a BROKEN link");
            } else
                softly.assertThat(statusCode).isLessThan(400);
        } catch (IOException e) {
            softly.fail(url + " --> " + "ERROR occurred");
        }
    }
}
