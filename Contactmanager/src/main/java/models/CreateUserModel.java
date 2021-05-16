package models;

import views.CreateUserView;

/**
 * Model for the create user page
 * @author Joonas Coatanea
 */
public class CreateUserModel extends Model<CreateUserView> {
    private boolean userCreated = false;
    private String errorMessage = "";

    /**
     * Checks if a user was created
     * @return A boolean indicating whether a user was created
     */
    public boolean isUserCreated() {
        return userCreated;
    }

    /**
     * Sets the status of a user having been created
     * @param userCreated The boolean indicating whether a user was created
     */
    public void setUserCreated(boolean userCreated) {
        this.userCreated = userCreated;
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
