package Pestañas;

import dad.gesaula.ui.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.util.*;

public class AlumnoController implements Initializable {

    @FXML
    private Tab Alumn;

    @FXML
    private Button Delete;

    @FXML
    private Tab Group;

    @FXML
    private TextField NameFichero;

    @FXML
    private Button New;

    @FXML
    private Button Save;

    @FXML
    private TabPane TabAlumn;

    @FXML
    private BorderPane root;

    @FXML
    private TableView<Alumno> alumnoTableView;
    @FXML
    private TableColumn<Alumno, String> nombreColumn;
    @FXML
    private TableColumn<Alumno, String> apellidosColumn;
    @FXML
    private TableColumn<Alumno, LocalDate> fechaNacimientoColumn;

    private ObservableList<Alumno> alumnos; // Lista de alumnos

    public AlumnoController() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AlumnView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        alumnos = FXCollections.observableArrayList();
        alumnoTableView.setItems(alumnos);
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        apellidosColumn.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());
        fechaNacimientoColumn.setCellValueFactory(cellData -> cellData.getValue().fechaNacimientoProperty());
    }

    @FXML
    void onNewAction(ActionEvent event) {
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setNombre("Sin nombre");
        nuevoAlumno.setApellidos("Sin apellidos");
        nuevoAlumno.setFechaNacimiento(LocalDate.now());
        alumnos.add(nuevoAlumno);
    }

    @FXML
    void NombreFichero(ActionEvent event) {

    }

    @FXML
    void onAlumnChanged(ActionEvent event) {

    }

    @FXML
    void onDeleteAction(ActionEvent event) {
        Alumno selectedAlumno = alumnoTableView.getSelectionModel().getSelectedItem();
        if (selectedAlumno != null) {
            alumnos.remove(selectedAlumno);
        }
    }

    @FXML
    void onGroupChange(ActionEvent event) {

    }

    @FXML
    void onSaveAction(MouseEvent event) {

    }
}
