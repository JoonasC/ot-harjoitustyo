package controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataModels.Contact;
import dialogs.ContactDialog;
import javafx.scene.control.Alert;
import models.MainModel;
import utils.PathUtils;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;

public class MainController extends Controller<MainModel> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Contact mockContact;
    private Contact mockEditContact;

    public void mock(Contact mockContact, Contact mockEditContact) {
        super.mock();
        this.mockContact = mockContact;
        this.mockEditContact = mockEditContact;
    }

    private void saveContacts() throws IOException {
        objectMapper.writeValue(Paths.get(PathUtils.getDataDir().toString(), model.getLoggedInUsername(), "contacts.json").toFile(), model.getContacts());
    }

    public void loadContacts() throws IOException {
        Set<Contact> loadedContacts = objectMapper
                .readValue(
                        Paths.get(
                                PathUtils.getDataDir().toString(),
                                model.getLoggedInUsername(), "contacts.json").toFile(), new TypeReference<>() {
                        }
                );
        model.setContacts(loadedContacts);
    }

    public void addContact() throws IOException {
        Optional<Contact> newContact;
        if (!mock) {
            ContactDialog contactDialog = new ContactDialog(null);
            newContact = contactDialog.showAndWait();
        } else {
            newContact = Optional.of(mockContact);
        }

        if (newContact.isPresent()) {
            if (model.addContact(newContact.get())) {
                saveContacts();
                model.renderView();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "This contact already exists");
                alert.showAndWait();
            }
        }
    }

    public void editContact(Contact contact) throws IOException {
        Optional<Contact> newContact;
        if (!mock) {
            ContactDialog contactDialog = new ContactDialog(contact);
            newContact = contactDialog.showAndWait();
        } else {
            newContact = Optional.of(mockEditContact);
        }

        if (newContact.isPresent()) {
            model.removeContact(contact);
            model.addContact(newContact.get());
            saveContacts();
            model.renderView();
        }
    }

    public void removeContact(Contact contact) throws IOException {
        model.removeContact(contact);
        saveContacts();
        model.renderView();
    }

    public void exit() {
        model.setLoggedInUsername("");
        model.getContacts().clear();
    }
}
