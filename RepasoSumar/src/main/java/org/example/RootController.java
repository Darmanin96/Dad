package org.example;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class RootController implements Initializable {

    @FXML
    private RadioButton Divi;

    @FXML
    private RadioButton Multi;

    @FXML
    private TextField Numero1;

    @FXML
    private TextField Numero2;

    @FXML
    private RadioButton Resta;

    @FXML
    private RadioButton Suma;

    @FXML
    private TextField resultado;

    @FXML
    private AnchorPane root;

    @FXML
    private Button sumarButton;

    private ToggleGroup operationGroup;


    @FXML
    void onSumarAction(ActionEvent event) {
      if (Suma.isSelected()) {
          int op1 = Integer.parseInt(Numero1.getText());
          int op2 = Integer.parseInt(Numero2.getText());
          resultado.setText(String.valueOf(op1 + op2));
      }else if (Resta.isSelected()) {
          int op1 = Integer.parseInt(Numero1.getText());
          int op2 = Integer.parseInt(Numero2.getText());
          resultado.setText(String.valueOf(op1 - op2));
      }else if (Divi.isSelected()) {
          int op1 = Integer.parseInt(Numero1.getText());
          int op2 = Integer.parseInt(Numero2.getText());
          resultado.setText(String.valueOf(op1 / op2));
      }else {
          int op1 = Integer.parseInt(Numero1.getText());
          int op2 = Integer.parseInt(Numero2.getText());
          resultado.setText(String.valueOf(op1 * op2));

      }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        operationGroup = new ToggleGroup();
        Divi.setToggleGroup(operationGroup);
        Multi.setToggleGroup(operationGroup);
        Resta.setToggleGroup(operationGroup);
        Suma.setToggleGroup(operationGroup);
    }

    public RootController(){
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
        fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AnchorPane getRoot() {
        return root;
    }

    public void setRoot(AnchorPane root) {
        this.root = root;
    }

    public Button getSumarButton() {
        return sumarButton;
    }

    public void setSumarButton(Button sumarButton) {
        this.sumarButton = sumarButton;
    }
}
