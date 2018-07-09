package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Evaluacion1 extends Application {
    public static void main(String []args){
        launch (args);
    }
    public char valor;
    public double n1;
    public  double n2;
    public  double nr;
    public  double enteros=(int)nr;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button botonlimpiarto = new Button("Limpiar todo");
        TextField caja1 = new TextField("0");
        caja1.setAlignment(Pos.CENTER_RIGHT);
        botonlimpiarto.setPrefSize(215,50);
        caja1.setPrefSize(400,30);
        Button botonlimpia = new Button("Limpiar ");
        botonlimpia.setPrefSize(100,50);
        Button botondiagonal = new Button("/ ");
        botondiagonal.setPrefSize(100,50);
        Button botonsiete = new Button("7");
        botonsiete.setPrefSize(100,50);
        Button botonocho = new Button("8");
        botonocho.setPrefSize(100,50);
        Button botonnueve = new Button("9");
        botonnueve.setPrefSize(100,50);
        Button botonasterisco = new Button("*");
        botonasterisco.setPrefSize(100,50);
        Button botoncuatro = new Button("4");
        botoncuatro.setPrefSize(100,50);
        Button botoncinco = new Button("5");
        botoncinco.setPrefSize(100,50);
        Button botonseis = new Button("6");
        botonseis.setPrefSize(100,50);
        Button botonmenos = new Button("-");
        botonmenos.setPrefSize(100,50);
        Button botonuno = new Button("1");
        botonuno.setPrefSize(100,50);
        Button botondos = new Button("2");
        botondos.setPrefSize(100,50);
        Button botontres= new Button("3");
        botontres.setPrefSize(100,50);
        Button botonmas= new Button("+");
        botonmas.setPrefSize(100,50);
        Button botoncero= new Button("0");
        botoncero.setPrefSize(215,50);
        Button botonpunto= new Button(".");
        botonpunto.setPrefSize(100,50);
        Button botonigual= new Button("=");
        botonigual.setPrefSize(100,50);


        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10));
        layout.setHgap(15);
        layout.setVgap(20);

       layout.add(botonlimpiarto,0,1,2,1);
       layout.add(caja1,0,0,4,1);
       layout.add(botonlimpia,2,1);
        layout.add(botondiagonal,3,1);
        layout.add(botonsiete,0,2);
        layout.add(botonocho,1,2);
        layout.add(botonnueve,2,2);
        layout.add(botonasterisco,3,2);
        layout.add(botoncuatro,0,3);
        layout.add(botoncinco,1,3);
        layout.add(botonseis,2,3);
        layout.add(botonmenos,3,3);
        layout.add(botonuno,0,4);
        layout.add(botondos,1,4);
        layout.add(botontres,2,4);
        layout.add(botonmas,3,4);
        layout.add(botoncero,0,5,2,1);
        layout.add(botonpunto,2,5);
        layout.add(botonigual,3,5);

        botonuno.setOnAction(e ->
                {
                    if (caja1.getText().equalsIgnoreCase("0")) {
                        caja1.setText("1");
                    } else {
                        caja1.setText(caja1.getText() + "1");
                    }

                    caja1.setAlignment(Pos.CENTER_RIGHT);
                    caja1.setEditable(false);
                }
        );

        botoncero.setOnAction(e ->
                {
                    if (caja1.getText().equalsIgnoreCase("0")) {
                        caja1.setText("0");
                    } else {
                        caja1.setText(caja1.getText() + "0");
                    }

                    caja1.setAlignment(Pos.CENTER_RIGHT);
                    caja1.setEditable(false);
                }
        );

        botondos.setOnAction(e ->
                {
                    if (caja1.getText().equalsIgnoreCase("0")) {
                        caja1.setText("2");
                    } else {
                        caja1.setText(caja1.getText() + "2");
                    }

                    caja1.setAlignment(Pos.CENTER_RIGHT);
                    caja1.setEditable(false);
                }
        );

        botontres.setOnAction(e ->
                {
                    if (caja1.getText().equalsIgnoreCase("0")) {
                        caja1.setText("3");
                    } else {
                        caja1.setText(caja1.getText() + "3");
                    }

                    caja1.setAlignment(Pos.CENTER_RIGHT);
                    caja1.setEditable(false);
                }
        );

        botoncuatro.setOnAction(e ->
                {
                    if (caja1.getText().equalsIgnoreCase("0")) {
                        caja1.setText("4");
                    } else {
                        caja1.setText(caja1.getText() + "4");
                    }

                    caja1.setAlignment(Pos.CENTER_RIGHT);
                    caja1.setEditable(false);
                }
        );

        botoncinco.setOnAction(e ->
                {
                    if (caja1.getText().equalsIgnoreCase("0")) {
                        caja1.setText("5");
                    } else {
                        caja1.setText(caja1.getText() + "5");
                    }

                    caja1.setAlignment(Pos.CENTER_RIGHT);
                    caja1.setEditable(false);
                }
        );

        botonseis.setOnAction(e ->
                {
                    if (caja1.getText().equalsIgnoreCase("0")) {
                        caja1.setText("6");
                    } else {
                        caja1.setText(caja1.getText() + "6");
                    }

                    caja1.setAlignment(Pos.CENTER_RIGHT);
                    caja1.setEditable(false);
                }
        );
        botonsiete.setOnAction(e ->
                {
                    if (caja1.getText().equalsIgnoreCase("0")) {
                        caja1.setText("7");
                    } else {
                        caja1.setText(caja1.getText() + "7");
                    }

                    caja1.setAlignment(Pos.CENTER_RIGHT);
                    caja1.setEditable(false);
                }
        );

        botonocho.setOnAction(e ->
                {
                    if (caja1.getText().equalsIgnoreCase("0")) {
                        caja1.setText("8");
                    } else {
                        caja1.setText(caja1.getText() + "8");
                    }

                    caja1.setAlignment(Pos.CENTER_RIGHT);
                    caja1.setEditable(false);
                }
        );

        botonnueve.setOnAction(e ->
                {
                    if (caja1.getText().equalsIgnoreCase("0")) {
                        caja1.setText("9");
                    } else {
                        caja1.setText(caja1.getText() + "9");
                    }

                    caja1.setAlignment(Pos.CENTER_RIGHT);
                    caja1.setEditable(false);
                }
        );

        botonmas.setOnAction(e ->
                {
                    valor='+';
                  n1=Double.valueOf(caja1.getText());
                   caja1.setText("0");

                }
        );

        botonmenos.setOnAction(event -> {
            valor='-';
            n1=Double.valueOf(caja1.getText());
            caja1.setText("0");
            }
        );

        botondiagonal.setOnAction(event -> {
            valor='/';
            n1=Double.valueOf(caja1.getText());
            caja1.setText("0");
        });

        botonasterisco.setOnAction(event -> {
            valor='*';
            n1=Double.valueOf(caja1.getText());
            caja1.setText("0");
        });

        botonlimpiarto.setOnAction(event -> {
            caja1.setText("");
            caja1.setText("0");
        });

        botonlimpia.setOnAction(event -> {
              caja1.setText("0");
        });

        botonpunto.setOnAction(event -> {
            if(caja1.getText().contains(".")==false){
                caja1.setText(caja1.getText()+".");
            }

        });

        botonigual.setOnAction(e ->
                {
                    switch (valor){
                        case '+':
                        n2=Double.valueOf(caja1.getText());
                        nr=n1+n2;
                        enteros=(int)nr;
                        if(nr==enteros){
                            caja1.setText(""+(int)nr);
                        }else{
                            caja1.setText(""+nr);
                        }
                        break;
                        case '-':
                            n2=Double.valueOf(caja1.getText());
                            nr=n1-n2;
                            enteros=(int)nr;
                            if(nr==enteros){
                                caja1.setText(""+(int)nr);
                            }else{
                                caja1.setText(""+nr);
                            }
                            break;
                        case '/':
                            n2=Double.valueOf(caja1.getText());
                            nr=n1/n2;
                            enteros=(int)nr;
                            if(nr==enteros){
                                caja1.setText(""+(int)nr);
                            }else{
                                caja1.setText(""+nr);
                            }
                            break;
                        case  '*':
                            n2=Double.valueOf(caja1.getText());
                            nr=n1*n2;
                            enteros=(int)nr;
                            if(nr==enteros){
                                caja1.setText(""+(int)nr);
                            }else{
                                caja1.setText(""+nr);
                            }

                    }
                }
        );



        Scene escena  = new Scene(layout);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
}
