package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {

    @AfterMethod
    public  void  methodPostConditions(){
       app.getUserHelper().clickLogoutBtn();
       app.getHomePageHelper().navigateToHomePage();
    }

    @Test
    public void positiveLoginTest()  {
        // click on logon btn by //a[@href='/login']
       app.getUserHelper().clickLoginOnNavBar();
       app.getUserHelper().login(user);
        String actualRes = app.getUserHelper().getSignOutBtnText();
        System.out.println(actualRes);

//        Assert.assertEquals(
//                driver.findElement(
//                        By.xpath("//div[contains(@class,'navbar-logged')]//button"))
//                        .getText().trim(),
//                "Sign Out");

        Assert.assertEquals(actualRes, "Sign Out");

    }


}
