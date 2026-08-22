package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import com.herokuapp.pages.alerts.AlertsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/javascript_alerts']")
    WebElement alertsLink;

    public AlertsPage getAlertsPage(){
        clickWithJS(alertsLink);
        return new AlertsPage(driver);
    }
}
