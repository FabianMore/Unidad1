package proyecto;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class login extends Application {

    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXTextField usuario;

    @FXML
    private JFXPasswordField contraseña;

    @FXML
    void inicio(ActionEvent event) throws IOException {
        String usuario1="admin";
        String contraseña1="1234";
        String user=usuario.getText();
        String password=contraseña.getText();



        if(user.equals(usuario1)&& password.equals(contraseña1)){
            JOptionPane.showMessageDialog(null,"Bienvenido");

            Parent layout = FXMLLoader.load(getClass().getResource("Ventana.fxml"));

            contenedor.getChildren().add(layout);


        }else
            JOptionPane.showMessageDialog(null, "Usuario / Contraseña incorrecta");

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().getResource("login.fxml"));


        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Agenda Super Genial by Fabian");
        primaryStage.show();

    }
}
