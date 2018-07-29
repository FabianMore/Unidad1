package Unidad_3_4;

import com.jfoenix.controls.JFXComboBox;
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

public class ExistenciasEditar implements Initializable {

    private int indice;

    @FXML
    private JFXTextField idProducto;

    @FXML
    private JFXTextField cantidad;

    @FXML
    private JFXTextField costo;

    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXComboBox<String> existencia;

    private ArrayList<Existencia> existencias;

    @FXML
    void actualizar(ActionEvent event) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");


        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "UPDATE existencias SET "+
                "idProducto='"+idProducto.getText()+"', "+
                "cantidad='"+cantidad.getText()+"', "+
                "costo='"+costo.getText()+"' "+

                " WHERE idExistencia= " + existencias.get(indice).getIdExistencia();

        statement.execute(sql);
        existencias.get(indice).setIdProducto(Integer.parseInt(idProducto.getText()));
        existencias.get(indice).setCantidad(cantidad.getText());
        existencias.get(indice).setCosto(costo.getText());


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

        String sql = "DELETE FROM existencias WHERE idExistencia="+
                existencias.get(indice).getIdExistencia();

        statement.execute(sql);

        statement.close();
        connection.close();

        existencia.getItems().remove(indice);
        existencias.remove(indice);
        idProducto.setText("");
        cantidad.setText("");
        costo.setText("");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM existencias";

            ResultSet resultSet = statement.executeQuery(sql);

            existencias = new ArrayList<Existencia>();

            while (resultSet.next()){
                existencias.add(new Existencia(resultSet.getInt("idExistencia"),
                        resultSet.getInt("idProducto"),
                        resultSet.getString("cantidad"),
                        resultSet.getString("costo")


                ));
                existencia.getItems().add(resultSet.getString("cantidad"));

            }
            existencia.setOnAction(event -> {
                indice =existencia.getSelectionModel().getSelectedIndex();
                idProducto.setText(String.valueOf(existencias.get(indice).getIdExistencia()));
                cantidad.setText(existencias.get(indice).getCantidad());
                costo.setText(existencias.get(indice).getCosto());


            });

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}