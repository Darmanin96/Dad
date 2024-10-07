package org.example;

import javafx.beans.property.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class VerControler implements Initializable {

    private DoubleProperty result = new SimpleDoubleProperty();


    @FXML
    private GridPane root;

    @FXML
    private Button C;

    @FXML
    private Button CE;

    @FXML
    private TextField Result;

    @FXML
    private Button cero;

    @FXML
    private Button divide;

    @FXML
    private Button eight;

    @FXML
    private Button equal;

    @FXML
    private Button five;

    @FXML
    private Button four;

    @FXML
    private Button less;

    @FXML
    private Button multi;

    @FXML
    private Button nine;

    @FXML
    private Button one;

    @FXML
    private Button plus;

    @FXML
    private Button point;

    @FXML
    private Button seven;

    @FXML
    private Button six;

    @FXML
    private Button three;

    @FXML
    private Button two;


    public VerControler(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/VerView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            
    }

    public DoubleProperty resultProperty() {
        return result;
    }

    public void setResult(double result) {
        this.result.set(result);
    }

    public GridPane getRoot() {
        return root;
    }

    public void setRoot(GridPane root) {
        this.root = root;
    }

    public Button getC() {
        return C;
    }

    public void setC(Button c) {
        C = c;
    }

    public Button getCE() {
        return CE;
    }

    public void setCE(Button CE) {
        this.CE = CE;
    }

    public TextField getResult() {
        return Result;
    }

    public void setResult(TextField result) {
        Result = result;
    }

    public Button getCero() {
        return cero;
    }

    public void setCero(Button cero) {
        this.cero = cero;
    }

    public Button getDivide() {
        return divide;
    }

    public void setDivide(Button divide) {
        this.divide = divide;
    }

    public Button getEight() {
        return eight;
    }

    public void setEight(Button eight) {
        this.eight = eight;
    }

    public Button getEqual() {
        return equal;
    }

    public void setEqual(Button equal) {
        this.equal = equal;
    }

    public Button getFive() {
        return five;
    }

    public void setFive(Button five) {
        this.five = five;
    }

    public Button getFour() {
        return four;
    }

    public void setFour(Button four) {
        this.four = four;
    }

    public Button getLess() {
        return less;
    }

    public void setLess(Button less) {
        this.less = less;
    }

    public Button getMulti() {
        return multi;
    }

    public void setMulti(Button multi) {
        this.multi = multi;
    }

    public Button getNine() {
        return nine;
    }

    public void setNine(Button nine) {
        this.nine = nine;
    }

    public Button getOne() {
        return one;
    }

    public void setOne(Button one) {
        this.one = one;
    }

    public Button getPlus() {
        return plus;
    }

    public void setPlus(Button plus) {
        this.plus = plus;
    }

    public Button getPoint() {
        return point;
    }

    public void setPoint(Button point) {
        this.point = point;
    }

    public Button getSeven() {
        return seven;
    }

    public void setSeven(Button seven) {
        this.seven = seven;
    }

    public Button getSix() {
        return six;
    }

    public void setSix(Button six) {
        this.six = six;
    }

    public Button getThree() {
        return three;
    }

    public void setThree(Button three) {
        this.three = three;
    }

    public Button getTwo() {
        return two;
    }

    public void setTwo(Button two) {
        this.two = two;
    }
}
