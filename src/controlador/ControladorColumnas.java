/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dao_base_datos.DAO_Pregunta;
import java.util.ArrayList;
import modelo.Evaluado;
import modelo.Pregunta;
import modelo.Respuesta;
import vista.Columnas;
import vista.ColumnasImage;

/**
 *
 * @author CFManuel
 */
public class ControladorColumnas {
    
    public ControladorColumnas(Evaluado evaluado){
        _evaluado = evaluado;
        _columnas =  new Columnas(this);
        _columnasImage =  new ColumnasImage(this);
        _daoPregunta = new DAO_Pregunta();
    }
    
    public void iniciarVista(){
        actualizarVistas();
        _columnasImage.setVisible(true);
    }
    
    private void actualizarVistas(){
        obtenerDatosPreguntas();
        respuestasActuales();
        
        if(_posicion == 0 || _posicion == 2){
             asignarImagenes();
        }
        if(_posicion == 1 || _posicion ==3 ){
            
        }
    }
    private void asignarImagenes(){
        for(int i=0;i<_ColumnaBRevuelta.size();i++){
            _columnasImage.asignarImagen(_ColumnaBRevuelta.get(i).getRespuesta(), i);
            _columnasImage.asignarColumnaLetras(_columnaAActual.get(i).getRespuesta(), i);
        }
    }
    
    private void obtenerDatosPreguntas(){
        if(_preguntas==null){
            _preguntas = _daoPregunta.buscarPreguntasPorTipo("2");
        }
    }
    
    private void respuestasActuales(){
        _columnaAActual = new ArrayList();
        _columnaBActual = new ArrayList();
        for(int i = 0;i<_preguntas.get(_posicion).getRespuestas().size();i++){
            _columnaAActual.add(_preguntas.get(_posicion).getRespuestas().get(i));
            i++;
            _columnaBActual.add(_preguntas.get(_posicion).getRespuestas().get(i));
        }
        
        ArrayList<Respuesta> destruir= _columnaBActual;
        _ColumnaBRevuelta = new ArrayList();
        int valorEntero=0;
        
        while (!destruir.isEmpty()) {
            if (destruir.size() == 1) {
                valorEntero = 0;
            } else {
                valorEntero = (int) Math.floor(Math.random() * (0 - (destruir.size() - 1) + 1) + (destruir.size() - 1));
            }
            _ColumnaBRevuelta.add(destruir.get(valorEntero));
            destruir.remove(valorEntero);
        }
        
        for(int i = 0;i<_preguntas.get(_posicion).getRespuestas().size();i++){
            i++;
            _columnaBActual.add(_preguntas.get(_posicion).getRespuestas().get(i));
        }
    }
    
    private Evaluado _evaluado = null;
    private Columnas _columnas = null;
    private ColumnasImage _columnasImage = null;
    private int _posicion = 0;
    private ArrayList<Pregunta> _preguntas = null;
    private DAO_Pregunta _daoPregunta = null;
    private ArrayList<Respuesta> _columnaAActual = null;
    private ArrayList<Respuesta> _columnaBActual = null;
    private ArrayList<Respuesta> _ColumnaBRevuelta =null;
    
}
