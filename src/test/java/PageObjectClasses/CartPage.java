package PageObjectClasses;

import Core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='cartEmpty']")
    public WebElement emptyCart;

    @FindBy(xpath = "//a[@data-testid='cart-button']")
    public WebElement cartBtn;
    @FindBy(xpath = "//li[contains(@data-cart-item-id, 'id')]")
    public List<WebElement> cartItems;
    @FindBy(xpath = "//li[contains(@data-cart-item-id, 'id')] //button[contains(@class,'deleteCartItemButton')]")
    public List<WebElement> cartItemsCross;


    /**
     * This method removes all items from the cart and checks that the cart is empty.
     */
    public void emptyCart(){
        cartBtn.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(cartItems));
        for(WebElement element : cartItemsCross){element.click();}
        wait.until(ExpectedConditions.visibilityOf(emptyCart));
    }
}
