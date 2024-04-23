import org.openqa.selenium.By;
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

    public void navigateToHomePage() {
        driver.navigate().to("https://telranedu.web.app/home");
    }

    public void clickLogoutBtn() {
        driver.findElement(
                By.xpath("//div[contains(@class,'navbar-logged')]//button")).click();
    }

    @Test
    public void positiveLoginTest() throws InterruptedException {
        // click on logon btn by //a[@href='/login']
        clickLoginOnNavBar();
        Thread.sleep(3000);
        // fill email by //input[@name='email']
        fillEmailOnLogin("ledyolga@ukr.net");

        // fill password by //input[@name='password']
        fillPasswordOnLogin("Qwerty123!@#");

        // click on logon btn by //button[@name='login']
        clickLoginBtn();

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

    public WebElement getSignOutBtnElement() {
        WebElement signOutBtn = driver.findElement(
                By.xpath("//div[contains(@class,'navbar-logged')]//button")
        );
        return signOutBtn;
    }

    public void clickLoginBtn() {
        driver.findElement(By.xpath("//button[@name='login']")).click();
    }

    public void fillPasswordOnLogin(String password) {
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
        inputPassword.click(); // кликнуть в поле
        inputPassword.clear();  // очистить поле инпута перед вводом наших значений
        inputPassword.sendKeys(password);
    }

    public void fillEmailOnLogin(String email) {
        WebElement inputEmail = driver.findElement(By
                .xpath("//input[@name='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }

    public void clickLoginOnNavBar() {
        driver.findElement(By.xpath("//a[@href='/login']")).click();
    }


}
