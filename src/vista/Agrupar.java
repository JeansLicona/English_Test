/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ControladorAgrupar;

/**
 *
 * @author CFManuel
 */
public class Agrupar extends javax.swing.JFrame {

    /**
     * Creates new form Agrupar
     * @param controlador
     */
    public Agrupar(ControladorAgrupar controlador) {
        initComponents();
        _controlador = controlador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _JPanel = new javax.swing.JPanel();
        _lblInstruccion = new javax.swing.JLabel();
        _lblPregunta = new javax.swing.JLabel();
        terminarExamen = new javax.swing.JButton();
        avanzar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        _LblGrupo1 = new javax.swing.JLabel();
        _TxtFldGrupo1_2 = new javax.swing.JTextField();
        _TxtFldGrupo1_1 = new javax.swing.JTextField();
        _TxtFldGrupo1_3 = new javax.swing.JTextField();
        _LblGrupo2 = new javax.swing.JLabel();
        _TxtFldGrupo2_2 = new javax.swing.JTextField();
        _TxtFldGrupo2_1 = new javax.swing.JTextField();
        _TxtFldGrupo2_3 = new javax.swing.JTextField();
        _LblGrupo3 = new javax.swing.JLabel();
        _TxtFldGrupo3_2 = new javax.swing.JTextField();
        _TxtFldGrupo3_1 = new javax.swing.JTextField();
        _TxtFldGrupo3_3 = new javax.swing.JTextField();
        _LblGrupo4 = new javax.swing.JLabel();
        _TxtFldGrupo4_2 = new javax.swing.JTextField();
        _TxtFldGrupo4_1 = new javax.swing.JTextField();
        _TxtFldGrupo4_3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        _JPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Examen"));
        _JPanel.setName("Examen"); // NOI18N

        _lblInstruccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        _lblInstruccion.setText("Pregunta");

        _lblPregunta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        _lblPregunta.setText("¿Pregunta?");

        terminarExamen.setText("Terminar Examen");
        terminarExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarExamenActionPerformed(evt);
            }
        });

        avanzar.setText("Avanzar >>");
        avanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avanzarActionPerformed(evt);
            }
        });

        regresar.setText("<< Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        _LblGrupo1.setText("Grupo 1");

        _TxtFldGrupo1_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _TxtFldGrupo1_2FocusLost(evt);
            }
        });

        _TxtFldGrupo1_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _TxtFldGrupo1_1FocusLost(evt);
            }
        });

        _TxtFldGrupo1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _TxtFldGrupo1_3ActionPerformed(evt);
            }
        });
        _TxtFldGrupo1_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _TxtFldGrupo1_3FocusLost(evt);
            }
        });

        _LblGrupo2.setText("Grupo 2");

        _TxtFldGrupo2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _TxtFldGrupo2_2ActionPerformed(evt);
            }
        });
        _TxtFldGrupo2_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _TxtFldGrupo2_2FocusLost(evt);
            }
        });

        _TxtFldGrupo2_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _TxtFldGrupo2_1FocusLost(evt);
            }
        });

        _TxtFldGrupo2_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _TxtFldGrupo2_3FocusLost(evt);
            }
        });

        _LblGrupo3.setText("Grupo 3");

        _TxtFldGrupo3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _TxtFldGrupo3_2ActionPerformed(evt);
            }
        });
        _TxtFldGrupo3_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _TxtFldGrupo3_2FocusLost(evt);
            }
        });

        _TxtFldGrupo3_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _TxtFldGrupo3_1FocusLost(evt);
            }
        });

        _TxtFldGrupo3_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _TxtFldGrupo3_3FocusLost(evt);
            }
        });

        _LblGrupo4.setText("Grupo 4");

        _TxtFldGrupo4_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _TxtFldGrupo4_2FocusLost(evt);
            }
        });

        _TxtFldGrupo4_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _TxtFldGrupo4_1FocusLost(evt);
            }
        });

        _TxtFldGrupo4_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _TxtFldGrupo4_3FocusLost(evt);
            }
        });

        javax.swing.GroupLayout _JPanelLayout = new javax.swing.GroupLayout(_JPanel);
        _JPanel.setLayout(_JPanelLayout);
        _JPanelLayout.setHorizontalGroup(
            _JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_JPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(_JPanelLayout.createSequentialGroup()
                        .addComponent(_LblGrupo1)
                        .addGap(18, 18, 18)
                        .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, _JPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(terminarExamen))
                            .addGroup(_JPanelLayout.createSequentialGroup()
                                .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(_JPanelLayout.createSequentialGroup()
                                        .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(_TxtFldGrupo1_2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                            .addComponent(_TxtFldGrupo1_3)
                                            .addComponent(_TxtFldGrupo1_1, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(50, 50, 50)
                                        .addComponent(_LblGrupo2)
                                        .addGap(18, 18, 18)
                                        .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(_TxtFldGrupo2_3, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                            .addComponent(_TxtFldGrupo2_2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(_TxtFldGrupo2_1, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(42, 42, 42)
                                        .addComponent(_LblGrupo3)
                                        .addGap(18, 18, 18)
                                        .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(_TxtFldGrupo3_3)
                                            .addComponent(_TxtFldGrupo3_1)
                                            .addComponent(_TxtFldGrupo3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)
                                        .addComponent(_LblGrupo4)
                                        .addGap(18, 18, 18)
                                        .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(_TxtFldGrupo4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(_TxtFldGrupo4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(_TxtFldGrupo4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(_JPanelLayout.createSequentialGroup()
                                        .addGap(409, 409, 409)
                                        .addComponent(regresar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(avanzar)))
                                .addGap(0, 12, Short.MAX_VALUE))))
                    .addGroup(_JPanelLayout.createSequentialGroup()
                        .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_lblInstruccion)
                            .addComponent(_lblPregunta))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        _JPanelLayout.setVerticalGroup(
            _JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_lblInstruccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_lblPregunta)
                .addGap(30, 30, 30)
                .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(_JPanelLayout.createSequentialGroup()
                        .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_TxtFldGrupo1_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_TxtFldGrupo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_LblGrupo1)
                            .addComponent(_TxtFldGrupo1_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_LblGrupo2)
                            .addComponent(_TxtFldGrupo2_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_TxtFldGrupo1_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_TxtFldGrupo2_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(_JPanelLayout.createSequentialGroup()
                        .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_TxtFldGrupo3_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_TxtFldGrupo4_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_LblGrupo3)
                            .addComponent(_TxtFldGrupo3_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_LblGrupo4)
                            .addComponent(_TxtFldGrupo4_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_TxtFldGrupo3_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_TxtFldGrupo4_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addGroup(_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(avanzar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(regresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(terminarExamen)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed

    }//GEN-LAST:event_regresarActionPerformed

    private void avanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avanzarActionPerformed
        _controlador.siguientePregunta();
    }//GEN-LAST:event_avanzarActionPerformed

    private void terminarExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarExamenActionPerformed

    }//GEN-LAST:event_terminarExamenActionPerformed

    private void _TxtFldGrupo1_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__TxtFldGrupo1_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__TxtFldGrupo1_3ActionPerformed

    private void _TxtFldGrupo2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__TxtFldGrupo2_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__TxtFldGrupo2_2ActionPerformed

    private void _TxtFldGrupo3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__TxtFldGrupo3_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__TxtFldGrupo3_2ActionPerformed

    private void _TxtFldGrupo1_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__TxtFldGrupo1_1FocusLost
        // TODO add your handling code here:
        _controlador.asignarRespuestaUsuario(_TxtFldGrupo1_1.getText(), 1, 1);
    }//GEN-LAST:event__TxtFldGrupo1_1FocusLost

    private void _TxtFldGrupo1_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__TxtFldGrupo1_2FocusLost
        // TODO add your handling code here:
        _controlador.asignarRespuestaUsuario(_TxtFldGrupo1_2.getText(), 1, 2);
    }//GEN-LAST:event__TxtFldGrupo1_2FocusLost

    private void _TxtFldGrupo1_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__TxtFldGrupo1_3FocusLost
        // TODO add your handling code here:
        _controlador.asignarRespuestaUsuario(_TxtFldGrupo1_3.getText(), 1, 3);
    }//GEN-LAST:event__TxtFldGrupo1_3FocusLost

    private void _TxtFldGrupo2_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__TxtFldGrupo2_1FocusLost
        // TODO add your handling code here:
        _controlador.asignarRespuestaUsuario(_TxtFldGrupo2_1.getText(), 2, 1);
    }//GEN-LAST:event__TxtFldGrupo2_1FocusLost

    private void _TxtFldGrupo2_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__TxtFldGrupo2_2FocusLost
        // TODO add your handling code here:
        _controlador.asignarRespuestaUsuario(_TxtFldGrupo2_2.getText(), 2, 2);
    }//GEN-LAST:event__TxtFldGrupo2_2FocusLost

    private void _TxtFldGrupo2_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__TxtFldGrupo2_3FocusLost
        // TODO add your handling code here:
        _controlador.asignarRespuestaUsuario(_TxtFldGrupo2_3.getText(), 2, 3);
    }//GEN-LAST:event__TxtFldGrupo2_3FocusLost

    private void _TxtFldGrupo3_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__TxtFldGrupo3_1FocusLost
        // TODO add your handling code here:
        _controlador.asignarRespuestaUsuario(_TxtFldGrupo3_1.getText(), 3, 1);
    }//GEN-LAST:event__TxtFldGrupo3_1FocusLost

    private void _TxtFldGrupo3_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__TxtFldGrupo3_2FocusLost
        // TODO add your handling code here:
        _controlador.asignarRespuestaUsuario(_TxtFldGrupo3_2.getText(), 3, 2);
    }//GEN-LAST:event__TxtFldGrupo3_2FocusLost

    private void _TxtFldGrupo3_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__TxtFldGrupo3_3FocusLost
        // TODO add your handling code here:
        _controlador.asignarRespuestaUsuario(_TxtFldGrupo3_3.getText(), 3, 3);
    }//GEN-LAST:event__TxtFldGrupo3_3FocusLost

    private void _TxtFldGrupo4_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__TxtFldGrupo4_1FocusLost
        // TODO add your handling code here:
        _controlador.asignarRespuestaUsuario(_TxtFldGrupo4_1.getText(), 4, 1);
    }//GEN-LAST:event__TxtFldGrupo4_1FocusLost

    private void _TxtFldGrupo4_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__TxtFldGrupo4_2FocusLost
        // TODO add your handling code here:
        _controlador.asignarRespuestaUsuario(_TxtFldGrupo4_2.getText(), 4, 2);
    }//GEN-LAST:event__TxtFldGrupo4_2FocusLost

    private void _TxtFldGrupo4_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__TxtFldGrupo4_3FocusLost
        // TODO add your handling code here:
        _controlador.asignarRespuestaUsuario(_TxtFldGrupo4_3.getText(), 4, 3);
    }//GEN-LAST:event__TxtFldGrupo4_3FocusLost

    public void vaciarCampos(){
        _TxtFldGrupo1_1.setText("");
        _TxtFldGrupo1_2.setText("");
        _TxtFldGrupo1_3.setText("");
        _TxtFldGrupo2_1.setText("");
        _TxtFldGrupo2_2.setText("");
        _TxtFldGrupo2_3.setText("");
        _TxtFldGrupo3_1.setText("");
        _TxtFldGrupo3_2.setText("");
        _TxtFldGrupo3_3.setText("");
        _TxtFldGrupo4_1.setText("");
        _TxtFldGrupo4_2.setText("");
        _TxtFldGrupo4_3.setText("");
    }
    
    /**
     * Asignar nombre a las secciones
     * @param seccion nombre de la seccion
     * @param index numero de la seccion
     */
    public void actualizarSeccion(String seccion, int index){
        switch(index){
            case 1:
                _LblGrupo1.setText(seccion);
                break;
            case 2:
                _LblGrupo2.setText(seccion);
                break;
            case 3:
                _LblGrupo3.setText(seccion);
                break;
            case 4:
                _LblGrupo4.setText(seccion);
        }
    }
    
    public void actualizarInstruccion(String instruccion){
        _lblInstruccion.setText(instruccion);
    }
    
    public void listaRespuestas(String respuestas){
        _lblPregunta.setText(respuestas);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel _JPanel;
    private javax.swing.JLabel _LblGrupo1;
    private javax.swing.JLabel _LblGrupo2;
    private javax.swing.JLabel _LblGrupo3;
    private javax.swing.JLabel _LblGrupo4;
    private javax.swing.JTextField _TxtFldGrupo1_1;
    private javax.swing.JTextField _TxtFldGrupo1_2;
    private javax.swing.JTextField _TxtFldGrupo1_3;
    private javax.swing.JTextField _TxtFldGrupo2_1;
    private javax.swing.JTextField _TxtFldGrupo2_2;
    private javax.swing.JTextField _TxtFldGrupo2_3;
    private javax.swing.JTextField _TxtFldGrupo3_1;
    private javax.swing.JTextField _TxtFldGrupo3_2;
    private javax.swing.JTextField _TxtFldGrupo3_3;
    private javax.swing.JTextField _TxtFldGrupo4_1;
    private javax.swing.JTextField _TxtFldGrupo4_2;
    private javax.swing.JTextField _TxtFldGrupo4_3;
    private javax.swing.JLabel _lblInstruccion;
    private javax.swing.JLabel _lblPregunta;
    private javax.swing.JButton avanzar;
    private javax.swing.JButton regresar;
    private javax.swing.JButton terminarExamen;
    // End of variables declaration//GEN-END:variables
    private ControladorAgrupar _controlador = null;
}
