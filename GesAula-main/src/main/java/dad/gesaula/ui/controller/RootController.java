package dad.gesaula.ui.controller;

import dad.gesaula.ui.model.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.time.*;
import java.util.*;

public class RootController implements Initializable {


    @FXML
    private Tab Alumno;

    @FXML
    private Tab Grupo;

    @FXML
    private Button New;

    @FXML
    private Button Save;

    @FXML
    private BorderPane root;

    @FXML
    private TextField Nombre;

    @FXML
    void onNewAction(ActionEvent event) {
        try {
            String archivo = Nombre.getText().trim();
            if (archivo.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Nombre del archivo vacío");
                alert.setContentText("El nombre del archivo está vacío. Por favor, introduce un nombre.");
                alert.showAndWait();
            } else {
                File file = new File(archivo);
                if (file.exists()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("El archivo ya existe");
                    alert.setContentText("El archivo ya existe. Por favor, introduce un nombre diferente.");
                    alert.showAndWait();
                } else {
                    file.createNewFile();
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Hecho");
                        alert.setHeaderText("Se ha creado el archivo");
                        alert.setContentText("EL archivo se ha creado con el nombre de " + Nombre.getText());
                        alert.showAndWait();

                }
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Entrada/Salida");
            alert.setHeaderText("Ocurrió un error al crear el archivo.");
            alert.setContentText("Detalles del error: " + e.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    void onSaveAction(ActionEvent event) {
        String archivo = Nombre.getText().trim();
        if (archivo.isEmpty()) {
            // Alerta si el nombre del archivo está vacío
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Nombre del archivo vacío");
            alert.setContentText("Por favor, introduce un nombre para el archivo.");
            alert.showAndWait();
        } else {
            File file = new File(archivo);
            if (!file.exists()) {
                // Alerta si el archivo no existe
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("El archivo no existe");
                alert.setContentText("Por favor, crea el archivo antes de guardar.");
                alert.showAndWait();
            } else {
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
                    GroupController groupController = new GroupController();
                    AlumnController alumnController = new AlumnController();
                    Alumno alumnoSeleccionado = alumnController.getTableAlumn().getSelectionModel().getSelectedItem();
                    String nombreAlumno = alumnoSeleccionado.getNombre();
                    String apellidosAlumno = alumnoSeleccionado.getApellidos();
                    LocalDate fechaNacimiento = alumnoSeleccionado.getFechaNacimiento();
                    Sexo sexo = alumnoSeleccionado.getSexo();
                    boolean repite = alumnoSeleccionado.isRepite();
                    String denominacion = groupController.getDenominacion().toString();
                    LocalDate inicio = groupController.getFinCurso().getValue();
                    LocalDate fin = groupController.getFinCurso().getValue();
                    String examenes = groupController.getPracticasLabel().toString();
                    String practicas = groupController.getPracticasLabel().toString();
                    String actitud = groupController.getActitudLabel().toString();
                    bufferedWriter.write("Nombre del alumno: " + nombreAlumno);
                    bufferedWriter.newLine();
                    bufferedWriter.write("Apellidos del alumno: " + apellidosAlumno);
                    bufferedWriter.newLine();
                    bufferedWriter.write("Fecha de nacimiento: " + (fechaNacimiento != null ? fechaNacimiento.toString() : "N/A"));
                    bufferedWriter.newLine();
                    bufferedWriter.write("Sexo: " + (sexo != null ? sexo.toString() : "N/A"));
                    bufferedWriter.newLine();
                    bufferedWriter.write("Repite: " + (repite ? "Sí" : "No"));
                    bufferedWriter.newLine();
                    bufferedWriter.write("Denominacion: " + denominacion);
                    bufferedWriter.newLine();
                    bufferedWriter.write("Inicio: " + inicio);
                    bufferedWriter.newLine();
                    bufferedWriter.write("Fin: " + fin);
                    bufferedWriter.newLine();
                    bufferedWriter.write("Examenes: " + examenes);
                    bufferedWriter.newLine();
                    bufferedWriter.write("Practicas: " + practicas);
                    bufferedWriter.newLine();
                    bufferedWriter.write("Actitud: " + actitud);
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Guardado exitoso");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Datos guardados correctamente en " + archivo);
                    successAlert.showAndWait();

                } catch (Exception e) {
                    e.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error de guardado");
                    alert.setHeaderText("No se pudo guardar el archivo");
                    alert.setContentText("Ocurrió un error al intentar guardar el archivo.");
                    alert.showAndWait();
                }
            }
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public RootController(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextField getNombre() {
        return Nombre;
    }

    public void setNombre(TextField nombre) {
        Nombre = nombre;
    }

    public Tab getAlumno() {
        return Alumno;
    }

    public void setAlumno(Tab alumno) {
        Alumno = alumno;
    }

    public Tab getGrupo() {
        return Grupo;
    }

    public void setGrupo(Tab grupo) {
        Grupo = grupo;
    }

    public Button getNew() {
        return New;
    }

    public void setNew(Button aNew) {
        New = aNew;
    }

    public Button getSave() {
        return Save;
    }

    public void setSave(Button save) {
        Save = save;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }
}
