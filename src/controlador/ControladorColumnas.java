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
    
    private void actualizarVistas(){
        if(_posicion == 0 || _posicion == 2){
            
        }
        if(_posicion == 1 || _posicion ==3 ){
            
        }
    }
    
    private void obtenerDatosPreguntas(){
        _preguntas = _daoPregunta.buscarPreguntasPorTipo("2");
    }
    
    private Evaluado _evaluado = null;
    private Columnas _columnas = null;
    private ColumnasImage _columnasImage = null;
    private int _posicion = 0;
    private ArrayList<Pregunta> _preguntas = null;
    private DAO_Pregunta _daoPregunta = null;
}
