package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
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

    @FindBy(id="column-a")
    WebElement elementA;
    @FindBy(id="column-b")
    WebElement elementB;
    @FindBy(css="#columns>.column>header")
    WebElement first;

    public DragAndDropPage changeElement() {
        actions.dragAndDrop(elementB,elementA).perform();
        Assertions.assertEquals("B", first.getText());
        return this;
    }

    public DragAndDropPage changeElementTwice() {
        actions.dragAndDrop(elementB,elementA).perform();
        actions.dragAndDrop(elementB,elementA).perform();
        Assertions.assertEquals("A", first.getText());
        return this;
    }

    public DragAndDropPage changeElementWithXY() {
        actions.dragAndDropBy(elementA, 250, 0).perform();
        Assertions.assertEquals("B", first.getText());
        return this;
    }
}


//        actions .moveToElement(elementB)
//                .pause(3000)  // Даем сайту заметить наведение мыши
//                .clickAndHold(elementB)
//                .pause(300)  // Имитируем удержание
//                .moveByOffset(2, 2)             // Микро-рывок, чтобы сработал триггер dragstart!
//                .moveToElement(elementA)
//                .pause(3000)  // Даем сайту понять, что мы над целью
//                .release()
//                .perform();
//actions.dragAndDropBy(elementA, 250, 0).perform();