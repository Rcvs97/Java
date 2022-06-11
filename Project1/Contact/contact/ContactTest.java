package contact;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;


public class ContactTest {
    

    @Test
    public void testConstructor()
    {
        Contact contact = new Contact("1", "Brad", "Pitt", "123 Street 1", "1552087955");
        assertTrue(contact != null);
        assertTrue(contact.getContactId().equals("1"));
        assertTrue(contact.getFirstName().equals("Brad"));
        assertTrue(contact.getLastName().equals("Pitt"));
        assertTrue(contact.getAddress().equals("123 Street 1"));
        assertTrue(contact.getPhoneNumber().equals("1552087955"));
        
    }
    
    @Test
    public void testConstructorInputsTooLong()
    {
        // test that any input with a length greater than 10 is not accepted
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Contact("11111111111", "Brad", "Pitt", "123 Street 1", "15520");
          });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Contact("12345", "Bradddddddd", "Pitt", "123 Street 1", "15520");
          });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Contact("12345", "Brad", "Pittttttttt", "123 Street 1", "15520");
          });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Contact("12345", "Brad", "Pitt", "123 Street 1256 Zip 8546", "15520");
          });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Contact("12345", "Brad", "Pitt", "123 Street 1", "155208745896");
          });
    }
    
    @Test
    public void testConstructorInputsTooShort()
    {
        // test that any input with a length greater than 10 is not accepted
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Contact("", "Brad", "Pitt", "123 Street 1", "15520");
          });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Contact("12345", "", "Pitt", "123 Street 1", "15520");
          });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Contact("12345", "Brad", "", "123 Street 1", "15520");
          });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Contact("12345", "Brad", "Pitt", "", "15520");
          });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Contact("12345", "Brad", "Pitt", "123 Street 1", "");
          });
    }
    
    @Test
    public void testSetPhoneNumberMustBeDigits()
    {
        // this test checks that the phone number is formed only by digits
        Contact contact = new Contact("12345", "Brad", "Pitt", "123 Street 1", "1234567890");	
	assertFalse(contact.setPhoneNumber("125458aa96"));
    }
    
    @Test
    public void testSetPhoneNumberTooLong()
    {
        // this method check if the phone number is too long
        Contact contact = new Contact("12345", "Brad", "Pitt", "123 Street 1", "1234567890");	
	assertFalse(contact.setPhoneNumber("11111111111"));
    }
    
    @Test
    public void testSetPhoneNumberTooShort()
    {
        // this method check if the phone number is too long
        Contact contact = new Contact("12345", "Brad", "Pitt", "123 Street 1", "1234567890");	
	assertFalse(contact.setPhoneNumber("123"));
    }
    
    @Test
    public void testSetContactFirstNameTooLong()
    {
        // this method check if the phone number is too long
        Contact contact = new Contact("12345", "Brad", "Pitt", "123 Street 1", "1234567890");	
	assertFalse(contact.setContactFirstName("Albus Percival Wulfric Brian"));
    }
    
    @Test
    public void testSetContactLastNameTooLong()
    {
        // this method check if the phone number is too long
        Contact contact = new Contact("12345", "Brad", "Pitt", "123 Street 1", "1234567890");	
	assertFalse(contact.setContactLasttName("Wormtail Voldemort"));
    }
    
    @Test
    public void testSetAddressTooLong()
    {
        // this method check if the phone number is too long
        Contact contact = new Contact("12345", "Brad", "Pitt", "123 Street 1", "1234567890");	
	assertFalse(contact.setAddress("Street 10, Av. 2, Building A-5, Floor 8, Door 9B"));
    }

    
    
    
}
