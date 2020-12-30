package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.data.Contact;
import project.data.ContactData;

import java.io.IOException;

public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("appmainwindow.fxml"));
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        primaryStage.setTitle("My Contacts");
        primaryStage.setScene(new Scene(root, 600, 375));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    /*@Override
    public void init() {
        ContactData.getInstance().loadContacts();
    }*/

   /* @Override
    public void stop(){
        ContactData.getInstance().storeContacts();
    }*/
}
