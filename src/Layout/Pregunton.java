package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Pregunton extends Application {
    public static void main(String[]args){
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Label pregunta = new Label("Pregunta 1: En una pecera habia 10 "+
        "peces. 2 se ahogaron 3 se fueron nadando ¿Cuantos peces quedaron?");
        ComboBox<String> respuestas = new ComboBox<String>();
        Label resultado = new Label();
        Button anterior = new Button("Anterior");
        Button siguiente = new Button("Siguiente");
        CheckBox mostrar = new CheckBox("Mostrar respouesta correcta");
        Label respuestaCorrecta = new Label("La respuesta correcta es");



        HBox layoutBotones = new HBox();
        layoutBotones.setSpacing(10);
        layoutBotones.getChildren().addAll(anterior,siguiente);
        anterior.setPrefSize(90,30);
        siguiente.setPrefSize(90,30);

        respuestas.setPrefWidth(200);
        respuestas.setPromptText("Elige una respuesta");

        pregunta.setPrefWidth(200);
        pregunta.setPrefHeight(100);
        pregunta.setWrapText(true);

        resultado.setPrefWidth(200);
        resultado.setAlignment(Pos.CENTER);


        respuestaCorrecta.setPrefWidth(200);
        respuestaCorrecta.setPrefHeight(50);
        respuestaCorrecta.setWrapText(true);

        VBox layout= new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(15);
        layout.getChildren().addAll(pregunta, respuestas, layoutBotones
                ,resultado, mostrar, respuestaCorrecta);

        respuestaCorrecta.setVisible(false);
        mostrar.setOnAction(event -> {
            if(mostrar.isSelected()){
                respuestaCorrecta.setVisible(true);
            }else{
                respuestaCorrecta.setVisible(false);
            }
        });




        cargarPreguntas();
        pregunta.setText(preguntas.get(indicePreguntaActual).getPregunta());
        respuestas.getItems().clear();
        for(String r : preguntas.get(indicePreguntaActual).getRespuesta()){
            respuestas.getItems().add(r);
        }

        respuestaCorrecta.setText(preguntas.get(indicePreguntaActual).getRespuesta()[preguntas.get(indicePreguntaActual).getIndiceCorrecto()]);

        respuestas.setOnAction(event -> {
            if(respuestas.getSelectionModel().getSelectedIndex() == preguntas.get(indicePreguntaActual).getIndiceCorrecto()){
                resultado.setText("Correcto");
            }else{
                resultado.setText("Incorrecto");
            }
        });


        siguiente.setOnAction(event -> {
            if(indicePreguntaActual== preguntas.size())
                return;
            indicePreguntaActual++;
            pregunta.setText(preguntas.get(indicePreguntaActual).getPregunta());
            respuestas.getItems().clear();
            respuestaCorrecta.setText(preguntas.get(indicePreguntaActual).getRespuesta()[preguntas.get(indicePreguntaActual).getIndiceCorrecto()]);
            for(String r : preguntas.get(indicePreguntaActual).getRespuesta()){
                respuestas.getItems().add(r);
            }
        });

        anterior.setOnAction(event -> {
            if(indicePreguntaActual== 0)
                return;
            indicePreguntaActual--;
            resultado.setText("");
            pregunta.setText(preguntas.get(indicePreguntaActual).getPregunta());
            respuestas.getItems().clear();
            respuestaCorrecta.setText(preguntas.get(indicePreguntaActual).getRespuesta()[preguntas.get(indicePreguntaActual).getIndiceCorrecto()]);
            for(String r : preguntas.get(indicePreguntaActual).getRespuesta()){
                respuestas.getItems().add(r);
            }
        });

        Scene escena  = new Scene(layout);
        primaryStage.setScene(escena);
        primaryStage.setTitle("Pregunton");
        primaryStage.show();
    }
    private ArrayList<Pregunta> preguntas;
    private int indicePreguntaActual;

   

    private  void cargarPreguntas(){
        indicePreguntaActual = 0;
        preguntas= new ArrayList<Pregunta>();
        preguntas.add(
                new Pregunta("¿Cuanto es 1 + 1?",
                        new String[]{"1","2","3","4"}, 1));

        preguntas.add(
                new Pregunta("¿Cuantos planetas tiene nuestro sistema solar",
                        new String[]{"10","2","3","8","11"}, 3));

        preguntas.add(
                new Pregunta("Si tienes tres perros el grande lo das en 300, el mediano en 200, en cuanto das el chiquito?",
                        new String[]{"400","100","150","200"}, 1));
        preguntas.add(
                new Pregunta("¿Que le pasa a lupita?",
                        new String[]{"nada","quiere bailar","se callo","no se"}, 3));
    }
}
