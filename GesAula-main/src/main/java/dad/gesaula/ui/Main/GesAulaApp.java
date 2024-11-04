package dad.gesaula.ui.Main;

import Pestañas.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;

public class GesAulaApp  extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        YourController root = new YourController();
        Stage window = new Stage();
        window.setTitle("GesAula");
        window.setScene(new Scene(root.getRoot()));
        window.show();
    }
}
