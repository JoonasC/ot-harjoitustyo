package views;

import controllers.MainController;
import dataModels.Contact;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.MainModel;
import routing.Router;

import java.io.IOException;
import java.util.Map;

/**
 * View for main page
 *
 * @author Joonas Coatanea
 */
public class MainView extends View<MainController, MainModel> {
    private final TableView<Contact> table;
    private final Scene scene;

    @SuppressWarnings("unchecked")
    public MainView(Router router) {
        super(router);

        Button addContactButton = new Button("Add contact");
        Button editContactButton = new Button("Edit contact");
        Button removeContactButton = new Button("Remove contact");
        Button logoutButton = new Button("Logout");
        HBox buttonContainer = new HBox(
                addContactButton,
                editContactButton,
                removeContactButton,
                logoutButton
        );
        buttonContainer.setSpacing(2);
        TableColumn<Contact, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Contact, String> phoneNumberColumn = new TableColumn<>("Phone number");
        TableColumn<Contact, String> emailColumn = new TableColumn<>("Email");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        table = new TableView<>();
        table.getColumns().addAll(nameColumn, phoneNumberColumn, emailColumn);
        VBox mainContainer = new VBox(
                buttonContainer,
                table
        );
        mainContainer.setSpacing(2);
        mainContainer.setPadding(new Insets(10));
        scene = new Scene(
                mainContainer
        );

        addContactButton.setOnMouseClicked(event -> {
            try {
                controller.addContact();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        });
        editContactButton.setOnMouseClicked(event -> {
            try {
                controller.editContact(table.getSelectionModel().getSelectedItem());
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        });
        removeContactButton.setOnMouseClicked(event -> {
            try {
                controller.removeContact(table.getSelectionModel().getSelectedItem());
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        });
        logoutButton.setOnMouseClicked(event -> {
            controller.exit();
            render();
            router.navigateTo(LoginView.class, Map.of("loggedOut", true));
        });
    }

    @Override
    public String getWindowTitleSuffix() {
        return "Contacts";
    }

    @Override
    public int getWindowWidth() {
        return 800;
    }

    @Override
    public int getWindowHeight() {
        return 485;
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void onNavigateTo(Map<String, Object> arguments) {
        model.setLoggedInUsername((String) arguments.get("loggedInUsername"));

        try {
            controller.loadContacts();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void render() {
        table.getItems().setAll(model.getContacts());
    }
}
