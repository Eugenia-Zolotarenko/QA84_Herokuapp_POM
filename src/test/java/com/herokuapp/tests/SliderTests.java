package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.SliderPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SliderTests extends TestBase {
    SliderPage slider;

    @BeforeEach
    public void preconditions(){
        slider = new HomePage(driver).getSliderPage();
    }

    @Test
    public void verifySliderPageTitle(){
        slider.isPageTitleCorrect("Horizontal Slider");
    }

    @Test
    public void moveSliderFromStartToEndTest(){
        slider.moveSliderFromStartToEnd()
                .verifySliderValue(5);
    }

    @Test
    public void moveSliderFromStartEndToStartTest(){
        slider.moveSliderFromEndToStart()
                .verifySliderValue(0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0, 0.5, 2, 4.5,  5, 6, 3.2 })

    public void moveSliderToTest(double value){
        slider.moveSliderTo(value)
              .verifySliderValue(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {3,5,7,50,70})

    public void moveSliderWithMouseTest(int xOffset){
        slider.moveSliderWithMouse(xOffset)
                .verifyMoveWithMouse();
    }
}
