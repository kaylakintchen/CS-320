package Module3;
import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contact> contacts;

    public ContactService() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        validateUniqueContactId(contact.getContactId());
        contacts.add(contact);
    }

    public void deleteContact(String contactId) {
        contacts.removeIf(contact -> contact.getContactId().equals(contactId));
    }

    public void updateContact(String contactId, String field, String value) {
        Contact contact = getContact(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }

        switch (field) {
            case "firstName":
                contact.setFirstName(value);
                break;
            case "lastName":
                contact.setLastName(value);
                break;
            case "phone":
                contact.setPhone(value);
                break;
            case "address":
                contact.setAddress(value);
                break;
            default:
                throw new IllegalArgumentException("Invalid field for update: " + field);
        }
    }
    public int getContactsCount() {
        return contacts.size();
    }

    public Contact getContact(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }

    private void validateUniqueContactId(String contactId) {
        if (getContact(contactId) != null) {
            throw new IllegalArgumentException("Contact with the same ID already exists.");
        }
    }
}
