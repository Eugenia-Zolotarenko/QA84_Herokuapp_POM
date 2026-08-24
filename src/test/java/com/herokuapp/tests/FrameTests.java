package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.frames.FramesPage;
import com.herokuapp.pages.frames.IFramePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FrameTests extends TestBase {
    FramesPage framesPage;

    @BeforeEach
    public void preconditions(){
        framesPage = new HomePage(driver).getFramesPage();
    }

    @Test
    public void verifyFramesPage(){
        framesPage.isPageTitleCorrect("Frames");
    }
}
