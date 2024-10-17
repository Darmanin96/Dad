package dad.pepencil.controllers;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javax.script.*;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

public class EditorController implements Initializable {

    private final ObjectProperty<File> file = new SimpleObjectProperty<>();
    private final ReadOnlyStringWrapper name = new ReadOnlyStringWrapper("Untitled");
    private final StringProperty content = new SimpleStringProperty();
    private final BooleanProperty hasChanges = new SimpleBooleanProperty();

    @FXML
    private TextArea editArea;

    @FXML
    private AnchorPane root;

    public TextArea getEditArea() {
        return editArea;
    }

    public void setEditArea(TextArea editArea) {
        this.editArea = editArea;
    }

    public AnchorPane getRoot() {
        return root;
    }

    public void setRoot(AnchorPane root) {
        this.root = root;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        file.addListener(this::onFileChanged);

        editArea.textProperty().bindBidirectional(content);

        name.bind(Bindings.createStringBinding(() -> {
                return file.getName() + (hasChanges.get() ? "*" : "");
            }, file,hasChanges)
        );
    }




    private void onFileChanged(Observable o,File ov, File nv){
        open();
    }

    private void on(Observable o,String ov, String nv){
        hasChanges.set(true);
    }

    private String updateName(){
        if (file.get()==null){
            return "Untitled";
        }
        return file.get().getName() + (hasChanges.get() ? "*" : "");
    }

    public void onContentChanged(Observable o,String ov, String nv){
        hasChanges.set(true);
    }


    public void open(){
        try {
            this.content.set(Files.readString(file.get().toPath()));
            this.hasChanges.set(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public EditorController() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/EditorView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void cut() {
        editArea.cut();
    }

    public void paste() {
        editArea.paste();
    }

    public void copy() {
        editArea.copy();
    }
    public void pasteAll() {
        editArea.paste();
    }

    public void undo() {
        editArea.undo();
    }

    public void redo() {
        editArea.redo();
    }

    public File getFile() {
        return file.get();
    }

    public void setFile(File file) {
        this.file.set(file);
    }

    public ObjectProperty<File> fileProperty() {
        return file;
    }

    public String getName() {
        return name.get();
    }

    public ReadOnlyStringProperty nameProperty() {
        return name.getReadOnlyProperty();
    }

}
