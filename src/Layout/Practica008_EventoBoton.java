package Layout;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Practica008_EventoBoton extends Application
{
    private TextField caja1;
    private TextField caja2;
    private TextField cajaResultado;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label etivalor1 = new Label("Valor 1: ");
        Label etivalor2 = new Label("Valor 2: ");
        Label etiResultado3 = new Label("Resultado: ");

        caja1 = new TextField();
        caja2 = new TextField();
        cajaResultado = new TextField();

        Button boton1 = new Button("Suma");

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10));
        layout.setVgap(10);
        layout.setHgap(5);

        layout.add(etivalor1, 0, 0);
        layout.add(caja1, 1, 0);

        layout.add(etivalor2, 0, 1);
        layout.add(caja2, 1, 1);

        layout.add(boton1, 0, 2, 2, 1);
        boton1.setAlignment(Pos.CENTER);


        boton1.setOnAction(e ->
                {
                    int v1 = Integer.valueOf(caja1.getText());
                    int v2 = Integer.valueOf(caja2.getText());

                    int r = v1 + v2;
                    cajaResultado.setText(String.valueOf(r));
                }
        ); //Esto es lo mismo


        /*
         boton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                    int v1=Integer.valueOf(caja1.getText());
                    int v2=Integer.valueOf(caja2.getText());

                    int r = v1 + v2;
                    cajaResultado.setText(String.valueOf(r));
            }
        }); //que esto

*/

        // boton1.setOnAction(this);
        layout.add(etiResultado3, 0, 3);
        layout.add(cajaResultado, 1, 3);

        Scene escena = new Scene(layout);
        primaryStage.setScene(escena);
        primaryStage.setTitle("Sumador!!");
        primaryStage.show();

    }
}
   /*
    @Override
    public void handle(Event event) {
        if(event.getSource()== boton1){
            int v1=Integer.valueOf(caja1.getText());
            int v2=Integer.valueOf(caja2.getText());

            int r = v1 + v2;
            cajaResultado.setText(String.valueOf(r));
        }
    }
}
//tambien es igual a esto
*/
