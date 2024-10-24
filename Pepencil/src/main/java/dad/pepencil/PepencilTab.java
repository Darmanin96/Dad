package dad.pepencil;

import dad.pepencil.controllers.*;
import javafx.scene.control.*;

public class PepencilTab extends Tab {
    private final EditorController controller;


    public PepencilTab(){
        super();
        controller = new EditorController();
        setContent(controller.getRoot());
        textProperty().bind(controller.nameProperty());
    }

    public EditorController getController(){
        return controller;
    }
}
