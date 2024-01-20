package PageObjectClasses;

import Core.BasePage;
import Core.CustomExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@data-testid='searchval']")
    public List<WebElement> searchField;
    @FindBy(xpath = "//button[@value='Search']")
    public List<WebElement> searchBtn;
    @FindBy(xpath = "//div[@class='modal-content'] //button[@class='btn btn-primary']")
    public WebElement modalWindowAcceptBtn;


    /**
     * @param itemName name of the product we are looking for.
     * @return SearchResultsPage for convenient use of the method.
     */
    public SearchResultsPage searchItems(String itemName){
        wait.until(ExpectedConditions.elementToBeClickable(modalWindowAcceptBtn)).click();
        wait.until(CustomExpectedConditions.disappearanceOfElement(modalWindowAcceptBtn));
        searchField.get(0).sendKeys(itemName);
        searchBtn.get(0).click();
        return new SearchResultsPage();
    }
}
