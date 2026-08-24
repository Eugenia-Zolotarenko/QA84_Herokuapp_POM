package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.windows.WindowsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WindowsTests extends TestBase {
    WindowsPage windows;

    @BeforeEach
    public void preconditions(){
        windows = new HomePage(driver).getWindowsPage(); //open page with Windows
    }

    @Test
    public void verifyWindowsPage(){
        windows.isPageTitleCorrect("Opening a new window");
    }

    @Test
    public void openNewWindowTest(){
        windows.getNewWindow() //Click here link
                .switchToNewWindow(1)
                .isPageTitleCorrect("New Window");
    }
}
