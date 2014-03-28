/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorEdicionExamen;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Pregunta;

/**
 *
 * @author Jeans Michell
 */
public class EdicionExamen extends javax.swing.JFrame {

    /**
     * Creates new form EdicionExamen
     */
    public EdicionExamen() {
        initComponents();
    }

    public EdicionExamen(ControladorEdicionExamen controladorExamen) {
        initComponents();
        _controladorExamen = controladorExamen;
    }

    public void asignarExamen(ArrayList<Pregunta> _preguntas) {
        this._preguntas = _preguntas;
        for (int indice = 0; indice < _preguntas.size(); indice++) {
            Pregunta pregunta = _preguntas.get(indice);
            Pregunta.addItem((indice + 1) + ". " + pregunta.getPregunta());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pregunta = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        Edicion = new javax.swing.JButton();
        preguntaEditar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        respuestas = new javax.swing.JTable();
        Editar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pregunta:");

        Edicion.setText("Seleccionar");
        Edicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdicionActionPerformed(evt);
            }
        });

        jLabel2.setText("Pregunta:");

        jLabel3.setText("Respuestas");

        respuestas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(respuestas);

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(preguntaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(91, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Editar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(Pregunta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(Edicion)))
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(Edicion))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(preguntaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Editar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EdicionActionPerformed
        // TODO add your handling code here:
        String preguntaEdicion = (String) Pregunta.getSelectedItem();
        String delimitadores = "[ .,;?!¡¿\'\"\\[\\]]+";
        String[] palabrasSeparadas = preguntaEdicion.split(delimitadores);
        int numeroPregunta = Integer.parseInt(palabrasSeparadas[0]);
        preguntaEdit = _preguntas.get(numeroPregunta - 1);
        this.preguntaEditar.setText(preguntaEdit.getPregunta());

        llenarTabla(crearModelo());
    }//GEN-LAST:event_EdicionActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        // TODO add your handling code here:
        String nuevaPregunta = preguntaEditar.getText();
        preguntaEdit.setPregunta(nuevaPregunta);
        editarRespuesta();
        _controladorExamen.editarPregunta(preguntaEdit);
    }//GEN-LAST:event_EditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EdicionExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EdicionExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EdicionExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EdicionExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EdicionExamen().setVisible(true);
            }
        });
    }
    private ControladorEdicionExamen _controladorExamen;
    private ArrayList<Pregunta> _preguntas;
    private Pregunta preguntaEdit;

    private void editarRespuesta() {
        for (int indice = 0; indice < preguntaEdit.getRespuestas().size(); indice++) {
            String respuesta=(String) respuestas.getValueAt(indice, 0);
            preguntaEdit.getRespuestas().get(indice).setRespuesta(respuesta);
            double ponderacion=(Double) respuestas.getValueAt(indice, 1);
            preguntaEdit.getRespuestas().get(indice).setPonderacion(ponderacion);
        }
    }

    private DefaultTableModel crearModelo() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Respuesta");
        modelo.addColumn("Puntaje");

        modelo.setNumRows(preguntaEdit.getRespuestas().size());
        for (int indice = 0; indice < preguntaEdit.getRespuestas().size(); indice++) {
            modelo.setValueAt(preguntaEdit.getRespuestas().get(indice).getRespuesta(), indice, 0);
            modelo.setValueAt(preguntaEdit.getRespuestas().get(indice).getPonderacion(), indice, 1);
        }
        return modelo;
    }

    private void llenarTabla(DefaultTableModel Model) {
        respuestas.setModel(Model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Edicion;
    private javax.swing.JButton Editar;
    private javax.swing.JComboBox Pregunta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField preguntaEditar;
    private javax.swing.JTable respuestas;
    // End of variables declaration//GEN-END:variables
}