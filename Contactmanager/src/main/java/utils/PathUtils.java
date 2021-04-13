package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {
    public static Path getDataDir() {
        if (System.getenv("contactmanager-datadir") != null) {
            return Paths.get(System.getenv("contactmanager-datadir"));
        }

        return Paths.get(System.getProperty("user.home"), "Contactmanager");
    }

    public static void ensureDataDirExists() throws IOException {
        Files.createDirectories(getDataDir());
    }
}
