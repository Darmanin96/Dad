package org.example;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import org.apache.commons.mail.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class VerController implements Initializable {

    @FXML
    private Button Cancel;

    @FXML
    private Button Conect;

    @FXML
    private TextField Password;

    @FXML
    private TextField Puerto;

    @FXML
    private TextField Server;

    @FXML
    private TextField User;

    @FXML
    private GridPane root;

    @FXML
    void onCancelAction(ActionEvent event) {

    }

    @FXML
    void onConectAction(ActionEvent event) {
        try {
            SimpleEmail email = new SimpleEmail();
            email.setHostName("");
            email.setSmtpPort(Integer.parseInt(Puerto.getText()));

        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public VerController() {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Guardar.fxml"));
        fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
