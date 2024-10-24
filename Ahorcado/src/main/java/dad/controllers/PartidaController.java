package dad.controllers;

import javafx.beans.property.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class PartidaController implements Initializable {

    private ObjectProperty<Tab> selectedTab = new SimpleObjectProperty<>();





    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private Button LetraButton;

    @FXML
    private Button ResolvelButton;

    @FXML
    private Label SecretWord;

    @FXML
    private BorderPane root;

    @FXML
    private TabPane editionTabe;



    public PartidaController(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ViewPartida.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    private Tab Palabra;

    @FXML
    private Tab Partida;

    @FXML
    private Tab Puntuaciones;



    @FXML
    void onLetraAction(ActionEvent event) {

    }

    @FXML
    void onPhotoAction(MouseEvent event) {

    }

    @FXML
    void onPuntuationAction(MouseEvent event) {

    }

    @FXML
    void onResolverAction(ActionEvent event) {

    }

    @FXML
    void onSecretAction(MouseEvent event) {

    }

    @FXML
    void onTextAction(ActionEvent event) {

    }

    public Tab getSelectedTab() {
        return selectedTab.get();
    }

    public ObjectProperty<Tab> selectedTabProperty() {
        return selectedTab;
    }

    public void setSelectedTab(Tab selectedTab) {
        this.selectedTab.set(selectedTab);
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public Label getSecretWord() {
        return SecretWord;
    }

    public void setSecretWord(Label secretWord) {
        SecretWord = secretWord;
    }

    public Button getLetraButton() {
        return LetraButton;
    }

    public void setLetraButton(Button letraButton) {
        LetraButton = letraButton;
    }

    public Button getResolvelButton() {
        return ResolvelButton;
    }

    public void setResolvelButton(Button resolvelButton) {
        ResolvelButton = resolvelButton;
    }

    public TabPane getEditionTabe() {
        return editionTabe;
    }

    public void setEditionTabe(TabPane editionTabe) {
        this.editionTabe = editionTabe;
    }

    public Tab getPalabra() {
        return Palabra;
    }

    public void setPalabra(Tab palabra) {
        Palabra = palabra;
    }

    public Tab getPartida() {
        return Partida;
    }

    public void setPartida(Tab partida) {
        Partida = partida;
    }

    public Tab getPuntuaciones() {
        return Puntuaciones;
    }

    public void setPuntuaciones(Tab puntuaciones) {
        Puntuaciones = puntuaciones;
    }
}
