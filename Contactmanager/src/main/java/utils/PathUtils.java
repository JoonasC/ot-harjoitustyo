package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A class that contains utilities for getting the path of the data directory and dealing with the data directory in
 * general
 *
 * @author Joonas Coatanea
 */
public class PathUtils {
    /**
     * Gets the path of the data directory
     *
     * @return The path of the data directory
     */
    public static Path getDataDir() {
        if (System.getenv("contactmanager-datadir") != null) {
            return Paths.get(System.getenv("contactmanager-datadir"));
        }

        return Paths.get(System.getProperty("user.home"), "Contactmanager");
    }

    /**
     * Ensures that the data directory exists
     *
     * @throws IOException
     */
    public static void ensureDataDirExists() throws IOException {
        Files.createDirectories(getDataDir());
    }
}
