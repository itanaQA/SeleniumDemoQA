package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void userCanSubmitPracticeFormWithValidData() throws InterruptedException {

        String fistName = excelReader.getStringData("User registration data", 1, 0);
        String lastName = excelReader.getStringData("User registration data", 1, 1);
        String email = excelReader.getStringData("User registration data", 1, 2);
        String gender = excelReader.getStringData("User registration data", 1, 3);
        String mobile = String.valueOf(excelReader.getIntegerData("User registration data", 1, 4));
        String dateOfBirth = excelReader.getStringData("User registration data", 1, 5);
        String subjects = excelReader.getStringData("User registration data", 1, 6);
        String hobbies = excelReader.getStringData("User registration data", 1, 7);
        String currentAddress = excelReader.getStringData("User registration data", 1, 9);
        //String state = excelReader.getStringData("User registration data", 1,10);
//String city = excelReader.getStringData("User registration data", 1,11);


        practiceFormPage.inputFirstName(fistName);
        practiceFormPage.inputLastName(lastName);
        practiceFormPage.inputEmail(email);
        practiceFormPage.selectGender(gender);
        practiceFormPage.inputMobileNumber(mobile);
        practiceFormPage.selectDateOfBirth(dateOfBirth);
        practiceFormPage.selectSubject(subjects);
        practiceFormPage.selectHobby(hobbies);
        practiceFormPage.uploadImage("C:\\ITANA\\QA kurs\\Java\\Selenium\\Petak11.10\\test_image.jpg");
        practiceFormPage.inputAddress(currentAddress);
        // practiceFormPage.selectState(state);
        //practiceFormPage.selectCity(city);
        practiceFormPage.submitForm();
        WebElement thankYouMessage = driver.findElement(By.cssSelector(".modal-title.h4"));
        WebElement closeButton = driver.findElement(By.id("closeLargeModal"));
        Assert.assertTrue(closeButton.isDisplayed());
        Assert.assertEquals(thankYouMessage.getText(), "Thanks for submitting the form");


    }

    @Test
    public void userCannotSubmitWithInvalidEmail() throws InterruptedException {

        String fistName = excelReader.getStringData("User registration data", 2, 0);
        String lastName = excelReader.getStringData("User registration data", 2, 1);
        String invalidEmail = excelReader.getStringData("User registration data", 2, 2);
        String gender = excelReader.getStringData("User registration data", 2, 3);
        String mobile = String.valueOf(excelReader.getIntegerData("User registration data", 2, 4));
        String dateOfBirth = excelReader.getStringData("User registration data", 2, 5);
        String subjects = excelReader.getStringData("User registration data", 2, 6);
        String hobbies = excelReader.getStringData("User registration data", 2, 7);
        String currentAddress = excelReader.getStringData("User registration data", 2, 9);
        //String state = excelReader.getStringData("User registration data", 1,10);
//String city = excelReader.getStringData("User registration data", 1,11);


        practiceFormPage.inputFirstName(fistName);
        practiceFormPage.inputLastName(lastName);
        practiceFormPage.inputEmail(invalidEmail);
        practiceFormPage.selectGender(gender);
        practiceFormPage.inputMobileNumber(mobile);
        practiceFormPage.selectDateOfBirth(dateOfBirth);
        practiceFormPage.selectSubject(subjects);
        practiceFormPage.selectHobby(hobbies);
        practiceFormPage.uploadImage("C:\\ITANA\\QA kurs\\Java\\Selenium\\Petak11.10\\test_image.jpg");
        practiceFormPage.inputAddress(currentAddress);
        // practiceFormPage.selectState(state);
        //practiceFormPage.selectCity(city);
        practiceFormPage.submitForm();
        Assert.assertTrue(practiceFormPage.submitButton.isDisplayed());

    }
    @Test
    public void userCannotSubmitWithoutGenderButton() throws InterruptedException {

        String fistName = excelReader.getStringData("User registration data", 1, 0);
        String lastName = excelReader.getStringData("User registration data", 1, 1);
        String invalidEmail = excelReader.getStringData("User registration data", 1, 2);
        String gender = excelReader.getStringData("User registration data", 2, 3);
        String mobile = String.valueOf(excelReader.getIntegerData("User registration data", 1, 4));
        String dateOfBirth = excelReader.getStringData("User registration data", 1, 5);
        String subjects = excelReader.getStringData("User registration data", 1, 6);
        String hobbies = excelReader.getStringData("User registration data", 1, 7);
        String currentAddress = excelReader.getStringData("User registration data", 1, 9);
        //String state = excelReader.getStringData("User registration data", 1,10);
//String city = excelReader.getStringData("User registration data", 1,11);


        practiceFormPage.inputFirstName(fistName);
        practiceFormPage.inputLastName(lastName);
        practiceFormPage.inputEmail(invalidEmail);
        practiceFormPage.selectGender(gender);
        practiceFormPage.inputMobileNumber(mobile);
        practiceFormPage.selectDateOfBirth(dateOfBirth);
        practiceFormPage.selectSubject(subjects);
        practiceFormPage.selectHobby(hobbies);
        practiceFormPage.uploadImage("C:\\ITANA\\QA kurs\\Java\\Selenium\\Petak11.10\\test_image.jpg");
        practiceFormPage.inputAddress(currentAddress);
        // practiceFormPage.selectState(state);
        //practiceFormPage.selectCity(city);
        practiceFormPage.submitForm();
        Assert.assertTrue(practiceFormPage.submitButton.isDisplayed());

    }



}
