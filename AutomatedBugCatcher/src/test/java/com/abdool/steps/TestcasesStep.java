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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestcasesStep {

    public WebDriver driver = BugCatcherRunner.driver;
    public CatcherPage catcherPage = BugCatcherRunner.catcherPage;

    //Background
    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=12");

        catcherPage.userName.sendKeys("ryeGuy");
        catcherPage.passWord.sendKeys("coolbeans");
        catcherPage.login.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/nav/a[6]")));

        catcherPage.TCLink.click();
        String expectedTitle = "Test Cases";
        String actualTitle = driver.getTitle();

        assertEquals(expectedTitle, actualTitle);
    }

    //Add a Test Case
    @When("The tester types Description into input with")
    public void the_tester_types_description_into_input_with(String docString) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(catcherPage.submitTC));

        catcherPage.descTC.clear();
        catcherPage.descTC.sendKeys(docString);
    }
    @When("The tester types Steps into input with")
    public void the_tester_types_steps_into_input_with(String docString) {
        catcherPage.stepTC.clear();
        catcherPage.stepTC.sendKeys(docString);
    }
    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button() {
        catcherPage.submitTC.click();
    }
    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        WebElement newText = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[6]/td[2]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(newText));

        String expectedResult = newText.getText();
        String actualResult = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[6]/td[2]")).getText();

        assertEquals(expectedResult, actualResult);
    }
    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted() {

        String expectedResult = "UNEXECUTED";
        String actualResult = driver.findElement(By.xpath ("/html/body/div[1]/table/tbody/tr[5]/td[3]")).getText();

        assertEquals(expectedResult, actualResult);
    }

    //Update a Test case
    @When("The tester presses on details")
    public void the_tester_presses_on_details() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(catcherPage.detailsTC));

        catcherPage.detailsTC.click();
    }
    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(catcherPage.editTC));

        String expected = driver.findElement(By.xpath("/html/body/div[3]/div/div/h3")).getText();
        String actual = driver.findElement(By.xpath("/html/body/div[3]/div/div/h3")).getText();

        assertEquals(expected, actual);
    }
    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one() {
        String expected = "No One";
        String actual = driver.findElement(By.xpath("/html/body/div[3]/div/div/p[6]")).getText();

        assertEquals(expected, actual);
    }
    @When("The tester presses the close button")
    public void the_tester_presses_the_close_button() {
        WebElement close = driver.findElement(By.xpath("/html/body/div[3]/div/div/button[1]"));

        close.click();
    }
    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(catcherPage.detailsTC));

        String expectedTitle = "Test Cases";
        String actualTitle = driver.getTitle();

        assertEquals(expectedTitle, actualTitle);
    }

    //Edit Existing Test Case

    @When("The tester presses on details button")
    public void the_tester_presses_on_details_button () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(catcherPage.detailsTC));

        WebElement detailsBtn = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[4]/td[4]/button"));
        detailsBtn.click();
    }

    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() {

        catcherPage.editTC.click();
    }
    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(catcherPage.editBtnTC));

        String expected = driver.findElement(By.xpath("/html/body/div/h1")).getText();
        String actual = driver.findElement(By.xpath("/html/body/div/h1")).getText();

        assertEquals(expected, actual);
    }
    @When("The tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() {
        catcherPage.editBtnTC.click();
    }
    @When("The tester types in {string} into the description text area")
    public void the_tester_types_in_into_the_description_text_area(String description) {
        WebElement saveBtn = driver.findElement(By.xpath("/html/body/div/button[2]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
        catcherPage.editDescTC.clear();
        catcherPage.editDescTC.sendKeys(description);

    }
    @When("The tester types in {string} into the steps text area")
    public void the_tester_types_in_into_the_steps_text_area(String steps) {

        catcherPage.editStepsTC.clear();
        catcherPage.editStepsTC.sendKeys(steps);
    }
    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() {
        catcherPage.editCheckTC.click();
    }
    @When("The tester selects {string} for performed from drop down")
    public void the_tester_selects_for_performed_from_drop_down(String tester) {

        Select name = new Select (catcherPage.editTesterTC);

        name.selectByValue(tester);
    }
    @When("The tester selects {string} for test result from drop down")
    public void the_tester_selects_for_test_result_from_drop_down(String result) {
        Select code = new Select (catcherPage.editResultTC);

        code.selectByValue(result);
    }
    @When("The tester types in {string} into the summary text area")
    public void the_tester_types_in_into_the_summary_text_area(String summary) {
        catcherPage.editSummaryTC.clear();
        catcherPage.editSummaryTC.sendKeys(summary);
    }
    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page() {
        // Write code here that turns the phrase above into concrete actions
        WebElement save = driver.findElement(By.xpath("/html/body/div/button[2]"));
        save.click();
    }
    @Then("A confirmation prompt should appear")
    public void a_confirmation_prompt_should_appear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert = driver.switchTo().alert().getText();
        assertTrue(alert.contains("Are you sure"));
        driver.switchTo().alert().accept();
    }
    @Then("An alert says the test case has been saved")
    public void an_alert_says_the_test_case_has_been_saved() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert = driver.switchTo().alert().getText();
        assertTrue(alert.contains("Test Case"));
        driver.switchTo().alert().accept();
    }

    //Reset a Test case
    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button() {
        catcherPage.editResetTC.click();
    }
    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {
        //throw new io.cucumber.java.PendingException();

        String actual = driver.findElement(By.xpath("/html/body/div/fieldset[2]/p")).getText();

        String expected = "FAIL";

        assertEquals(expected, actual);

    }
}
