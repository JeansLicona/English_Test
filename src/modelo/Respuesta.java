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

    public Respuesta(){}
    
    public Respuesta(int id_respuesta,String respuesta,double ponderacion){
        this.id_respuesta=id_respuesta;
        this.respuesta=respuesta;
        this.ponderacion=ponderacion;
    }
    
    public int getID_respuesta() {
        return id_respuesta;
    }

    public void setID_respuesta(int id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public double getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(double ponderacion) {
        this.ponderacion = ponderacion;
    }
    private int id_respuesta;
    private String respuesta;
    private double ponderacion;
}
