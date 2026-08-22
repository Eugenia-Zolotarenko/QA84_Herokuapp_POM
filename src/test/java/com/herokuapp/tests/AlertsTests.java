package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.alerts.AlertsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlertsTests extends TestBase {
    AlertsPage alerts;

    @BeforeEach
    public void preconditions(){
        alerts = new HomePage(driver).getAlertsPage(); //open page with Alerts
    }

    @Test
    public void jsAlert(){
        alerts.getAlerts();
        Assertions.assertTrue(alerts.isAlertPresent(5));
    }

    @Test
    public void jsConfirmOK(){
        alerts.getConfirm()
                .clickOnResult("Ok")
                .verifyResult("Ok");
    }
   @Test
    public void jsConfirmCancel(){
        alerts.getConfirm()
                .clickOnResult("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    public void jsPromptOk(){
        alerts.getPrompt()
                .typeInAlert("Test text")
                .clickOnResult("Ok")
                .verifyResult("Test text");
    }    @Test
    public void jsPromptCancel(){
        alerts.getPrompt()
                .typeInAlert("Test text")
                .clickOnResult("Cancel")
                .verifyResult("null");
    }
}
