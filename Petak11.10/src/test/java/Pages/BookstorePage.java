package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookstorePage extends BaseTest {

    public BookstorePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "item-0")

    public List<WebElement> cardTab;


    //--------------------------------------

    public void clickOnTab(String tabName){
        for(int i = 0; i< cardTab.size();i++){
            if (cardTab.get(i).getText().equals(tabName)){
                cardTab.get(i).click();
                break;
            }
        }
    }


}
