package views;

import controllers.LoginController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import models.LoginModel;
import routing.Router;

public class LoginView extends View<LoginController, LoginModel> {
    private final Label errorLabel;
    private final TextField usernameTextField;
    private final Button loginButton;
    private final Button createUserButton;
    private final Scene scene;

    public LoginView(Router router) {
        super(router);

        errorLabel = new Label();
        errorLabel.setVisible(false);
        errorLabel.setTextFill(Color.RED);
        usernameTextField = new TextField();
        loginButton = new Button("Login");
        createUserButton = new Button("Create user");
        scene = new Scene(
                new VBox(
                        errorLabel,
                        new Label("Username"),
                        usernameTextField,
                        loginButton,
                        createUserButton
                )
        );

        loginButton.setOnMouseClicked(event -> {
            controller.login(usernameTextField.getText());
        });
    }

    @Override
    public String getWindowTitleSuffix() {
        return "Login";
    }

    @Override
    public int getWindowWidth() {
        return 400;
    }

    @Override
    public int getWindowHeight() {
        return 400;
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void render() {
        errorLabel.setText(model.getErrorMessage());
        errorLabel.setVisible(!model.getErrorMessage().isEmpty());

        if (model.isLoggedIn()) {
            usernameTextField.clear();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Login successful");
            alert.show();
            // TODO: Switch to main page
        }
    }
}
