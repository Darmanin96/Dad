package dad.bindings.ui;


import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class StageLocationApp extends Application {
    private Label sizeLabel;
    private Label coordsLabel;




    @Override
    public void start(Stage stage) throws Exception {

        StringBinding width = stage.widthProperty().asString();
        StringBinding height = stage.heightProperty().asString();

        coordsLabel = new Label();
        sizeLabel = new Label();
        sizeLabel.textProperty().bind(
                Bindings.concat("Size: ", width, "," , height));
        VBox root = new VBox();
        root.setSpacing(5);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(sizeLabel, coordsLabel);
        Scene scene = new Scene(root,640,480);
        stage.setTitle("Size and location");
        stage.setScene(scene);
        stage.show();

    }
}
