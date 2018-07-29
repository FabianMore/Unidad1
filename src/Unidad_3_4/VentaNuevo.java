package Unidad_3_4;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class VentaNuevo {



    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXDatePicker fecha;

    @FXML
    private JFXTextField total;

    @FXML
    private JFXTextField idCliente;

    @FXML
    void cancelar(ActionEvent event) {
        Pane p = (Pane)contenedor.getParent();

        p.getChildren().remove(0);

    }

    @FXML
    void guardar(ActionEvent event) throws SQLException {



        Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");

        Statement statement = connection.createStatement();

        String sql = "INSERT INTO ventas (idCliente,fecha, total) VALUES ("+
                "'"+idCliente.getText()+"'," +
                "'"+fecha.getEditor().getText()+"'," +
                "'"+total.getText()+"'"+
                ")";

        statement.execute(sql);
        idCliente.setText("");

        total.setText("");


    }

}