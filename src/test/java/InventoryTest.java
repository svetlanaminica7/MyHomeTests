import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class InventoryTest extends BaseTest
{
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutOnePage checkoutStepOnePage;

    @BeforeMethod
    public void SetUp()
    {
        driver = browserOpen();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutOnePage(driver);
        loginPage.LoginOnPage();

    }

    @Test
    public void AddToCartTwoProducts()
    {
        //Act
        /*loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
         loginPage.clickLogin();*/

        //Arange
        inventoryPage.clickBackpack();
        inventoryPage.clickLight();

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(inventoryPage.getCartNumber(),"2");
    }


    @Test
    public void removeProduct()
    {
        /*loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();*/
        inventoryPage.clickBackpack();
        inventoryPage.clickLight();
        inventoryPage.removeBackpack();

        Assert.assertEquals(inventoryPage.getCartNumber(),"1");
    }

    @Test
    public void sortProduct()
    {
        /*loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();*/
        inventoryPage.sortProducts("Price (high to low)");

        Assert.assertEquals(inventoryPage.getPrice(),"$49.99");
    }

    @Test
    public void sortLowProduct()
    {
        inventoryPage.sortProducts("Price (low to high)");

        Assert.assertEquals(inventoryPage.getPrice(),"$7.99");
    }

    @Test
    public void BuyProductsToTheEnd()
    {
        inventoryPage.clickLight();
        inventoryPage.clickBackpack();
        inventoryPage.clickCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.setForm("Svetlana","Kojic","1100");
        checkoutStepOnePage.clickFinish();

        Assert.assertEquals(checkoutStepOnePage.getMessage(),"Thank you for your order!");

    }

    @AfterMethod
    public void after()
    {
        driver.quit();
    }
}
