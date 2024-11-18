import org.testng.annotations.Test;
import org.testng.Assert;

import com.example.Pages.HomePage;
import com.example.Pages.HomeScreenPage;
import com.example.Pages.LoginPage;
import com.example.Pages.RegisterPage;

public class RegisterTest extends BaseTest {
    RegisterPage register = new RegisterPage(driver);
    LoginPage login = new LoginPage(driver);
    HomeScreenPage homeScreen = new HomeScreenPage(driver);
    HomePage home = new HomePage(driver);
    String userName = "Yogesh Naik";
    String userEmail = "naikyogesh751@gmail.com";

    @Test(description = "Verifying navigation to sign in page", priority = 0)
    public void navigateToLoginPageVerify() {

        homeScreen.navigateToRegisterScreen();
        String expectedTitle = "Automation Exercise - Signup / Login";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(description = "Verifying successful sign in", priority = 1)
    public void userSignUpVerify() {
        login.signUp(userName, userEmail);
        String expectedTitle = "Automation Exercise - Signup";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(description = "Verifying that values of name and email is as entered by user", priority = 2)
    public void nameAndEmailVerify() {
        String tempName = register.getName();
        String tempEmail = register.getEmail();
        Assert.assertEquals(tempName, userName);
        Assert.assertEquals(tempEmail, userEmail);
    }

}
