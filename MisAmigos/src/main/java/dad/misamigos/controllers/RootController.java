package dad.misamigos.controllers;

import dad.misamigos.model.*;
import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    private final ListProperty<Friend> friends = new SimpleListProperty<>(FXCollections.observableArrayList(
            friend -> new Observable[]{friend.nameProperty(), friend.usernameProperty()}
    ));
    private final ObjectProperty<Friend> selectedFriend = new SimpleObjectProperty<>();

    @FXML
    private Button enemyButton;

    @FXML
    private Button friendButton;

    @FXML
    private ListView<Friend> friendList;

    @FXML
    private VBox emptyBox;

    @FXML
    private VBox friendControllerBox;

    @FXML
    private BorderPane root;

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BorderPane getRoot() {
        return root;
    }

    public ObservableList<Friend> getFriends() {
        return friends.get();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        friendList.itemsProperty().bind(friends);
        selectedFriend.bind(friendList.getSelectionModel().selectedItemProperty());
        enemyButton.disableProperty().bind(selectedFriend.isNull());
        selectedFriend.addListener((_, ov, nv) -> {
            if (nv != null) {

            }
        });
    }

    @FXML
    void onAddFriendAction(ActionEvent event) {
        friends.add(new Friend());
    }

    @FXML
    void onRemoveFriendAction(ActionEvent event) {
        friends.remove(selectedFriend.get());

    void onFriendAction(ActionEvent event) {
        Friend friend = new Friend();
        friend.setName("Nombre");
        friend.setUsername("Apellidos");
        friends.add(friend);
        friendList.getSelectionModel().select(friend);

    }
}
