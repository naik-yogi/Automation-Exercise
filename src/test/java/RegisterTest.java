import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.example.Pages.HomePage;
import com.example.Pages.HomeScreenPage;
import com.example.Pages.LoginPage;
import com.example.Pages.RegisterPage;

public class RegisterTest extends BaseTest {
    // RegisterPage register = new RegisterPage(driver);
    // LoginPage login = new LoginPage(driver);
    // HomeScreenPage homeScreen = new HomeScreenPage(driver);
    // HomePage home = new HomePage(driver);
    String userName = "Yogesh Naik";
    String userEmail = "naikyogi65343@gmail.com";

    RegisterPage register;
    LoginPage login;
    HomeScreenPage homeScreen;
    HomePage home;

    @BeforeMethod
    public void setUpPages() {
        register = new RegisterPage(driver);
        login = new LoginPage(driver);
        homeScreen = new HomeScreenPage(driver);
        home = new HomePage(driver);
    }

    @Test(description = "Verifying navigation to sign in page", priority = 0)
    public void navigateToLoginPageVerify() throws InterruptedException {

        homeScreen.navigateToRegisterScreen();
        String expectedTitle = "Automation Exercise - Signup / Login";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        Thread.sleep(5000);
    }

    @Test(description = "Verifying successful sign in", priority = 1)
    public void userSignUpVerify() throws InterruptedException {
        login.signUp(userName, userEmail);
        Thread.sleep(5000);
        String expectedTitle = "Automation Exercise - Signup";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(description = "Verifying that values of name and email is as entered by user", priority = 3)
    public void nameAndEmailVerify() {
        String tempName = register.getName();
        String tempEmail = register.getEmail();
        Assert.assertEquals(tempName, userName);
        Assert.assertEquals(tempEmail, userEmail);
    }

}
