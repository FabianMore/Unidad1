package Unidad_3_4;

public class Existencia {
    private int idExistencia;
    private int idProducto;
    private String cantidad;
    private String costo;

    public Existencia(int idExistencia, int idProducto, String cantidad, String costo) {
        this.idExistencia = idExistencia;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public int getIdExistencia() {
        return idExistencia;
    }

    public void setIdExistencia(int idExistencia) {
        this.idExistencia = idExistencia;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
}