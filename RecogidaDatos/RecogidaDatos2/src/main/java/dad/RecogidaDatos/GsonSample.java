package dad.RecogidaDatos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GsonSample extends Application {
    private TextField nombreTexto;
    private Button guardarButton;
    private Button limpiarButton;
    private TextField apellidosText;
    private TextField edadText;


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Recogida Datos");
        nombreTexto = new TextField();
        nombreTexto.setPromptText("Nombre");
        apellidosText = new TextField();
        apellidosText.setPromptText("Apellidos");
        edadText = new TextField();
        edadText.setPromptText("Edad");
        guardarButton = new Button("Guardar");
        guardarButton.setDefaultButton(true);
        limpiarButton = new Button("Limpiar");
        limpiarButton.setAlignment(Pos.BOTTOM_LEFT);
        guardarButton.setAlignment(Pos.BOTTOM_RIGHT);
        VBox vbox = new VBox();
        HBox hBox = new HBox();
        vbox.getChildren().addAll(hBox,nombreTexto, apellidosText, edadText, limpiarButton,guardarButton);
        vbox.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(vbox, 800,600));
        stage.show();
    }
}
