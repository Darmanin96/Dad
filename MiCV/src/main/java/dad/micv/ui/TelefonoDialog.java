/*package dad.micv.ui;

import javafx.beans.property.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class TelefonoDialog extends Dialog<Telefono> implements Initializable {


    private StringProperty numero = new SimpleStringProperty();
    private final ObjectProperty<TipoTelefono> tipo = new SimpleObjectProperty<Telefono>();

    @FXML
    private TextField numeroText;

    @FXML
    private GridPane root;

    @FXML
    private ComboBox<TipoTelefono> tipoCombo;


    public TelefonoDialog() {
        super();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/TelefonoDialogView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTitle("Nuevo Telefono");
        setHeaderText("Introduzca el nuevo número de teléfono");
        getDialogPane().setContent(root);
        getDialogPane().getButtonTypes().setAll(
                new ButtonType("Crear", ButtonBar.ButtonData.OK_DONE), ButtonType.CANCEL
        );

        setResultConverter(this::onResult);
        numero.bind(numeroText.textProperty());
        tipo.bind(tipoCombo.getSelectionModel().selectedItemProperty());

        tipoCombo.getItems().setAll(TipoTelefono.values());


    }

    private Telefono onResult(ButtonType buttonType){
        if (buttonType.getButtonData() == ButtonBar.ButtonData.OK_DONE){
            Telefono telefono = new Telefono();
            telefono.setNumero(numero.get());
            telefono.setTipo(tipo.get());
            return telefono;
        }
        return null;

    }
}*/
