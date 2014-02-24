/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jeans Michell
 */
public class Respuesta {

    public int getID_respuesta() {
        return id_respuesta;
    }

    public void setID_respuesta(int id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(double ponderacion) {
        this.ponderacion = ponderacion;
    }
    private int id_respuesta;
    private String descripcion;
    private double ponderacion;
}
