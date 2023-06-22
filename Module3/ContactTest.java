package Module3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testContactCreation() {
        // Verify that the contact ID is required and cannot be longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Jane", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Jane", "Doe", "1234567890", "123 Main St"));

        // Verify that the first name is required and cannot be longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "JaneJaneJan", "Doe", "1234567890", "123 Main St"));

        // Verify that the last name is required and cannot be longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Jane", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Jane", "DoeDoeDoeDoe", "1234567890", "123 Main St"));

        // Verify that the phone number is required and must be exactly 10 digits
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Jane", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Jane", "Doe", "123456789", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Jane", "Doe", "12345678901", "123 Main St"));

        // Verify that the address is required and cannot be longer than 30 characters
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Jane", "Doe", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Jane", "Doe", "1234567890", "1234567890123456789012345678901"));

        // Verify that a contact can be created with valid inputs
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Main St");

        assertEquals("1234567890", contact.getContactId());
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }
    
    @Test
    public void testValidContactCreation() {
        // Create a contact with valid arguments
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Main St");

        // Verify the contact object is created successfully
        assertNotNull(contact);
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }


    @Test
    public void testContactSetterMethods() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        contact.setFirstName("Michael");
        assertEquals("Michael", contact.getFirstName());

        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        contact.setPhone("9876543210");
        assertEquals("9876543210", contact.getPhone());

        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }



}
    
   
