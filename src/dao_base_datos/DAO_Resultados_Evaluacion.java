/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_base_datos;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Evaluado;
import modelo.Resultado_Evaluacion;
import query.DatosQuery;

/**
 *
 * @author Jeans Michell
 */
public class DAO_Resultados_Evaluacion extends DAO_Base_Datos{
    
    public boolean registrarResultado(Resultado_Evaluacion resultado){
        boolean servicioCompletado;
        try {
            establecerConexion();
            String sentencia=datosSentencia.obtenerDatosParaRegistrarResultado(resultado);
            registrarDatoEnBaseDatos(nombreTabla, columnasTabla, sentencia);
            cerrarConexion();
            servicioCompletado=true;
        } catch (SQLException e) {
            servicioCompletado=false;
        }
        return servicioCompletado;
    }
    
    public boolean editarResultado(Resultado_Evaluacion resultado){
        boolean servicioCompletado;
        try{
            establecerConexion();
            String idResultado=""+resultado.getID_resultado();
            String sentencia=datosSentencia.obtenerDatosParaEditarResultado(resultado);
            modificarDatoDeBaseDatos(nombreTabla, sentencia, columnaLlave, idResultado);
            cerrarConexion();
            servicioCompletado=true;
        }catch(SQLException e){
            servicioCompletado=false;
        }
        return servicioCompletado;
    }
    
    public ArrayList<Resultado_Evaluacion> buscarResultados(){
        ArrayList datosResultado;
        try {
            establecerConexion();
            buscarTodosLosDatosDeLaTabla(nombreTabla);
            datosResultado=obtenerBusquedaEstructurada();
            cerrarConexion();
            convertirDatosAResultado(datosResultado);
        }catch(SQLException e){
            System.out.println("Error al buscar todos los resultados");
        }
        return resultados;
    }
    
    public Resultado_Evaluacion buscarResultadoEvaluado(int id_evaluado){
        ArrayList datosResultado;
        try {
            establecerConexion();
            String idEvaluado=""+id_evaluado;
            buscarDatoDeBaseDatos(nombreTabla, columnaFK, idEvaluado);
            datosResultado=obtenerBusquedaEstructurada();
            cerrarConexion();
            convertirDatosAResultado(datosResultado);
        }catch(SQLException e){
            System.out.println("Error al buscar todos los resultados");
        }
        return resultados.get(0);
    }
    
    public boolean eliminarResultado(int id_resultado){
        boolean servicioCompletado;
        try {
            establecerConexion();
            String idResultado=""+id_resultado;
            eliminarDatoDeBaseDatos(nombreTabla, columnaLlave, idResultado);
            cerrarConexion();
            servicioCompletado=true;
        } catch (SQLException e) {
            servicioCompletado=false;
        }
        return servicioCompletado;
    }
    
    
    
    private DatosQuery datosSentencia=new DatosQuery();
    private String nombreTabla="resultado";
    private String columnaLlave="id_resultado";
    private String columnaFK="evaluado";
    private String columnasTabla="evaluado, calificacion";
    private ArrayList<Resultado_Evaluacion> resultados=new ArrayList<Resultado_Evaluacion>();

    private void convertirDatosAResultado(ArrayList datosResultado) {
        DAO_Evaluado daoEvaluado= new DAO_Evaluado();
        for(int fila=0; fila<datosResultado.size(); fila++){
            ArrayList datosRespuesta=(ArrayList) datosResultado.get(fila);
            int id_resultado=(Integer)datosRespuesta.get(0);
            int id_evaluado=(Integer)datosRespuesta.get(1);
            double calificacion=(double)datosRespuesta.get(2);
            Evaluado evaluado=daoEvaluado.buscarEvaluadoporID(id_evaluado);
            Resultado_Evaluacion resultado=new Resultado_Evaluacion(id_resultado, evaluado, calificacion);
            resultados.add(resultado);
        }
    }
}
