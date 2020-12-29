package project;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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

    public DialogController() {
    }

    public Contact parseData(){
        String firstName = firstNameTextField.getText().trim();
        String lastName = lastNameTextField.getText().trim();
        String phoneNumber = phoneNumberTextField.getText().trim();
        String notes = notesTextField.getText().trim();
        Contact contact = new Contact(firstName, lastName, phoneNumber, notes);
        ContactData.getInstance().getContacts().add(contact);
        return contact;
    }
}
