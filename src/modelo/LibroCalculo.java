/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;

/**
 *
 * @author CFManuel
 */
public class LibroCalculo {
    
    public LibroCalculo(){
        _libro = new HSSFWorkbook();
    }
    
    public void crearhoja(String nombreHoja){
        _hoja = _libro.createSheet(nombreHoja);
    }
    
    public void asignarHoja(String nombreHoja){
        _hoja = _libro.getSheet(nombreHoja);
    }
    
    public void crearFila(){
        if(_numFilaSiguiente==0){
            _fila = _hoja.createRow(_numFilaSiguiente);
            _numFilaSiguiente++;
        }else{
            _fila = _hoja.createRow(_hoja.getLastRowNum()+1);
            _numFilaSiguiente++;
        }
        
    }
    
    public void asignarFila(int numFila){
        _fila = _hoja.getRow(numFila);
    }
    
    public void crearCelda(){
        if(_numCeldaSiguiente==0){
            _celda = _fila.createCell(_numCeldaSiguiente);
            _numCeldaSiguiente++;
        }else{
            if(_fila.getLastCellNum()>=1){
            _celda = _fila.createCell(_fila.getLastCellNum());
            _numCeldaSiguiente++;
            }else{
            _celda = _fila.createCell(_fila.getLastCellNum()+1);
            _numCeldaSiguiente++;
            }
            
        }
        
    }
    
    public void asignarCelda(int numCelda){
        _celda = _fila.getCell(numCelda);
    }
    
    public void editarCelda(int numCelda, String contenido){
        _celda = _fila.getCell(numCelda);
        _celda.setCellValue(contenido);
    }
    
    public void editarCelda(String contenido){
        _celda.setCellValue(contenido);
    }
    
    public void mezclarCampos(int primeraFila,int ultimaFila, int primeraColumna, int ultimaColumna){
        CellRangeAddress rangoMezcla = new CellRangeAddress(primeraFila, ultimaFila, primeraColumna, ultimaColumna);
        _hoja.addMergedRegion(rangoMezcla);
    }
    
    public void guardarLibro(){
        try {
            FileOutputStream elFichero = new FileOutputStream("InformeExamenIngles.xls");
            _libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void guardarLibro(String nombre){
        try {
            FileOutputStream elFichero = new FileOutputStream(nombre+".xls");
            _libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void resetiarMarcadores(){
        _numFilaSiguiente = 0;
        _numCeldaSiguiente = 0;
    }
    
    private HSSFWorkbook _libro = null;
    private HSSFSheet _hoja = null;
    private HSSFRow _fila = null;
    private HSSFCell _celda = null;
    private int _numFilaSiguiente = 0;
    private int _numCeldaSiguiente = 0;
}
