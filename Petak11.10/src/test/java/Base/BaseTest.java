package Base;

import Pages.BookstorePage;
import Pages.Homepage;
import Pages.LogInPage;
import Pages.PracticeFormPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public ExcelReader excelReader;
    public Homepage homepage;
    public BookstorePage bookstorePage;
    public LogInPage logInPage;
    public PracticeFormPage practiceFormPage;
    protected WebDriverWait wait;

    @BeforeClass
    public void setUp() throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        excelReader = new ExcelReader("UserData.xlsx");
        excelReader = new ExcelReader("Practice Form Data.xlsx");
        logInPage = new LogInPage();
        bookstorePage = new BookstorePage();
        homepage = new Homepage();
        practiceFormPage = new PracticeFormPage(wait);

    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }


}
