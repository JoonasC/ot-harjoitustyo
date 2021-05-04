package controllers;

import models.CreateUserModel;
import utils.PathUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateUserController extends Controller<CreateUserModel> {
    public void createUser(String username) throws IOException {
        if (!Paths.get(PathUtils.getDataDir().toString(), username).toFile().exists() && !username.isEmpty()) {
            Files.createDirectory(Paths.get(PathUtils.getDataDir().toString(), username));
            model.setUserCreated(true);
            model.setErrorMessage("");
        } else {
            model.setUserCreated(false);
            model.setErrorMessage("Username is taken");
        }

        model.renderView();
    }

    public void exit() {
        model.setUserCreated(false);
        model.setErrorMessage("");
    }
}
