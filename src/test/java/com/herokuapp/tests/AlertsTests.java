package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.alerts.AlertsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class AlertsTests extends TestBase {
    AlertsPage alerts;

    @BeforeEach
    public void preconditions(){
        alerts = new HomePage(driver).getAlertsPage(); //open page with Alerts
    }

    @Test
    public void verifyAlertsPage(){
        alerts.isPageTitleCorrect("JavaScript Alerts");
    }


    @Test
    public void jsAlert(){
        alerts.getAlerts()
                .verifyAlertText("I am a JS Alert")
                .acceptAlert()
                .verifyResult("You successfully clicked an alert");
       // Assertions.assertTrue(alerts.isAlertPresent(5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ok","Cancel"})

    public void jsConfirm(String option){
        alerts.getConfirm()
                .verifyAlertText("I am a JS Confirm")
                .clickOnResult(option)
                .verifyResult(option);
    }
//   @Test
//    public void jsConfirmCancel(){
//        alerts.getConfirm()
//                .clickOnResult("Cancel")
//                .verifyResult("Cancel");
//    }

    static Stream<Arguments> provideValuesForPromptAlert(){
        return Stream.of(
                Arguments.of("Test text", "Ok", "Test text"),
                Arguments.of("", "Ok" , ""),
                Arguments.of("", "Cancel" , "null"),
                Arguments.of("Test text", "Cancel" , "null")
        );
    }

    @ParameterizedTest
    @MethodSource("provideValuesForPromptAlert")
    public void jsPromptClickOnButtonOk(String text, String option, String resultText){
        alerts.getPrompt()
                .typeInAlert(text)
                .verifyAlertText("I am a JS prompt")
                .clickOnResult(option)
                .verifyResult(resultText);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Test text",""})
    public void jsPromptClickOnButtonCancel(String text){
        alerts.getPrompt()
                .typeInAlert(text)
                .clickOnResult("Cancel")
                .verifyResult("null");
    }
//    @Test
//    public void jsAlertTextTest() {
//        alerts.getAlerts()
//              .verifyAlertText("I am a JS Alert")
//              .acceptAlert();
//    }
}

