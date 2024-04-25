package helpers;

import config.ApplicationManager;
import dto.ContactDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }
    public void clickAddOnNavBar() {
        driver.findElement(By.xpath("//a[@href='/add']")).click();
    }

    public void addContact(ContactDTO contactDTO) {
        fillNameOnAddContact(contactDTO.getName());
        fillLastNameOnAddContact(contactDTO.getLastName());
        fillPhoneOnAddContact(contactDTO.getPhone());
        fillEmailOnAddContact(contactDTO.getEmail());
        fillAddressOnAddContact(contactDTO.getAddress());
        fillDescriptionOnAddContact(contactDTO.getDescription());

        clickAddContact();
    }
    public void fillNameOnAddContact(String name) {
        typeText(name, By.xpath("//input[@placeholder='Name']"));
    }
    public void fillLastNameOnAddContact(String lastName) {
        typeText(lastName, By.xpath("//input[@placeholder='Last Name']") );
    }
    public void fillPhoneOnAddContact(String phone) {
        typeText(phone, By.xpath("//input[@placeholder='Phone']"));
    }

    public void fillEmailOnAddContact(String email) {
        typeText( email, By.xpath("//input[@placeholder='email']"));
    }
    public void fillAddressOnAddContact(String address) {
        typeText(address,By.xpath("//input[@placeholder='Address']") );
    }
    public void fillDescriptionOnAddContact(String description) {
        typeText(description, By.xpath("//input[@placeholder='description']") );
    }

    public void clickAddContact() {
        driver.findElement(By.xpath("//div[contains(@class, 'add_form')]//button")).click();
    }

    public boolean isContactDisplaysOnThePage(String phone) {
        List<WebElement> allPhones = driver.findElements(By
                .xpath("//div[contains(@class,'contact-item_card')]//h3"));
        boolean res = false;
        for(WebElement el:allPhones) {
            if(getTextBaseByElement(el).equals(phone)) {
                res = true;
                break;
            }
        }
        return res;
    }

}
