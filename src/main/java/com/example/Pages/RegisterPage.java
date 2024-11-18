package com.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.example.Utils.PasswordManager;

public class RegisterPage extends HomePage {
    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement titleMr;

    @FindBy(xpath = "//input[@id='id_gender2']")
    WebElement titleMrs;

    @FindBy(xpath = "//input[@id='name']")
    WebElement name;

    @FindBy(xpath = "//input[@id='email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//select[@id='days']")
    WebElement dayOfBirth;

    @FindBy(xpath = "//select[@id='months']")
    WebElement monthOfBirth;

    @FindBy(xpath = "//select[@id='years']")
    WebElement yearOfBirth;

    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement newsletter;

    @FindBy(xpath = "//input[@id='optin']")
    WebElement specialOffers;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "address2")
    WebElement address2;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "zipcode")
    WebElement zipCode;

    @FindBy(id = "mobile_number")
    WebElement mobileNumber;

    @FindBy(xpath = "//button[text()='Create Account']")
    WebElement createAccoungtButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectTitle(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            titleMr.click();
        } else {
            titleMrs.click();
        }
    }

    public String enterPassword() {
        PasswordManager ps = new PasswordManager();
        password.sendKeys(ps.generatePassword());
        return ps.getPassword();
    }

    public String getName() {
        return name.getAttribute("value");

    }

    public String getEmail() {
        return email.getAttribute("value");
    }

    public void selectDateOfBirth(String day, String month, String year) {
        Select selectDay = new Select(dayOfBirth);
        selectDay.selectByValue(day);

        Select selectMonth = new Select(monthOfBirth);
        selectMonth.selectByValue(month);

        Select selectYear = new Select(yearOfBirth);
        selectYear.selectByValue(year);
    }

    public void newsletterCheck(boolean newsletterOption, boolean optinOption) {
        if (newsletterOption) {
            newsletter.click();
        }
        if (optinOption) {
            specialOffers.click();
        }
    }

    public void basicDetails(String fName, String lName, String companyName) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        company.sendKeys(companyName);
    }

    public void registerUser(String add1, String add2, String countryName, String sName, String cityName, String code,
            String mobNum) {
        address1.sendKeys(add1);
        address2.sendKeys(add2);
        state.sendKeys(sName);
        city.sendKeys(cityName);
        zipCode.sendKeys(code);
        mobileNumber.sendKeys(mobNum);
        Select selectCountry = new Select(country);
        selectCountry.selectByValue(countryName);
        createAccoungtButton.click();

    }

}
