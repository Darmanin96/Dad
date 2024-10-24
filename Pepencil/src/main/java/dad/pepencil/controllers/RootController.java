package dad.pepencil.controllers;

import dad.pepencil.*;
import javafx.beans.property.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class RootController implements Initializable {


    private ObjectProperty<Tab> selectedTab = new SimpleObjectProperty<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        editionTabPane.getTabs().clear();
        newFile();
        selectedTab.bind(editionTabPane.getSelectionModel().selectedItemProperty());

    }

    public RootController(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    private TabPane editionTabPane;

    @FXML
    private BorderPane root;

    @FXML
    void onNewAction(ActionEvent event) {
        newFile();
    }

    private EditorController newFile(){
        PepencilTab newTab = new PepencilTab();
        editionTabPane.getTabs().add(newTab);
        editionTabPane.getSelectionModel().select(newTab);
        return newTab.getController();

    }

    @FXML
    void onCutAction(MouseEvent event) {
        getSelectedEditor().cut();
    }

    @FXML
    void onPasteAction(ActionEvent event) {
        getSelectedEditor().paste();
    }

    @FXML
    void onCopyAction(ActionEvent event) {
        getSelectedEditor().copy();
    }


    @FXML
    void onOpenAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.*"));
        File file = fileChooser.showOpenDialog(root.getScene().getWindow());
        if(file != null){
            PepencilTab newTab = new PepencilTab();

        }
    }

    private EditorController getSelectedEditor(){
        return null;
    }


    @FXML
    void onSaveAction(ActionEvent event) {
        if (getSelectedEditor().getFile() != null){
            getSelectedEditor().save();
        }else {
            onSaveAction(event);
        }


    }

    @FXML
    void onSaveCommonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Todos los archivos", "*.*"));
        if (getSelectedEditor().getFile() != null){
           // getSelectedEditor().setFile();
        }
    }





    public TabPane getEditionTabPane() {
        return editionTabPane;
    }

    public void setEditionTabPane(TabPane editionTabPane) {
        this.editionTabPane = editionTabPane;
    }

    public BorderPane getRoot() {
        return root;
    }

    private PepencilTab getSelectedTab() {
        return (PepencilTab) selectedTab.get();
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

}
