import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage
{
    @FindBy(id = "checkout")
    WebElement checkout;

// Ovo se zove "javni" konstruktor,kada ima this onda nema return!
    public CartPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickCheckout()
    {
        checkout.click();
    }
}

