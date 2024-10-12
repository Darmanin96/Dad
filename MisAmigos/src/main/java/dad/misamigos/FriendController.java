package dad.misamigos;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FriendController implements Initializable {

    private ObjectProperty<Friend> friend = new SimpleObjectProperty<>();

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private TextField emailText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField phoneText;

    @FXML
    private TextField surnameText;

    @FXML
    private GridPane root;

    @FXML
    private VBox emptyBox;

    public FriendController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FriendView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        friend.addListener(this::onFriendChanged);
    }

    private void onFriendChanged(ObservableValue<? extends Friend> o, Friend ov, Friend nv) {
        if (ov != null) {
            unbindFields(ov);
        }
        if (nv != null) {
            bindFields(nv);
        }
    }

    private void bindFields(Friend friend) {
        surnameText.textProperty().bindBidirectional(friend.usernameProperty());
        nameText.textProperty().bindBidirectional(friend.nameProperty());
        phoneText.textProperty().bindBidirectional(friend.phoneNumberProperty());
        emailText.textProperty().bindBidirectional(friend.emailProperty());
        birthDatePicker.valueProperty().bindBidirectional(friend.birthDateProperty());
    }

    private void unbindFields(Friend friend) {
        surnameText.textProperty().unbindBidirectional(friend.usernameProperty());
        nameText.textProperty().unbindBidirectional(friend.nameProperty());
        phoneText.textProperty().unbindBidirectional(friend.phoneNumberProperty());
        emailText.textProperty().unbindBidirectional(friend.emailProperty());
        birthDatePicker.valueProperty().unbindBidirectional(friend.birthDateProperty());
    }

    @FXML
    void onPhotoAction(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar foto");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Todos los archivos", "*.*"));
        File imageFile = fileChooser.showOpenDialog(root.getScene().getWindow());
        if (imageFile != null) {
            Image photo = new Image(imageFile.toURI().toString());
            friend.get().setPhoto(photo);
        }
    }

    public GridPane getRoot() {
        return root;
    }

    public Friend getFriend() {
        return friend.get();
    }

    public ObjectProperty<Friend> friendProperty() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend.set(friend);
    }
}
