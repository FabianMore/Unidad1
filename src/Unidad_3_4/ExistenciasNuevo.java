package Unidad_3_4;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExistenciasNuevo {

    @FXML
    private JFXTextField idProducto;

    @FXML
    private JFXTextField cantidad;

    @FXML
    private JFXTextField costo;

    @FXML
    private AnchorPane contenedor;

    @FXML
    void cancelar(ActionEvent event) {
        Pane p = (Pane)contenedor.getParent();

        p.getChildren().remove(0);

    }

    @FXML
    void guardar(ActionEvent event) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");

        Statement statement = connection.createStatement();

        String sql = "INSERT INTO existencias (idProducto, cantidad, costo ) VALUES ("+
                "'"+idProducto.getText()+"'," +
                "'"+cantidad.getText()+"',"+
                "'"+costo.getText()+"'"+
                ")";

        statement.execute(sql);
        idProducto.setText("");
        cantidad.setText("");
        costo.setText("");


    }

}

