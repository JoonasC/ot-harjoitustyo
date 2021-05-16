package models;

import views.LoginView;

/**
 * Model for the login page
 * @author Joonas Coatanea
 */
public class LoginModel extends Model<LoginView> {
    private boolean loggedIn = false;
    private String loggedInUsername = "";
    private String errorMessage = "";

    /**
     * Checks whether a user is logged in
     * @return A boolean indicating whether a user is logged in
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * Sets the status of a user being logged in
     * @param loggedIn The boolean indicating whether a user is logged in
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     * Gets the username of the logged in user
     * @return The username of the logged in user
     */
    public String getLoggedInUsername() {
        return loggedInUsername;
    }

    /**
     * Sets the username of the logged in user
     * @param loggedInUsername The username of the logged in user
     */
    public void setLoggedInUsername(String loggedInUsername) {
        this.loggedInUsername = loggedInUsername;
    }

    /**
     * Gets the error message
     * @return The error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the error message
     * @param errorMessage The error message
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
