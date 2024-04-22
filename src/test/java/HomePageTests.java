import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void homePageOpened(){
        WebElement homePageText = driver.findElement(By.cssSelector("div:nth-child(2) h1"));
        String actualResult = homePageText.getText().trim(); //trim обрезает пробелы
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, "Home Component");

    }
}
