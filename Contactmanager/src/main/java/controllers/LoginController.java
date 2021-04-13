package controllers;

import models.LoginModel;
import utils.PathUtils;

import java.nio.file.Paths;

public class LoginController extends Controller<LoginModel> {
    public void login(String username) {
        if (Paths.get(PathUtils.getDataDir().toString(), username).toFile().exists() && !username.isEmpty()) {
            model.setLoggedIn(true);
            model.setErrorMessage("");
        } else {
            model.setLoggedIn(false);
            model.setErrorMessage("Wrong username");
        }

        model.renderView();
    }
}
