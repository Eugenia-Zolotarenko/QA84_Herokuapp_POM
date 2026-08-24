package com.herokuapp.pages.windows;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WindowsPage extends BasePage {
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="a[href='/windows/new']")
    WebElement newWindow;

    public WindowsPage getNewWindow(){
        click(newWindow);
        return this;
    }

    public WindowsPage switchToNewWindow(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }
}