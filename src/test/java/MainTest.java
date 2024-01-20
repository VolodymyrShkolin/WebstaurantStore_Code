import Core.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest{

    @Test
    public void mainTestCase(){
        mp.searchItems("stainless work table")
                .checkText("Table")
                .addToCart()
                .emptyCart();
    }
}
