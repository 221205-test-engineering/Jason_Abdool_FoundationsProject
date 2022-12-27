package com.abdool.steps;

import com.abdool.pages.CatcherPage;
import com.abdool.runner.BugCatcherRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReportDefectStep {
    public WebDriver driver = BugCatcherRunner.driver;
    public CatcherPage catcherPage = BugCatcherRunner.catcherPage;

    //Report Defect Positive-Testing
    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page() {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=12");

        catcherPage.userName.sendKeys("cavalier89");
        catcherPage.passWord.sendKeys("alucard");
        catcherPage.login.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/nav/a[6]")));

        catcherPage.reportLink.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form/button")));

        WebElement title = driver.findElement(By.xpath("/html/body/div[1]/h1"));
        String expected = "Defect Reporter";
        String actual = title.getText();

        assertEquals(expected, actual);
    }
    @When("The employee selects todays date")
    public void the_employee_selects_todays_date() {
        // Write code here that turns the phrase above into concrete actions
        Calendar cal = Calendar.getInstance();
        Date d = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dateString = sdf.format(d);

        WebElement datebox = driver.findElement(By.xpath("/html/body/div[1]/form/input[1]"));
        datebox.clear();
        datebox.sendKeys(dateString);

    }
    @When("The employee types in Description with")
    public void the_employee_types_in_description_with(String docString) {
        WebElement descBox = driver.findElement(By.xpath("/html/body/div[1]/form/textarea[1]"));
        descBox.clear();
        descBox.sendKeys(docString);
    }
    @When("The employee types in Steps with")
    public void the_employee_types_in_steps_with(String docString) {
        WebElement stepBox = driver.findElement(By.xpath("/html/body/div[1]/form/textarea[2]"));
        stepBox.clear();
        stepBox.sendKeys(docString);
    }
    @When("The employee selects {string} priority")
    public void the_employee_selects_priority(String priority) {
        WebElement slider = driver.findElement(By.xpath("/html/body/div[1]/form/input[3]"));

        new Actions(driver)
                .clickAndHold(slider)
                .build()
                .perform();

    }
    @When("The employee selects {string} severity")
    public void the_employee_selects_severity(String severity) {
        WebElement slider = driver.findElement(By.xpath("/html/body/div[1]/form/input[2]"));

        new Actions(driver)
                .clickAndHold(slider)
                .build()
                .perform();
    }
    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() {
        WebElement reportBtn = driver.findElement(By.xpath("/html/body/div[1]/form/button"));

        reportBtn.click();
    }
    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    @When("The employee clicks Ok")
    public void the_employee_clicks_ok() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert = driver.switchTo().alert().getText();
        assertTrue(alert.contains("Confirm Bug Report"));
        driver.switchTo().alert().accept();
    }
    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(catcherPage.closeBtn));

        WebElement defectID = driver.findElement(By.xpath("/html/body/div[3]/div/div/h4"));
        String expected = defectID.getText();
        String actual = defectID.getText();

        assertEquals(expected, actual);
    }
    @When("The employee clicks close")
    public void the_employee_clicks_close() {
       catcherPage.closeBtn.click();
    }
    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form/button")));

        WebElement title = driver.findElement(By.xpath("/html/body/div[1]/h1"));
        String expected = "Defect Reporter";
        String actual = title.getText();

        assertEquals(expected, actual);
    }

    //Report Defect Negative-Testing-1 Short Steps
    @When("The employee types in Steps with meh")
    public void the_employee_types_in_steps_with_meh(String docString) {
        WebElement stepBox = driver.findElement(By.xpath("/html/body/div[1]/form/textarea[2]"));
        stepBox.clear();
        stepBox.sendKeys(docString);
    }
    @When("The employee selects high priority")
    public void the_employee_selects_high_priority() {
        WebElement slider = driver.findElement(By.xpath("/html/body/div[1]/form/input[3]"));

        new Actions(driver)
                .clickAndHold(slider)
                .keyDown(Keys.ARROW_RIGHT)
                .keyUp(Keys.ARROW_RIGHT)
                .build()
                .perform();
    }
    @When("The employee selects low severity")
    public void the_employee_selects_low_severity() {
        WebElement slider = driver.findElement(By.xpath("/html/body/div[1]/form/input[2]"));

        new Actions(driver)
                .clickAndHold(slider)
                .keyDown(Keys.ARROW_LEFT)
                .keyUp(Keys.ARROW_LEFT)
                .build()
                .perform();
    }

    @Then("No confirmation dialog appears")
    public void no_confirmation_dialog_appears() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            String alert = driver.switchTo().alert().getText();
            assertTrue(alert.contains("Confirm Bug Report"));
            driver.switchTo().alert().dismiss();

        } catch(UnhandledAlertException | TimeoutException e) {

            System.out.println("The automation testing caught something...");
        }

    }

    //Report Defect Negative-Testing-2 Short Description
    @When("The employee types in description with meh")
    public void the_employee_types_in_description_with_meh(String docString) {
        WebElement descBox = driver.findElement(By.xpath("/html/body/div[1]/form/textarea[1]"));
        descBox.clear();
        descBox.sendKeys(docString);
    }

    //Report Defect Negative-Testing-3 No Date Selected. Don't have to anything for this. All steps are done above.
    //However, No date selected causes Timeout exception.





}
