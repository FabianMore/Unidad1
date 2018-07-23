package Unidad_2.Practica015_JFoenix_inicioSesion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicioSesion extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().getResource("inicioSesion.fxml"));

        Scene scene = new Scene(layout);
        primaryStage.setTitle("Genius Coder: Inicio de Sesion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
