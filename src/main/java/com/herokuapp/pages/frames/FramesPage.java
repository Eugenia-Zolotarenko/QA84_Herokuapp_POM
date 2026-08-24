package com.herokuapp.pages.frames;

import com.herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css="a[href='/iframe']")
    WebElement iframe;

    public IFramePage getIFramePage(){
        clickWithJS(iframe);
        return new IFramePage(driver);
    }
}
