package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.alerts.AlertsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AlertsTests extends TestBase {
    AlertsPage alerts;

    @BeforeEach
    public void preconditions(){
        alerts = new HomePage(driver).getAlertsPage(); //open page with Alerts
    }

    @Test
    public void jsAlert(){
        alerts.getAlerts().acceptAlert().verifyResult("You successfully clicked an alert");
       // Assertions.assertTrue(alerts.isAlertPresent(5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ok","Cancel"})

    public void jsConfirmOK(String option){
        alerts.getConfirm()
                .clickOnResult(option)
                .verifyResult(option);
    }
//   @Test
//    public void jsConfirmCancel(){
//        alerts.getConfirm()
//                .clickOnResult("Cancel")
//                .verifyResult("Cancel");
//    }

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
