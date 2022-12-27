package com.abdool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatcherPage {

    public WebDriver driver;
    public CatcherPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    public WebElement userName;

    @FindBy(name = "pass")
    public WebElement passWord;

    @FindBy(xpath = "/html/body/div/fieldset/button")
    public WebElement login;

    @FindBy(xpath = "/html/body/div/nav/p")
    public WebElement welcomeMsg;

    @FindBy(name = "username")
    public WebElement userWrong;

    @FindBy(name = "pass")
    public WebElement passWrong;

    @FindBy(xpath = "/html/body/div/nav/a[1]")
    public WebElement matrixLink;

    @FindBy(xpath = "/html/body/div/nav/a[2]")
    public WebElement TCLink;

    @FindBy(xpath = "/html/body/div/nav/a[3]")
    public WebElement reportLink;

    @FindBy(xpath = "/html/body/div/nav/a[4]")
    public WebElement overviewLink;

    @FindBy(xpath = "/html/body/div/button")
    public WebElement newMatrix;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/span/button")
    public WebElement showBtn;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/table/tbody/tr[1]/td[6]/button")
    public WebElement editMatBtn;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/ul[2]/li/input")
    public WebElement addDefId;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/ul[2]/li/button")
    public WebElement addDefBtn;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/ul[1]/li/input")
    public WebElement addTestId;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/ul[1]/li/button")
    public WebElement addTestBtn;

    @FindBy(xpath = "/html/body/div[1]/form/fieldset/textarea[1]")
    public WebElement descTC;

    @FindBy(xpath = "/html/body/div[1]/form/fieldset/textarea[2]")
    public WebElement stepTC;

    @FindBy(xpath = "/html/body/div[1]/form/fieldset/button")
    public WebElement submitTC;

    @FindBy(xpath = "/html/body/div[1]/table/tbody/tr[5]/td[4]/button")
    public WebElement detailsTC;

    @FindBy(xpath = "/html/body/div[3]/div/div/button[2]/a")
    public WebElement editTC;

    @FindBy(xpath = "/html/body/div/button")
    public WebElement editBtnTC;


    @FindBy(xpath = "/html/body/div/fieldset[1]/textarea[1]")
    public WebElement editDescTC;

    @FindBy(xpath = "/html/body/div/fieldset[1]/textarea[2]")
    public WebElement editStepsTC;

    @FindBy(xpath = "/html/body/div/fieldset[1]/input")
    public WebElement editCheckTC;

    @FindBy(xpath = "/html/body/div/fieldset[1]/select")
    public WebElement editTesterTC;

    @FindBy(xpath = "/html/body/div/fieldset[2]/select")
    public WebElement editResultTC;

    @FindBy(xpath = "/html/body/div/fieldset[2]/textarea")
    public WebElement editSummaryTC;

    @FindBy(xpath = "/html/body/div/button[1]")
    public WebElement editResetTC;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[3]/button")
    public WebElement selectBtn;

    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/div/div/div/div[1]/div/div/button[1]")
    public WebElement acceptBtn;

    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/div/div/div/div[1]/div/div/button[2]")
    public WebElement rejectBtn;

    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/div/div/div/div[1]/div/div/button[3]")
    public WebElement fixedBtn;

    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/div/div/div/div[1]/div/div/button[4]")
    public WebElement declineBtn;

    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/div/div/div/div[1]/div/div/button[5]")
    public WebElement shelveBtn;

    @FindBy(xpath = "/html/body/div[3]/div/div/button")
    public WebElement closeBtn;
}
