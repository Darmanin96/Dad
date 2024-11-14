package dad.gesaula.ui.controller;

import dad.gesaula.ui.model.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class SelectedController implements Initializable {


    @FXML
    private TextField Apellidos;

    @FXML
    private TextField Nombre;

    @FXML
    private CheckBox Repite;

    @FXML
    private ChoiceBox<Sexo> sexo;

    @FXML
    private DatePicker fechaNacimiento;

    @FXML
    private GridPane root;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sexo.setItems(FXCollections.observableArrayList(Sexo.values()));
    }

    public SelectedController(){

    }

    public void obtenerAlumno(Alumno alumno) {
        if (alumno != null) {
            Nombre.textProperty().bindBidirectional(alumno.nombreProperty());
            Apellidos.textProperty().bindBidirectional(alumno.apellidosProperty());
            fechaNacimiento.valueProperty().bindBidirectional(alumno.fechaNacimientoProperty());
            Repite.selectedProperty().bindBidirectional(alumno.repiteProperty());
            sexo.valueProperty().bindBidirectional(alumno.sexoProperty());
        }
    }


    public TextField getApellidos() {
        return Apellidos;
    }

    public void setApellidos(TextField apellidos) {
        Apellidos = apellidos;
    }

    public TextField getNombre() {
        return Nombre;
    }

    public void setNombre(TextField nombre) {
        Nombre = nombre;
    }

    public CheckBox getRepite() {
        return Repite;
    }

    public void setRepite(CheckBox repite) {
        Repite = repite;
    }

    public ChoiceBox<Sexo> getSexo() {
        return sexo;
    }

    public void setSexo(ChoiceBox<Sexo> sexo) {
        this.sexo = sexo;
    }

    public DatePicker getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(DatePicker fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public GridPane getRoot() {
        return root;
    }

    public void setRoot(GridPane root) {
        this.root = root;
    }
}
