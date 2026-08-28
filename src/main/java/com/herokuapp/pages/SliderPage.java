package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css="input[type='range']")
    WebElement slider;

    @FindBy(id="range")
    WebElement currentSliderValue;

    double max = Double.parseDouble(slider.getAttribute("max"));
    double min = Double.parseDouble(slider.getAttribute("min"));
    double step = Double.parseDouble(slider.getAttribute("step"));
    int maxSteps =(int) ((max-min)/step);
    double defaultValue = Double.parseDouble(slider.getAttribute("value"));
    double currentValue=  Double.parseDouble(currentSliderValue.getText());

    public SliderPage moveSliderFromStartToEnd() {
        slider.sendKeys(Keys.HOME);
        for(int i = 1; i <= maxSteps; i++){
            slider.sendKeys(Keys.RIGHT);
        }
        return this;
    }

    public SliderPage moveSliderTo(double value) {
        slider.sendKeys(Keys.HOME);
//        double min = Double.parseDouble(slider.getAttribute("min"));
//        double max = Double.parseDouble(slider.getAttribute("max"));
//        double step = Double.parseDouble(slider.getAttribute("step"));
//        double defaultValue = Double.parseDouble(slider.getAttribute("value"));
//        double currentValue=  Double.parseDouble(currentSliderValue.getText());
//        int maxSteps =(int) ((max-min)/step);

        value = Math.floor(value * 2.0) / 2.0;

        if(value> currentValue){
            if(value>=max) slider.sendKeys(Keys.END);
            else {
                while (currentValue < value) {
                    slider.sendKeys(Keys.RIGHT);
                    currentValue = Double.parseDouble(currentSliderValue.getText());
                }
            }
        } else if (value< currentValue) {
            if(value <= min) slider.sendKeys(Keys.HOME);
            else {
                while (currentValue > value) {
                    slider.sendKeys(Keys.LEFT);
                    currentValue = Double.parseDouble(currentSliderValue.getText());
                }
            }
        }
        return this;
    }

    public  void verifySliderValue(double value){
        double actual = 0;
        double expected = Double.parseDouble(currentSliderValue.getText());
        if(value>=max) actual = max;
        else if (value <= min) actual = min;
        else actual = Math.floor(value * 2.0) / 2.0;
        Assertions.assertEquals(actual, expected);
    }


    public SliderPage moveSliderFromEndToStart() {
        slider.sendKeys(Keys.HOME);
        for(int i = 5; i > maxSteps; i--){
            slider.sendKeys(Keys.LEFT);
        }
        return this;
    }

    public SliderPage moveSliderWithMouse(int xOffset) {
        actions.dragAndDropBy(slider, xOffset, 0).perform();
        return this;
    }

    public SliderPage verifyMoveWithMouse() {
        currentValue = Double.parseDouble(currentSliderValue.getText());
        Assertions.assertTrue(defaultValue != currentValue);
        return this;
    }
}
