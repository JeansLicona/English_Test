/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import modelo.Evaluado;

/**
 *
 * @author CFManuel
 */
public class ControladorPrincipal {
    
    public static void main (String args[]){
//        ControladorLogin ctrlLogin = new ControladorLogin();
//        ctrlLogin.iniciarPantalla();
        Evaluado evaluado = new Evaluado();
        ControladorColumnas colum = new ControladorColumnas(evaluado);
        colum.iniciarVista();
    }
}
