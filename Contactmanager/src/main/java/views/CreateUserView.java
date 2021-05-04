package views;

import controllers.CreateUserController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import models.CreateUserModel;
import routing.Router;

import java.io.IOException;
import java.util.Map;

public class CreateUserView extends View<CreateUserController, CreateUserModel> {
    private final Label errorLabel;
    private final TextField usernameTextField;
    private final Scene scene;

    public CreateUserView(Router router) {
        super(router);

        errorLabel = new Label();
        errorLabel.setVisible(false);
        errorLabel.setTextFill(Color.RED);
        Label usernameLabel = new Label("Username");
        usernameTextField = new TextField();
        Button createUserButton = new Button("Create user");
        Button cancelButton = new Button("Cancel");
        HBox createUserButtonContainer = new HBox(
                createUserButton
        );
        createUserButtonContainer.setAlignment(Pos.CENTER);
        HBox cancelButtonContainer = new HBox(
                cancelButton
        );
        cancelButtonContainer.setAlignment(Pos.CENTER);
        VBox mainContainer = new VBox(
                errorLabel,
                usernameLabel,
                usernameTextField,
                createUserButtonContainer,
                cancelButtonContainer
        );
        mainContainer.setSpacing(2);
        mainContainer.setPadding(new Insets(10));
        scene = new Scene(
                mainContainer
        );

        createUserButton.setOnMouseClicked(event -> {
            try {
                controller.createUser(usernameTextField.getText());
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        });
        cancelButton.setOnMouseClicked(event -> {
            controller.exit();
            usernameTextField.clear();
            render();
            router.navigateTo(LoginView.class, Map.of());
        });
    }

    @Override
    public String getWindowTitleSuffix() {
        return "Create user";
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
    }

    @Override
    public void render() {
        errorLabel.setText(model.getErrorMessage());
        errorLabel.setVisible(!model.getErrorMessage().isEmpty());

        if (model.isUserCreated()) {
            controller.exit();
            usernameTextField.clear();

            router.navigateTo(LoginView.class, Map.of());
        }
    }
}
