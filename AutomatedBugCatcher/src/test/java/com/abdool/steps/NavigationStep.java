<<<<<<< HEAD
package com.abdool.steps;

import com.abdool.pages.CatcherPage;
import com.abdool.runner.BugCatcherRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class NavigationStep {
    public WebDriver driver = BugCatcherRunner.driver;
    public CatcherPage catcherPage = BugCatcherRunner.catcherPage;

    //Manager sees links Matrices, Test Cases, Defect Reporting and Defect Overview on Homepage

    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() {       //This will run everytime it is called from the features given
        //return to website login page, login as manager
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=12");

        catcherPage.userName.sendKeys("g8tor");
        catcherPage.passWord.sendKeys("chomp!");
        catcherPage.login.click();

    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        //wait on homepage to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/nav/a[6]")));
        String actualTitle = driver.getTitle();
        String expectedTitle = "Manager Home";
        assertEquals(expectedTitle, actualTitle);
    }
    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
        // check links to confirm manager can see links
        String mLink = catcherPage.matrixLink.getText();
        String tcLink = catcherPage.TCLink.getText();
        String repLink = catcherPage.reportLink.getText();
        String overLink = catcherPage.overviewLink.getText();

        assertEquals("Matrices", mLink);
        assertEquals("Test Cases", tcLink);
        assertEquals("Report a Defect", repLink);
        assertEquals("Defect Overview", overLink);

    }


    //Navigation of the pages, user is able to return to the homepage
    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices() {
        catcherPage.matrixLink.click();
    }
    @Then("The title of the page should be Matrix Page")
    public void the_title_of_the_page_should_be_matrix_page() {
        String actualTitle = driver.getTitle();
        assertEquals("Matrix Dashboard", actualTitle);
    }
    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {

        driver.navigate().back();
    }
    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Manager Home";
        assertEquals(expectedTitle, actualTitle);
    }
    //Something to Note:
    //The gherkin reuses code, like the back button and homepage.
    //we only need to create one method because it will use that code as an instance.
    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() {
        catcherPage.TCLink.click();
    }

    //All links Viable (can be navigated too)
    @When("The manager clicks on {string}")
    public void the_manager_clicks_on(String link) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/nav/a[6]")));
        WebElement linkText = driver.findElement(By.linkText(link));

        linkText.click();
    }
    @Then("The title of page should be {string}")
    public void the_title_of_page_should_be(String Title) {
        String actualTitle = driver.getTitle();
        assertEquals(Title, actualTitle);
    }

}
=======
package com.abdool.steps;

import com.abdool.pages.CatcherPage;
import com.abdool.runner.BugCatcherRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class NavigationStep {
    public WebDriver driver = BugCatcherRunner.driver;
    public CatcherPage catcherPage = BugCatcherRunner.catcherPage;

    //Manager sees links Matrices, Test Cases, Defect Reporting and Defect Overview on Homepage

    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() {       //This will run everytime it is called from the features given
        //return to website login page, login as manager
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=12");

        catcherPage.userName.sendKeys("g8tor");
        catcherPage.passWord.sendKeys("chomp!");
        catcherPage.login.click();

    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        //wait on homepage to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/nav/a[6]")));
        String actualTitle = driver.getTitle();
        String expectedTitle = "Manager Home";
        assertEquals(expectedTitle, actualTitle);
    }
    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
        // check links to confirm manager can see links
        String mLink = catcherPage.matrixLink.getText();
        String tcLink = catcherPage.TCLink.getText();
        String repLink = catcherPage.reportLink.getText();
        String overLink = catcherPage.overviewLink.getText();

        assertEquals("Matrices", mLink);
        assertEquals("Test Cases", tcLink);
        assertEquals("Report a Defect", repLink);
        assertEquals("Defect Overview", overLink);

    }


    //Navigation of the pages, user is able to return to the homepage
    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices() {
        catcherPage.matrixLink.click();
    }
    @Then("The title of the page should be Matrix Page")
    public void the_title_of_the_page_should_be_matrix_page() {
        String actualTitle = driver.getTitle();
        assertEquals("Matrix Dashboard", actualTitle);
    }
    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {

        driver.navigate().back();
    }
    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Manager Home";
        assertEquals(expectedTitle, actualTitle);
    }
    //Something to Note:
    //The gherkin reuses code, like the back button and homepage.
    //we only need to create one method because it will use that code as an instance.
    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() {
        catcherPage.TCLink.click();
    }

    //All links Viable (can be navigated too)
    @When("The manager clicks on {string}")
    public void the_manager_clicks_on(String link) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/nav/a[6]")));
        WebElement linkText = driver.findElement(By.linkText(link));

        linkText.click();
    }
    @Then("The title of page should be {string}")
    public void the_title_of_page_should_be(String Title) {
        String actualTitle = driver.getTitle();
        assertEquals(Title, actualTitle);
    }

}
>>>>>>> e770fd8901b82cf24d1c79dda06497639b0de885
