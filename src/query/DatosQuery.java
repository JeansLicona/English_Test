/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

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
        datosPregunta+="'"+pregunta.getPregunta()+"',";
        datosPregunta+="'"+pregunta.getTipo_pregunta()+"'";
        return datosPregunta;
    }
    
    public String obtenerDatosParaRegistrarRespuesta(int id_pregunta,Respuesta respuesta){
        String datosRespuesta="";
        datosRespuesta+="'"+respuesta.getRespuesta()+"',";
        datosRespuesta+=respuesta.getPonderacion()+",";
        datosRespuesta+=id_pregunta;
        return datosRespuesta;
    }
    
    public String obtenerDatosParaRegistrarEvaluado(Evaluado evaluado){
        String datosEvaluado="";
        datosEvaluado+="'"+evaluado.getNombres()+"',";
        datosEvaluado+="'"+evaluado.getPrimer_apellido()+"',";
        datosEvaluado+="'"+evaluado.getSegundo_apellido()+"',";
        datosEvaluado+="'"+evaluado.getNombre_usuario()+"'";
        return datosEvaluado;
    }
    
    public String obtenerDatosParaRegistrarResultado(Resultado_Evaluacion resultado){
        String datosResultado="";
        datosResultado+=(resultado.getEvaluado()).getID_evaluado()+",";
        datosResultado+=resultado.getResultado();
        return datosResultado;
    }

    public String obtenerDatosParaEditarEvaluado(Evaluado evaluado) {
        String datosModificarEvaluado="";
        datosModificarEvaluado+="nombres = '"+evaluado.getNombres()+"',";
        datosModificarEvaluado+="primer_apellido = '"+evaluado.getPrimer_apellido()+"',";
        datosModificarEvaluado+="segundo_apellido = '"+evaluado.getSegundo_apellido()+"',";
        datosModificarEvaluado+="nombre_usuario = '"+evaluado.getNombre_usuario()+"'";
        return datosModificarEvaluado;
    }

    public String obtenerDatosParaEditarRespuesta(Respuesta respuesta) {
        String datosModificarEvaluado="";
        datosModificarEvaluado+="respuesta= '"+respuesta.getRespuesta()+"',";
        datosModificarEvaluado+="ponderacion= "+respuesta.getPonderacion();
        return datosModificarEvaluado;
    }

    public String obtenerDatosParaEditarPregunta(Pregunta pregunta) {
        String datosModificarPregunta="";
        datosModificarPregunta+="pregunta='"+pregunta.getPregunta()+"',";
        datosModificarPregunta+="tipo_pregunta='"+pregunta.getTipo_pregunta()+"'";
        return datosModificarPregunta;
    }

    public String obtenerDatosParaEditarResultado(Resultado_Evaluacion resultado) {
        String datosModificarResultado="";
        datosModificarResultado+="evaluado="+(resultado.getEvaluado()).getID_evaluado()+",";
        datosModificarResultado+="calificacion="+resultado.getResultado();
        return datosModificarResultado;
    }
}
