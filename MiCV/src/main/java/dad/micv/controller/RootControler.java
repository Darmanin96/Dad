package dad.micv.controller;

import javafx.application.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class RootControler implements Initializable {

    @FXML
    private Tab Conocimientos;

    @FXML
    private Tab Contacto;

    @FXML
    private MenuItem Exit;

    @FXML
    private Tab Experiencia;

    @FXML
    private Tab Formacion;

    @FXML
    private MenuItem New;

    @FXML
    private MenuItem Open;

    @FXML
    private Tab Personal;

    @FXML
    private MenuItem Save;

    @FXML
    private MenuItem saveAs;

    @FXML
    private BorderPane root;

    @FXML
    void onActionExit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Estás seguro?");
        alert.setContentText("Estás seguro que desea salir?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Platform.exit();
            }
        });

    }

    @FXML
    void onActionOpen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Todos los archivos", "*.*");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(root.getScene().getWindow());
        if (file != null) {
            System.out.println("Archivo seleccionado: " + file.getAbsolutePath());
            try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @FXML
    void onActionSave(ActionEvent event) {

    }

    @FXML
    void onNewAction(ActionEvent event) {

    }

    @FXML
    void onSaveAsAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public RootControler(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MainControllerView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Tab getConocimientos() {
        return Conocimientos;
    }

    public void setConocimientos(Tab conocimientos) {
        Conocimientos = conocimientos;
    }

    public Tab getContacto() {
        return Contacto;
    }

    public void setContacto(Tab contacto) {
        Contacto = contacto;
    }

    public MenuItem getExit() {
        return Exit;
    }

    public void setExit(MenuItem exit) {
        Exit = exit;
    }

    public Tab getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(Tab experiencia) {
        Experiencia = experiencia;
    }

    public Tab getFormacion() {
        return Formacion;
    }

    public void setFormacion(Tab formacion) {
        Formacion = formacion;
    }

    public MenuItem getNew() {
        return New;
    }

    public void setNew(MenuItem aNew) {
        New = aNew;
    }

    public MenuItem getOpen() {
        return Open;
    }

    public void setOpen(MenuItem open) {
        Open = open;
    }

    public Tab getPersonal() {
        return Personal;
    }

    public void setPersonal(Tab personal) {
        Personal = personal;
    }

    public MenuItem getSave() {
        return Save;
    }

    public void setSave(MenuItem save) {
        Save = save;
    }

    public MenuItem getSaveAs() {
        return saveAs;
    }

    public void setSaveAs(MenuItem saveAs) {
        this.saveAs = saveAs;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }
}
