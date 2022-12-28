<<<<<<< HEAD
package com.abdool.steps;

import com.abdool.pages.CatcherPage;
import com.abdool.runner.BugCatcherRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginStep {

    public WebDriver driver = BugCatcherRunner.driver;
    public CatcherPage catcherPage = BugCatcherRunner.catcherPage;

    //Positive-Testing of login
    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        //My login page is: https://bugcatcher-dan.coe.revaturelabs.com/?dev=12

        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=12");
    }
    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String username) {
        // Username is typed in
        catcherPage.userName.sendKeys(username);
    }
    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String password) {
        //Password is typed in
        catcherPage.passWord.sendKeys(password);
    }
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        // The login button is clicked
        catcherPage.login.click();
    }
    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_page(String role) {
        //Use explicit wait so that the page will load
        // Compare assertions if we are on correct roles
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/nav/a[6]")));

        String actualRole = driver.getTitle();
        assertEquals(role + " Home", actualRole);
    }
    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_on_the_home_page(String fname, String lname) {
        // compare assertions for correct first and last name
        //on the welcome message on homepage
        assertEquals("Welcome " + fname + " " + lname, catcherPage.welcomeMsg.getText());

    }

    //Negative Testing of login - 1
    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input() {
        catcherPage.userWrong.sendKeys("g8tor");
    }
    @When("The employee types in chomp!! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input() {
        catcherPage.passWrong.sendKeys("chomp!!");
    }
    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        // need to wait so the program loads to accept alert
        //We use an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String expectedOutput = "Wrong password for User";
        String actual = driver.switchTo().alert().getText();
        assertEquals(expectedOutput, actual);
        driver.switchTo().alert().accept();

    }

    //Negative Testing of login - 2
    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input() {
        catcherPage.userWrong.sendKeys("sicEmDawgs");
    }
    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input() {
        catcherPage.passWrong.sendKeys("natchamps");
    }

    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {
        // need to wait so the program loads to accept alert
        //We use an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String expectedOutput = "Username not found";
        String actual = driver.switchTo().alert().getText();
        assertEquals(expectedOutput, actual);
        driver.switchTo().alert().accept();
    }

}
=======
package com.abdool.steps;

import com.abdool.pages.CatcherPage;
import com.abdool.runner.BugCatcherRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginStep {

    public WebDriver driver = BugCatcherRunner.driver;
    public CatcherPage catcherPage = BugCatcherRunner.catcherPage;

    //Positive-Testing of login
    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        //My login page is: https://bugcatcher-dan.coe.revaturelabs.com/?dev=12

        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=12");
    }
    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String username) {
        // Username is typed in
        catcherPage.userName.sendKeys(username);
    }
    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String password) {
        //Password is typed in
        catcherPage.passWord.sendKeys(password);
    }
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        // The login button is clicked
        catcherPage.login.click();
    }
    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_page(String role) {
        //Use explicit wait so that the page will load
        // Compare assertions if we are on correct roles
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/nav/a[6]")));

        String actualRole = driver.getTitle();
        assertEquals(role + " Home", actualRole);
    }
    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_on_the_home_page(String fname, String lname) {
        // compare assertions for correct first and last name
        //on the welcome message on homepage
        assertEquals("Welcome " + fname + " " + lname, catcherPage.welcomeMsg.getText());

    }

    //Negative Testing of login - 1
    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input() {
        catcherPage.userWrong.sendKeys("g8tor");
    }
    @When("The employee types in chomp!! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input() {
        catcherPage.passWrong.sendKeys("chomp!!");
    }
    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        // need to wait so the program loads to accept alert
        //We use an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String expectedOutput = "Wrong password for User";
        String actual = driver.switchTo().alert().getText();
        assertEquals(expectedOutput, actual);
        driver.switchTo().alert().accept();

    }

    //Negative Testing of login - 2
    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input() {
        catcherPage.userWrong.sendKeys("sicEmDawgs");
    }
    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input() {
        catcherPage.passWrong.sendKeys("natchamps");
    }

    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {
        // need to wait so the program loads to accept alert
        //We use an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String expectedOutput = "Username not found";
        String actual = driver.switchTo().alert().getText();
        assertEquals(expectedOutput, actual);
        driver.switchTo().alert().accept();
    }

}
>>>>>>> e770fd8901b82cf24d1c79dda06497639b0de885
