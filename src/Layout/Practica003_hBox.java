package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Practica003_hBox extends Application {
    public static void main(String [] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button boton1 = new Button("Boton 1");
        Button boton2=new Button("Boton 2");
        Button boton3 = new Button("Boton 3");

        HBox layout = new HBox();

        layout.setPadding(new Insets(20));
        layout.setSpacing(20);

        layout.getChildren().addAll(boton1, boton2, boton3);

        Scene escena = new Scene(layout);

        primaryStage.setScene(escena);
        primaryStage.show();
    }
}
//caja horizontal
