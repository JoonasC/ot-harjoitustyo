package controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataModels.Contact;
import dialogs.ContactDialog;
import javafx.scene.control.Alert;
import models.MainModel;
import utils.PathUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;

/**
 * Controller for the main page
 *
 * @author Joonas Coatanea
 */
public class MainController extends Controller<MainModel> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Contact mockContact;
    private Contact mockEditContact;

    /**
     * Sets mock mode to true, which will prevent this controller from opening JavaFX dialogs. As dialogs cannot be
     * opened, a mock contact for adding/removing contacts and a mock edit contact for editing contacts will also be set
     * will also be set
     *
     * @param mockContact     A mock contact for adding/removing contacts
     * @param mockEditContact A mock edit contact for editing contacts
     */
    public void mock(Contact mockContact, Contact mockEditContact) {
        super.mock();
        this.mockContact = mockContact;
        this.mockEditContact = mockEditContact;
    }

    /**
     * Saves contacts
     *
     * @throws IOException
     */
    private void saveContacts() throws IOException {
        objectMapper.writeValue(Paths.get(PathUtils.getDataDir().toString(), model.getLoggedInUsername(), "contacts.json").toFile(), model.getContacts());
    }

    /**
     * Loads saved contact
     *
     * @throws IOException
     */
    public void loadContacts() throws IOException {
        if (!Paths.get(PathUtils.getDataDir().toString(), model.getLoggedInUsername(), "contacts.json").toFile().exists()) {
            Files.createFile(Paths.get(PathUtils.getDataDir().toString(), model.getLoggedInUsername(), "contacts.json"));
            FileWriter fileWriter = new FileWriter(Paths.get(PathUtils.getDataDir().toString(), model.getLoggedInUsername(), "contacts.json").toString());
            fileWriter.write("[]");
            fileWriter.close();
        }

        Set<Contact> loadedContacts = objectMapper
                .readValue(
                        Paths.get(
                                PathUtils.getDataDir().toString(),
                                model.getLoggedInUsername(), "contacts.json").toFile(), new TypeReference<>() {
                        }
                );
        model.setContacts(loadedContacts);
    }

    /**
     * Adds a new contact
     *
     * @throws IOException
     */
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

    /**
     * Edits a contact
     *
     * @param contact The contact to edit
     * @throws IOException
     */
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

    /**
     * Removes a contact
     *
     * @param contact The contact to remove
     * @throws IOException
     */
    public void removeContact(Contact contact) throws IOException {
        model.removeContact(contact);
        saveContacts();
        model.renderView();
    }

    /**
     * Resets model state
     */
    public void exit() {
        model.setLoggedInUsername("");
        model.getContacts().clear();
    }
}
