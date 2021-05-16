package dialogs;

import dataModels.Contact;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import utils.ValidationUtils;

/**
 * A class that implements a popup dialog to add or edit contacts
 *
 * @author Joonas Coatanea
 */
public class ContactDialog extends Dialog<Contact> {
    private final Label errorLabel;
    private final TextField nameTextField;
    private final TextField phoneNumberTextField;
    private final TextField emailTextField;

    public ContactDialog(Contact contact) {
        errorLabel = new Label();
        errorLabel.setVisible(false);
        errorLabel.setTextFill(Color.RED);
        errorLabel.setWrapText(true);
        nameTextField = new TextField();
        phoneNumberTextField = new TextField();
        emailTextField = new TextField();
        VBox mainContainer = new VBox(
                errorLabel,
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
        dialogPane.setMinWidth(400);

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

        dialogPane.lookupButton(buttonType).addEventFilter(ActionEvent.ACTION, event -> {
            if (!ValidationUtils.validateName(nameTextField.getText())) {
                errorLabel.setText("Please verify that the name you entered is valid (allowed characters: a-z, ö and ä)");
                errorLabel.setVisible(true);
                event.consume();
            } else if (!ValidationUtils.validatePhoneNumber(phoneNumberTextField.getText())) {
                errorLabel.setText("Please verify that the phone number you entered is valid");
                errorLabel.setVisible(true);
                event.consume();
            } else if (!ValidationUtils.validateEmail(emailTextField.getText())) {
                errorLabel.setText("Please verify that the email you entered is valid");
                errorLabel.setVisible(true);
                event.consume();
            }
            dialogPane.getScene().getWindow().sizeToScene();
        });

        setResultConverter(callbackButtonType -> {
            if (callbackButtonType == buttonType) {
                return new Contact(nameTextField.getText(), phoneNumberTextField.getText(), emailTextField.getText());
            }

            return null;
        });
    }
}
