package org.example.demo;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    SQLAcces sqlAcces = new SQLAcces();

    @FXML
    private VBox PanelBotones;

    @FXML
    private VBox PanelMascota;

    @FXML
    private VBox PanelPropietario;

    @FXML
    private VBox PanelBuscarMascotas;

    @FXML
    private VBox PanelConsulta;

    private void selectPanelVisible(int panel){
        switch(panel){
            case 0:
                PanelBotones.setVisible(true);
                PanelMascota.setVisible(false);
                PanelPropietario.setVisible(false);
                PanelConsulta.setVisible(false);
                PanelBuscarMascotas.visibleProperty().set(false);
                break;
            case 1:
                PanelBotones.setVisible(false);
                PanelMascota.setVisible(true);
                PanelPropietario.setVisible(false);
                PanelConsulta.setVisible(false);
                PanelBuscarMascotas.visibleProperty().set(false);
                break;
            case 2:
                 PanelBotones.setVisible(false);
                 PanelMascota.setVisible(false);
                 PanelPropietario.setVisible(true);
                 PanelConsulta.setVisible(false);
                PanelBuscarMascotas.visibleProperty().set(false);
                 break;
                 case 3:
                     PanelBotones.setVisible(false);
                     PanelMascota.setVisible(false);
                     PanelPropietario.setVisible(false);
                     PanelConsulta.setVisible(true);
                     PanelBuscarMascotas.visibleProperty().set(false);
                     break;
                     case 4:
                         PanelBotones.setVisible(false);
                         PanelMascota.setVisible(false);
                         PanelPropietario.setVisible(false);
                         PanelConsulta.setVisible(false);
                         PanelBuscarMascotas.visibleProperty().set(true);
                         break;
        }
    }

    @FXML
    private void BotonRegistrarMascota (){
        selectPanelVisible(1);
    }
    @FXML
    private void BotonVolver (){
        selectPanelVisible(0);
    }
    @FXML
    private void BotonRegistrarPropietario (){
        selectPanelVisible(2);
    }
    @FXML
    private void BotonRegistrarConsulta (){
        selectPanelVisible(3);
    }
    @FXML
    private void BotonListaMascotas (){ selectPanelVisible(4);}





    //-----ALERTAS----

    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();

    }

    //----CREAR MASCOTA---


    @FXML
    private TextField PasaporteMascota;

    @FXML
    private TextField NombreMascota;

    @FXML
    private TextField PesoMascota;

    @FXML
    private TextField DNIMascota;

    @FXML
    private DatePicker FechaNMascota;

    @FXML
    private ComboBox<Tipo> TipoMascota;

    @FXML
    private void RegistrarMascota () throws SQLException {
        String pasaporte =  PasaporteMascota.getText();
        String nombre =  NombreMascota.getText();
        Double peso =  Double.parseDouble(PesoMascota.getText());
        LocalDateTime fechaNacimiento =  FechaNMascota.getValue().atStartOfDay();
        Tipo tipo =TipoMascota.getValue();

        Propietario propietario = sqlAcces.buscarPropietarioPorDNI(DNIMascota.getText());

        try{
            if(PasaporteMascota.getText().isEmpty() || NombreMascota.getText().isEmpty() || PesoMascota.getText().isEmpty() || DNIMascota.getText().isEmpty()){
                showAlert("Por favor rellene todos los campos");
            } else{
                Mascota m =new Mascota(pasaporte, nombre, peso, fechaNacimiento, propietario, tipo);

                sqlAcces.añadirMascota(m);
                showAlert("Mascota registrada");
            }

        }catch (Exception e){

        }
    }


    //---REGISTRAR PROPIETARIO---


    @FXML
    private TextField DNIPropietario;

    @FXML
    private TextField NombrePropietario;

    @FXML
    private TextField ApellidoPropietario;

    @FXML
    private TextField TelefonoPropietario;

    @FXML
    private TextField DireccionPropietario;

    @FXML
    private TextField EmailPropietario;

    @FXML
    private void RegistrarPropietario() throws SQLException {
        String dni = DNIPropietario.getText();
        String nombre = NombrePropietario.getText();
        String apellido = ApellidoPropietario.getText();
        String telefono = TelefonoPropietario.getText();
        String direccion = DireccionPropietario.getText();
        String email = EmailPropietario.getText();

        try {
            if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty()
                    || telefono.isEmpty() || direccion.isEmpty() || email.isEmpty()) {
                showAlert("Por favor rellene todos los campos");
            } else {
                Propietario p = new Propietario(dni, nombre, apellido, telefono, direccion, email);

                sqlAcces.añadirPropietario(p);
                showAlert("Propietario registrado");
            }

        } catch (Exception e) {

        }
    }


    //------REGISTRAR CONSULTA-----


    @FXML
    private TextField DuracionConsulta;
    @FXML
    private TextField ObservacionesConsulta;
    @FXML
    private TextField PasaporteConsulta;
    @FXML
    private DatePicker FechaConsulta;
    @FXML
    private TextField HoraConsulta;

    @FXML
    private void RegistrarConsulta() throws SQLException {
        String pasaporte = PasaporteConsulta.getText();
        LocalDate fecha = FechaConsulta.getValue();
        String horaTexto = HoraConsulta.getText();
        String duracion = DuracionConsulta.getText();
        String observaciones = ObservacionesConsulta.getText();

        try {
            if (pasaporte.isEmpty() || fecha == null || horaTexto.isEmpty() || duracion.isEmpty()) {
                showAlert("Por favor rellene todos los campos");
                return;
            }

            LocalTime hora = LocalTime.parse(horaTexto);
            LocalDateTime fechaHora = LocalDateTime.of(fecha, hora);

            Mascota mascota = sqlAcces.buscarMascotaPorPasaporte(pasaporte);

            if (mascota == null) {
                showAlert("No existe ninguna mascota con ese pasaporte");
                return;
            }

            Consulta c = new Consulta(0, fechaHora, Integer.parseInt(duracion), observaciones, mascota);

            sqlAcces.añadirConsulta(c);
            showAlert("Consulta registrada");

        } catch (DateTimeParseException e) {
            showAlert("El formato de la hora debe ser HH:mm, por ejemplo 10:30");
        } catch (Exception e) {

        }
    }


    //----BUSCAR MASCOTA----

    @FXML
    private TextField PasaporteBuscar;

    @FXML
    private TextField BuscarNombreMascota;
    @FXML
    private TextField PesoBuscarMascota;

    @FXML
    private ListView<Mascota> ListaMascotas;

    @FXML
    private void BuscarMascota() {
        String pasaporte = PasaporteBuscar.getText();

        try {
            if (pasaporte.isEmpty()) {
                ListaMascotas.setItems(sqlAcces.cargarMascotas());
            } else {
                Mascota m = sqlAcces.buscarMascotaPorPasaporte(pasaporte);
                if (m == null) {
                    showAlert("No existe ninguna mascota con ese pasaporte");
                    ListaMascotas.setItems(sqlAcces.cargarMascotas());
                } else {
                    BuscarNombreMascota.setText(m.getNombre());
                    PesoBuscarMascota.setText(String.valueOf(m.getPeso()));
                }
            }
        } catch (Exception e) {
            showAlert("Error al buscar la mascota");
        }
    }

    @FXML
    private void ActualizarCampos() {
        String pasaporte = PasaporteBuscar.getText();

        try {
            if (pasaporte.isEmpty() || BuscarNombreMascota.getText().isEmpty() || PesoBuscarMascota.getText().isEmpty()) {
                showAlert("Por favor rellene todos los campos");
                return;
            }

            Mascota m = sqlAcces.buscarMascotaPorPasaporte(pasaporte);
            m.setNombre(BuscarNombreMascota.getText());
            m.setPeso(Double.parseDouble(PesoBuscarMascota.getText()));

            sqlAcces.actualizarMascota(m);
            showAlert("Mascota actualizada correctamente");

        } catch (NumberFormatException e) {
            showAlert("El peso debe ser un número válido");
        } catch (Exception e) {
            showAlert("Error al actualizar la mascota");
        }
    }




    //---Exportar datos----

    @FXML
    private void ExportarDatos() {
        try {
            ObservableList<Mascota> mascotas = sqlAcces.cargarMascotas();

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mascotas.dat"))) {
                oos.writeObject(new ArrayList<>(mascotas));
            }

            showAlert("Datos exportados correctamente");

        } catch (SQLException e) {
            showAlert("Error al cargar las mascotas");
        } catch (IOException e) {
            showAlert("Error al exportar los datos");
        }
    }






    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectPanelVisible(0);

        try {
            TipoMascota.setItems(sqlAcces.cargarTiposConsulta());
        } catch (SQLException e) {
        }
        ListaMascotas.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                PasaporteBuscar.setText(newVal.getPasaporte());
                BuscarNombreMascota.setText(newVal.getNombre());
                PesoBuscarMascota.setText(String.valueOf(newVal.getPeso()));
            }
        });
        ListaMascotas.setCellFactory(param -> new ListCell<Mascota>() {
            @Override
            protected void updateItem(Mascota m, boolean empty) {
                super.updateItem(m, empty);
                if (empty || m == null) {
                    setText(null);
                } else {
                    setText(m.getPasaporte() + " - " + m.getNombre());
                }
            }
        });

        try {
            ListaMascotas.setItems(sqlAcces.cargarMascotas());
        } catch (SQLException e) {
            showAlert("Error al cargar las mascotas");
        }
    }


}