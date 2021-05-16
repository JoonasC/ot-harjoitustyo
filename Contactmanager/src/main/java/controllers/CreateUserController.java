package controllers;

import models.CreateUserModel;
import utils.PathUtils;
import utils.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Controller for the create user page
 *
 * @author Joonas Coatanea
 */
public class CreateUserController extends Controller<CreateUserModel> {
    /**
     * Creates a user with a given username
     *
     * @param username The username of the user to create
     * @throws IOException
     */
    public void createUser(String username) throws IOException {
        if (ValidationUtils.validateUsername(username)) {
            if (!Paths.get(PathUtils.getDataDir().toString(), username).toFile().exists() && !username.isEmpty()) {
                Files.createDirectory(Paths.get(PathUtils.getDataDir().toString(), username));
                model.setUserCreated(true);
                model.setErrorMessage("");
            } else {
                model.setUserCreated(false);
                model.setErrorMessage("Username is already taken");
            }
        } else {
            model.setUserCreated(false);
            model.setErrorMessage("Please verify that your username is valid (allowed characters: a-z, ö, ä, 0-9, minimum length: 2 and maximum length: 15)");
        }

        model.renderView();
    }

    /**
     * Resets model state
     */
    public void exit() {
        model.setUserCreated(false);
        model.setErrorMessage("");
    }
}
