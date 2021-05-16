import org.junit.Test;
import utils.PathUtils;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class PathUtilTest {
    @Test
    public void pathUtilShouldGetCorrectPath() {
        assertEquals(PathUtils.getDataDir(), Paths.get(System.getProperty("user.home"), "Contactmanager"));
    }
}
