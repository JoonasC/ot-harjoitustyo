package dialogs;

import dataModels.Contact;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ContactDialog extends Dialog<Contact> {
    private final TextField nameTextField;
    private final TextField phoneNumberTextField;
    private final TextField emailTextField;

    public ContactDialog(Contact contact) {
        nameTextField = new TextField();
        phoneNumberTextField = new TextField();
        emailTextField = new TextField();
        VBox mainContainer = new VBox(
                new Label("Name"),
                nameTextField,
                new Label("Phone number"),
                phoneNumberTextField,
                new Label("Email"),
                emailTextField
        );
        mainContainer.setSpacing(2);
        mainContainer.setPadding(new Insets(10));

        DialogPane dialogPane = getDialogPane();

        ButtonType buttonType;
        if (contact != null) {
            setTitle("Contactmanager - Edit contact");
            buttonType = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);

            nameTextField.setText(contact.getName());
            phoneNumberTextField.setText(contact.getPhoneNumber());
            emailTextField.setText(contact.getEmail());
        } else {
            setTitle("Contactmanager - Add contact");
            buttonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        }

        dialogPane.getButtonTypes().addAll(buttonType, ButtonType.CANCEL);
        dialogPane.setContent(mainContainer);

        setResultConverter(callbackButtonType -> {
            if (callbackButtonType == buttonType) {
                return new Contact(nameTextField.getText(), phoneNumberTextField.getText(), emailTextField.getText());
            }

            return null;
        });
    }
}
