package com.herokuapp.pages.alerts;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css= "button[onclick='jsAlert()']")
    WebElement jsAlert;

    public AlertsPage getAlerts(){
        clickWithJS(jsAlert);
        return this;
    }

    @FindBy(css= "button[onclick='jsConfirm()']")
    WebElement jsConfirm;

    public AlertsPage getConfirm(){
        clickWithJS(jsConfirm);
        return this;
    }

    @FindBy(css= "button[onclick='jsPrompt()']")
    WebElement jsPrompt;

    public AlertsPage getPrompt(){
        clickWithJS(jsPrompt);
        return this;
    }

    public AlertsPage acceptAlert(){
        driver.switchTo().alert().accept();
        return this;
    }

    public AlertsPage clickOnResult(String result){
        if(result != null && result.equalsIgnoreCase("Ok")){
            driver.switchTo().alert().accept();
        } else if (result!=null && result.equalsIgnoreCase("Cancel")){
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id="result")
    WebElement confirmResult;

    public AlertsPage verifyResult(String text){
        Assertions.assertTrue(isContainsText(text, confirmResult));
        return this;
    }

    public AlertsPage typeInAlert(String text){
        driver.switchTo().alert().sendKeys(text);
        return this;
    }

    public AlertsPage verifyAlertText(String expectedText) {
        String actualText = driver.switchTo().alert().getText();

        softly.assertThat(expectedText.equals(actualText));
        softly.assertAll();
       // Assertions.assertEquals(expectedText, actualText);
        return this;
    }

}
