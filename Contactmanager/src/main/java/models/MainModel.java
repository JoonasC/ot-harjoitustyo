package models;

import dataModels.Contact;
import views.MainView;

import java.util.HashSet;
import java.util.Set;

/**
 * Model for the main page
 */
public class MainModel extends Model<MainView> {
    private String loggedInUsername = "";
    private Set<Contact> contacts = new HashSet<>();

    /**
     * Gets the username of the logged in user
     * @return The username of the logged in user
     */
    public String getLoggedInUsername() {
        return loggedInUsername;
    }

    /**
     * Sets the username of the logged in user
     * @param loggedInUsername The username of the logged in user
     */
    public void setLoggedInUsername(String loggedInUsername) {
        this.loggedInUsername = loggedInUsername;
    }

    /**
     * Gets the contacts
     * @return A set of contacts
     */
    public Set<Contact> getContacts() {
        return contacts;
    }

    /**
     * Adds a contact
     * @param contact The contact to add
     * @return A boolean indicating whether the contact was added
     */
    public boolean addContact(Contact contact) {
        return contacts.add(contact);
    }

    /**
     * Removes a contact
     * @param contact The contact to remove
     * @return A boolean indicating whether the contact was removed
     */
    public boolean removeContact(Contact contact) {
        return contacts.remove(contact);
    }

    /**
     * Sets the contacts
     * @param contacts A set of contacts to set
     */
    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
}
