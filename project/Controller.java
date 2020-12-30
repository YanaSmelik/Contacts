package project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import project.data.Contact;
import project.data.ContactData;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    private TableView<Contact> contactsTableView;
    @FXML
    private GridPane mainPane;
    @FXML
    private MenuItem deleteMenuItem;
    @FXML
    private MenuItem editMenuItem;
    @FXML
    private MenuItem addMenuItem;
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;

    private FXMLLoader fxmlLoader;


    public void initialize() {
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Contact contact = contactsTableView.getSelectionModel().getSelectedItem();
                ContactData.getInstance().deleteContact(contact);
            }
        });
        editMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Contact contact = contactsTableView.getSelectionModel().getSelectedItem();
                ContactData.getInstance().editContact(contact);
            }
        });
        addMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayAddContactDialog();
            }
        });
    }

    public void displayAddContactDialog() {
        Dialog<Button> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Add Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addcontactdialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Optional<Button> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == saveButton) {
            DialogController controller = fxmlLoader.getController();
            Contact contact = controller.parseData();
            ContactData.getInstance().addContact(contact);
            contactsTableView.getSelectionModel().select(contact);
        }
    }


}
