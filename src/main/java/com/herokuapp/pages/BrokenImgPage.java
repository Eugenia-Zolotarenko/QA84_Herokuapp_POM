package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImgPage extends BasePage {
    public BrokenImgPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css= "#content img")
    List<WebElement> images;

    public BrokenImgPage checkBrokenImages() {
        for (int i = 0; i < images.size(); i++) {
            WebElement img = images.get(i);
            String imgUrl = img.getAttribute("src");
            verifyLinks(imgUrl);
        }
        softly.assertAll();
        return this;
    }

}
