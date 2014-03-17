/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dao_base_datos.DAO_Evaluado;
import modelo.Evaluado;
import vista.Login;

/**
 * Clase controladora de la vista Login
 * @author CFManuel
 */
public class ControladorLogin {
    
    /**
     * Constructor de la clase con parametro vacio
     */
    public ControladorLogin(){
        _login = new Login(this);
        _daoEvaluado = new DAO_Evaluado();
    }
    
    /**
     * Inicia la pantalla de este controlador
     */
    public void iniciarPantalla(){
        _login.setVisible(true);
    }
    
    /**
     * Guarda un usuario con los parametro requeridos.
     * @param nombres Nombre o Nombres del sujeto
     * @param apellidoP Apellido Paterno del sujeto
     * @param apellidoM Apellido Materno del sujeto
     */
    public void guardaUsuario(String nombres, String apellidoP, String apellidoM){
        Evaluado evaluado = new Evaluado();
        evaluado.setNombre_usuario(crearNombreUsuario(nombres, apellidoP, apellidoM));
        evaluado.setNombres(nombres);
        evaluado.setPrimer_apellido(apellidoP);
        evaluado.setSegundo_apellido(apellidoM);
        
        DAO_Evaluado daoEval = new DAO_Evaluado();
        daoEval.registrarEvaluado(evaluado);
        
        evaluado = _daoEvaluado.buscarEvaluado(evaluado.getNombre_usuario());
        
        ControladorOpcionMultiple ctrlOpMult= new ControladorOpcionMultiple(evaluado);
        ctrlOpMult.iniciarPantalla();
        _login.setVisible(false);
    }
    
    /**
     * Separa el nombre en Nombres ApellidoP y ApellidoM
     * @param nombreCompleto Nombre completo a separar
     * @return Regresa una cadena separada en Nombres, ApellidoP y ApellidoM
     */
    public String[] separarNombre(String nombreCompleto){
        String delimitadores= "[ .,;?!¡¿\'\"\\[\\]]+";
        String[] separados = nombreCompleto.split(delimitadores);
        String[] nombreAgrupado = {"","",""};
        
        if(separados.length == 4){
            nombreAgrupado[0] = separados[0]+" "+separados[1];
            nombreAgrupado[1] = separados[2];
            nombreAgrupado[2] = separados[3];
        }
        if(separados.length == 3){
            return separados;
        }
        
        return nombreAgrupado;
    }
    
    /**
     * Crea un nombre de usuario a partir de los de la primera letra de apellidoP
     * la primera letra de apellidoM y las 2 primeras letras del primer o unico
     * nombre.
     * @param nombres nombres de evaluado
     * @param apellidoP apellido paterno del evaluado
     * @param apellidoM apellido materno del evaluado
     * @return nombre de usuario creado
     */
    private String crearNombreUsuario(String nombres, String apellidoP, String apellidoM){
        int valorEntero = (int) Math.floor(Math.random()*(100-999+1)+999);
        String nombreUsuario = apellidoP.substring(0, 1) + apellidoM.substring(0,1) + nombres.substring(0,2);//+valorEntero;
        
        return nombreUsuario;
    }
    
    private Login _login = null;
    private DAO_Evaluado _daoEvaluado= null;
    
}
