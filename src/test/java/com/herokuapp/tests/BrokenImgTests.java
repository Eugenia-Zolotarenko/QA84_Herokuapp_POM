package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.BrokenImgPage;
import com.herokuapp.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrokenImgTests extends TestBase {
    BrokenImgPage brokenImg;

    @BeforeEach
    public void preconditions(){
        brokenImg = new HomePage(driver).getBrokenImgPage();
    }

    @Test
    public void isPageTitleCorrectTest(){
        brokenImg.isPageTitleCorrect("Broken Images");
    }

    @Test
    public void chekBrokenImagesTest(){
        brokenImg.checkBrokenImages();
    }

}
