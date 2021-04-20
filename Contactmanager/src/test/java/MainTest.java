import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.MainController;
import dataModels.Contact;
import models.MainModel;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.PathUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import static org.junit.Assert.*;

// Aika loppui vähän kesken testien tekemiseen...
public class MainTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Contact mockContact = new Contact("test", "+358401587852", "test@test.com");

    private MainController controller;
    private MainModel model;

    @BeforeClass
    public static void environmentSetup() throws IOException {
        PathUtils.ensureDataDirExists();
        Files.createDirectories(Paths.get(PathUtils.getDataDir().toString(), "test"));
    }

    @AfterClass
    public static void environmentTeardown() throws IOException {
        Files.deleteIfExists(Paths.get(PathUtils.getDataDir().toString(), "test"));
    }

    @Before
    public void setUp() {
        controller = new MainController();
        model = new MainModel();
        controller.setModel(model);
        model.setLoggedInUsername("test");

        controller.mock(mockContact);
    }

    @Test
    public void creatingContactsShouldWorkAsExpected() throws IOException {
        controller.addContact();

        // assertArrayEquals(model.getContacts(), Set.of(mockContact));
    }
}
