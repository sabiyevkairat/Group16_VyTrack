package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    public LogInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement logInButton;


    public void logIn(String username){
        usernameInput.sendKeys(ConfigurationReader.getProperty(username));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        logInButton.click();

    }



}
