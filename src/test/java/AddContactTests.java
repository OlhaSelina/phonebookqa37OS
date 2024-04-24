import dto.ContactDTO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddContactTests extends BaseTest{
    @BeforeClass
    public void preconditions(){
        clickLoginOnNavBar();
        login(user);
    }

    @AfterClass
    public  void  methodPostConditions(){
        clickLogoutBtn();
        navigateToHomePage();
    }

    @Test
    public void positiveContact()  {
        clickAddOnNavBar();
        ContactDTO contactDTO = new ContactDTO()
                .setName("sdfghj")
                .setLastName("fvbnj")
                .setPhone("5554567890")
                .setEmail("adsdf@ewf.com")
                .setAddress("sdfdhj")
                .setDescription("srtfgyj sdfjgk gshrfh ");
        addContact(contactDTO);
        pause(3000);
        Assert.assertTrue(isContactDisplaysOnThePage("5554567890"));
    }

}
