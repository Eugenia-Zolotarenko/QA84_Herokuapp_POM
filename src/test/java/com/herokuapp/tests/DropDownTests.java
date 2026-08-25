package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.DropDownPage;
import com.herokuapp.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DropDownTests extends TestBase {
    DropDownPage dropDownPage;

    @BeforeEach
    public void preconditions(){
        dropDownPage = new HomePage(driver).getDropDownPage();
    }

    @Test
    public void verifyDropDownPageTitle(){
        dropDownPage.isPageTitleCorrect("Dropdown List");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Option 1", "Option 2"})
    public void dropDownListTest(String option){
        dropDownPage.selectOption(option)
                .verifySelectedOption(option);
    }
}
