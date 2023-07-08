import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class InventoryPage extends BasePage
{

    //Dugme koje dodaje proizvod backpack u korpu!
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement backpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement light;

    //Span element cija vrednost je broj proizvoda u korpi!
    @FindBy(className = "shopping_cart_badge")
    WebElement cart;


    //Dugme sa ovim id izbacuje proizvod backpack iz korpe!
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpack;

    @FindBy(className = "product_sort_container")
    WebElement sort;

    @FindBy(className = "inventory_item_price")
    WebElement price;

    public InventoryPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickBackpack()
    {
        backpack.click();
    }

    public void clickLight()
    {
        light.click();
    }

    public String getCartNumber()
    {
        return cart.getText();
    }

    public void removeBackpack()
    {
        removeBackpack.click();
    }

    public void sortProducts(String text)
    {
        Select select = new Select(sort);
        select.selectByVisibleText(text);
    }
//Kada ocekujemo da nam vrati String pisemo ovakvu metodu!
    public String getPrice()
    {
        return price.getText();
    }

    public void clickCart()
    {
        cart.click();
    }
}


