package com.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends HomePage {

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement signUpLoginButton;

    @FindBy(xpath = "//a[text()=' Home']")
    WebElement homeButton;

    @FindBy(xpath = "//a[text()=' Products']")
    WebElement productButton;

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickButton(String option) {
        if (option.equalsIgnoreCase("continue")) {
            continueButton.click();
        } else if (option.equalsIgnoreCase("home")) {
            homeButton.click();
        } else if (option.equalsIgnoreCase("product")) {
            productButton.click();
        } else {
            signUpLoginButton.click();
        }
    }

}
