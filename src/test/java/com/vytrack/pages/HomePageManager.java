package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageManager {
    public HomePageManager(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//i[@class='fa-asterisk menu-icon']/..)[1]")
    public WebElement fleet;

    @FindBy(xpath = "(//i[@class='fa-users menu-icon']/..)[1]")
    public WebElement customers;

    @FindBy(xpath = "//span[.='Accounts']")
    public WebElement accounts;

    @FindBy(xpath = "(//a[@href='#']/span[@class='title title-level-1'])[6]")
    public  WebElement marketing;

    @FindBy(id="user-menu")
    public WebElement userProfile;


}
