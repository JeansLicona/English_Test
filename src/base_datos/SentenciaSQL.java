/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeans Michell
 */
public class SentenciaSQL {

    public int registrarDatoDeBaseDatos(String nombreTabla, String columnas, String datos) throws SQLException {
        servidor = crearConexion();
        sentenciaConsultaSql = crearsentenciaparaRegistro(nombreTabla, columnas, datos);
        int clave = ejecutarActualizacion(servidor, sentenciaConsultaSql);
        return clave;
    }

    public void eliminarDatoDeBaseDatos(String nombreTabla, String columna, String datocolumna) throws SQLException {
        servidor = crearConexion();
        sentenciaConsultaSql = crearsentenciaparaEliminacion(nombreTabla, columna, datocolumna);
        ejecutarSolicitud(servidor, sentenciaConsultaSql);
    }

    public void modificarDatoDeBaseDatos(String nombreTabla, String datosNuevo, String columnaId, String datoId) throws SQLException {
        servidor = crearConexion();
        sentenciaConsultaSql = crearsentenciaparaModificacion(nombreTabla, datosNuevo, columnaId, datoId);
        ejecutarSolicitud(servidor, sentenciaConsultaSql);

    }

    public void buscarDatoDeBaseDatos(String nombreTabla, String columnaId, String datoId) throws SQLException {
        servidor = crearConexion();
        sentenciaConsultaSql = crearsentenciaparaBusqueda(nombreTabla, columnaId, datoId);
        ejecutarBusqueda(servidor, sentenciaConsultaSql);
    }

    public void buscarTodosLosDatosDeLaTabla(String nombreTabla) throws SQLException {
        servidor = crearConexion();
        sentenciaConsultaSql = crearsentenciaparaBusquedaTotal(nombreTabla);
        ejecutarBusqueda(servidor, sentenciaConsultaSql);
    }

    public void buscarDatoDeBaseDatosTotalDatosOrdenados(String nombreTabla, String columnaId) throws SQLException {
        servidor = crearConexion();
        sentenciaConsultaSql = crearsentenciaparaBusquedaTotalOrdenada(nombreTabla, columnaId);
        ejecutarBusqueda(servidor, sentenciaConsultaSql);
    }

    public ArrayList obtenerBusquedaEstructurada() throws SQLException {
        ResultSet resultadoBusqueda = obtenerResultadoBusquedaDeBaseDatos();
        ArrayList BusquedaDivididaPorRenglonesYColumnas = new ArrayList();
        BusquedaDivididaPorRenglonesYColumnas = dividirBusquedaPorRenglonesyColumnas(resultadoBusqueda);
        return BusquedaDivididaPorRenglonesYColumnas;
    }
    
    private static String baseDatos = "coa";
    private static String usuarioBaseDatos = "root";
    private static String contraseña = "";
    private static String url = "jdbc:mysql://localhost/" + baseDatos;
    private static Connection conexion = null;
    private Statement servidor = null;
    private String sentenciaConsultaSql;
    private ResultSet Busqueda;
    
    protected static Connection establecerConexion() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuarioBaseDatos, contraseña);

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return conexion;
    }

    protected void cerrarConexion() throws SQLException {
        conexion.close();
    }
    
    private ArrayList dividirBusquedaPorRenglonesyColumnas(ResultSet resultadoBusqueda) throws SQLException {
        ArrayList BusquedaFinal = new ArrayList();

        ResultSetMetaData metadato = (ResultSetMetaData) resultadoBusqueda.getMetaData();

        int columnas = metadato.getColumnCount();
        while (resultadoBusqueda.next()) {
            ArrayList Fila = new ArrayList();

            for (int i = 1; i <= columnas; i++) {
                Fila.add(resultadoBusqueda.getObject(i));
            }
            BusquedaFinal.add(Fila);
        }
        return BusquedaFinal;
    }

    private Statement crearConexion() throws SQLException {
        return conexion.createStatement();
    }

    private String crearsentenciaparaRegistro(String nombreTabla, String columnas, String datos) {
        String consulta = "";
        consulta = "insert into " + nombreTabla + "(" + columnas + ")" + " values(" + datos + ");";
        return consulta;
    }

    private String crearsentenciaparaEliminacion(String nombreTabla, String columna, String datocolumna) {
        String consulta = "";
        consulta = "delete from " + nombreTabla + " where " + columna + " = " + datocolumna;
        return consulta;
    }

    private String crearsentenciaparaModificacion(String nombreTabla, String datosNuevo, String columnaId, String datoId) {
        String consulta = "";
        consulta = "update " + nombreTabla + " set " + datosNuevo + " where " + columnaId + " = " + datoId;
        return consulta;
    }

    private String crearsentenciaparaBusqueda(String nombreTabla, String columnaId, String datoId) {
        String consulta = "";
        consulta = "select * from " + nombreTabla + " where " + columnaId + " = '" + datoId + "'";
        return consulta;
    }

    private String crearsentenciaparaBusquedaTotal(String nombreTabla) {
        String consulta = "";
        consulta = "select * from " + nombreTabla;
        return consulta;
    }

    private String crearsentenciaparaBusquedaTotalOrdenada(String nombreTabla, String columnaId) {
        String consulta = "";
        consulta = "select * from " + nombreTabla + " ORDER BY " + columnaId + " ASC";
        return consulta;
    }

    private int ejecutarActualizacion(Statement servidor, String sentencia) throws SQLException {
        servidor.executeUpdate(sentencia, Statement.RETURN_GENERATED_KEYS);

        ResultSet resultSet = servidor.getGeneratedKeys();

        int clave = -1;

        if (resultSet.next()) {
            clave = resultSet.getInt(1);
        }

        return clave;
    }

    private void ejecutarSolicitud(Statement servidor, String sentencia) throws SQLException {
        servidor.execute(sentencia);
    }

    private void ejecutarBusqueda(Statement servidor, String sentencia) throws SQLException {
        ResultSet resultadodeBusqueda = servidor.executeQuery(sentencia);
        guardarResultadoBusqueda(resultadodeBusqueda);
    }

    private void guardarResultadoBusqueda(ResultSet resultadoBusqueda) {
        this.Busqueda = resultadoBusqueda;
    }

    private ResultSet obtenerResultadoBusquedaDeBaseDatos() {
        return (ResultSet) Busqueda;
    }
    
}
