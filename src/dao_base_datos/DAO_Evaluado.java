/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_base_datos;

import query.DatosQuery;
import static dao_base_datos.DAO_Base_Datos.establecerConexion;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Evaluado;

/**
 *
 * @author Jeans Michell
 */
public class DAO_Evaluado extends DAO_Base_Datos {

    public boolean registrarEvaluado(Evaluado evaluado) {
        boolean servicioCompletado;
        try {
            String nombre_usuario = evaluado.getNombre_usuario();
            if (!existeNombreUsuario(nombre_usuario)) {
                establecerConexion();
                String sentencia = datosSentencia.obtenerDatosParaRegistrarEvaluado(evaluado);
                registrarDatoEnBaseDatos(nombreTabla, columnasTabla, sentencia);
                cerrarConexion();
                servicioCompletado = true;
            }else{
                servicioCompletado=false;
            }
        } catch (SQLException e) {
            servicioCompletado = false;
        }
        return servicioCompletado;
    }

    public boolean editarEvaluado(Evaluado evaluado) {
        boolean servicioCompletado;
        try {
            establecerConexion();
            String idEvaluado = "" + evaluado.getID_evaluado();
            String sentencia = datosSentencia.obtenerDatosParaEditarEvaluado(evaluado);
            modificarDatoDeBaseDatos(nombreTabla, sentencia, columnaLlave, idEvaluado);
            cerrarConexion();
            servicioCompletado = true;
        } catch (SQLException e) {
            servicioCompletado = false;
        }
        return servicioCompletado;
    }

    public Evaluado buscarEvaluado(String nombre_usuario) {
        ArrayList datosEvaluados;
        try {
            establecerConexion();
            buscarDatoDeBaseDatos(nombreTabla, columnaNombreUsuario, nombre_usuario);
            datosEvaluados = obtenerBusquedaEstructurada();
            cerrarConexion();
            convertirDatosAEvaluado(datosEvaluados);
        } catch (SQLException e) {
            System.out.println("Error al buscar a todos las personas Evaluadas");
        }
        return evaluados.get(0);
    }
    
    public Evaluado buscarEvaluadoporID(int id_usuario) {
        ArrayList datosEvaluados;
        try {
            establecerConexion();
            String idUsuario=""+id_usuario;
            buscarDatoDeBaseDatos(nombreTabla, columnaLlave, idUsuario);
            datosEvaluados = obtenerBusquedaEstructurada();
            cerrarConexion();
            convertirDatosAEvaluado(datosEvaluados);
        } catch (SQLException e) {
            System.out.println("Error al buscar a todos las personas Evaluadas");
        }
        return evaluados.get(0);
    }

    public ArrayList<Evaluado> buscarEvaluados() {
        ArrayList datosEvaluados;
        try {
            establecerConexion();
            buscarTodosLosDatosDeLaTabla(nombreTabla);
            datosEvaluados = obtenerBusquedaEstructurada();
            cerrarConexion();
            convertirDatosAEvaluado(datosEvaluados);
        } catch (SQLException e) {
            System.out.println("Error al buscar a todos las personas Evaluadas");
        }
        return evaluados;
    }

    public boolean eliminarEvaluado(int id_evaluado) {
        boolean servicioCompletado;
        try {
            establecerConexion();
            String idEvaluado=""+id_evaluado;
            eliminarDatoDeBaseDatos(nombreTabla, columnaLlave, idEvaluado);
            cerrarConexion();
            servicioCompletado = true;
        } catch (SQLException e) {
            servicioCompletado = false;
        }
        return servicioCompletado;
    }
    
    private DatosQuery datosSentencia = new DatosQuery();
    private String nombreTabla = "evaluado";
    private String columnaNombreUsuario = "nombre_usuario";
    private String columnasTabla = "nombres, primer_apellido, segundo_apellido, nombre_usuario";
    private String columnaLlave = "id_evaluado";
    private ArrayList<Evaluado> evaluados = new ArrayList<Evaluado>();

    private void convertirDatosAEvaluado(ArrayList datosEvaluados) {
        for (int fila = 0; fila < datosEvaluados.size(); fila++) {
            ArrayList datosEvaluado = (ArrayList) datosEvaluados.get(fila);
            int id_evaluado = (Integer) datosEvaluado.get(0);
            String nombres = (String) datosEvaluado.get(1);
            String primer_apellido = (String) datosEvaluado.get(2);
            String segundo_apellido = (String) datosEvaluado.get(3);
            String nombre_usuario = (String) datosEvaluado.get(4);
            Evaluado evaluado = new Evaluado(id_evaluado, nombres, primer_apellido, segundo_apellido, nombre_usuario);
            evaluados.add(evaluado);
        }
    }

    private boolean existeNombreUsuario(String nombre_usuario) {
        ArrayList datosEvaluados;
        boolean existeEvaluado = true;
        try {
            buscarDatoDeBaseDatos(nombreTabla, columnaNombreUsuario, nombre_usuario);
            datosEvaluados = obtenerBusquedaEstructurada();
            convertirDatosAEvaluado(datosEvaluados);
            if (evaluados.isEmpty()) {
                existeEvaluado = false;
            }
        } catch (SQLException e) {
            System.out.println("Error por Busqueda de Todos las personas Evaluadas");
        }
        return existeEvaluado;
    }
}
