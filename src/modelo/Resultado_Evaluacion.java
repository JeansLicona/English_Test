/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jeans Michell
 */
public class Resultado_Evaluacion {

    public Resultado_Evaluacion(){}
    
    public Resultado_Evaluacion(int id_resultado, Evaluado evaluado, double resultado){
        this.id_resultado=id_resultado;
        this.evaluado=evaluado;
        this.resultado=resultado;
    }
    
    public int getID_resultado() {
        return id_resultado;
    }

    public void setID_resultado(int id_resultado) {
        this.id_resultado = id_resultado;
    }

    public Evaluado getEvaluado() {
        return evaluado;
    }

    public void setEvaluado(Evaluado evaluado) {
        this.evaluado = evaluado;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
    private int id_resultado;
    private Evaluado evaluado;
    private double resultado;
}
