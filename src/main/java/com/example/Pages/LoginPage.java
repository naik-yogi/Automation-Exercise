package com.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends HomePage {
    String nameToVerify;
    String emailToVerify;
    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement nameInput;

    @FindBy(xpath = "//input[@placeholder='Name']/following-sibling::input[@type='email']")
    WebElement emailAddressSignIn;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signUpButton;

    @FindBy(xpath = "//input[@name='password']/preceding-sibling::input[@name='email']")
    WebElement emailAddressLogin;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void signUp(String name, String emailAddress) throws InterruptedException {
        nameInput.sendKeys(name);
        emailAddressSignIn.sendKeys(emailAddress);
        signUpButton.click();
        nameToVerify = name; // to validate name
        emailToVerify = emailAddress; // to validate email
        Thread.sleep(5000);
    }

    public void login(String email, String password) {
        emailAddressLogin.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
