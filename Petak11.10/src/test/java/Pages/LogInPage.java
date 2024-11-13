package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BaseTest {

    public LogInPage (){
        PageFactory.initElements(driver,this);

    }

    @FindBy (id = "userName")
    public WebElement userNameField;

    @FindBy (id = "password")
    public WebElement passwordField;

    @FindBy (id = "login")
    public WebElement loginButton;

    //--------------------------------------

    public void inputUsername(String username){
        userNameField.clear();
        userNameField.sendKeys(username);

    }

    public void inputPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLogInButton (){

        loginButton.click();
    }



}
