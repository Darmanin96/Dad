package dad.micv.controller;

import dad.micv.model.adapters.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class ConocimientoHabilidadController implements Initializable {

    @FXML
    private Button Cancelar;

    @FXML
    private Button Crear;

    @FXML
    private TextField denominacion;

    @FXML
    private ChoiceBox<String> nivel;

    @FXML
    private BorderPane root;

    @FXML
    private Button x;

    @FXML
    void onCancelarAction(ActionEvent event) {
        cerrar();
    }

    @FXML
    void onCrearAction(ActionEvent event) {
        confirmar = true;
        cerrar();
    }

    @FXML
    void onXAction(ActionEvent event) {
        limpiar();
    }

    private void limpiar(){
        denominacion.setText("");
        nivel.getItems().clear();
    }

    private void cerrar(){
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

    private boolean confirmar = false;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
            nivel.getItems().addAll("Basico","Intermedio","Avanzado");
    }

    public ConocimientoHabilidadController(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ConocimientoHabilidadView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Button getCancelar() {
        return Cancelar;
    }

    public void setCancelar(Button cancelar) {
        Cancelar = cancelar;
    }

    public Button getCrear() {
        return Crear;
    }

    public void setCrear(Button crear) {
        Crear = crear;
    }

    public TextField getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(TextField denominacion) {
        this.denominacion = denominacion;
    }

    public ChoiceBox<String> getNivel() {
        return nivel;
    }

    public void setNivel(ChoiceBox<String> nivel) {
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

    public boolean isConfirmar() {
        return confirmar;
    }

    public void setConfirmar(boolean confirmar) {
        this.confirmar = confirmar;
    }
}
