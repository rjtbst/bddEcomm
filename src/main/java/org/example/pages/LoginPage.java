package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //locators
    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By loginBtnLocator = By.xpath("//button[text()=' Login 'and@type= 'submit']");
    private By forgotPwdLinkLocator = By.xpath("//*[text()='Forgot your password? ']");
    private  By logoutLinkLocator = By.xpath("//a[text()='Logout']");
    private By resetPwdLink = By.xpath("//button[text()=' Reset Password ']");
private By errorMessage = By.xpath("//div[@role='alert']//p");
    //constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //page methods
    public void enterEmail(String email){
        driver.findElement(emailInputLocator).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginBtnLocator).click();
    }

    public void clickForgotPwdLink(){
        driver.findElement(forgotPwdLinkLocator).click();
    }
    public boolean checkForgotPwdLink(){
        return driver.findElement(resetPwdLink).isDisplayed();
    }
    public boolean checkLogoutLink(){
        return driver.findElement(logoutLinkLocator).isDisplayed();
    }
  public String checkErrorMsg(){
       return driver.findElement(errorMessage).getText();
  }
    public void login(String email, String password){
       enterEmail(email);
       enterPassword(password);
       clickLoginButton();
       return;
    }

    public String getForgotPwdPageUrl(){
        return driver.getCurrentUrl();
    }
}
