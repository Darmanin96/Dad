package dad.micv.controller;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class PestañaController implements Initializable {

    @FXML
    private TextField Apellidos;

    @FXML
    private TextField DNI;

    @FXML
    private TextArea Direccion;

    @FXML
    private Button Less;

    @FXML
    private TextField Localidad;

    @FXML
    private TextArea Nacionalidad;

    @FXML
    private TextField Name;

    @FXML
    private ChoiceBox<String> Pais;

    @FXML
    private Button Plus;

    @FXML
    private TextField codigoPotal;

    @FXML
    private DatePicker fechaNacimiento;

    @FXML
    private GridPane root;

    @FXML
    void OnLessAction(ActionEvent event) {

    }

    @FXML
    void onPlusAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String fileCSV = "C:\\Users\\darma\\Documents\\GitHub\\Dad\\MiCV\\src\\main\\resources\\csv\\paises.csv";
    }

    public PestañaController(){
    }

    private List<String> listaPaises(String fileCSV){
        List<String> paises = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader())) {

        }

    }

    public TextField getApellidos() {
        return Apellidos;
    }

    public void setApellidos(TextField apellidos) {
        Apellidos = apellidos;
    }

    public TextField getDNI() {
        return DNI;
    }

    public void setDNI(TextField DNI) {
        this.DNI = DNI;
    }

    public TextArea getDireccion() {
        return Direccion;
    }

    public void setDireccion(TextArea direccion) {
        Direccion = direccion;
    }

    public Button getLess() {
        return Less;
    }

    public void setLess(Button less) {
        Less = less;
    }

    public TextField getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(TextField localidad) {
        Localidad = localidad;
    }

    public TextArea getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(TextArea nacionalidad) {
        Nacionalidad = nacionalidad;
    }

    public TextField getName() {
        return Name;
    }

    public void setName(TextField name) {
        Name = name;
    }

    public ChoiceBox<?> getPais() {
        return Pais;
    }

    public void setPais(ChoiceBox<?> pais) {
        Pais = pais;
    }

    public Button getPlus() {
        return Plus;
    }

    public void setPlus(Button plus) {
        Plus = plus;
    }

    public TextField getCodigoPotal() {
        return codigoPotal;
    }

    public void setCodigoPotal(TextField codigoPotal) {
        this.codigoPotal = codigoPotal;
    }

    public DatePicker getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(DatePicker fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public GridPane getRoot() {
        return root;
    }

    public void setRoot(GridPane root) {
        this.root = root;
    }
}
