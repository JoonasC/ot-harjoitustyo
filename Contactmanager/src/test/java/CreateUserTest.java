import controllers.CreateUserController;
import models.CreateUserModel;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.PathUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateUserTest {
    private CreateUserController controller;
    private CreateUserModel model;

    @BeforeClass
    public static void environmentSetUp() throws IOException {
        PathUtils.ensureDataDirExists();
    }

    @Before
    public void setUp() {
        controller = new CreateUserController();
        model = new CreateUserModel();
        controller.setModel(model);

        controller.mock();
        model.mock();
    }

    @After
    public void tearDown() throws IOException {
        Files.delete(Paths.get(PathUtils.getDataDir().toString(), "test"));
    }

    @Test
    public void creatingAUserWithAUsernameThatIsAlreadyTakenShouldWorkAsExpected() throws IOException {
        Path testUserPath = Paths.get(PathUtils.getDataDir().toString(), "test");

        Files.createDirectory(testUserPath);

        controller.createUser("test");
        assertEquals(model.getErrorMessage(), "Username is already taken");
    }

    @Test
    public void creatingAUserWithAUsernameThatIsNotAlreadyTakenShouldWorkAsExpected() throws IOException {
        controller.createUser("test");

        assertEquals(model.getErrorMessage(), "");
        assertTrue(model.isUserCreated());
        assertTrue(Paths.get(PathUtils.getDataDir().toString(), "test").toFile().exists());
    }
}
