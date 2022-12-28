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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefectStep {

    public WebDriver driver = BugCatcherRunner.driver;
    public CatcherPage catcherPage = BugCatcherRunner.catcherPage;

    //Assign Defects
    //Given is created in another file: Navigation Step
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
        WebElement pending = driver.findElement(By.xpath("/html/body/div/h3"));
        String expected = "Assign Defects";
        String actual = pending.getText();

        //May need to create defect if this runs first if defect-report doesn't run first
        try {
            assertEquals(expected, actual);
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("No Defects found.");
        }
    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(catcherPage.selectBtn));

        catcherPage.selectBtn.click();
    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        WebElement text = driver.findElement(By.xpath("/html/body/div/div/h4"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(text));

        String expected = driver.findElement(By.xpath("/html/body/div/div/h4")).getText();
        String actual = driver.findElement(By.xpath("/html/body/div/div/h4")).getText();

        assertEquals(expected, actual);

    }
    @When("The manager selects a tester from the drop down list")
    public void the_manager_selects_a_tester_from_the_drop_down_list() {
        WebElement tester = driver.findElement(By.xpath("/html/body/div/div/input"));

        tester.sendKeys("cavalier89");
    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        WebElement assignBtn = driver.findElement(By.xpath("/html/body/div/div/button"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(assignBtn));

        assignBtn.click();
    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        WebElement pending = driver.findElement(By.xpath("/html/body/div/h3"));
        String expected = "Assign Defects";
        String actual = pending.getText();

        assertEquals(expected, actual);
    }


    //Defect-status
    @Given("The tester is on the Home Page")
    public void the_tester_is_on_the_home_page() {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=12");

        catcherPage.userName.sendKeys("cavalier89");
        catcherPage.passWord.sendKeys("alucard");
        catcherPage.login.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/nav/a[6]")));

        String actualTitle = driver.getTitle();
        String expectedTitle = "Tester Home";

        assertEquals(expectedTitle, actualTitle);
    }
    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them() {
        WebElement pending = driver.findElement(By.xpath("/html/body/div[1]/h3[1]"));
        String expected = "My Defects";
        String actual = pending.getText();

        assertEquals(expected, actual);
    }
    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status() {
        WebElement text1 = driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div/span/p"));
        text1.click();

        WebElement statusBtn = driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div/div/div/div[1]/span/button"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(statusBtn));

        statusBtn.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOf(catcherPage.acceptBtn));

        catcherPage.acceptBtn.click();
        catcherPage.rejectBtn.click();
        catcherPage.fixedBtn.click();
        catcherPage.declineBtn.click();
        catcherPage.shelveBtn.click();

        //change back to accept.
        catcherPage.acceptBtn.click();
    }
    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        WebElement text1 = driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div/span/p"));
        text1.click();

        WebElement status = driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div/span/p/b[2]"));
        String expected = status.getText();
        String actual = status.getText();

        assertEquals(expected, actual);
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefectStep {

    public WebDriver driver = BugCatcherRunner.driver;
    public CatcherPage catcherPage = BugCatcherRunner.catcherPage;

    //Assign Defects
    //Given is created in another file: Navigation Step
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
        WebElement pending = driver.findElement(By.xpath("/html/body/div/h3"));
        String expected = "Assign Defects";
        String actual = pending.getText();

        //May need to create defect if this runs first if defect-report doesn't run first
        try {
            assertEquals(expected, actual);
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("No Defects found.");
        }
    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(catcherPage.selectBtn));

        catcherPage.selectBtn.click();
    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        WebElement text = driver.findElement(By.xpath("/html/body/div/div/h4"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(text));

        String expected = driver.findElement(By.xpath("/html/body/div/div/h4")).getText();
        String actual = driver.findElement(By.xpath("/html/body/div/div/h4")).getText();

        assertEquals(expected, actual);

    }
    @When("The manager selects a tester from the drop down list")
    public void the_manager_selects_a_tester_from_the_drop_down_list() {
        WebElement tester = driver.findElement(By.xpath("/html/body/div/div/input"));

        tester.sendKeys("cavalier89");
    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        WebElement assignBtn = driver.findElement(By.xpath("/html/body/div/div/button"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(assignBtn));

        assignBtn.click();
    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        WebElement pending = driver.findElement(By.xpath("/html/body/div/h3"));
        String expected = "Assign Defects";
        String actual = pending.getText();

        assertEquals(expected, actual);
    }


    //Defect-status
    @Given("The tester is on the Home Page")
    public void the_tester_is_on_the_home_page() {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=12");

        catcherPage.userName.sendKeys("cavalier89");
        catcherPage.passWord.sendKeys("alucard");
        catcherPage.login.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/nav/a[6]")));

        String actualTitle = driver.getTitle();
        String expectedTitle = "Tester Home";

        assertEquals(expectedTitle, actualTitle);
    }
    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them() {
        WebElement pending = driver.findElement(By.xpath("/html/body/div[1]/h3[1]"));
        String expected = "My Defects";
        String actual = pending.getText();

        assertEquals(expected, actual);
    }
    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status() {
        WebElement text1 = driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div/span/p"));
        text1.click();

        WebElement statusBtn = driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div/div/div/div[1]/span/button"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(statusBtn));

        statusBtn.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOf(catcherPage.acceptBtn));

        catcherPage.acceptBtn.click();
        catcherPage.rejectBtn.click();
        catcherPage.fixedBtn.click();
        catcherPage.declineBtn.click();
        catcherPage.shelveBtn.click();

        //change back to accept.
        catcherPage.acceptBtn.click();
    }
    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        WebElement text1 = driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div/span/p"));
        text1.click();

        WebElement status = driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div/span/p/b[2]"));
        String expected = status.getText();
        String actual = status.getText();

        assertEquals(expected, actual);
    }
}
>>>>>>> e770fd8901b82cf24d1c79dda06497639b0de885
