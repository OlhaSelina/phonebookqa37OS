package helpers;

import dto.ContactDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    By getAllContactsNames = By.xpath("// div[contains(@class,'contact-item_card')]/h2");
    By btnRemoveContact = By.xpath("//button[text()='Remove']");
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

    public void deleteContactByName(String name) {
        // find all names of our contacts:
        // div[contains(@class,'contact-item_card')]/h2
        List<WebElement> allContactsNames = findElementsBase(getAllContactsNames);
        if(!allContactsNames.isEmpty()){
            for (WebElement el: allContactsNames){
                if (getTextBaseByElement(el).equals(name)){
                    clickBaseByElement(el);
                    clickBase(btnRemoveContact);
                }

            }
        }else {
            System.out.println("List is empty");
        }
    }

    public boolean isContactByNameExist(String name) {
        boolean flag = false;
        List<WebElement> allContactsNames = findElementsBase(getAllContactsNames);
        if(!allContactsNames.isEmpty()){
            for (WebElement el: allContactsNames){
                if (getTextBaseByElement(el).equals(name)){
                    flag = true;
                   return flag;
                }
            }
        }else {
            System.out.println("List is empty");
            return false;
        }
        return flag;
    }

    public void deleteAllContacts() {
        while (!findElementsBase(getAllContactsNames).isEmpty())
        {
            WebElement element = findElementBase(getAllContactsNames);
            clickBaseByElement(element);
            clickBase(btnRemoveContact);
            pause(1500);
        }
   /*     List<WebElement> allContactsNames = findElementsBase(getllContactsNames);
        if(!allContactsNames.isEmpty()){
            for (WebElement el: allContactsNames){
                    pause(1500);
                    clickBaseByElement(el);
                    clickBase(btnRemoveContact);
                }
        }else {
            System.out.println("List is empty");
        } */
    }

    public boolean isContactListEmpty() {
        List<WebElement> allContactsNames = findElementsBase(getAllContactsNames);
        return allContactsNames.isEmpty();
    }
}
