package com.vytrack.tests.Base;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.lang.module.Configuration;
import java.security.PublicKey;

public class TestBase {

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("environment"));
    }

    @AfterClass
    public void tearDown(){
        Driver.quitDriver();
    }
}
