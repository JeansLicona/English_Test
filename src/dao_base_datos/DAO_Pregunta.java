/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_base_datos;

import query.DatosQuery;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Pregunta;
import modelo.Respuesta;

/**
 *
 * @author Jeans Michell
 */
public class DAO_Pregunta extends DAO_Base_Datos{
    
    public boolean registrarPregunta(Pregunta pregunta){
        boolean servicioCompletado;
        try {
            establecerConexion();
            String sentencia=datosSentencia.obtenerDatosParaRegistrarPregunta(pregunta);
            int id_pregunta=registrarDatoEnBaseDatos(nombreTabla, columnasTabla, sentencia);
            cerrarConexion();
            registrarRespuestasPregunta(id_pregunta, pregunta.getRespuestas());
            servicioCompletado=true;
        } catch (SQLException e) {
            servicioCompletado=false;
        }
        
        return servicioCompletado;
    }
    
    public boolean editarPregunta(Pregunta pregunta){
        boolean servicioCompletado;
        try {
            establecerConexion();
            String idPregunta=""+pregunta.getID_pregunta();
            String sentencia=datosSentencia.obtenerDatosParaEditarPregunta(pregunta);
            modificarDatoDeBaseDatos(nombreTabla, sentencia, columnaLlave, idPregunta);
            cerrarConexion();
            servicioCompletado=true;
        } catch (SQLException ex) {
            servicioCompletado=false;
        }
        return servicioCompletado;
    }
    
    public ArrayList<Pregunta> buscarPreguntasPorTipo(String tipo_pregunta){
        ArrayList datosPreguntas;
        try {
            establecerConexion();
            buscarDatoDeBaseDatos(nombreTabla, columnaTipo, tipo_pregunta);
            datosPreguntas=obtenerBusquedaEstructurada();
            cerrarConexion();
            convertirDatosAPregunta(datosPreguntas);   
        } catch (SQLException e) {
            System.out.println("Error al buscar todas las preguntas");
        }
        return preguntas;
    }
    
    public ArrayList<Pregunta> buscarPreguntas(){
        ArrayList datosPreguntas;
        try {
            establecerConexion();
            buscarTodosLosDatosDeLaTabla(nombreTabla);
            datosPreguntas=obtenerBusquedaEstructurada();
            cerrarConexion();
            convertirDatosAPregunta(datosPreguntas);   
        } catch (SQLException e) {
            System.out.println("Error al buscar todas las preguntas");
        }
        return preguntas;
    }
    
    public boolean eliminarPregunta(int id_pregunta){
        boolean servicioCompletado;
        try {
            establecerConexion();
            String idPregunta=""+id_pregunta;
            eliminarDatoDeBaseDatos(nombreTabla, columnaLlave, idPregunta);
            cerrarConexion();
            servicioCompletado=true;
        } catch (SQLException e) {
            servicioCompletado=false;
        }
        return servicioCompletado;
    }
    
    private DatosQuery datosSentencia=new DatosQuery();
    private String nombreTabla="pregunta";
    private String columnaLlave="id_pregunta";
    private String columnaTipo="tipo_pregunta";
    private String columnasTabla="pregunta, tipo_pregunta";
    private ArrayList<Pregunta> preguntas= new ArrayList<Pregunta>();
    private DAO_Respuesta daoRespuesta=new DAO_Respuesta();

    private void registrarRespuestasPregunta(int id_pregunta, ArrayList<Respuesta> respuestas) {
        for(int indice=0; indice< respuestas.size();indice++){
            daoRespuesta.registrarRespuesta(id_pregunta, respuestas.get(indice));
        }
    }

    private void convertirDatosAPregunta(ArrayList datosPreguntas) {
        for(int fila=0; fila<datosPreguntas.size();fila++){
            ArrayList datosPregunta=(ArrayList)datosPreguntas.get(fila);
            int id_pregunta=(Integer)datosPregunta.get(0);
            String descripPregunta=(String)datosPregunta.get(1);
            String tipo_pregunta=(String)datosPregunta.get(2);
            ArrayList<Respuesta> respuestas=daoRespuesta.buscarRespuestas(id_pregunta);
            Pregunta pregunta=new Pregunta(id_pregunta, descripPregunta, respuestas,tipo_pregunta);
            preguntas.add(pregunta);
        }
    }
    
}
