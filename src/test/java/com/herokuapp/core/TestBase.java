package com.herokuapp.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase{
    String browser;
    public static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected WebDriver driver;
    protected ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));


    @BeforeEach
    public void init(){
        driver = app.start();
//        if(browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if(browser.equalsIgnoreCase("firefox")){
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        } else if (browser.equalsIgnoreCase("edge")){
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//        }
    }

//    @AfterEach
//    public void tearDown(){
//        app.stop();
//    }

}
