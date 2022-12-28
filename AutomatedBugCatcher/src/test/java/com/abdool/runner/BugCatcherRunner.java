<<<<<<< HEAD
package com.abdool.runner;


import com.abdool.pages.CatcherPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/abdool/features", glue = "com.abdool.steps")
//change @CucumberOptions to work on only one feature
//REMINDER: DON'T FORGET to switch back to /features when testing all.

public class BugCatcherRunner {

    // This class will start the execution of our tests
    // we'll need an instance of our WebDriver
    public static WebDriver driver;
    public static CatcherPage catcherPage;

    @BeforeClass
    public  static void setup () {
        //Create setup to use for chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        catcherPage = new CatcherPage(driver);
    }

    @AfterClass
    public static void finish(){
        driver.quit();
    }

}
=======
package com.abdool.runner;


import com.abdool.pages.CatcherPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/abdool/features", glue = "com.abdool.steps")
//change @CucumberOptions to work on only one feature
//REMINDER: DON'T FORGET to switch back to /features when testing all.

public class BugCatcherRunner {

    // This class will start the execution of our tests
    // we'll need an instance of our WebDriver
    public static WebDriver driver;
    public static CatcherPage catcherPage;

    @BeforeClass
    public  static void setup () {
        //Create setup to use for chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        catcherPage = new CatcherPage(driver);
    }

    @AfterClass
    public static void finish(){
        driver.quit();
    }

}
>>>>>>> e770fd8901b82cf24d1c79dda06497639b0de885
