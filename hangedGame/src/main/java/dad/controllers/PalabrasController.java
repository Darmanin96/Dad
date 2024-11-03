package dad.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PalabrasController {

    @FXML
    private ListView<String> wordListView;

    @FXML
    private TextField newWordInput;

    @FXML
    private void addWord() {
        String word = newWordInput.getText();
        if (!word.isEmpty()) {
            wordListView.getItems().add(word);
            newWordInput.clear();
        }
    }

    @FXML
    private void removeWord() {
        String selectedWord = wordListView.getSelectionModel().getSelectedItem();
        if (selectedWord != null) {
            wordListView.getItems().remove(selectedWord);
        }
    }
}
