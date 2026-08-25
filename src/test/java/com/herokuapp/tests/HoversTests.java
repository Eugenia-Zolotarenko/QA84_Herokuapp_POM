package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.HoversPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HoversTests extends TestBase {
    HoversPage hovers;

    @BeforeEach
    public void preconditions(){
        hovers = new HomePage(driver).getHoversPage();
    }
    @Test
    public void verifyHoversPageTitle(){
        hovers.isPageTitleCorrect("Hovers");
    }

    @Test
    public void hoverMouseOnElementsTest(){
        hovers.hoverMouseOnElements();
    }
}
