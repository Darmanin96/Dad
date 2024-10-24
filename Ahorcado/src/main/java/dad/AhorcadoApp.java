package dad;

import dad.controllers.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;

public class AhorcadoApp  extends Application {

    private PartidaController partidaController = new PartidaController();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ahorcado");
        primaryStage.setScene(new Scene(partidaController.getRoot()));
        primaryStage.show();

    }
}
