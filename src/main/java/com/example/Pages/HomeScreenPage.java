package com.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeScreenPage extends HomePage {

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement loginButton;

    public HomeScreenPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToRegisterScreen() {
        loginButton.click();
    }

}
