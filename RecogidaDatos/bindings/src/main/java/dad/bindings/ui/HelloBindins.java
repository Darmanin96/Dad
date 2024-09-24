package dad.bindings.ui;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloBindins extends Application {

    private TextField nameText;
    private Label gretingLabel;
    private CheckBox hasNameCheck;


    @Override
    public void start(Stage stage) throws Exception {
        nameText = new TextField();
        nameText.setPromptText("Introducir nombre: ");

        gretingLabel = new Label();

        hasNameCheck = new CheckBox("Hay nombre?");

        VBox root = new VBox(5);
        root.setFillWidth(false);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(nameText, gretingLabel, hasNameCheck);
        Scene scene = new Scene(root,640,480);
        stage.setTitle("Hola Bildins");
        stage.setScene(scene);
        stage.show();

        gretingLabel.textProperty().bind(
                Bindings.concat("¡¡¡Hola: " ,
                        Bindings.when(nameText.textProperty().isEmpty())
                                        .then("a todo el mundo").
                                otherwise(nameText.textProperty()),
                        " !!!!" )
        );
        hasNameCheck.selectedProperty().bind(nameText.textProperty().isNotEmpty());
    }
}
