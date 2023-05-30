package org.example.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.testng.Assert;

public class LoginPageStepDef {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I am on the orangeHrm login page")
    public void i_am_on_the_orangeHrm_login_page(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }
    @Given("I have entered valid username and password")
    public void i_have_entered_valid_username_and_password(){
        loginPage.enterEmail("Admin");
        loginPage.enterPassword("admin123");
    }
@When("I click on login button")
public void i_click_on_login_button(){
        loginPage.clickLoginButton();
}
@Then("I should be logged in successfully")
public void i_should_be_logged_in_successfully(){
    Assert.assertEquals(loginPage.checkLogoutLink(),true);
}
    //outline
    @Given("I have entered invalid {string} and invalid {string}")
    public void i_have_entered_invalid_cred(String username, String password){
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }
  @Then("I should see and error message indicating {string}")
  public void i_should_see_error_message(String error_message){
        Assert.assertEquals(loginPage.checkErrorMsg(),error_message);
    }

 @When("I click on forget password")
    public void i_click_on_forget_password(){
        loginPage.clickForgotPwdLink();
 }
 @Then("I should be redirect to password reset page")
    public void i_should_be_redirect_to_password_reset_page(){
        Assert.assertEquals(loginPage.checkForgotPwdLink(),true);
 }
}
