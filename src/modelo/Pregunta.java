/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Jeans Michell
 */
public class Pregunta {

    public Pregunta(){}
    
    public Pregunta(int id_pregunta,String pregunta,ArrayList<Respuesta> respuestas,String tipo_pregunta){
        this.id_pregunta=id_pregunta;
        this.pregunta=pregunta;
        this.respuestas=respuestas;
        this.tipo_pregunta=tipo_pregunta;
    }
    
    public int getID_pregunta() {
        return id_pregunta;
    }

    public void setID_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
    
    public String getTipo_pregunta() {
        return tipo_pregunta;
    }

    public void setTipo_pregunta(String tipo_pregunta) {
        this.tipo_pregunta = tipo_pregunta;
    }
    
    private int id_pregunta;
    private String pregunta;
    private ArrayList<Respuesta> respuestas;
    private String tipo_pregunta;
    
}
