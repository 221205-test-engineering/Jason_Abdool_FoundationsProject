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
import static org.junit.Assert.assertTrue;

public class MatrixStep {

    public WebDriver driver = BugCatcherRunner.driver;
    public CatcherPage catcherPage = BugCatcherRunner.catcherPage;

    //Creating a New Matrix
    //Given is created in another file: Navigation Steps
    @When("The manager chooses to create a new matrix")
    public void the_manager_chooses_to_create_a_new_matrix() {
        catcherPage.newMatrix.click();
    }
    @When("The manager creates a title for the matrix")
    public void the_manager_creates_a_title_for_the_matrix() {
        WebElement matrixTitle = driver.findElement(By.xpath("/html/body/div/input"));
        matrixTitle.sendKeys("Automated: Test Title");
    }
    @When("The manager adds requirements to the matrix")
    public void the_manager_adds_requirements_to_the_matrix() {
        WebElement matrixStory = driver.findElement(By.xpath("/html/body/div/fieldset/table/tbody/tr/td[1]/input"));
        WebElement requireBtn = driver.findElement(By.xpath("/html/body/div/fieldset/button"));

        matrixStory.sendKeys("Automated Test: User Story");
        requireBtn.click();
    }
    @When("The manager saves the matrix")
    public void the_manager_saves_the_matrix() {
        WebElement createMatrix = driver.findElement(By.xpath("/html/body/div/button"));
        createMatrix.click();
    }
    @Then("An alert with a success message should appear")
    public void an_alert_with_a_success_message_should_appear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        String alert = driver.switchTo().alert().getText();
        assertTrue(alert.contains("Matrix with ID "));
        driver.switchTo().alert().accept();
    }

    //Updating Defects

    @Given("The manager is on the matrix homepage")
    public void the_manager_is_on_the_matrix_homepage() {
        catcherPage.matrixLink.click();
        assertEquals("Matrix Dashboard", driver.getTitle());
    }
    @Given("The manager has selected the matrix")
    public void the_manager_has_selected_the_matrix() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(catcherPage.showBtn));

        catcherPage.showBtn.click();
    }
    @When("The manager adds a defect")
    public void the_manager_adds_a_defect() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(catcherPage.editMatBtn));

        catcherPage.editMatBtn.click();
        catcherPage.addDefId.sendKeys("903");
        catcherPage.addDefBtn.click();
    }
    @When("The manager confirms their changes")
    public void the_manager_confirms_their_changes() {
        WebElement saveReq = driver.findElement(By.xpath("/html/body/div/ul/li[1]/div/div/div/button"));
        saveReq.click();
    }
    @Then("Then the matrix should saved")
    public void then_the_matrix_should_saved() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert = driver.switchTo().alert().getText();
        assertTrue(alert.contains("Matrix Saved"));
        driver.switchTo().alert().accept();
    }

    //Updating Testcases

    @When("The manager adds a Test Cases")
    public void the_manager_adds_a_test_cases() {
        //Returns back to home page, need to click on matrix link again
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(catcherPage.editMatBtn));

        catcherPage.editMatBtn.click();
        catcherPage.addTestId.sendKeys("803");
        catcherPage.addTestBtn.click();

    }

}
