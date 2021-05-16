package controllers;

import models.LoginModel;
import utils.PathUtils;
import utils.ValidationUtils;

import java.io.File;
import java.nio.file.Paths;

/**
 * Controller for the login page
 *
 * @author Joonas Coatanea
 */
public class LoginController extends Controller<LoginModel> {
    /**
     * Logs a user in by username
     *
     * @param username Username of the user to login
     */
    public void login(String username) {
        File userDataDir = Paths.get(PathUtils.getDataDir().toString(), username).toFile();
        if (userDataDir.exists() && userDataDir.isDirectory() && !username.isEmpty() && ValidationUtils.validateUsername(username)) {
            model.setLoggedIn(true);
            model.setLoggedInUsername(username);
            model.setErrorMessage("");
        } else {
            model.setLoggedIn(false);
            model.setLoggedInUsername("");
            model.setErrorMessage("Wrong username");
        }

        model.renderView();
    }

    /**
     * Logs a user out
     */
    public void logout() {
        model.setLoggedIn(false);
        model.setLoggedInUsername("");
        model.setErrorMessage("");
        model.renderView();
    }

    /**
     * Resets model state
     */
    public void exit() {
        model.setErrorMessage("");
    }
}
