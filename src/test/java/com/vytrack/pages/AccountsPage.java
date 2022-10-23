package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountsPage {

    public AccountsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css="a[title='Filters']")
    public WebElement filterButton;

    @FindBy(xpath="//div[@class='filter-item oro-drop']/div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']")
    public List<WebElement> filters;




}
