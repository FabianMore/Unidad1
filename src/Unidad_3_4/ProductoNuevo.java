package Unidad_3_4;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductoNuevo {

    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXTextField nombre;


    @FXML
    private JFXTextArea descripcion;

    @FXML
    private JFXTextField idProveedor;

    @FXML
    void cancelar(ActionEvent event) {
        Pane p = (Pane)contenedor.getParent();

        p.getChildren().remove(0);
    }

    @FXML
    void guardar(ActionEvent event) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");

        Statement statement = connection.createStatement();

        String sql = "INSERT INTO productos (idProveedor,nombre, descripcion) VALUES ("+
                "'"+idProveedor.getText()+"'," +
                "'"+nombre.getText()+"'," +
                "'"+descripcion.getText()+"'"+
                ")";

        statement.execute(sql);
        idProveedor.setText("");
        nombre.setText("");
        descripcion.setText("");


    }


}
