package levelone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {

    @AfterMethod
    public  void  methodPostConditions(){
        driver.findElement(
                By.xpath("//div[contains(@class,'navbar-logged')]//button")).click();
        driver.navigate().to("https://telranedu.web.app/home");
    }
    @Test
    public void positiveLoginTest() throws InterruptedException {
        // click on logon btn by //a[@href='/login']
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(3000);
        // fill email by //input[@name='email']
        WebElement inputEmail = driver.findElement(By.xpath("//input[@name='email']"));
        inputEmail.click(); // кликнуть в поле
        inputEmail.clear();  // очистить поле инпута перед вводом наших значений
        inputEmail.sendKeys("ledyolga@ukr.net");

        // fill password by //input[@name='password']
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
        inputPassword.click(); // кликнуть в поле
        inputPassword.clear();  // очистить поле инпута перед вводом наших значений
        inputPassword.sendKeys("Qwerty123!@#");

        // click on logon btn by //button[@name='login']
        driver.findElement(By.xpath("//button[@name='login']")).click();

        //validation - verification  by sing out //div[contains(@class,'navbar-logged')]//button

        // text:Sign Out
        // Thread.sleep(5000); ставим когда надо притормозить выполнение кода и увидеть ошибку
        WebElement signOutBtn = driver.findElement(
                By.xpath("//div[contains(@class,'navbar-logged')]//button")
        );
        String actualRes = signOutBtn.getText().trim();
        System.out.println(actualRes);

       // Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'navbar-logged')]//button"))
       //         .getText().trim(),"Sign Out");

        Assert.assertEquals(actualRes, "Sign Out");

    }


}
