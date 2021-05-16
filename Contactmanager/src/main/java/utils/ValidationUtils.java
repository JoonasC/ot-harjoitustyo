package utils;

/**
 * A class that contains utilities to validate user input
 *
 * @author Joonas Coatanea
 */
public class ValidationUtils {
    /**
     * Validates that a username contains only the characters a-z, 0-9, ö and ä, and that the username's length is
     * between (inclusive) 2 and 15 characters
     *
     * @param username The username string to validate
     * @return A boolean indicating whether the username is valid
     */
    public static boolean validateUsername(String username) {
        return username.matches("[A-Za-z0-9öä]{2,15}");
    }

    /**
     * Validates that a contact's name contains only the characters a-z, ö and ä, and that the name is in a
     * FIRSTNAME[SPACE]LASTNAME pattern
     *
     * @param name The name string to validate
     * @return A boolean indicating whether the name is valid
     */
    public static boolean validateName(String name) {
        return name.matches("[A-Za-zöä]+ [A-Za-zöä]+");
    }

    /**
     * Validates that a contact's email address contains only the characters a-z, 0-9, . and _, and that the email address is in a
     * ADDRESS@DOMAIN.TLD pattern
     *
     * @param email The email address string to validate
     * @return A boolean indicating whether the email address is valid
     */
    public static boolean validateEmail(String email) {
        return email.matches("[A-Za-z0-9._]+@[A-Za-z0-9]+\\.[A-Za-z]+");
    }

    /**
     * Validates that a contact's phone number is valid
     *
     * @param phoneNumber The phone number string to validate
     * @return A boolean indicating whether the phone number is valid
     */
    public static boolean validatePhoneNumber(String phoneNumber) {
        // Regex taken from https://ihateregex.io/expr/phone/
        return phoneNumber.matches("[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}");
    }
}
