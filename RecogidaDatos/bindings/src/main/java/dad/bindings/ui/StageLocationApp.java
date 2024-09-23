package dad.bindings.ui;


import javafx.application.Application;
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

        StringBinding x = stage.xProperty().asString();
        StringBinding y = stage.yProperty().asString();
        StringBinding width = stage.widthProperty().asString();
        StringBinding height = stage.heightProperty().asString();

        coordsLabel = new Label();
        coordsLabel.textProperty().bind(x
                .concat(", ").concat(", "));
        sizeLabel = new Label();
        sizeLabel.textProperty().bind(x
                .concat(", ").concat(", "));
        VBox root = new VBox();
        root.setSpacing(5);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(sizeLabel, coordsLabel);
        Scene scene = new Scene(root,640,480);
        stage.setTitle("Mouestara");
        stage.setScene(scene);
        stage.show();



    }
}
