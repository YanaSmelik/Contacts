package project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.data.Contact;
import project.data.ContactData;

public class DialogController {
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField notesTextField;
    @FXML
    private Button cancelButton;


    private FXMLLoader fxmlLoader;

    public DialogController() {
    }

    public Contact parseData() {
        String firstName = firstNameTextField.getText().trim();
        String lastName = lastNameTextField.getText().trim();
        String phoneNumber = phoneNumberTextField.getText().trim();
        String notes = notesTextField.getText().trim();
        Contact contact = new Contact(firstName, lastName, phoneNumber, notes);
        ContactData.getInstance().getContacts().add(contact);
        return contact;
    }

    @FXML
    public void handleSavePressed() {
        ContactData.getInstance().addContact(parseData());
    }

    @FXML
    public void handleCancelPressed(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
