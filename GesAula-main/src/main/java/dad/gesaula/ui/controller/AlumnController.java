package dad.gesaula.ui.controller;

import dad.gesaula.ui.model.Alumno;
import dad.gesaula.ui.model.Sexo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.util.StringConverter;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class AlumnController implements Initializable {



    @FXML
    private TableColumn<Alumno, String> Apellidos;

    @FXML
    private Button Eliminar;

    @FXML
    private TableColumn<Alumno, String> Nombre;

    @FXML
    private Button Nuevo;

    @FXML
    private TableColumn<Alumno, Boolean> Repite;

    @FXML
    private TableColumn<Alumno, LocalDate> fechaNacimiento;

    @FXML
    private BorderPane root;

    @FXML
    private TableColumn<Alumno, String> sexoColumn;

    @FXML
    private TableView<Alumno> tableAlumn;

    @FXML
    private AnchorPane detallePanel;


    private ObservableList<Alumno> alumnosList = FXCollections.observableArrayList();

    @FXML
    void onEliminarAction(ActionEvent event) {
        Alumno selected = tableAlumn.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminar Alumno");
            alert.setHeaderText("Se elimina el alumno" + selected.getNombre());
            alert.setContentText("Estas seguro?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                alumnosList.remove(selected);
            }
        }
    }

    @FXML
    void onNewAction(ActionEvent event) {
        Alumno alumno = new Alumno();
        alumno.setNombre("Sin nombre");
        alumno.setApellidos("Sin apellidos");
        alumno.setFechaNacimiento(null);
        alumno.setRepite(false);
        alumno.setSexo(null);
        alumnosList.add(alumno);

    }


    public void cargar(Alumno alumnoSeleccionado) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/SelectedView.fxml"));
            Pane pane = fxmlLoader.load();
            SelectedController selectedController = fxmlLoader.getController();
            selectedController.obtenerAlumno(alumnoSeleccionado);
            detallePanel.getChildren().clear();
            detallePanel.getChildren().add(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableAlumn.setItems(alumnosList);
        Nombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        Apellidos.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());
        fechaNacimiento.setCellValueFactory(cellData -> cellData.getValue().fechaNacimientoProperty());
        Repite.setCellValueFactory(cellData -> cellData.getValue().repiteProperty());
        tableAlumn.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            detallePanel.setVisible(newValue != null);
            if (newValue != null) {
                cargar(newValue);
            }
        });


    }



    public TableColumn<Alumno, String> getApellidos() {
        return Apellidos;
    }

    public void setApellidos(TableColumn<Alumno, String> apellidos) {
        Apellidos = apellidos;
    }

    public Button getEliminar() {
        return Eliminar;
    }

    public void setEliminar(Button eliminar) {
        Eliminar = eliminar;
    }

    public TableColumn<Alumno, String> getNombre() {
        return Nombre;
    }

    public void setNombre(TableColumn<Alumno, String> nombre) {
        Nombre = nombre;
    }

    public Button getNuevo() {
        return Nuevo;
    }

    public void setNuevo(Button nuevo) {
        Nuevo = nuevo;
    }

    public TableColumn<Alumno, Boolean> getRepite() {
        return Repite;
    }

    public void setRepite(TableColumn<Alumno, Boolean> repite) {
        Repite = repite;
    }

    public TableColumn<Alumno, LocalDate> getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(TableColumn<Alumno, LocalDate> fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public TableColumn<Alumno, String> getSexoColumn() {
        return sexoColumn;
    }

    public void setSexoColumn(TableColumn<Alumno, String> sexoColumn) {
        this.sexoColumn = sexoColumn;
    }

    public TableView<Alumno> getTableAlumn() {
        return tableAlumn;
    }

    public void setTableAlumn(TableView<Alumno> tableAlumn) {
        this.tableAlumn = tableAlumn;
    }

    public AnchorPane getDetallePanel() {
        return detallePanel;
    }

    public void setDetallePanel(AnchorPane detallePanel) {
        this.detallePanel = detallePanel;
    }

    public ObservableList<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(ObservableList<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }
}
