package Unidad_2.Practica015_JFoenix_inicioSesion;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class InicioSesion extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().getResource("inicioSesion.fxml"));

        Scene scene = new Scene(layout);
        primaryStage.setTitle("Genius Coder: Inicio de Sesion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private JFXTextField usuario;

    @FXML
    private JFXPasswordField clave;

    @FXML
        void IniciarSesion(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:basededatos1.db");

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String correo= usuario.getText();
            String clv = clave.getText();

            String consulta = "SELECT * FROM usuarios " + "WHERE correo='"+correo+"'  AND clave='"+clv+"' ";

            ResultSet  rs = statement.executeQuery(consulta);

            if (rs.next()) {
                System.out.println("Usuario valido");
                System.out.println(rs.getString("nombre"));
            }else {
                System.out.println("Usuario no valido");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println("Usuario: "+ usuario.getText());
        System.out.println("Clave: "+ clave.getText());

    }

}
