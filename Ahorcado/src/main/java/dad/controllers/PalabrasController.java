package dad.controllers;

import javafx.fxml.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class PalabrasController implements Initializable {



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private GridPane root;

    public PalabrasController(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/PalabrasView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





    public GridPane getRoot() {
        return root;
    }

    public void setRoot(GridPane root) {
        this.root = root;
    }
}
