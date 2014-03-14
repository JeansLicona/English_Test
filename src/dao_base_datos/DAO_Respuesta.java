/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_base_datos;

import query.DatosQuery;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Respuesta;

/**
 *
 * @author Jeans Michell
 */
public class DAO_Respuesta extends DAO_Base_Datos{
    
    public boolean registrarRespuesta(int id_pregunta,Respuesta respuesta){
        boolean servicioCompletado;
        try {
            establecerConexion();
            String sentencia= datosSentencia.obtenerDatosParaRegistrarRespuesta(id_pregunta, respuesta);
            registrarDatoEnBaseDatos(nombreTabla, columnasTabla, sentencia);
            cerrarConexion();
            servicioCompletado=true;
        }catch(SQLException e){
            servicioCompletado=false;
        }
        return servicioCompletado;
    }
    
    public boolean editarRespuesta(Respuesta respuesta){
        boolean servicioCompletado;
        try {
            establecerConexion();
            String idRespuesta=""+respuesta.getID_respuesta();
            String sentencia=datosSentencia.obtenerDatosParaEditarRespuesta(respuesta);
            modificarDatoDeBaseDatos(nombreTabla, sentencia, columnaLlave, idRespuesta);
            cerrarConexion();
            servicioCompletado=true;
        } catch (SQLException e) {
            servicioCompletado=false;
        }
        return servicioCompletado;
    }
    
    public ArrayList<Respuesta> buscarRespuestas(int id_pregunta){
        ArrayList datosRespuestas;
        ArrayList<Respuesta> respuestas = null;
        try {
            establecerConexion();
            String idPregunta= ""+id_pregunta;
            buscarDatoDeBaseDatos(nombreTabla, columnaFK, idPregunta);
            datosRespuestas=obtenerBusquedaEstructurada();
            cerrarConexion();
            respuestas = convertirDatosARespuesta(datosRespuestas);    
        } catch (SQLException e) {
            System.out.println("Error al buscar las respuestas");
        }
        return respuestas;
    }
    
    public boolean eliminarRespuesta(int id_pregunta){
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
    
    private DatosQuery datosSentencia= new DatosQuery();
    private String nombreTabla="respuesta";
    private String columnaLlave="id_respuesta";
    private String columnaFK="pregunta_id";
    private String columnasTabla="respuesta , ponderacion, pregunta_id";
    //private ArrayList<Respuesta> respuestas=new ArrayList<Respuesta>();
    
    private ArrayList<Respuesta> convertirDatosARespuesta(ArrayList datosRespuestas){
        ArrayList<Respuesta> respuestas = new ArrayList();
        for (int fila = 0; fila < datosRespuestas.size(); fila++) {
            ArrayList datosRespuesta=(ArrayList)datosRespuestas.get(fila);
            int id_respuesta=(Integer)datosRespuesta.get(0);
            String respuestaDescripcion=(String)datosRespuesta.get(1);
            double ponderacion=(double)datosRespuesta.get(2);
            Respuesta respuesta=new Respuesta(id_respuesta, respuestaDescripcion, ponderacion);
            respuestas.add(respuesta);
        }
        return respuestas;
    }
}
