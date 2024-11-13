package Pages;

import Base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class PracticeFormPage extends BaseTest {

    public PracticeFormPage() {
        PageFactory.initElements(driver, this);
    }

    public PracticeFormPage(WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(className = "custom-control-label")
    public List<WebElement> genderButton;

    @FindBy(id = "userNumber")
    public WebElement mobileNumberField;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthField;


    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

    @FindBy(css = ".subjects-auto-complete__option")
    public List<WebElement> subjectsOptions;

    @FindBy(css = ".custom-checkbox")
    public List<WebElement> hobbies;

    @FindBy(id = "uploadPicture")
    public WebElement inputImage;

    @FindBy(id = "currentAddress")
    public WebElement addressField;

    @FindBy(id = "state")
    public WebElement stateDropdown;

    @FindBy(css = "div[role='option']")
    public List<WebElement> stateOptions;

    @FindBy(id = "city")
    public WebElement cityDropdown;

    @FindBy(css = "div[role='option']")
    public List<WebElement> cityOptions;

    @FindBy(id = "submit")
    public WebElement submitButton;

//------------------------------------------------------------------------------------------

    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);

    }

    public void inputMobileNumber(String mobileNumber) {
        mobileNumberField.clear();
        mobileNumberField.sendKeys(mobileNumber);

    }

    public void selectDateOfBirth(String date) {
        dateOfBirthField.clear();
        dateOfBirthField.sendKeys(date);
        dateOfBirthField.sendKeys(Keys.ENTER);

    }


    public void selectSubject(String subject) {
        subjectsInput.click();


        subjectsInput.clear();
        subjectsInput.sendKeys(subject);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".subjects-auto-complete__option")));


        List<WebElement> options = driver.findElements(By.cssSelector(".subjects-auto-complete__option"));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(subject)) {
                option.click();
                break;
            }
        }
    }

    public void selectGender(String gender) {

        for (int i = 0; i < genderButton.size(); i++) {
            WebElement option = genderButton.get(i);
            if (option.getText().equalsIgnoreCase(gender)) {
                option.click();
                break;
            }
        }
    }


    public void selectHobby(String hobbyName) {
        for (int i = 0; i < hobbies.size(); i++) {
            if (hobbies.get(i).getText().equals(hobbyName)) {
                hobbies.get(i).click();
                break;
            }
        }
    }

    public void selectState(String state){
        stateDropdown.click();

        stateDropdown.sendKeys(state);

        stateDropdown.sendKeys(Keys.ENTER);
    }
    public void selectCity(String city){
        stateDropdown.click();

        cityDropdown.sendKeys(city);

        cityDropdown.sendKeys(Keys.ENTER);
    }




    public void uploadImage(String imageLocation) {
        inputImage.sendKeys(imageLocation);
    }

    public void inputAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }


    public void submitForm() {
        submitButton.click();
    }


}




