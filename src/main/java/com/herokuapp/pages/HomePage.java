package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import com.herokuapp.pages.alerts.AlertsPage;
import com.herokuapp.pages.frames.FramesPage;
import com.herokuapp.pages.frames.IFramePage;
import com.herokuapp.pages.windows.WindowsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/javascript_alerts']")
    WebElement alertsLink;

    public AlertsPage getAlertsPage(){
        clickWithJS(alertsLink);
        return new AlertsPage(driver);
    }

    @FindBy(css="a[href='/windows']")
    WebElement windows;

    public WindowsPage getWindowsPage(){
        clickWithJS(windows);
        return new WindowsPage(driver);
    }

    @FindBy(css="a[href='/frames']")
    WebElement frames;

    public FramesPage getFramesPage(){
        clickWithJS(frames);
        return new FramesPage(driver);
    }

    @FindBy(css="a[href='/dropdown']")
    WebElement dropdown;

    public DropDownPage getDropDownPage(){
        clickWithJS(dropdown);
        return new DropDownPage(driver);
    }

    @FindBy(css="a[href='/hovers']")
    WebElement hovers;

    public HoversPage getHoversPage(){
        clickWithJS(hovers);
        return new HoversPage(driver);
    }

    @FindBy(css="a[href='/horizontal_slider']")
    WebElement slider;

    public SliderPage getSliderPage(){
        clickWithJS(slider);
        return new SliderPage(driver);
    }

    @FindBy(css="a[href='/drag_and_drop']")
    WebElement dragAndDrop;

    public DragAndDropPage getDragAndDropPage(){
        clickWithJS(dragAndDrop);
        return new DragAndDropPage(driver);
    }

    @FindBy(css="a[href='/broken_images']")
    WebElement brokenImg;

    public BrokenImgPage getBrokenImgPage(){
        clickWithJS(brokenImg);
        return new BrokenImgPage(driver);
    }



}
