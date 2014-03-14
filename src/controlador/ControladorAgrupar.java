/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import modelo.Evaluado;
import vista.Agrupar;

/**
 * Controlador para la pantalla de la seccion de Opcion Multiple
 * @author CFManuel
 */
public class ControladorAgrupar {
    
    public ControladorAgrupar(Evaluado evaluado){
     _agrupar = new Agrupar(this);
     _evaluado = evaluado;
    }
    
    /**
     * Inicia la pantalla de este controlador
     */
    public void iniciarPantalla() {
        actualizarCampos();
        _agrupar.setVisible(true);
    }
    
    private void actualizarCampos(){
        
    }
    
    private Agrupar _agrupar = null;
    private Evaluado _evaluado = null;
    private int _posicion = 0;
}
