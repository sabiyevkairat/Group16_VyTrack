package com.vytrack.tests;

import com.vytrack.pages.AccountsPage;
import com.vytrack.pages.HomePageManager;
import com.vytrack.pages.LogInPage;
import com.vytrack.pages.UserMenuPage;
import com.vytrack.tests.Base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US99 extends TestBase {


    @Test
    public void filter_costumer_info_on_account_page(){

        for (int i = 1; i <= 3; i++) {
            LogInPage logInPage=new LogInPage();
            logInPage.logIn("username"+i);


            HomePageManager homePageManager=new HomePageManager();
            BrowserUtils.waitForVisibilityOf(homePageManager.customers);
            BrowserUtils.actionsMoveToElement(homePageManager.customers);

            homePageManager.accounts.click();

            AccountsPage accountsPage=new AccountsPage();
            if (i==1){
                BrowserUtils.waitForVisibilityOf(accountsPage.filterButton);
                accountsPage.filterButton.click();
            }

            List<String> expectedFilters= new ArrayList<>(Arrays.asList("Account Name", "Contact Name", "Contact Email", "Contact Phone", "Owner", "Business Unit", "Created At", "Updated At"));


            List<String> actualFilters = new ArrayList<>();
            List<WebElement> filters=accountsPage.filters;
            for (WebElement eachFilter : filters) {
                actualFilters.add(eachFilter.getText().substring(0, eachFilter.getText().length() - 5));
            }

            Assert.assertEquals(actualFilters, expectedFilters);

            homePageManager.userProfile.click();
            UserMenuPage userMenuPage=new UserMenuPage();
            userMenuPage.logout.click();

        }


    }


}
