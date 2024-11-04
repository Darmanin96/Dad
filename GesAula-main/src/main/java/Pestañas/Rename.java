package Pestañas;

import dad.gesaula.ui.model.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class Rename implements Initializable {
    @FXML
    private Label ActitudLabel;

    @FXML
    private Label PracticaLabel;

    @FXML
    private Label examenLabel;

    @FXML
    private Tab Alumno;

    @FXML
    private Tab Group;

    @FXML
    private TextField NameFichero;

    @FXML
    private Button New;

    @FXML
    private Button Save;

    @FXML
    private BorderPane root;
    @FXML
    private Slider actitud;

    @FXML
    private TextField denominacion;

    @FXML
    private Slider examen;

    @FXML
    private DatePicker finCurso;

    @FXML
    private DatePicker inicioCurso;

    @FXML
    private Slider practica;

    @FXML
    void onNewAction(ActionEvent event) {
        nuevo();
    }

    @FXML
    void onSaveAction(ActionEvent event) {
            guardar();
    }

    @FXML
    private TabPane TabAlumn;

    @FXML
    void onCangedGroup(ActionEvent event) {
        TabAlumn.getSelectionModel().select(Alumno);
    }

    @FXML
    void onChangedAlumn(ActionEvent event) {
        TabAlumn.getSelectionModel().select(Group);

    }


    public Slider getActitud() {
        return actitud;
    }

    public void setActitud(Slider actitud) {
        this.actitud = actitud;
    }

    public TextField getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(TextField denominacion) {
        this.denominacion = denominacion;
    }

    public Slider getExamen() {
        return examen;
    }

    public void setExamen(Slider examen) {
        this.examen = examen;
    }

    public DatePicker getFinCurso() {
        return finCurso;
    }

    public void setFinCurso(DatePicker finCurso) {
        this.finCurso = finCurso;
    }

    public DatePicker getInicioCurso() {
        return inicioCurso;
    }

    public void setInicioCurso(DatePicker inicioCurso) {
        this.inicioCurso = inicioCurso;
    }

    public Slider getPractica() {
        return practica;
    }

    public void setPractica(Slider practica) {
        this.practica = practica;
    }

    public Tab getAlumno() {
        return Alumno;
    }

    public void setAlumno(Tab alumno) {
        Alumno = alumno;
    }

    public Tab getGroup() {
        return Group;
    }

    public void setGroup(Tab group) {
        Group = group;
    }

    public TextField getNameFichero() {
        return NameFichero;
    }

    public void setNameFichero(TextField nameFichero) {
        NameFichero = nameFichero;
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

    public Label getActitudLabel() {
        return ActitudLabel;
    }

    public void setActitudLabel(Label actitudLabel) {
        ActitudLabel = actitudLabel;
    }

    public Label getPracticaLabel() {
        return PracticaLabel;
    }

    public void setPracticaLabel(Label practicaLabel) {
        PracticaLabel = practicaLabel;
    }

    public Label getExamenLabel() {
        return examenLabel;
    }

    public void setExamenLabel(Label examenLabel) {
        this.examenLabel = examenLabel;
    }

    public TabPane getTabAlumn() {
        return TabAlumn;
    }

    public void setTabAlumn(TabPane tabAlumn) {
        TabAlumn = tabAlumn;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        examen.valueProperty().addListener((obs, oldVal, newVal) -> {
            examenLabel.setText(newVal.toString());
        });
        practica.valueProperty().addListener((obs, oldVal, newVal) -> {
            PracticaLabel.setText(newVal.toString());
        });

        actitud.valueProperty().addListener((obs, oldVal, newVal) -> {
            ActitudLabel.setText(newVal.toString());
        });
    }

    public Rename() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardar() {
        String archivo = NameFichero.getText().trim();
        if (archivo.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingrese un nombre para el archivo.");
            alert.showAndWait();
            return;
        }

        File file = new File(archivo);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write("Denominación: " + denominacion.getText() + "\n");
            bw.write(inicioCurso.getValue().toString() + "\n");
            bw.write(finCurso.getValue().toString() + "\n");
            bw.write(examen.getValue() + "\n");
            bw.write(practica.getValue() + "\n");
            bw.write(actitud.getValue() + "\n");
            Grupo grupo = new Grupo();
            grupo.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void nuevo() {
        String archivo = NameFichero.getText().trim();
        if (archivo.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingrese un nombre para el archivo.");
            alert.showAndWait();
            return;
        }

        File file = new File(archivo);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write("Denominacion: " + denominacion.getText() + "\n");
                bw.write(inicioCurso.getValue().toString() + "\n");
                bw.write(finCurso.getValue().toString() + "\n");
                bw.write(examen.getValue() + "\n");
                bw.write(practica.getValue() + "\n");
                bw.write(actitud.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
