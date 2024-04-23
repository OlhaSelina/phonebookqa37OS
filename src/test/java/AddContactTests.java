import dto.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends BaseTest{
    @BeforeClass
    public void preconditions(){
        //TODO
            // click on logon btn by //a[@href='/login']
        clickLoginOnNavBar();
        // fill email by //input[@name='email']
        login(new UserDTO());
    }

    @AfterClass
    public  void  methodPostConditions(){
        clickLogoutBtn();
        navigateToHomePage();
    }

    @Test
    public void positiveContact() throws InterruptedException {
        // click   //a[@href='/add']
        driver.findElement(By.xpath("//a[@href='/add']")).click();

        // fill Name  //input[@placeholder='Name']
                WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
                name.click();
                name.clear();
                name.sendKeys("sdfhg");
        // fill lastName  //input[@placeholder='Last Name']
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys("aesdf");
        // fill phone //input[@placeholder='Phone']
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Phone']"));
        phone.click();
        phone.clear();
        String numberPhone = "5554567890";
        phone.sendKeys(numberPhone);
        // fill email //input[@placeholder='email']
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='email']"));
        email.click();
        email.clear();
        email.sendKeys("adsdf@ewf.com");
        // fill address  //input[@placeholder='Address']
        WebElement address = driver.findElement(By.xpath("//input[@placeholder='Address']"));
        address.click();
        address.clear();
        address.sendKeys("sdfdhj");
        // fill discription //input[@placeholder='description']
        WebElement discription = driver.findElement(By.xpath("//input[@placeholder='description']"));
        discription.click();
        discription.clear();
        discription.sendKeys("srtfgyj sdfjgk gshrfh ");

        //  click save btn //div[contains(@class, 'add_form')]//button
        driver.findElement(By.xpath("//div[contains(@class, 'add_form')]//button")).click();
        Thread.sleep(3000);



        List<WebElement> allPhones = driver.findElements(By.xpath("//div[contains(@class,'contact-item_card')]//h3"));

        boolean res = false;  //перебираем лист и проверяем по номеру телефона, что у нас добавился контакт
        for (WebElement el:allPhones){
            if (getTextBase(el).equals(numberPhone)){
                res = true;
                break;
            }
        }
        Assert.assertTrue(res);
    }
}
