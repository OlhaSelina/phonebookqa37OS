import dto.UserDTO;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {

    @AfterMethod
    public  void  methodPostConditions(){
        clickLogoutBtn();
        navigateToHomePage();
    }

    @Test
    public void positiveLoginTest() throws InterruptedException {
        // click on logon btn by //a[@href='/login']
        clickLoginOnNavBar();
        Thread.sleep(3000);
        // fill email by //input[@name='email']


        login(user);

        //validation - verification  by sing out //div[contains(@class,'navbar-logged')]//button

        // text:Sign Out
        // Thread.sleep(5000); ставим когда надо притормозить выполнение кода и увидеть ошибку
        WebElement signOutBtn = getSignOutBtnElement();
        String actualRes = getTextBase(signOutBtn);
        System.out.println(actualRes);

       // Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'navbar-logged')]//button"))
       //         .getText().trim(),"Sign Out");

        Assert.assertEquals(actualRes, "Sign Out");

    }


}
