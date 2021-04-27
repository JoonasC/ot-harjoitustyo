import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.MainController;
import dataModels.Contact;
import models.MainModel;
import org.junit.*;
import utils.PathUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Contact mockContact = new Contact("test", "+358401587852", "test@test.com");
    private final Contact mockEditContact = new Contact("testEdit", "+358401587852", "testEdit@test.com");

    private MainController controller;
    private MainModel model;

    @BeforeClass
    public static void environmentSetup() throws IOException {
        PathUtils.ensureDataDirExists();
        Files.createDirectories(Paths.get(PathUtils.getDataDir().toString(), "test"));
    }

    @AfterClass
    public static void environmentTeardown() throws IOException {
        Files.delete(Paths.get(PathUtils.getDataDir().toString(), "test"));
    }

    @Before
    public void setUp() {
        controller = new MainController();
        model = new MainModel();
        controller.setModel(model);
        model.setLoggedInUsername("test");

        controller.mock(mockContact, mockEditContact);
        model.mock();
    }

    @After
    public void tearDown() throws IOException {
        Files.delete(Paths.get(PathUtils.getDataDir().toString(), "test", "contacts.json"));
    }

    @Test
    public void loadingContactsShouldWorkAsExpected() throws IOException {
        objectMapper.writeValue(Paths.get(PathUtils.getDataDir().toString(), "test", "contacts.json").toFile(), Set.of(mockContact));

        controller.loadContacts();

        assertArrayEquals(new Contact[]{mockContact}, model.getContacts().toArray());
    }

    @Test
    public void creatingContactsShouldWorkAsExpected() throws IOException {
        controller.addContact();

        assertArrayEquals(new Contact[]{mockContact}, model.getContacts().toArray());

        Set<Contact> loadedContacts = objectMapper
                .readValue(
                        Paths.get(
                                PathUtils.getDataDir().toString(),
                                "test", "contacts.json").toFile(), new TypeReference<>() {
                        }
                );
        assertArrayEquals(new Contact[]{mockContact}, loadedContacts.toArray());
    }

    @Test
    public void editingContactsShouldWorkAsExpected() throws IOException {
        controller.addContact();

        controller.editContact(mockContact);

        assertArrayEquals(new Contact[]{mockEditContact}, model.getContacts().toArray());

        Set<Contact> loadedContacts = objectMapper
                .readValue(
                        Paths.get(
                                PathUtils.getDataDir().toString(),
                                "test", "contacts.json").toFile(), new TypeReference<>() {
                        }
                );
        assertArrayEquals(new Contact[]{mockEditContact}, loadedContacts.toArray());
    }

    @Test
    public void removingContactsShouldWorkAsExpected() throws IOException {
        controller.addContact();

        controller.removeContact(mockContact);

        assertTrue(model.getContacts().isEmpty());

        Set<Contact> loadedContacts = objectMapper
                .readValue(
                        Paths.get(
                                PathUtils.getDataDir().toString(),
                                "test", "contacts.json").toFile(), new TypeReference<>() {
                        }
                );
        assertTrue(loadedContacts.isEmpty());
    }
}
