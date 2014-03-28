/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao_base_datos.DAO_Pregunta;
import dao_base_datos.DAO_Respuesta;
import java.util.ArrayList;
import modelo.Pregunta;
import vista.EdicionExamen;


/**
 *
 * @author Jeans Michell
 */
public class ControladorEdicionExamen {
    public ControladorEdicionExamen(){
        _daoPreguntas=new DAO_Pregunta();
        _daoRespuesta=new DAO_Respuesta();
        _preguntas=new ArrayList<>();
        _edicionExamen=new EdicionExamen(this);
    }
    
    public void iniciarPantalla(){
        _edicionExamen.setVisible(true);
        obtenerPrueba();
        asignarSecciones();
    }
    
    public void editarPregunta(Pregunta preguntaEditada) {
        _daoPreguntas.editarPregunta(preguntaEditada);
        editarRespuestas(preguntaEditada);
    }
    
    private DAO_Pregunta _daoPreguntas=null;
    private DAO_Respuesta _daoRespuesta=null;
    private ArrayList<Pregunta> _preguntas=null;
    private EdicionExamen _edicionExamen=null;
    
    private void obtenerPrueba(){
        _preguntas=_daoPreguntas.buscarPreguntas();
    }
    
    private void asignarSecciones(){
        _edicionExamen.asignarExamen(_preguntas);
    }

    private void editarRespuestas(Pregunta preguntaEditada) {
        for(int indice=0; indice<preguntaEditada.getRespuestas().size();indice++){
            _daoRespuesta.editarRespuesta(preguntaEditada.getRespuestas().get(indice));
        }
    }
}
