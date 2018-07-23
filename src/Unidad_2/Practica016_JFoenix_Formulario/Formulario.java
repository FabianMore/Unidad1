package Unidad_2.Practica016_JFoenix_Formulario;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Formulario extends Application {

    @FXML
    private ImageView botonUsuario;

    @FXML
    private ImageView botonUbicacion;

    @FXML
    private ImageView botonEscuela;

    @FXML
    private ImageView botonSalir;

    @FXML
    private AnchorPane paneUsuario;

    @FXML
    private AnchorPane paneUbicacion;

    @FXML
    private AnchorPane paneEscuela;

    @FXML
    private ImageView upMapa;

    @FXML
    private ImageView upUsuario;

    @FXML
    private ImageView upEscuela;

    @FXML
    void mostrarEscuela(MouseEvent event) {
        mostrarPane("Escuela");

    }

    @FXML
    void mostrarUbicacion(MouseEvent event) {
        mostrarPane("Ubicacion");

    }

    @FXML
    void mostrarUsuario(MouseEvent event) {
        mostrarPane("Usuario");

    }

    @FXML
    void salir(MouseEvent event) {
        Platform.exit();

    }

    private void mostrarPane(String opc)
    {

        switch (opc){
            case "Usuario":
                if (paneUsuario.isVisible()){
                    paneUsuario.setVisible(false);
                    upUsuario.setVisible(false);
                    return;
                }
                break;
            case "Ubicacion":
                if (paneUbicacion.isVisible()){
                    paneUbicacion.setVisible(false);
                    upMapa.setVisible(false);
                    return;
                }
                break;
            case "Escuela":
                if (paneEscuela.isVisible()){
                    paneEscuela.setVisible(false);
                    upEscuela.setVisible(false);
                    return;
                }
                break;
        }

        paneUsuario.setVisible(false);
        paneUbicacion.setVisible(false);
        paneEscuela.setVisible(false);
        upUsuario.setVisible(false);
        upEscuela.setVisible(false);
        upMapa.setVisible(false);

        switch (opc){
            case "Usuario":
                paneUsuario.setVisible(true);
                upUsuario.setVisible(true);
                break;
            case "Ubicacion":
                paneUbicacion.setVisible(true);
                upMapa.setVisible(true);
                break;
            case "Escuela":
                paneEscuela.setVisible(true);
                upEscuela.setVisible(true);
                break;

        }
    }
    private double posX, posY;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().getResource("Formulario.fxml"));

        layout.setOnMousePressed(event -> {
            posX = primaryStage.getX()-event.getX();
            posY = primaryStage.getY()-event.getY();
           // System.out.println("0: "+ posX + ", " + posY);
           // System.out.println("1: "+ primaryStage.getX() + ", " + primaryStage.getY());
        });

        layout.setOnMouseDragged(event -> {
         primaryStage.setX(event.getX()+posX);
         primaryStage.setY(event.getY()+posY);
        });

        Scene scene = new Scene(layout);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }
}
