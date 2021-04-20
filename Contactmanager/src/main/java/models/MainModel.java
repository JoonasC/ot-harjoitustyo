package models;

import dataModels.Contact;
import views.MainView;

import java.util.HashSet;
import java.util.Set;

public class MainModel extends Model<MainView> {
    private String loggedInUsername = "";
    private Set<Contact> contacts = new HashSet<>();

    public String getLoggedInUsername() {
        return loggedInUsername;
    }

    public void setLoggedInUsername(String loggedInUsername) {
        this.loggedInUsername = loggedInUsername;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public boolean addContact(Contact contact) {
        return contacts.add(contact);
    }

    public boolean removeContact(Contact contact) {
        return contacts.remove(contact);
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
}
