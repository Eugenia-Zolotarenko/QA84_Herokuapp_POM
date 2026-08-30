package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.DragAndDropPage;
import com.herokuapp.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DragAndDropTests extends TestBase {
    DragAndDropPage dragAndDrop;

    @BeforeEach
    public void preconditions(){
        dragAndDrop = new HomePage(driver).getDragAndDropPage();
    }

    @Test
    public void verifyDragAndDropPageTitle(){
        dragAndDrop.isPageTitleCorrect("Drag and Drop");
    }

    @Test
    public void isElementDraggableTest(){
        dragAndDrop.isElementDraggable();
    }

    @Test
    public void changeElementsTest(){
        dragAndDrop.changeElement();
    }
    @Test
    public void changeElementsTwiceTest(){
        dragAndDrop.changeElementTwice();
    }
    @Test
    public void changeElementsWithXYTest(){
        dragAndDrop.changeElementWithXY();
    }
}
