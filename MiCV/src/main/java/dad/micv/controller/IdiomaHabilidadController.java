package dad.micv.controller;

import dad.micv.model.adapters.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class IdiomaHabilidadController implements Initializable {

    @FXML
    private TextField denominacion;

    @FXML
    private ChoiceBox<Idioma> nivel;

    @FXML
    private BorderPane root;

    @FXML
    private Button x;

    @FXML
    void onXAction(ActionEvent event) {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public IdiomaHabilidadController() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/IdiomaHabilidadView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextField getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(TextField denominacion) {
        this.denominacion = denominacion;
    }

    public ChoiceBox<Idioma> getNivel() {
        return nivel;
    }

    public void setNivel(ChoiceBox<Idioma> nivel) {
        this.nivel = nivel;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public Button getX() {
        return x;
    }

    public void setX(Button x) {
        this.x = x;
    }
}
