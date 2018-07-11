package Layout;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Practica_011_TreeView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TreeItem<String> raiz, rama1, rama2;
        raiz = new TreeItem<String>("Alimentos");
        raiz.setExpanded(true);

        /*rama1 = new TreeItem<String>("Vegetales");
        rama1.setExpanded(true);
        raiz.getChildren().add(rama1);*/
        //es lo mismo que crear hijo

        rama1= crearHijo("Vegetales",raiz);

        /*rama2 = new TreeItem<String>("Carnes");
        rama2.setExpanded(true);
        raiz.getChildren().add(rama2);*/

        rama2=crearHijo("Carnes",raiz);

        crearHijo("Cebolla", rama1);
        crearHijo("Papa", rama1);
        crearHijo("Res",rama2);


        TreeView treeView = new TreeView(raiz);
        treeView.setShowRoot(true);



        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println(newValue);
            }
        });

       /* treeView.getSelectionModel().selectedItemProperty().addListener((o, anterior,nuevo)-> {
            System.out.println(nuevo);

        }); */
       //Igual que el de arriba treview

        VBox layout =new VBox();
        layout.getChildren().add(treeView);

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private TreeItem<String> crearHijo(String titulo, TreeItem padre){
        TreeItem<String> hijo = new TreeItem<>(titulo);
        hijo.setExpanded(true);
        padre.getChildren().add(hijo);
        return hijo;
    }
}
