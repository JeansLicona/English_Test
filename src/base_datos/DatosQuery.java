/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base_datos;

import modelo.Evaluado;
import modelo.Pregunta;
import modelo.Respuesta;
import modelo.Resultado_Evaluacion;

/**
 *
 * @author Jeans Michell
 */
public class DatosQuery {
    
    public String obtenerDatosParaRegistrarPregunta(Pregunta pregunta){
        String datosPregunta="";
        datosPregunta+=pregunta.getDescripcion();
        return datosPregunta;
    }
    
    public String obtenerDatosParaRegistrarRespuesta(int id_pregunta,Respuesta respuesta){
        String datosRespuesta="";
        datosRespuesta+=respuesta.getDescripcion();
        datosRespuesta+=respuesta.getPonderacion();
        datosRespuesta+=id_pregunta;
        return datosRespuesta;
    }
    
    public String obtenerDatosParaRegistrarEvaluado(Evaluado evaluado){
        String datosEvaluado="";
        datosEvaluado+=evaluado.getNombres();
        datosEvaluado+=evaluado.getPrimer_apellido();
        datosEvaluado+=evaluado.getSegundo_apellido();
        datosEvaluado+=evaluado.getNombre_usuario();
        return datosEvaluado;
    }
    
    public String obtenerDatosParaRegistrarResultado(Resultado_Evaluacion resultado){
        String datosResultado="";
        datosResultado+=(resultado.getEvaluado()).getID_evaluado();
        datosResultado+=resultado.getResultado();
        return datosResultado;
    }
}
