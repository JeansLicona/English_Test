package vista;

import controlador.ControladorOpcionMultiple;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Examen extends javax.swing.JFrame {

    public Examen(ControladorOpcionMultiple controlador){
        initComponents();
        _controlador = controlador;
    }

    /**
     * Actualiza el label de pregunta en la interfaz.
     * @param pregunta pregunta actualizada
     */
    public void actualizarPregunta(String pregunta){
        _pregunta.setText(pregunta);
    }
    
    /**
     * Actualiza la opcion 1 de las respuestas.
     * @param respuesta respuesta a actualizar
     */
    public void actualizarOpcion1(String respuesta){
        _opcion1.setText(respuesta);
    }
    
    /**
     * Actualiza la opcion 2 de las respuestas.
     * @param respuesta respuesta a actualizar
     */
    public void actualizarOpcion2(String respuesta){
        _opcion2.setText(respuesta);
    }
    
    /**
     * Actualiza la opcion 3 de las respuestas.
     * @param respuesta respuesta a actualizar
     */
    public void actualizarOpcion3(String respuesta){
        _opcion3.setText(respuesta);
    }
    
    /**
     * Actualiza la opcion 4 de las respuestas.
     * @param respuesta respuesta a actualizar
     */
    public void actualizarOpcion4(String respuesta){
        _opcion4.setText(respuesta);
    }
    
    /**
     * Bloque las opciones para seguir retrocediendo.
     */
    public void bloquerRetroceso(){
        _regresar.setEnabled(false);
    }
    
    /**
     * Desbloquea las opciones para seguir retrocediendo.
     */
    public void habilitarRetroceso(){
        _regresar.setEnabled(true);
    }
    
    /**
     * Selecciona la opcion una opcion de las respuestas.
     * @param opcionSeleccionada opcion que se seleccionara
     */
    public void selecionarOpcion(int opcionSeleccionada){
        switch(opcionSeleccionada){
            case 1: _opcion1.setSelected(true);
                break;
            case 2: _opcion2.setSelected(true);
                break;
            case 3: _opcion3.setSelected(true);
                break;
            case 4: _opcion4.setSelected(true);
        }
    }
    
    public void limpiarSelecciones(){
        _opcion1.setSelected(false);
        _opcion2.setSelected(false);
        _opcion3.setSelected(false);
        _opcion4.setSelected(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        _pregunta = new javax.swing.JLabel();
        _opcion1 = new javax.swing.JRadioButton();
        _opcion2 = new javax.swing.JRadioButton();
        _opcion3 = new javax.swing.JRadioButton();
        _opcion4 = new javax.swing.JRadioButton();
        avanzar = new javax.swing.JButton();
        _regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Examen"));
        jPanel1.setName("Examen"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Pregunta");

        _pregunta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        _pregunta.setText("¿Pregunta 1?");

        buttonGroup1.add(_opcion1);
        _opcion1.setText("Respuesta1");
        _opcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _opcion1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(_opcion2);
        _opcion2.setText("Respuesta 2");
        _opcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _opcion2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(_opcion3);
        _opcion3.setText("Respuesta 3");
        _opcion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _opcion3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(_opcion4);
        _opcion4.setText("Respuesta 4");
        _opcion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _opcion4ActionPerformed(evt);
            }
        });

        avanzar.setText("Avanzar >>");
        avanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avanzarActionPerformed(evt);
            }
        });

        _regresar.setText("<< Regresar");
        _regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 505, Short.MAX_VALUE)
                        .addComponent(_regresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(avanzar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(_pregunta)
                            .addComponent(_opcion1)
                            .addComponent(_opcion2)
                            .addComponent(_opcion3, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_opcion4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_pregunta)
                .addGap(62, 62, 62)
                .addComponent(_opcion1)
                .addGap(18, 18, 18)
                .addComponent(_opcion2)
                .addGap(18, 18, 18)
                .addComponent(_opcion3)
                .addGap(18, 18, 18)
                .addComponent(_opcion4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avanzar)
                    .addComponent(_regresar))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__regresarActionPerformed
        _controlador.preguntaAnterior();
    }//GEN-LAST:event__regresarActionPerformed

    private void avanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avanzarActionPerformed
        _controlador.siguientePregunta();
    }//GEN-LAST:event_avanzarActionPerformed

    private void _opcion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__opcion4ActionPerformed
        _controlador.asignarRespuestaUsuario(_controlador.obtenerRespuestaActual(3));
    }//GEN-LAST:event__opcion4ActionPerformed

    private void _opcion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__opcion3ActionPerformed
        _controlador.asignarRespuestaUsuario(_controlador.obtenerRespuestaActual(2));
    }//GEN-LAST:event__opcion3ActionPerformed

    private void _opcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__opcion2ActionPerformed
        _controlador.asignarRespuestaUsuario(_controlador.obtenerRespuestaActual(1));
    }//GEN-LAST:event__opcion2ActionPerformed

    private void _opcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__opcion1ActionPerformed
        _controlador.asignarRespuestaUsuario(_controlador.obtenerRespuestaActual(0));
    }//GEN-LAST:event__opcion1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton _opcion1;
    private javax.swing.JRadioButton _opcion2;
    private javax.swing.JRadioButton _opcion3;
    private javax.swing.JRadioButton _opcion4;
    private javax.swing.JLabel _pregunta;
    private javax.swing.JButton _regresar;
    private javax.swing.JButton avanzar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    private ControladorOpcionMultiple _controlador = null;
}