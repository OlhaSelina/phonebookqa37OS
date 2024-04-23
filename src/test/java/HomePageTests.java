import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void homePageOpened(){
        WebElement homePageText = getElementHomePageText();
        String actualResult = getTextBase(homePageText);
        System.out.println(actualResult); //sout
        Assert.assertEquals(actualResult, "Home Component");

    }

}
