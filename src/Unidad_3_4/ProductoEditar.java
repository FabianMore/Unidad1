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

    @FXML
    private JFXComboBox<String> proveedor;

    private ArrayList<Producto> productos;
    private ArrayList<Proveedor> proveedores;

    @FXML
    void actualizar(ActionEvent event) throws SQLException {

        String nombreProducto = nombre.getText();
        String descripcionProducto = descripcion.getText();
        int indiceSeleccionado = proveedor.getSelectionModel().getSelectedIndex();
        int idProveedor = proveedores.get(indiceSeleccionado).getIdProveedor();
        int idProducto = productos.get(indiceSeleccionado).getIdProducto();
        int indiceSeleccionadoProducto = producto.getSelectionModel().getSelectedIndex();

        Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");

        Statement statement = connection.createStatement();

        String sql = "UPDATE productos SET "+
                "idProveedor="+idProveedor+", " +
                "nombre='"+nombreProducto+"'," +
                "descripcion='"+descripcionProducto+"' WHERE idProducto="+idProducto;



        statement.execute(sql);
        statement.close();
        connection.close();

        productos.get(indiceSeleccionadoProducto).setNombre(nombreProducto);
        productos.get(indiceSeleccionadoProducto).setDescripcion(descripcionProducto);
        productos.get(indiceSeleccionadoProducto).setIdProveedor(idProveedor);

        proveedor.getSelectionModel().clearSelection();
        producto.getSelectionModel().clearSelection();
        nombre.setText("");
        descripcion.setText("");



    }

    @FXML
    void cancelar(ActionEvent event) {
        Pane p = (Pane)contenedor.getParent();
        p.getChildren().remove(0);

    }

    @FXML
    void eliminar(ActionEvent event) throws SQLException {

        int indice = producto.getSelectionModel().getSelectedIndex();
        int idProducto = productos.get(indice).getIdProducto();

        Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "DELETE FROM productos WHERE idProducto="+ idProducto;
        statement.execute(sql);


        producto.getSelectionModel().clearSelection();
        proveedor.getSelectionModel().clearSelection();
        nombre.setText("");
        descripcion.setText("");

        productos.remove(indice);
        producto.getItems().remove(indice);

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

                producto.getItems().add(resultSet.getString("nombre"));
                productos.add(new Producto(
                        resultSet.getInt("idProducto"),

                        resultSet.getInt("idProveedor"),

                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion")

                ));
               // producto.getItems().add(resultSet.getString("nombre"));

            }
           /* producto.setOnAction(event -> {
                indice =producto.getSelectionModel().getSelectedIndex();

                nombre.setText(productos.get(indice).getNombre());
                descripcion.setText(productos.get(indice).getDescripcion());
                idProveedor.setText(String.valueOf(productos.get(indice).getIdProducto()));

            });   */

           // statement.close();
            //connection.close();



             sql = "SELECT * FROM proveedores";

            resultSet= statement.executeQuery(sql);

            proveedores = new ArrayList<Proveedor>();

            while (resultSet.next()){

                proveedor.getItems().add(resultSet.getString("nombre"));
                proveedores.add(new Proveedor(
                        resultSet.getInt("idProveedor"),
                        resultSet.getString("nombre"),
                        resultSet.getString("rfc"),
                        resultSet.getString("calle"),
                        resultSet.getString("colonia"),
                        resultSet.getString("ciudad"),
                        resultSet.getString("pais"),
                        resultSet.getString("telefono"),
                        resultSet.getString("celular"),
                        resultSet.getString("email")
                ));

            }

            } catch (SQLException e) {
            e.printStackTrace();
        }

        producto.setOnAction(event -> {
            int indice = producto.getSelectionModel().getSelectedIndex();
            nombre.setText(productos.get(indice).getNombre());
            descripcion.setText(productos.get(indice).getDescripcion());

            for (int i=0; i<proveedores.size(); i++){
                if(productos.get(indice).getIdProveedor() == proveedores.get(i).getIdProveedor()){
                     proveedor.getSelectionModel().select(i);
                     break;
                }
            }
        });
    }
}

