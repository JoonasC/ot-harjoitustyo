import controllers.LoginController;
import models.LoginModel;
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

public class LoginTest {
    private LoginController controller;
    private LoginModel model;

    @BeforeClass
    public static void environmentSetUp() throws IOException {
        PathUtils.ensureDataDirExists();
    }

    @Before
    public void setUp() {
        controller = new LoginController();
        model = new LoginModel();
        controller.setModel(model);

        model.mock();
    }

    @Test
    public void loggingInWithAWrongUsernameShouldWorkAsExpected() {
        controller.login("t");
        assertEquals(model.getErrorMessage(), "Wrong username");
    }

    @Test
    public void loggingInWithACorrectUsernameShouldWorkAsExpected() throws IOException {
        Path testUserPath = Paths.get(PathUtils.getDataDir().toString(), "test");

        Files.createDirectory(testUserPath);

        controller.login("test");
        assertEquals(model.getErrorMessage(), "");
        assertTrue(model.isLoggedIn());

        Files.delete(testUserPath);
    }
}
