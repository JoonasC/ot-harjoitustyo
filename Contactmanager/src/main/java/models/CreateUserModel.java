package models;

import views.CreateUserView;

public class CreateUserModel extends Model<CreateUserView> {
    private boolean userCreated = false;
    private String errorMessage = "";

    public boolean isUserCreated() {
        return userCreated;
    }

    public void setUserCreated(boolean userCreated) {
        this.userCreated = userCreated;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
