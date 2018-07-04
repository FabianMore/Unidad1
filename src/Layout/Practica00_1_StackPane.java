package Layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.Stack;

public class Practica00_1_StackPane extends Application {
public static void main(String[] args){
    launch(args);
}
    @Override
    public void start(Stage primaryStage)
    {
        Button boton = new Button("Click aqui");
        Label etiqueta = new Label("buen dia");
        Rectangle rectangulo = new Rectangle(100, 200);

        StackPane layout = new StackPane();
        layout.getChildren().add(rectangulo);
        layout.getChildren().add(boton);
        layout.getChildren().add(etiqueta);

        layout.setAlignment(rectangulo, Pos.TOP_LEFT);
        layout.setAlignment(etiqueta,Pos.BOTTOM_RIGHT);

        Scene escena = new Scene(layout,300,200);

        primaryStage.setScene(escena);
        primaryStage.show();

    }
}
//caja apiladas 