package Layout;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Practica012_TableView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TableView<Producto> tableView;

        TableColumn<Producto, String> columnaNombre = new TableColumn<>("Nombre");
        columnaNombre.setMinWidth(250);
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));

        TableColumn<Producto, String> columnaCosto = new TableColumn<>("Costo");
        columnaCosto.setMinWidth(50);
        columnaCosto.setCellValueFactory(new PropertyValueFactory<>("costo"));

        TableColumn<Producto, String> columnaExistencia = new TableColumn<>("Existencia");
        columnaExistencia.setMinWidth(250);
        columnaExistencia.setCellValueFactory(new PropertyValueFactory<>("cantidadExisten"));

        ObservableList<Producto> elementos = FXCollections.observableArrayList();
        elementos.add(new Producto("Monitor HP",1000,20));
        elementos.add(new Producto("Mouse",200,2));
        elementos.add(new Producto("Teclado MX",250,3));

        tableView = new TableView<>();
        tableView.setItems(elementos);

        tableView.getColumns().addAll(columnaNombre, columnaCosto, columnaExistencia);

        StackPane layout = new StackPane();
        layout.getChildren().add(tableView);

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class Producto {
        private String nombreProducto;
        private double costo;
        private int cantidadExisten;

        public Producto(){
            this.nombreProducto = "";
            this.costo = 0;
            this.cantidadExisten = 0;
        }
     public Producto(String nombre, double costo, int cantidad){
            this.nombreProducto = nombre;
            this.costo = costo;
            this.cantidadExisten = cantidad;
     }

        public String getNombreProducto() {
            return nombreProducto;
        }

        public void setNombreProducto(String nombreProducto) {
            this.nombreProducto = nombreProducto;
        }

        public double getCosto() {
            return costo;
        }

        public void setCosto(double costo) {
            this.costo = costo;
        }

        public int getCantidadExisten() {
            return cantidadExisten;
        }

        public void setCantidadExisten(int cantidadExisten) {
            this.cantidadExisten = cantidadExisten;
        }
    }

}
