package models;

import views.LoginView;

public class LoginModel extends Model<LoginView> {
    private boolean loggedIn = false;
    private String loggedInUsername = "";
    private String errorMessage = "";

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setLoggedInUsername(String loggedInUsername) {
        this.loggedInUsername = loggedInUsername;
    }

    public String getLoggedInUsername() {
        return loggedInUsername;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
