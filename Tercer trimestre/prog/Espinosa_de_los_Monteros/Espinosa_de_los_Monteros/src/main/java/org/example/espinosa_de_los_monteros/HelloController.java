package org.example.espinosa_de_los_monteros;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import org.example.espinosa_de_los_monteros.SQLAcces;

import javax.swing.*;


public class HelloController implements Initializable {

    private SQLAcces sqlAcces = new SQLAcces();

    //paneres
    @FXML
    private VBox PanelBotones;

    @FXML
    private VBox PanelPacientes;

    @FXML
    private VBox PanelDoctores;

    @FXML
    private VBox PanelConsulta;

    @FXML
    private VBox PanelListaDoctores;


    //void

    private void selectPanelVisible(int panel){
        switch (panel){
            case 0:
                PanelBotones.setVisible(true);
                PanelPacientes.setVisible(false);
                PanelDoctores.setVisible(false);
                PanelConsulta.setVisible(false);
                PanelListaDoctores.setVisible(false);
                break;
            case 1:
                    PanelBotones.setVisible(false);
                    PanelPacientes.setVisible(true);
                    PanelDoctores.setVisible(false);
                    PanelConsulta.setVisible(false);
                    PanelListaDoctores.setVisible(false);
            break;
            case 2:
                PanelBotones.setVisible(false);
                PanelPacientes.setVisible(false);
                PanelDoctores.setVisible(true);
                PanelConsulta.setVisible(false);
                PanelListaDoctores.setVisible(false);
                break;
                case 3:
                    PanelBotones.setVisible(false);
                    PanelPacientes.setVisible(false);
                    PanelDoctores.setVisible(false);
                    PanelConsulta.setVisible(true);
                    PanelListaDoctores.setVisible(false);
                    break;
                    case 4:
                        PanelBotones.setVisible(false);
                        PanelPacientes.setVisible(false);
                        PanelDoctores.setVisible(false);
                        PanelConsulta.setVisible(false);
                        PanelListaDoctores.setVisible(true);
                        break;
            default:
                PanelBotones.setVisible(true);
                PanelPacientes.setVisible(false);
        }
    }

    // alertas

    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();

    }


    //agregar paciente

    @FXML
    private TextField DNIPaciente;

    @FXML
    private TextField NombrePaciente;

    @FXML
    private TextField ApellidoPaciente;

    @FXML
    private TextField EmailPaciente;

    @FXML
    private TextField DireccionPacitene;

    @FXML
    private TextField TelefonoPaciente;


    @FXML
    private void BotonPacienteInicio (){
        selectPanelVisible(1);
    }

    @FXML
    private void VolverPacientes (){
        selectPanelVisible(0);
    }

    @FXML
    private void BotonAñadirDoctores (){
        selectPanelVisible(2);
    }

    @FXML
    private void BotonRegistrarConsultas (){
        selectPanelVisible(3);
    }

    @FXML
    private void BotonBuscarDoctores(){
        selectPanelVisible(4);
    }

    //---------REGISTRAR PACIENTE--------

    @FXML
    private void RegistrarPaciente ()throws SQLException {
        String dni =  DNIPaciente.getText();
        String nombre = NombrePaciente.getText();
        String apellido = ApellidoPaciente.getText();
        String email = EmailPaciente.getText();
        String telefono = TelefonoPaciente.getText();
        String direccion = DireccionPacitene.getText();
        try{
            if(DNIPaciente.getText().isEmpty() ||  NombrePaciente.getText().isEmpty() || ApellidoPaciente.getText().isEmpty() || EmailPaciente.getText().isEmpty() || DireccionPacitene.getText().isEmpty() || TelefonoPaciente.getText().isEmpty()){
                showAlert("Por favor rellene todos los campos");

            }else{
                Paciente p = new Paciente(dni, nombre, apellido, email, telefono, direccion);
                sqlAcces.añadirPaciente(p);
                showAlert("Paciente registrado");
            }

        }catch (SQLException e){
            showAlert(e.getMessage());
        }
    }


    //Registrar Doctotr

    @FXML
    private TextField NumColegiadoDoctor;

    @FXML
    private TextField NombreDoctor;

    @FXML
    private TextField ApellidoDoctor;

    @FXML
    private TextField TelefonoDoctor;

    @FXML
    private TextField DireccionDoctor;

    @FXML
    private TextField EmailDoctor;

    @FXML
    private ComboBox<Tipo> TipoConsultaDoctor;
    @FXML
    private DatePicker FechaAltaDoctor;


    @FXML
    private void RegistrarDoctor() throws SQLException{
        String num = NumColegiadoDoctor.getText();
        String Nombre = NombreDoctor.getText();
        String Apellido = ApellidoDoctor.getText();
        String Telefono = TelefonoDoctor.getText();
        String Direccion = DireccionDoctor.getText();
        String email = EmailDoctor.getText();
        String fecha = FechaAltaDoctor.getValue().toString();
        int tipoConsulta = TipoConsultaDoctor.getValue().getId();

        try {
            Doctor d = new Doctor(num, Nombre, Apellido, Telefono, Direccion, email, fecha, tipoConsulta);

            sqlAcces.insertarDoctor(d);

            ListaDoctores.setItems(sqlAcces.cargarDoctores());//AQUI RECARGO LA LISTVIEW pero esto tiene que ser cuando ya la haya creado para que se recarge al registrar

            showAlert("Exito, Doctor añadido correctamente");
        }catch (SQLException e){
            showAlert("Error");
        }
    }

    //Registrar Consulta

    @FXML
    private DatePicker fehcaConsulta;

    @FXML
    private TextField DNIConsulta;

    @FXML
    private TextField ObservacionesConsulta;

    @FXML
    private TextField NColegiadoConsulta;

    @FXML
    private ComboBox<Tipo> ConsultaTipos;

    @FXML
    private void RregistrarConsulta() throws SQLException{
        String fechas = fehcaConsulta.getValue().toString();
        String dni = DNIConsulta.getText();
        String observaciones = ObservacionesConsulta.getText();
        String numCOlegiado = NColegiadoConsulta.getText();
        int tipoConsulta = ConsultaTipos.getValue().getId();

        try{
            int doctorTipoconstulta = sqlAcces.obtenerTipoConsultaDoctor(numCOlegiado);
            Consulta c = new Consulta(observaciones,fechas,tipoConsulta,dni,numCOlegiado, doctorTipoconstulta);
            sqlAcces.insertarConsulta(c);
            showAlert("Éxito, consulta registrada correctamente");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    //-------LISTA DOCTORES------

    @FXML
    private ListView<Doctor> ListaDoctores;

    @FXML
    private TextField BuscarNumColegiado;

    private Doctor doctorSeleccionado;



    @FXML
    private void BuscarNumColegiado() throws SQLException{
        String num = BuscarNumColegiado.getText();

        try{
            Doctor d = sqlAcces.buscarDoctorPorNumColegiado(num);
            if(d != null){
                doctorSeleccionado = d;
                NombreListaDoctor.setText(d.getNombre());
                telefonoListaDoctor.setText(d.getTelefono());
                ObservableList<Doctor> resultado = FXCollections.observableArrayList();
                resultado.add(d);
                ListaDoctores.setItems(resultado);
            }


        }catch (SQLException e){
            showAlert("Error: " + e.getMessage());
        }
    }

    //------actualizar


    @FXML
    private TextField NombreListaDoctor;

    @FXML
    private TextField telefonoListaDoctor;

    @FXML
    private void ActualizarListaDoctores() {
        if(doctorSeleccionado == null){
            showAlert("Primero busca un doctor");
            return;
        }
        try{
            doctorSeleccionado.setNombre(NombreListaDoctor.getText());
            doctorSeleccionado.setTelefono(telefonoListaDoctor.getText());
            sqlAcces.actualizarDoctor(doctorSeleccionado);
            ListaDoctores.setItems(sqlAcces.cargarDoctores());


        }catch (SQLException e){
            showAlert("Error: " + e.getMessage());
        }
    }


    @FXML
    private void EliminarDoctor() {
        if(doctorSeleccionado == null){
            showAlert("Primero selecciona un doctor");
            return;
        }
        try {
            sqlAcces.eliminarDoctor(doctorSeleccionado.getNumColegiado());
            ListaDoctores.setItems(sqlAcces.cargarDoctores());
            NombreListaDoctor.clear();
            telefonoListaDoctor.clear();
            doctorSeleccionado = null;
            showAlert("Doctor eliminado correctamente");

        } catch (SQLIntegrityConstraintViolationException e){
            showAlert("NO se puede eliminar el doctor porque tiene consultas asociadas");
        } catch (SQLException e){
            showAlert("Error: " + e.getMessage());
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectPanelVisible(0);

        try {
            TipoConsultaDoctor.setItems(sqlAcces.cargarTiposConsulta());
            ConsultaTipos.setItems(sqlAcces.cargarTiposConsulta());
            ListaDoctores.setItems(sqlAcces.cargarDoctores());

            //ESTO ES UN LISTENER QUE SIRVE PARA QUE CUANDO PINCHE SEPA QUE DOCTOR PINCHASTE
            ListaDoctores.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                if (newVal != null) {
                    doctorSeleccionado = newVal;
                    NombreListaDoctor.setText(newVal.getNombre());
                    telefonoListaDoctor.setText(newVal.getTelefono());
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void exportarPacientes() {
        try {
            List<Paciente> pacientes = new ArrayList<>(sqlAcces.cargarDatosPacienteInicio());
            sqlAcces.exportarPacientes(pacientes, "pacientes.dat");
            showAlert("Pacientes exportados correctamente");
        } catch (SQLException e) {
            showAlert("Error al cargar pacientes: " + e.getMessage());
        } catch (IOException e) {
            showAlert("Error al exportar el fichero: " + e.getMessage());
        }
    }


    public void SalirPrograma(){
        Platform.exit();
    }





}