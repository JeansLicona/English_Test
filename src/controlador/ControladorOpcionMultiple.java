/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dao_base_datos.DAO_Pregunta;
import dao_base_datos.DAO_Respuesta;
import java.util.ArrayList;
import modelo.Evaluado;
import modelo.Pregunta;
import modelo.Respuesta;
import modelo.Resultado_Evaluacion;
import vista.Examen;

/**
 * Controlador para la pantalla de la seccion de Opcion Multiple
 * @author CFManuel
 */
public class ControladorOpcionMultiple {

    public ControladorOpcionMultiple(Evaluado evaluado){
     _opcionMultiple = new Examen(this);
     _daoPregunta = new DAO_Pregunta();
     _evaluado = evaluado;
    }
    
    /**
     * Inicia la pantalla de este controlador
     */
    public void iniciarPantalla() {
        actualizarCampos();
        _opcionMultiple.setVisible(true);
    }
    
    /**
     * Siguiente Pregunta
     */
    public void siguientePregunta(){
        _posicion++;
        actualizarCampos();
        System.out.println(_posicion);
        if(_posicion>=5){
        }
    }
    
    /**
     * Pregunta Anterior
     */
    public void preguntaAnterior(){
        _posicion--;
        if((_posicion-1)<0){
            _opcionMultiple.bloquerRetroceso();
        }else{
            _opcionMultiple.habilitarRetroceso();
        }
    }
    
    /**
     * Asigna la posicion de la pregunta actual
     * @param posicion posicion de la pregunta actual
     */
    public void setPosicion(int posicion){
        _posicion = posicion;
    }
    
    /**
     * Actualiza los campos de la vista
     */
    private void actualizarCampos(){
        ArrayList<Pregunta> preguntas = _daoPregunta.buscarPreguntasPorTipo("0");
        ArrayList<Respuesta> respuestas = null;
        
        Pregunta pregunta = (Pregunta) preguntas.get(_posicion);
        respuestas = pregunta.getRespuestas();
        
        _opcionMultiple.actualizarPregunta(pregunta.getPregunta());
        _opcionMultiple.actualizarOpcion1(respuestas.get(0).getRespuesta());
        _opcionMultiple.actualizarOpcion2(respuestas.get(1).getRespuesta());
        _opcionMultiple.actualizarOpcion3(respuestas.get(2).getRespuesta());
        _opcionMultiple.actualizarOpcion4(respuestas.get(3).getRespuesta());
    }
    
    private Examen _opcionMultiple = null;
    private DAO_Pregunta _daoPregunta= null;
    private Evaluado _evaluado = null;
    private int _posicion = 0;
}
