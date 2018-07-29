package Unidad_3_4;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VentaEditar implements Initializable {

    private int indice;

    @FXML
    private JFXDatePicker fecha;

    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXTextField total;

    @FXML
    private JFXTextField idCliente;

    @FXML
    private JFXComboBox<String> venta;

    private ArrayList<Venta> ventas;

    @FXML
    void actualizar(ActionEvent event) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "UPDATE ventas SET "+
                "idCliente='"+idCliente.getText()+"', "+
                "fecha='"+fecha.getPromptText()+"', "+
                "total='"+total.getText()+"' "+

                " WHERE idVenta= " + ventas.get(indice).getIdVenta();

        statement.execute(sql);
        ventas.get(indice).setIdCliente(Integer.parseInt(idCliente.getText()));
        ventas.get(indice).setFecha(fecha.getPromptText());
        ventas.get(indice).setTotal(total.getText());

    }

    @FXML
    void cancelar(ActionEvent event) {
        Pane p = (Pane)contenedor.getParent();
        p.getChildren().remove(0);

    }

    @FXML
    void eliminar(ActionEvent event) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");

        Statement statement = connection.createStatement();

        String sql = "DELETE FROM ventas WHERE idVenta="+
                ventas.get(indice).getIdVenta();

        statement.execute(sql);

        statement.close();
        connection.close();

        venta.getItems().remove(indice);
        ventas.remove(indice);
        idCliente.setText("");
        fecha.setPromptText("");
        total.setText("");


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM ventas";

            ResultSet resultSet = statement.executeQuery(sql);

            ventas = new ArrayList<Venta>();

            while (resultSet.next()){
                ventas.add(new Venta(resultSet.getInt("idVenta"),
                        resultSet.getInt("idCliente"),
                        resultSet.getString("fecha"),
                        resultSet.getString("total")


                ));
                venta.getItems().add(resultSet.getString("total"));

            }
            venta.setOnAction(event -> {
                indice =venta.getSelectionModel().getSelectedIndex();


                total.setText(ventas.get(indice).getTotal());
                fecha.setPromptText(String.valueOf(ventas.get(indice).getFecha()));
                idCliente.setText(String.valueOf(ventas.get(indice).getIdVenta()));

            });

            statement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}