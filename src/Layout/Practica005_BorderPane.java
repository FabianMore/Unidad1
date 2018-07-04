package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class Practica005_BorderPane extends Application {
  public static  void main (String[] args){
      launch(args);
  }

    @Override
    public void start(Stage primaryStage) throws Exception {
       Button bArriba = new Button("Arriba");
        Button bIzquierda = new Button("Izquierda");
        Button bDerecha = new Button("Derecha");
        Button bAbajo = new Button("Abajo");
        Button bCentro = new Button("Centro");

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10,20,30,10));
        layout.setTop(bArriba);
        layout.setBottom(bAbajo);
        layout.setLeft(bIzquierda);
        layout.setRight(bDerecha);

        layout.setCenter(bCentro);

        BorderPane.setAlignment(bAbajo,Pos.CENTER);
        BorderPane.setAlignment(bDerecha,Pos.BOTTOM_RIGHT);

        Scene escena = new Scene(layout);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
}
