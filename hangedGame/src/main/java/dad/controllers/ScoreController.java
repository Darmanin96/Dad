package dad.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ScoreController {

    @FXML
    private ListView<String> scoreListView;

    public void addScore(String playerName, int score) {
        scoreListView.getItems().add(playerName + ": " + score);
    }
}
