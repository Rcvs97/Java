package contact;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;


public class ContactServiceTest {
    
    private static ContactService service =  ContactService.getService();
    
    
    @Test
    public void addContact()
    {
        Contact contact = new Contact("1", "Brad", "Pitt", "123 Street 1", "1552087955");	
        assertTrue(service.addContact(contact));
        
        Contact contact2 = service.getContact("1");

        assertTrue(contact2 != null);
        assertTrue(contact2.getContactId().equals("1"));
        assertTrue(contact2.getFirstName().equals("Brad"));
        assertTrue(contact2.getLastName().equals("Pitt"));
        assertTrue(contact2.getAddress().equals("123 Street 1"));
        assertTrue(contact2.getPhoneNumber().equals("1552087955"));
    }
    
    @Test
    public void testRemoveContact()
    {
        Contact contact = new Contact("1", "Brad", "Pitt", "123 Street 1", "1552087955");	
        service.addContact(contact);
        assertTrue(service.deleteContact("1"));
    }
    
    @Test
    public void testAddMultipleContacts()
    {
        
        Contact contact1 = new Contact("10", "Brad", "Pitt", "123 Street 1", "1552087955");
        Contact contact2 = new Contact("20", "Mariah", "Hill", "155 Street 2", "1554585546");
        Contact contact3 = new Contact("30", "John", "Hancock", "155 Street 3", "1556955546");
        
        assertTrue(service.addContact(contact1));
        assertTrue(service.addContact(contact2));
        assertTrue(service.addContact(contact3));
    }
    
    @Test
    public void testRepeatedId()
    {
        Contact contact1 = new Contact("155", "Brad", "Pitt", "123 Street 1", "1552087955");
        Contact contact2 = new Contact("155", "Mariah", "Hill", "155 Street 2", "1552087955");
        
        assertTrue(service.addContact(contact1));
        assertFalse(service.addContact(contact2));
    }
    
    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("1558", "Brad", "Pitt", "123 Street 1", "1552087955");
        service.addContact(contact);
        Contact contact2 = service.getContact("1558");

        contact2.setContactFirstName("Charles");
        contact2 = service.getContact("1558");
        assertTrue(contact2.getFirstName().equals("Charles"));

    }
    
    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("1668", "Brad", "Pitt", "123 Street 1", "1552087955");
        service.addContact(contact);
        Contact contact2 = service.getContact("1668");

        contact2.setContactLasttName("Jhonson");
        contact2 = service.getContact("1668");
        assertTrue(contact2.getLastName().equals("Jhonson"));

    }
    
    @Test
    public void testUpdatePhoneNumber() {
        Contact contact = new Contact("1578", "Brad", "Pitt", "123 Street 1", "1552087955");
        service.addContact(contact);
        Contact contact2 = service.getContact("1578");

        contact2.setPhoneNumber("1234567898");
        contact2 = service.getContact("1578");
        assertTrue(contact2.getPhoneNumber().equals("1234567898"));

    }
    
    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("1588", "Brad", "Pitt", "123 Street 1", "1552087955");
        service.addContact(contact);
        Contact contact2 = service.getContact("1588");

        contact2.setAddress("Winston Av. 3B");
        contact2 = service.getContact("1588");
        assertTrue(contact2.getAddress().equals("Winston Av. 3B"));

    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1559", "John", "Wick", "123 Street 1", "1552087955");
        service.addContact(contact);
        assertTrue(service.deleteContact("1559"));
        assertTrue(service.getContact("1559") == null);
    }

    @Test
    public void testDeleteUnexistingContact() {
        System.out.println(service.deleteContact("654654"));
    }
    
}
