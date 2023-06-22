package Module3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }


    @Test
    public void testAddContact() {
        ContactService contactService = new ContactService();
        assertEquals(0, contactService.getContactsCount());

        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        assertEquals(1, contactService.getContactsCount());
        assertNotNull(contactService.getContact("1234567890"));
    }

    @Test
    public void testDeleteNonExistentContact() {
        ContactService contactService = new ContactService();
        assertEquals(0, contactService.getContactsCount());

        // Delete a contact that doesn't exist
        assertDoesNotThrow(() -> contactService.deleteContact("Contact doesn't exist."));

        assertEquals(0, contactService.getContactsCount());
    }

    
    @Test
    public void testAddContactWithDuplicateId() {
        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Jane", "Smith", "9876543210", "456 Elm St");

        // Add the first contact
        contactService.addContact(contact1);
        assertEquals(1, contactService.getContactsCount());

        // Adding a contact with duplicate ID should throw an exception
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
    }

    @Test
    public void testUpdateContactFirstName() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContact("1234567890", "firstName", "Michael");

        assertEquals("Michael", contact.getFirstName());
    }
    @Test
    public void testGetContactNotFound() {
        Contact retrievedContact = contactService.getContact("nonexistent");
        assertNull(retrievedContact);
    }
    @Test
    public void testGetContactFound() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Contact retrievedContact = contactService.getContact("1234567890");
        assertNotNull(retrievedContact);
        assertEquals(contact.getContactId(), retrievedContact.getContactId());
        assertEquals(contact.getFirstName(), retrievedContact.getFirstName());
        assertEquals(contact.getLastName(), retrievedContact.getLastName());
        assertEquals(contact.getPhone(), retrievedContact.getPhone());
        assertEquals(contact.getAddress(), retrievedContact.getAddress());
    }


    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Delete the contact
        contactService.deleteContact("1234567890");
        assertEquals(0, contactService.getContactsCount());

        // Ensure the contact is no longer retrievable
        assertNull(contactService.getContact("1234567890"));
    }

    @Test
    public void testUpdateContactLastName() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContact("1234567890", "lastName", "Smith");

        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testUpdateContactPhone() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContact("1234567890", "phone", "9876543210");

        assertEquals("9876543210", contact.getPhone());
    }

    @Test
    public void testUpdateContactAddress() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContact("1234567890", "address", "456 Elm St");

        assertEquals("456 Elm St", contact.getAddress());
    }
    @Test
    public void testUpdateContactFields() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Update the contact fields
        contactService.updateContact("1234567890", "firstName", "Jane");
        contactService.updateContact("1234567890", "lastName", "Smith");
        contactService.updateContact("1234567890", "phone", "9876543210");
        contactService.updateContact("1234567890", "address", "456 Elm St");

        // Verify the updated contact fields
        Contact updatedContact = contactService.getContact("1234567890");
        assertNotNull(updatedContact);
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }


    @Test
    public void testUpdateContactInvalidField() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Ensure an IllegalArgumentException is thrown when updating with an invalid field
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContact("1234567890", "invalidField", "value"));

        // Ensure the contact remains unchanged
        Contact retrievedContact = contactService.getContact("1234567890");
        assertNotNull(retrievedContact);
        assertEquals("John", retrievedContact.getFirstName());
        assertEquals("Doe", retrievedContact.getLastName());
        assertEquals("1234567890", retrievedContact.getPhone());
        assertEquals("123 Main St", retrievedContact.getAddress());
    }
}
