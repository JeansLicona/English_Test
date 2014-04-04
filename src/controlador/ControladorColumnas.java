/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao_base_datos.DAO_Pregunta;
import dao_base_datos.DAO_Resultados_Evaluacion;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Evaluado;
import modelo.LibroCalculo;
import modelo.Pregunta;
import modelo.Respuesta;
import modelo.Resultado_Evaluacion;
import vista.Columnas;
import vista.ColumnasImage;

/**
 *
 * @author CFManuel
 */
public class ControladorColumnas {

    public ControladorColumnas(Evaluado evaluado, double calificacion,LibroCalculo libroCalculo) {
        _evaluado = evaluado;
        _columnas = new Columnas(this);
        _columnasImage = new ColumnasImage(this);
        _daoPregunta = new DAO_Pregunta();
        _respuestaUsuario = new ArrayList();
        inicializarArrayList();
        _calificacion = calificacion;
        _libroCalculo = libroCalculo;
        _libroCalculo.resetiarMarcadores();
        generarEncabezadoLibroCalculo();
    }

    public void iniciarVista() {
        actualizarVistas();

    }

    public void siguientePregunta() {
        _posicion++;
        if (_posicion > 3) {
            calcularCalificacion();
        } else {
            actualizarVistas();
        }
    }

    public void regresarPregunta() {
        _posicion--;
        actualizarVistas();
    }

    public void agregarRespuestaUsuario(int respuesta, int posicion) {
        posicion = posicion - 1;
        try {
            _respuestaUsuario.get(_posicion).set(posicion, _columnaBRevuelta.get(respuesta).getRespuesta());
        } catch (IndexOutOfBoundsException e) {
            _respuestaUsuario.get(_posicion).add(posicion, _columnaBRevuelta.get(respuesta).getRespuesta());
        }
    }

    public void calcularCalificacion() {
        int calificacion = 0;
        for (int i = 0; i < _respuestaUsuario.size(); i++) {
            _posicion = i;
            respuestasActuales();
            for (int j = 0; j < _respuestaUsuario.get(i).size(); j++) {
                if (_columnaBActual.get(j).getRespuesta() == _respuestaUsuario.get(i).get(j)) {
                    agregarRespuestaHojaCalculo(_respuestaUsuario.get(i).get(j), _columnaBActual.get(j).getRespuesta(),String.valueOf(_columnaBActual.get(j).getPonderacion()));
                    calificacion += _columnaBActual.get(j).getPonderacion();
                }else{
                    agregarRespuestaHojaCalculo(_respuestaUsuario.get(i).get(j), _columnaBActual.get(j).getRespuesta(),"0");
                }
            }
        }
        System.out.println(calificacion);
        _calificacion += calificacion;
        agregarRespuestaHojaCalculo("", "Total", String.valueOf(calificacion));
        _libroCalculo.guardarLibro("InformeExamen("+_evaluado.getPrimer_apellido()+" "+_evaluado.getSegundo_apellido()+")");
        guardarCalificacion();
        _columnas.setVisible(false);
        JOptionPane.showMessageDialog(_columnas, "Su calificacion ha sido de "+_calificacion);
        System.exit(0);
    }

    public void guardarCalificacion() {
        DAO_Resultados_Evaluacion daoResultados = new DAO_Resultados_Evaluacion();
        Resultado_Evaluacion resultado = new Resultado_Evaluacion();
        resultado.setEvaluado(_evaluado);
        resultado.setResultado(_calificacion);
        daoResultados.registrarResultado(resultado);
    }

    private void actualizarVistas() {
        obtenerDatosPreguntas();
        respuestasActuales();

        if (_posicion == 0 || _posicion == 2) {
            asignarEtiquetasEImagenes();
            _columnasImage.setVisible(true);
            _columnas.setVisible(false);
        }
        if (_posicion == 1 || _posicion == 3) {
            asignarEtiquetas();
            _columnasImage.setVisible(false);
            _columnas.setVisible(true);
        }
    }

    private void asignarEtiquetas() {
        _columnas.actualizarPregunta("<html>"+_preguntas.get(_posicion).getPregunta()+"</html>");
        for (int i = 0; i < _columnaBRevuelta.size(); i++) {
            _columnas.asignarColumnaLetrasB("<html>"+_columnaBRevuelta.get(i).getRespuesta()+"</html>", i);
            _columnas.asignarColumnaLetrasA(_columnaAActual.get(i).getRespuesta(), i);
        }

        _columnas.limpiarCampos();
        for (int i = 0; i < _respuestaUsuario.get(_posicion).size(); i++) {
            for (int j = 0; j < _columnaBRevuelta.size(); j++) {
                if (_respuestaUsuario.get(_posicion).get(i) == _columnaBRevuelta.get(j).getRespuesta()) {
                    _columnas.asignarRespuestas(String.valueOf(i + 1), j);
                }
            }
        }
    }

    private void asignarEtiquetasEImagenes() {
        _columnasImage.actualizarPregunta("<html>"+_preguntas.get(_posicion).getPregunta()+"</html>");
        for (int i = 0; i < _columnaBRevuelta.size(); i++) {
            _columnasImage.asignarImagen(_columnaBRevuelta.get(i).getRespuesta(), i);
            _columnasImage.asignarColumnaLetras(_columnaAActual.get(i).getRespuesta(), i);
        }
        _columnasImage.limpiarCampos();
        for (int i = 0; i < _respuestaUsuario.get(_posicion).size(); i++) {
            for (int j = 0; j < _columnaBRevuelta.size(); j++) {
                if (_respuestaUsuario.get(_posicion).get(i) == _columnaBRevuelta.get(j).getRespuesta()) {
                    _columnasImage.asignarRespuestas(String.valueOf(i + 1), j);
                }
            }
        }
    }

    private void obtenerDatosPreguntas() {
        if (_preguntas == null) {
            _preguntas = _daoPregunta.buscarPreguntasPorTipo("2");
        }
    }

    private void respuestasActuales() {
        _columnaAActual = new ArrayList();
        _columnaBActual = new ArrayList();
        for (int i = 0; i < _preguntas.get(_posicion).getRespuestas().size(); i++) {
            _columnaAActual.add(_preguntas.get(_posicion).getRespuestas().get(i));
            i++;
            _columnaBActual.add(_preguntas.get(_posicion).getRespuestas().get(i));
        }

        ArrayList<Respuesta> destruir = _columnaBActual;
        _columnaBRevuelta = new ArrayList();
        int valorEntero = 0;

        while (!destruir.isEmpty()) {
            if (destruir.size() == 1) {
                valorEntero = 0;
            } else {
                valorEntero = (int) Math.floor(Math.random() * (0 - (destruir.size() - 1) + 1) + (destruir.size() - 1));
            }
            _columnaBRevuelta.add(destruir.get(valorEntero));
            destruir.remove(valorEntero);
        }

        for (int i = 0; i < _preguntas.get(_posicion).getRespuestas().size(); i++) {
            i++;
            _columnaBActual.add(_preguntas.get(_posicion).getRespuestas().get(i));
        }
    }

    public void inicializarArrayList() {
        ArrayList array1 = new ArrayList();
        ArrayList array2 = new ArrayList();
        ArrayList array3 = new ArrayList();
        ArrayList array4 = new ArrayList();

        array1.add("");
        array1.add("");
        array1.add("");
        array1.add("");
        array1.add("");
        array2.add("");
        array2.add("");
        array2.add("");
        array2.add("");
        array2.add("");
        array3.add("");
        array3.add("");
        array3.add("");
        array3.add("");
        array3.add("");
        array4.add("");
        array4.add("");
        array4.add("");
        array4.add("");
        array4.add("");

        _respuestaUsuario.add(array1);
        _respuestaUsuario.add(array2);
        _respuestaUsuario.add(array3);
        _respuestaUsuario.add(array4);
    }
    
            private void generarEncabezadoLibroCalculo(){
        _libroCalculo.crearhoja("Seccion Columnas");
        _libroCalculo.crearFila();
        _libroCalculo.crearCelda();
        _libroCalculo.editarCelda(_evaluado.getNombres()+" "+_evaluado.getPrimer_apellido()+" "+_evaluado.getSegundo_apellido());
        _libroCalculo.mezclarCampos(0, 0, 0, 2);
        _libroCalculo.crearFila();
        _libroCalculo.crearCelda();
        _libroCalculo.editarCelda("Columna A");
        _libroCalculo.crearCelda();
        _libroCalculo.editarCelda("Columna B");
        _libroCalculo.crearCelda();
        _libroCalculo.editarCelda("Valor de Respuesta");
    }
        
        private void agregarRespuestaHojaCalculo(String columnaA, String columnaB, String valor){
        _libroCalculo.crearFila();
        _libroCalculo.crearCelda();
        _libroCalculo.editarCelda(columnaA);
        _libroCalculo.crearCelda();
        _libroCalculo.editarCelda(columnaB);
        _libroCalculo.crearCelda();
        _libroCalculo.editarCelda(valor);
    }

    private Evaluado _evaluado = null;
    private Columnas _columnas = null;
    private ColumnasImage _columnasImage = null;
    private int _posicion = 0;
    private ArrayList<Pregunta> _preguntas = null;
    private DAO_Pregunta _daoPregunta = null;
    private ArrayList<Respuesta> _columnaAActual = null;
    private ArrayList<Respuesta> _columnaBActual = null;
    private ArrayList<Respuesta> _columnaBRevuelta = null;
    private ArrayList<ArrayList<String>> _respuestaUsuario = null;
    private double _calificacion = 0;
    private LibroCalculo _libroCalculo = null;

}
