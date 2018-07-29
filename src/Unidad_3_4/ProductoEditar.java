package Unidad_3_4;

import Layout.Practica012_TableView;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
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

public class ProductoEditar implements Initializable {

    private int indice;

    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXTextField nombre;

    @FXML
    private JFXTextArea descripcion;

    @FXML
    private JFXTextField idProveedor;

    @FXML
    private JFXComboBox<String> producto;

    private ArrayList<Producto> productos;

    @FXML
    void actualizar(ActionEvent event) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "UPDATE productos SET "+
                "nombre='"+nombre.getText()+"', "+
                "descripcion='"+descripcion.getText()+"', "+
                "idProveedor='"+idProveedor.getText()+"' "+

                " WHERE idProducto= " + productos.get(indice).getIdProducto();

        statement.execute(sql);
        productos.get(indice).setNombre(nombre.getText());
        productos.get(indice).setDescripcion(descripcion.getText());
        productos.get(indice).setIdProveedor(Integer.parseInt(idProveedor.getText()));


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

        String sql = "DELETE FROM productos WHERE idProducto="+
                productos.get(indice).getIdProducto();

        statement.execute(sql);

        statement.close();
        connection.close();

        producto.getItems().remove(indice);
        productos.remove(indice);
        idProveedor.setText("");
        nombre.setText("");
        descripcion.setText("");


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM productos";

            ResultSet resultSet = statement.executeQuery(sql);

            productos = new ArrayList<Producto>();

            while (resultSet.next()){
                productos.add(new Producto(resultSet.getInt("idProducto"),
                        resultSet.getInt("idProveedor"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion")


                ));
                producto.getItems().add(resultSet.getString("nombre"));

            }
            producto.setOnAction(event -> {
                indice =producto.getSelectionModel().getSelectedIndex();

                nombre.setText(productos.get(indice).getNombre());
                descripcion.setText(productos.get(indice).getDescripcion());
                idProveedor.setText(String.valueOf(productos.get(indice).getIdProducto()));

            });

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

