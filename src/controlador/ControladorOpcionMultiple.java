/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dao_base_datos.DAO_Pregunta;
import java.util.ArrayList;
import modelo.Evaluado;
import modelo.LibroCalculo;
import modelo.Pregunta;
import modelo.Respuesta;
import vista.Examen;
import vista.Presentacion;

/**
 * Controlador para la pantalla de la seccion de Opcion Multiple
 * @author CFManuel
 */
public class ControladorOpcionMultiple {

    public ControladorOpcionMultiple(Evaluado evaluado){
     _opcionMultiple = new Examen(this);
     _daoPregunta = new DAO_Pregunta();
     _evaluado = evaluado;
     _respuestaUsuario = new ArrayList();
     _presentacion = new Presentacion(this);
     _libroCalculo = new LibroCalculo();
     generarEncabezadoLibroCalculo();
    }
    
    public void iniciarPresentacion(){
        _presentacion.setVisible(true);
    }
    /**
     * Inicia la pantalla de este controlador
     */
    public void iniciarPantalla() {
        actualizarCampos();
        _presentacion.setVisible(false);
        _opcionMultiple.setVisible(true);
    }
    
    /**
     * Siguiente Pregunta
     */
    public void siguientePregunta(){
        _posicion++;
        if(_posicion>=_preguntas.size()){
            calcularGuardarCalificacion();
            _opcionMultiple.setVisible(false);
            ControladorAgrupar ctrlOpMult= new ControladorAgrupar(_evaluado,_calificacion,_libroCalculo);
            ctrlOpMult.iniciarPantalla();
        }else{
            actualizarCampos();
        }
    }
    
    /**
     * Pregunta Anterior
     */
    public void preguntaAnterior(){
        _posicion--;
        actualizarCampos();
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
    
        
    public void asignarRespuestaUsuario(Respuesta respuestaElegida){
        try{
        _respuestaUsuario.set(_posicion, respuestaElegida);
        }catch(IndexOutOfBoundsException e){
            _respuestaUsuario.add(_posicion, respuestaElegida);
        }
    }
    
    public ArrayList<Respuesta> obtenerRespuestasUsuario(){
        return _respuestaUsuario;
    }
    
    public Respuesta obtenerRespuestaActual(int numeroRespuesta){
        return _respuestasActuales.get(numeroRespuesta);
    }
    
    /**
     * Actualiza los campos de la vista
     */
    private void actualizarCampos(){
        obtenerPreguntasConRespuestas();
        actualizarRespuestasActuales();
        
        _opcionMultiple.actualizarPregunta(obtenerPregunta());
        _opcionMultiple.actualizarOpcion1("<html>"+_respuestasActuales.get(0).getRespuesta()+"</html>");
        _opcionMultiple.actualizarOpcion2("<html>"+_respuestasActuales.get(1).getRespuesta()+"</html>");
        _opcionMultiple.actualizarOpcion3("<html>"+_respuestasActuales.get(2).getRespuesta()+"</html>");
        _opcionMultiple.actualizarOpcion4("<html>"+_respuestasActuales.get(3).getRespuesta()+"</html>");
        
        if(_respuestaUsuario.size()>_posicion){
            _opcionMultiple.limpiarSelecciones();
            int numeroRespuesta = _respuestasActuales.indexOf(_respuestaUsuario.get(_posicion));
            _opcionMultiple.selecionarOpcion(numeroRespuesta);
        }else{
            _opcionMultiple.limpiarSelecciones();
        }
    }
    
    private void obtenerPreguntasConRespuestas(){
        if (_preguntas==null){
            _preguntas = _daoPregunta.buscarPreguntasPorTipo("0");
        }else{
        }
    }
    
    private void actualizarRespuestasActuales(){
        Pregunta pregunta = (Pregunta) _preguntas.get(_posicion);
        _respuestasActuales = pregunta.getRespuestas();
    }
    
    private String obtenerPregunta(){
        Pregunta pregunta = (Pregunta) _preguntas.get(_posicion);
        return "<html>"+pregunta.getPregunta()+"</html>";
    }
    
    private void calcularGuardarCalificacion(){
        double calificacionSeccion1 = 0;
        
        for(int i=0;i<_respuestaUsuario.size();i++){
            calificacionSeccion1 = calificacionSeccion1 + _respuestaUsuario.get(i).getPonderacion();
            agregarRespuestaHojaCalculo(_preguntas.get(i).getPregunta(), _respuestaUsuario.get(i).getRespuesta(), String.valueOf(_respuestaUsuario.get(i).getPonderacion()));
        }
        System.out.println(calificacionSeccion1);
        _calificacion+=calificacionSeccion1;
        agregarRespuestaHojaCalculo("", "Total", String.valueOf(_calificacion));
    }
    
    private void generarEncabezadoLibroCalculo(){
        _libroCalculo.crearhoja("Seccion OpcionesMultiples");
        _libroCalculo.crearFila();
        _libroCalculo.crearCelda();
        _libroCalculo.editarCelda(_evaluado.getNombres()+" "+_evaluado.getPrimer_apellido()+" "+_evaluado.getSegundo_apellido());
        _libroCalculo.mezclarCampos(0, 0, 0, 2);
        _libroCalculo.crearFila();
        _libroCalculo.crearCelda();
        _libroCalculo.editarCelda("Pregunta");
        _libroCalculo.crearCelda();
        _libroCalculo.editarCelda("Respuesta Usuario");
        _libroCalculo.crearCelda();
        _libroCalculo.editarCelda("Valor de Respuesta");
    }
    
    private void agregarRespuestaHojaCalculo(String pregunta, String respuesta, String valor){
        _libroCalculo.crearFila();
        _libroCalculo.crearCelda();
        _libroCalculo.editarCelda(pregunta);
        _libroCalculo.crearCelda();
        _libroCalculo.editarCelda(respuesta);
        _libroCalculo.crearCelda();
        _libroCalculo.editarCelda(valor);
    }
    
    private Examen _opcionMultiple = null;
    private DAO_Pregunta _daoPregunta= null;
    private Evaluado _evaluado = null;
    private int _posicion = 0;
    private ArrayList<Respuesta> _respuestaUsuario = null;
    private ArrayList<Respuesta> _respuestasActuales = null;
    private ArrayList<Pregunta> _preguntas = null;
    private double _calificacion = 0;
    private Presentacion _presentacion= null;
    private LibroCalculo _libroCalculo = null; 
}
