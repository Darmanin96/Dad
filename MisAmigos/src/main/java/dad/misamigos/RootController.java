package dad.misamigos;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
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

import javax.script.Bindings;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {


    private final  ListProperty<Friend> friends = new SimpleListProperty<>(FXCollections.observableArrayList(
            friend -> new Observable[] { friend.nameProperty(), friend.usernameProperty() }
    ));
    private  final ObjectProperty<Friend> selectedFriend = new SimpleObjectProperty<>();


    @FXML
    private Button enemyButtom;

    @FXML
    private Button friendButtom;

    @FXML
    private ListView<Friend> friendList;

    @FXML
    private VBox emptybox;

    @FXML
    private VBox friendController;


    @FXML
    private BorderPane root;

    public RootController(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ModificarView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BorderPane getRoot(){
        return root;
    }

    public VBox getEmptybox(){
        return emptybox;
    }

    public VBox getFriendController(){
        return friendController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
                friendList.itemsProperty().bind(friends);
                selectedFriend.bind(friendList.getSelectionModel().selectedItemProperty());
                enemyButtom.disableProperty().bind(selectedFriend.isNull());
                selectedFriend.addListener(this::onSelectedFriendChanged);
                friendController.friendProperty.bind(selectedFriend);

    }

    private void onSelectedFriendChanged(ObservableValue<? extends Friend> o, Friend ov, Friend nv) {
        if (nv ==  null){
            root.setCenter(emptybox);
        }else {
            root.setCenter(friendController);
        }
    }

    @FXML
    void onEnemyAction(ActionEvent event) {
            friends.remove(selectedFriend.get());
    }

    public ObservableList<Friend> getFriends() {
        return friends.get();
    }

    public ListProperty<Friend> friendsProperty() {
        return friends;
    }

    public Friend getSelectedFriend() {
        return selectedFriend.get();
    }

    public ObjectProperty<Friend> selectedFriendProperty() {
        return selectedFriend;
    }

    public Button getEnemyButtom() {
        return enemyButtom;
    }

    public void setEnemyButtom(Button enemyButtom) {
        this.enemyButtom = enemyButtom;
    }

    public Button getFriendButtom() {
        return friendButtom;
    }

    public void setFriendButtom(Button friendButtom) {
        this.friendButtom = friendButtom;
    }

    public ListView<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(ListView<Friend> friendList) {
        this.friendList = friendList;
    }

    public void setEmptybox(VBox emptybox) {
        this.emptybox = emptybox;
    }

    public void setFriendController(VBox friendController) {
        this.friendController = friendController;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    @FXML
    void onFriendAction(ActionEvent event) {
        Friend friend = new Friend();
        friend.setName("Nombre");
        friend.setUsername("Apellidos");
        friends.add(friend);
        friendList.getSelectionModel().select(friend);





    }
}
