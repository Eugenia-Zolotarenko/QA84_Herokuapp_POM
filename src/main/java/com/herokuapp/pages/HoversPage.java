package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoversPage extends BasePage {
    public HoversPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css="div.figure")
    List<WebElement> pictures;

    @FindBy(xpath = "//h5[contains(normalize-space(.),'name')]")
    WebElement name;

    @FindBy(xpath = "//a[contains(normalize-space(.),'View profile')]")
    WebElement link;

    public HoversPage hoverMouseOnElements() {
        for (WebElement picture: pictures){
            actions.moveToElement(picture).perform();
            softly.assertThat(isElementVisible(name));
            softly.assertThat(isElementVisible(link));
        }
        softly.assertAll();
        return this;
    }
}
