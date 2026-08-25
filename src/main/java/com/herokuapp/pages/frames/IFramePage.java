package com.herokuapp.pages.frames;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class IFramePage extends BasePage {
    public IFramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tinymce")
    WebElement textArea;

    public IFramePage verifyText(String text) {
        Assertions.assertTrue(isContainsText(text, textArea));
        return this;
    }

    @FindBy(css = "iframe")
    WebElement iframe;
    public IFramePage switchToIFrame() {
        driver.switchTo().frame(iframe);
        return this;
    }

}


