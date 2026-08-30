package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#columns>div")
    List<WebElement> draggableElements;

    public DragAndDropPage isElementDraggable() {
        String isDraggable;
        for (WebElement element: draggableElements){
            isDraggable = element.getAttribute("draggable");
            softly.assertThat(isDraggable.equals("true"));
        }
        softly.assertAll();
        return this;
    }

    public DragAndDropPage dragElement() {
        for (WebElement element: draggableElements){
            actions.dragAndDropBy(element, 250, 100).perform();
        }
        return this;
    }


}
