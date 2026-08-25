package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage {
    public DropDownPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id="dropdown")
    WebElement dropdown;

    public DropDownPage selectOption(String option) {
        new Select(dropdown).selectByVisibleText(option);
        return this;
    }

    public DropDownPage verifySelectedOption(String option) {
        String actualSelectedValue  = new Select(dropdown).getFirstSelectedOption().getText();
        Assertions.assertEquals(option, actualSelectedValue);
        return this;
    }

    // Assertions.assertTrue(shouldHaveText(oldSelectMenu,
    //                new Select(oldSelectMenu)
    //                        .getFirstSelectedOption().getText(), 5));
}
