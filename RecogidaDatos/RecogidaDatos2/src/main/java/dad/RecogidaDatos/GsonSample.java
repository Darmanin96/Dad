package dad.RecogidaDatos;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;

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
        VBox vbox = new VBox();
        HBox nombreBox = new HBox(10,new Label("Nombre"), nombreTexto);
        nombreBox.setAlignment(Pos.CENTER);
        HBox apellidosBox = new HBox(10,new Label("Apellidos"), apellidosText);
        apellidosBox.setAlignment(Pos.CENTER);
        HBox edadBox = new HBox(10, new Label("Edad: "), edadText);
        limpiarButton.setAlignment(Pos.BOTTOM_LEFT);
        guardarButton.setAlignment(Pos.BOTTOM_RIGHT);
        edadBox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(15,nombreBox,apellidosBox,edadBox,guardarButton,limpiarButton);
        vBox.setAlignment(Pos.CENTER);
        limpiarButton.setOnAction(e -> limpriar());
        guardarButton.setOnAction(e -> guardarDatos());
        stage.setScene(new Scene(vBox, 800,600));
        stage.show();
    }

    private void guardarDatos() {
        String nombre = nombreTexto.getText();
        String apellidos = apellidosText.getText();
        int edad = Integer.parseInt(edadText.getText());
        Persona persona = new Persona(nombre,apellidos,edad);
        Gson gson = new Gson();
        try(FileWriter fileWriter = new FileWriter("datos.json")) {
            gson.toJson(persona,fileWriter);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private void limpriar(){
        nombreTexto.clear();
        apellidosText.clear();
        edadText.clear();
    }
}
