package dad.misamigos.controllers;

import dad.misamigos.model.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Button photoView;

    @FXML
    private GridPane root;

    @FXML
    private VBox emptyBox;

    public FriendController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ModificarView.fxml"));
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
        if (ov != null){
            surnameText.textProperty().bindBidirectional(ov.usernameProperty());
            nameText.textProperty().bindBidirectional(ov.nameProperty());
            phoneText.textProperty().bindBidirectional(ov.phoneNumerProperty());
            emailText.textProperty().bindBidirectional(ov.emailProperty());
            birthDatePicker.valueProperty().bindBidirectional(ov.birthDateProperty());
        }

        if (nv != null){
            nameText.textProperty().bindBidirectional(nv.nameProperty());
            surnameText.textProperty().bindBidirectional(nv.usernameProperty());
            birthDatePicker.valueProperty().bindBidirectional(nv.birthDateProperty());
            phoneText.textProperty().bindBidirectional(nv.phoneNumerProperty());
            emailText.textProperty().bindBidirectional(nv.emailProperty());

        }

    }

    @FXML
    void onPhotoAction(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar foto: ");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagen", "*.png","*.jpg","*.jpeg"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Todos los archivos", "*.*"));
        File imageFilter = fileChooser.showOpenDialog(getRoot().getScene().getWindow());
        if (imageFilter != null) {
            Image photo = new Image(imageFilter.toURI().toString());
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

    public DatePicker getBirthDatePicker() {
        return birthDatePicker;
    }

    public void setBirthDatePicker(DatePicker birthDatePicker) {
        this.birthDatePicker = birthDatePicker;
    }

    public TextField getEmailText() {
        return emailText;
    }

    public void setEmailText(TextField emailText) {
        this.emailText = emailText;
    }

    public TextField getNameText() {
        return nameText;
    }

    public void setNameText(TextField nameText) {
        this.nameText = nameText;
    }

    public TextField getPhoneText() {
        return phoneText;
    }

    public void setPhoneText(TextField phoneText) {
        this.phoneText = phoneText;
    }

    public TextField getSurnameText() {
        return surnameText;
    }

    public void setSurnameText(TextField surnameText) {
        this.surnameText = surnameText;
    }

    public void setRoot(GridPane root) {
        this.root = root;
    }

    public VBox getEmptyBox() {
        return emptyBox;
    }

    public void setEmptyBox(VBox emptyBox) {
        this.emptyBox = emptyBox;
    }

    public Button getPhotoView() {
        return photoView;
    }

    public void setPhotoView(Button photoView) {
        this.photoView = photoView;
    }


}
