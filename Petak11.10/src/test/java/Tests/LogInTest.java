package Tests;


import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
    }

    @Test
    public void userCanLogInWithValidCredentials() {

        homepage.clickOnCard("Book Store Application");
        bookstorePage.clickOnTab("Login");
        String validUsername = excelReader.getStringData("Sheet1", 1, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);
        logInPage.inputUsername(validUsername);
        logInPage.inputPassword(validPassword);
        logInPage.clickOnLogInButton();

        WebElement usernameLabel = driver.findElement(By.id("userName-value"));
        WebElement logoutButton = driver.findElement(By.id("submit"));

        Assert.assertEquals(usernameLabel.getText(), validUsername);
        Assert.assertTrue(logoutButton.isDisplayed());

        logoutButton.click();

    }

    @Test
    public void userCannotLogInWithinvalidUsername() {


        homepage.clickOnCard("Book Store Application");
        bookstorePage.clickOnTab("Login");
        String invalidUsername = excelReader.getStringData("Sheet1", 3, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);
        logInPage.inputUsername(invalidUsername);
        logInPage.inputPassword(validPassword);
        logInPage.clickOnLogInButton();

        WebElement errorMessage = driver.findElement(By.className("mb-1"));
        Assert.assertTrue(logInPage.loginButton.isDisplayed());
        Assert.assertTrue(errorMessage.isDisplayed());


    }

    @Test
    public void userCannotLogInWithinvalidPassword() {

        homepage.clickOnCard("Book Store Application");
        bookstorePage.clickOnTab("Login");
        String validUsername = excelReader.getStringData("Sheet1", 1, 0);
        String invalidPassword = excelReader.getStringData("Sheet1", 2, 1);
        logInPage.inputUsername(validUsername);
        logInPage.inputPassword(invalidPassword);
        logInPage.clickOnLogInButton();

        WebElement errorMessage = driver.findElement(By.className("mb-1"));
        Assert.assertTrue(logInPage.loginButton.isDisplayed());
        Assert.assertTrue(errorMessage.isDisplayed());

    }

    @Test
    public void userCannotLogInWithNoCredentials() {

        homepage.clickOnCard("Book Store Application");
        bookstorePage.clickOnTab("Login");
        String blankUsername = ("");
        String blankPassword = ("");
        logInPage.inputUsername(blankUsername);
        logInPage.inputPassword(blankPassword);
        logInPage.clickOnLogInButton();

        WebElement blankFieldErrorUsername = driver.findElement(By.cssSelector(".mr-sm-2.is-invalid.form-control"));
        WebElement blankFieldErrorPassword = driver.findElement(By.cssSelector(".mr-sm-2.is-invalid.form-control"));
        Assert.assertTrue(logInPage.loginButton.isDisplayed());
        Assert.assertTrue(blankFieldErrorPassword.isDisplayed());
        Assert.assertTrue(blankFieldErrorUsername.isDisplayed());

    }


}