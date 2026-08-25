package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.frames.FramesPage;
import com.herokuapp.pages.frames.IFramePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.FindBy;

public class IFrameTests extends TestBase {
    FramesPage framesPage;
    IFramePage iFrame;

    @BeforeEach
    public void preconditions(){
        framesPage = new HomePage(driver).getFramesPage();
        iFrame = framesPage.getIFramePage();
    }

    @Test
    public void verifyIFramePage(){
        iFrame.isPageTitleCorrect("iFrame");
    }

    @Test
    public void iframeTextTest() {
        iFrame.switchToIFrame()
              .verifyText("Your content goes here.");
    }
}






