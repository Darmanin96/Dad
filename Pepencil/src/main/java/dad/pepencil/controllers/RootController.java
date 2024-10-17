package dad.pepencil.controllers;

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
    private MapProperty<Tab,EditorController> controllers = new SimpleMapProperty<>(FXCollections.observableHashMap());


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
        EditorController editorController = new EditorController();
        Tab newTab = new Tab();
        newTab.setContent(editorController.getRoot());
        editionTabPane.getTabs().add(newTab);
        controllers.put(newTab,editorController);
        editionTabPane.getSelectionModel().select(newTab);
        return editorController;

    }

    @FXML
    void onCutAction(MouseEvent event) {
        controllers.get(selectedTab.get()).cut();
    }

    @FXML
    void onCopyAction(ActionEvent event) {
        controllers.get(selectedTab.get()).copy();
    }


    @FXML
    void onOpenAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.*"));
        File file = fileChooser.showOpenDialog(root.getScene().getWindow());
        if(file != null){
            EditorController controller = newFile();
            controller.setFile(file);
        }
    }


    @FXML
    void onSaveAction(ActionEvent event) {
        Tab seleTab = editionTabPane.getSelectionModel().getSelectedItem();
        EditorController controller = controllers.get(seleTab);

    }

    @FXML
    void onSaveCommonAction(ActionEvent event) {

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

    public void setRoot(BorderPane root) {
        this.root = root;
    }

}
