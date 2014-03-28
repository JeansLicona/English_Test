/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao_base_datos.DAO_Pregunta;
import dao_base_datos.DAO_Resultados_Evaluacion;
import java.util.ArrayList;
import modelo.Evaluado;
import modelo.Pregunta;
import modelo.Respuesta;
import modelo.Resultado_Evaluacion;
import vista.Agrupar;

/**
 * Controlador para la pantalla de la seccion de Opcion Multiple
 *
 * @author CFManuel
 */
public class ControladorAgrupar {

    public ControladorAgrupar(Evaluado evaluado, double calificacion) {
        _agrupar = new Agrupar(this);
        _evaluado = evaluado;
        _daoPregunta = new DAO_Pregunta();
        _respuestasComparar = new ArrayList();
        crearEstructuraRespuestaUsuario();
        _calificacion =  calificacion;
    }

    /**
     * Inicia la pantalla de este controlador
     */
    public void iniciarPantalla() {
        actualizarCampos();
        _agrupar.setVisible(true);
        _agrupar.deshabilitarRetroceso();
    }
    
    public void siguientePregunta(){
        _posicion++;
        if(_posicion>=_preguntas.size()){
            calcularCalificacion();
            _agrupar.setVisible(false);
            ControladorColumnas columnas = new ControladorColumnas(_evaluado,_calificacion);
            columnas.iniciarVista();
        }else{
            actualizarCampos();
            _agrupar.HabilitarRetroceso();
        }
    }
    
    public void regresarPregunta(){
        _posicion--;
        if(_posicion<=0){
            actualizarCampos();
            _agrupar.deshabilitarRetroceso();
        }else{
            actualizarCampos();
            _agrupar.HabilitarRetroceso();
        }
        
    }
    
    public void asignarRespuestaUsuario(String Respuesta,int indexSeccion,int indexRespuesta){
        _respuestaUsuario.get(_posicion).get(indexSeccion).set(indexRespuesta, Respuesta);
    }
    
    private void calcularCalificacion(){
        ArrayList<Respuesta> nuevaListaRespuestaUsuario = new ArrayList();
        int index = -1;
        int calificacion = 0;
        
        for (int i = 0; i < _respuestaUsuario.size(); i++) {
            for (int j = 0; j < _respuestaUsuario.get(i).size(); j++) {
                for (int k = 0; k < _respuestaUsuario.get(i).get(j).size(); k++) {
                    index = _respuestaUsuario.get(i).get(j).indexOf(_respuestasComparar.get(i).get(j).get(k).getRespuesta());

                    if(index>-1){
                        nuevaListaRespuestaUsuario.add(_respuestasComparar.get(i).get(j).get(index));
                        index = -1;
                    }
                }
            }
        }
        
        
        for (int i = 0; i < nuevaListaRespuestaUsuario.size(); i++) {
            calificacion+= nuevaListaRespuestaUsuario.get(i).getPonderacion();
        }
        _calificacion+=calificacion;
        System.out.println(calificacion);
    }
    

    /**
     * Estructura las respuestas agrupadas en la base de datos.
     */
    private void estructurarRespuestas() {
        ArrayList<Respuesta> respuestaJunta = new ArrayList();
        ArrayList<Respuesta> grupos = new ArrayList();
        ArrayList<ArrayList<Respuesta>> gruposRespuestas = new ArrayList();

        if (_preguntas == null) {
            _preguntas = _daoPregunta.buscarPreguntasPorTipo("1");
        }

        respuestaJunta = _preguntas.get(_posicion).getRespuestas();

        for (int i = 0; i < (respuestaJunta.size() / 4); i++) {
            ArrayList<Respuesta> gruposTemporales = new ArrayList();
            grupos.add(respuestaJunta.get(i * 4));
            gruposTemporales.add(respuestaJunta.get((i * 4) + 1));
            gruposTemporales.add(respuestaJunta.get((i * 4) + 2));
            gruposTemporales.add(respuestaJunta.get((i * 4) + 3));
            gruposRespuestas.add(gruposTemporales);
        }

        _gruposActuales = grupos;
        _grupoRespuestaActuales = gruposRespuestas;
        _respuestasComparar.add(_grupoRespuestaActuales);
    }

    /**
     * Actualiza los campos el la GUI
     */
    private void actualizarCampos() {
        estructurarRespuestas();
        asignarInstrucciones();
        asignarListaRespuestas();
        asignarNombreSecciones();
        asignarRespuestaUsuario();
    }

    /**
     * Crea una cadena con el conjunto de palabras al azar
     * @return Cadena de palabras
     */
    private String todasRespuestas() {
        String respuestas = "";
        int valorEntero = 0;
        ArrayList<Respuesta> todasRespuestas = new ArrayList();

        for (int i = 0; i < _grupoRespuestaActuales.size(); i++) {
            todasRespuestas.addAll(_grupoRespuestaActuales.get(i));
        }

        while (!todasRespuestas.isEmpty()) {
            if (todasRespuestas.size() == 1) {
                valorEntero = 0;
            } else {
                valorEntero = (int) Math.floor(Math.random() * (0 - (todasRespuestas.size() - 1) + 1) + (todasRespuestas.size() - 1));
            }
            respuestas = respuestas + " / " + todasRespuestas.get(valorEntero).getRespuesta();
            todasRespuestas.remove(valorEntero);
        }

        return respuestas;
    }

    /**
     * Asigna los nombres de las secciones al GUI
     */
    private void asignarNombreSecciones() {
        for (int i = 0; i < _gruposActuales.size(); i++) {
            _agrupar.actualizarSeccion(_gruposActuales.get(i).getRespuesta(), i + 1);
        }
    }

    /**
     * Asigna las instrucciones al GUI
     */
    private void asignarInstrucciones() {
        _agrupar.actualizarInstruccion(_preguntas.get(_posicion).getPregunta());
    }

    /**
     * Asigna la lista de las preguntas al GUI
     */
    private void asignarListaRespuestas() {
        _agrupar.listaRespuestas(todasRespuestas());
    }
    
    private void asignarRespuestaUsuario(){
        _agrupar.vaciarCampos();
        for(int i=0; i<_respuestaUsuario.get(_posicion).size();i++){
            for(int j=0; j<_respuestaUsuario.get(_posicion).get(i).size();j++){
                _agrupar.asignarRespuestasUsuario(_respuestaUsuario.get(_posicion).get(i).get(j), i+1, j+1);
            }
        }
    }
    
    private void crearEstructuraRespuestaUsuario(){
        ArrayList<String> primero1 = new ArrayList();
        primero1.add("");
        primero1.add("");
        primero1.add("");
        ArrayList<String> primero2 = new ArrayList();
        primero2.add("");
        primero2.add("");
        primero2.add("");
        ArrayList<String> primero3 = new ArrayList();
        primero3.add("");
        primero3.add("");
        primero3.add("");
        ArrayList<String> primero4 = new ArrayList();
        primero4.add("");
        primero4.add("");
        primero4.add("");
        
        ArrayList<String> primero5 = new ArrayList();
        primero5.add("");
        primero5.add("");
        primero5.add("");
        ArrayList<String> primero6 = new ArrayList();
        primero6.add("");
        primero6.add("");
        primero6.add("");
        ArrayList<String> primero7 = new ArrayList();
        primero7.add("");
        primero7.add("");
        primero7.add("");
        ArrayList<String> primero8 = new ArrayList();
        primero8.add("");
        primero8.add("");
        primero8.add("");
        
        ArrayList<ArrayList<String>> segundo1 = new ArrayList();
        segundo1.add(primero1);
        segundo1.add(primero2);
        segundo1.add(primero3);
        segundo1.add(primero4);
        ArrayList<ArrayList<String>> segundo2 = new ArrayList();
        segundo2.add(primero5);
        segundo2.add(primero6);
        segundo2.add(primero7);
        segundo2.add(primero8);
        
        ArrayList<ArrayList<ArrayList<String>>> tercero = new ArrayList();
        tercero.add(segundo1);
        tercero.add(segundo2);
        
        _respuestaUsuario = tercero;
    }

    private Agrupar _agrupar = null;
    private Evaluado _evaluado = null;
    private int _posicion = 0;
    private ArrayList<ArrayList<ArrayList<String>>> _respuestaUsuario = null;
    private ArrayList<Pregunta> _preguntas = null;
    private ArrayList<Respuesta> _gruposActuales = null;
    private ArrayList<ArrayList<Respuesta>> _grupoRespuestaActuales = null;
    private DAO_Pregunta _daoPregunta;
    private ArrayList<ArrayList<ArrayList<Respuesta>>> _respuestasComparar = null;
    private double _calificacion = 0;
}
