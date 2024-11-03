package org.example;

import javafx.fxml.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class SecundariaVentana implements Initializable {


    @FXML
    private AnchorPane root;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public SecundariaVentana(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/VentanaSecundariaç.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AnchorPane getRoot() {
        return root;
    }

    public void setRoot(AnchorPane root) {
        this.root = root;
    }
}
