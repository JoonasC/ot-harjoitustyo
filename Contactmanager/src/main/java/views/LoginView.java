package views;

import controllers.LoginController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import models.LoginModel;
import routing.Router;

import java.util.Map;

/**
 * View for the login page
 *
 * @author Joonas Coatanea
 */
public class LoginView extends View<LoginController, LoginModel> {
    private final Label errorLabel;
    private final TextField usernameTextField;
    private final Scene scene;

    public LoginView(Router router) {
        super(router);

        errorLabel = new Label();
        errorLabel.setVisible(false);
        errorLabel.setTextFill(Color.RED);
        Label usernameLabel = new Label("Username");
        usernameTextField = new TextField();
        Button loginButton = new Button("Login");
        Button createUserButton = new Button("Create user");
        HBox loginButtonContainer = new HBox(
                loginButton
        );
        loginButtonContainer.setAlignment(Pos.CENTER);
        HBox createUserButtonContainer = new HBox(
                createUserButton
        );
        createUserButtonContainer.setAlignment(Pos.CENTER);
        VBox mainContainer = new VBox(
                errorLabel,
                usernameLabel,
                usernameTextField,
                loginButtonContainer,
                createUserButtonContainer
        );
        mainContainer.setSpacing(2);
        mainContainer.setPadding(new Insets(10));
        scene = new Scene(
                mainContainer
        );

        loginButton.setOnMouseClicked(event -> controller.login(usernameTextField.getText()));
        createUserButton.setOnMouseClicked(event -> {
            controller.exit();
            usernameTextField.clear();
            render();
            router.navigateTo(CreateUserView.class, Map.of());
        });
    }

    @Override
    public void setModel(LoginModel loginModel) {
        super.setModel(loginModel);
        router.setLoginModel(loginModel);
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
        return 200;
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void onNavigateTo(Map<String, Object> arguments) {
        if (arguments.containsKey("loggedOut")) {
            if ((Boolean) arguments.get("loggedOut")) {
                controller.logout();
            }
        }
    }

    @Override
    public void render() {
        errorLabel.setText(model.getErrorMessage());
        errorLabel.setVisible(!model.getErrorMessage().isEmpty());

        if (model.isLoggedIn()) {
            controller.exit();
            usernameTextField.clear();

            router.navigateTo(MainView.class, Map.of("loggedInUsername", model.getLoggedInUsername()));
        }
    }
}
