package vista;

import controlador.ControladorColumnas;
import controlador.ControladorOpcionMultiple;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Imagen;

public class ColumnasImage extends javax.swing.JFrame {

    public ColumnasImage(ControladorColumnas controlador){
        initComponents();
        _controlador = controlador;
        this.setSize(845, 550);
    }

    /**
     * Actualiza el label de pregunta en la interfaz.
     * @param pregunta pregunta actualizada
     */
    public void actualizarPregunta(String pregunta){
        _pregunta.setText(pregunta);
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
    
    public void limpiarCampos(){
        _jtf1.setText("");
        _jtf2.setText("");
        _jtf3.setText("");
        _jtf4.setText("");
        _jtf5.setText("");
    }
    
    public void asignarRespuestas(String respuesta, int numeroRespuesta){
        switch(numeroRespuesta){
            case 0: _jtf1.setText(respuesta);
                break;
            case 1: _jtf2.setText(respuesta);
                break;
            case 2: _jtf3.setText(respuesta);
                break;
            case 3: _jtf4.setText(respuesta);
                break;
            case 4: _jtf5.setText(respuesta);
                break;
        }
    }
    
    public void asignarColumnaLetras(String nombreRespuesta, int numeroRespuesta){
        switch(numeroRespuesta){
            case 0: _jlbl1.setText(nombreRespuesta);
                break;
            case 1: _jlbl2.setText(nombreRespuesta);
                break;
            case 2: _jlbl3.setText(nombreRespuesta);
                break;
            case 3: _jlbl4.setText(nombreRespuesta);
                break;
            case 4: _jlbl5.setText(nombreRespuesta);
                break;
        }
    }
    
    public void asignarImagen(String nombreImagen,int numeroRespuesta){
        Imagen imagen = null;
        String direccion ="/imagenes/"+nombreImagen;
        
        switch(numeroRespuesta){
            case 0:  imagen = new Imagen(direccion,_jpnImagen1.getWidth(),_jpnImagen1.getHeight());
                    _jpnImagen1.removeAll();
                    _jpnImagen1.add(imagen);
                    _jpnImagen1.repaint();
                    break;
            case 1:  imagen = new Imagen(direccion,_jpnImagen2.getWidth(),_jpnImagen2.getHeight());
                    _jpnImagen2.removeAll();
                    _jpnImagen2.add(imagen);
                    _jpnImagen2.repaint();
                    break;
            case 2:  imagen = new Imagen(direccion,_jpnImagen3.getWidth(),_jpnImagen3.getHeight());
                    _jpnImagen3.removeAll();
                    _jpnImagen3.add(imagen);
                    _jpnImagen3.repaint();
                    break;
            case 3:  imagen = new Imagen(direccion,_jpnImagen4.getWidth(),_jpnImagen4.getHeight());
                    _jpnImagen4.removeAll();
                    _jpnImagen4.add(imagen);
                    _jpnImagen4.repaint();
                    break;
            case 4:  imagen = new Imagen(direccion,_jpnImagen5.getWidth(),_jpnImagen5.getHeight());
                    _jpnImagen5.removeAll();
                    _jpnImagen5.add(imagen);
                    _jpnImagen5.repaint();
                    break;
        }
        
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        _pregunta = new javax.swing.JLabel();
        terminarExamen = new javax.swing.JButton();
        avanzar = new javax.swing.JButton();
        _regresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        _jlbl1 = new javax.swing.JLabel();
        _jlbl2 = new javax.swing.JLabel();
        _jlbl3 = new javax.swing.JLabel();
        _jlbl4 = new javax.swing.JLabel();
        _jlbl5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        _jtf1 = new javax.swing.JTextField();
        _jtf2 = new javax.swing.JTextField();
        _jtf3 = new javax.swing.JTextField();
        _jtf4 = new javax.swing.JTextField();
        _jtf5 = new javax.swing.JTextField();
        _jpnImagen1 = new javax.swing.JPanel();
        _jpnImagen5 = new javax.swing.JPanel();
        _jpnImagen3 = new javax.swing.JPanel();
        _jpnImagen2 = new javax.swing.JPanel();
        _jpnImagen4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 760));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Examen"));
        jPanel1.setName("Examen"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Pregunta");

        _pregunta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        _pregunta.setText("¿Pregunta 1?");

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

        _regresar.setText("<< Regresar");
        _regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _regresarActionPerformed(evt);
            }
        });

        jLabel2.setText("Columna A");

        jLabel3.setText("1.-");

        jLabel4.setText("2.-");

        jLabel5.setText("3.-");

        jLabel6.setText("4.-");

        jLabel7.setText("5.-");

        _jlbl1.setText("jLabel8");

        _jlbl2.setText("jLabel9");

        _jlbl3.setText("jLabel10");

        _jlbl4.setText("jLabel11");

        _jlbl5.setText("jLabel12");

        jLabel13.setText("Columna B");

        _jtf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _jtf1ActionPerformed(evt);
            }
        });
        _jtf1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _jtf1FocusLost(evt);
            }
        });

        _jtf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _jtf2ActionPerformed(evt);
            }
        });
        _jtf2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _jtf2FocusLost(evt);
            }
        });

        _jtf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _jtf3ActionPerformed(evt);
            }
        });
        _jtf3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _jtf3FocusLost(evt);
            }
        });

        _jtf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _jtf4ActionPerformed(evt);
            }
        });
        _jtf4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _jtf4FocusLost(evt);
            }
        });

        _jtf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _jtf5ActionPerformed(evt);
            }
        });
        _jtf5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                _jtf5FocusLost(evt);
            }
        });

        javax.swing.GroupLayout _jpnImagen1Layout = new javax.swing.GroupLayout(_jpnImagen1);
        _jpnImagen1.setLayout(_jpnImagen1Layout);
        _jpnImagen1Layout.setHorizontalGroup(
            _jpnImagen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        _jpnImagen1Layout.setVerticalGroup(
            _jpnImagen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout _jpnImagen5Layout = new javax.swing.GroupLayout(_jpnImagen5);
        _jpnImagen5.setLayout(_jpnImagen5Layout);
        _jpnImagen5Layout.setHorizontalGroup(
            _jpnImagen5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );
        _jpnImagen5Layout.setVerticalGroup(
            _jpnImagen5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 95, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout _jpnImagen3Layout = new javax.swing.GroupLayout(_jpnImagen3);
        _jpnImagen3.setLayout(_jpnImagen3Layout);
        _jpnImagen3Layout.setHorizontalGroup(
            _jpnImagen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 99, Short.MAX_VALUE)
        );
        _jpnImagen3Layout.setVerticalGroup(
            _jpnImagen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout _jpnImagen2Layout = new javax.swing.GroupLayout(_jpnImagen2);
        _jpnImagen2.setLayout(_jpnImagen2Layout);
        _jpnImagen2Layout.setHorizontalGroup(
            _jpnImagen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );
        _jpnImagen2Layout.setVerticalGroup(
            _jpnImagen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout _jpnImagen4Layout = new javax.swing.GroupLayout(_jpnImagen4);
        _jpnImagen4.setLayout(_jpnImagen4Layout);
        _jpnImagen4Layout.setHorizontalGroup(
            _jpnImagen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 95, Short.MAX_VALUE)
        );
        _jpnImagen4Layout.setVerticalGroup(
            _jpnImagen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 603, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(terminarExamen, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(_regresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(avanzar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel2)
                                .addGap(283, 283, 283)
                                .addComponent(jLabel13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(_pregunta)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(_jlbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(_jlbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(_jlbl3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(_jlbl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(_jlbl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(123, 123, 123)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(_jtf3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(_jpnImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(_jtf1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(_jpnImagen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(_jtf5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(_jpnImagen5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(134, 134, 134)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(_jtf2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(_jpnImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(_jtf4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(_jpnImagen4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(_jlbl1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(_jtf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(_jlbl2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(_jlbl3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(_jlbl4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(_pregunta)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_jpnImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_jtf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_jpnImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(_jtf4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(_jtf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(_jlbl5)
                                .addComponent(jLabel7))
                            .addComponent(_jpnImagen4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(avanzar)
                            .addComponent(_regresar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(terminarExamen)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(_jpnImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_jtf5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_jpnImagen5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 55, Short.MAX_VALUE))))
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

    private void _jtf5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__jtf5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__jtf5ActionPerformed

    private void _jtf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__jtf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__jtf4ActionPerformed

    private void _jtf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__jtf3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__jtf3ActionPerformed

    private void _jtf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__jtf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__jtf2ActionPerformed

    private void _jtf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__jtf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__jtf1ActionPerformed

    private void _regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__regresarActionPerformed

        _controlador.regresarPregunta();
    }//GEN-LAST:event__regresarActionPerformed

    private void avanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avanzarActionPerformed

        _controlador.siguientePregunta();
    }//GEN-LAST:event_avanzarActionPerformed

    private void terminarExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarExamenActionPerformed

    }//GEN-LAST:event_terminarExamenActionPerformed

    private void _jtf1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__jtf1FocusLost
        // TODO add your handling code here:
        if(!_jtf1.getText().isEmpty()){
        _controlador.agregarRespuestaUsuario(0, Integer.valueOf(_jtf1.getText()));}
    }//GEN-LAST:event__jtf1FocusLost

    private void _jtf3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__jtf3FocusLost
        // TODO add your handling code here:
        if(!_jtf3.getText().isEmpty()){
        _controlador.agregarRespuestaUsuario(2, Integer.valueOf(_jtf3.getText()));}
    }//GEN-LAST:event__jtf3FocusLost

    private void _jtf2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__jtf2FocusLost
        // TODO add your handling code here:
        if(!_jtf2.getText().isEmpty()){
        _controlador.agregarRespuestaUsuario(1, Integer.valueOf(_jtf2.getText()));}
    }//GEN-LAST:event__jtf2FocusLost

    private void _jtf4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__jtf4FocusLost
        // TODO add your handling code here:
        if(!_jtf4.getText().isEmpty()){
        _controlador.agregarRespuestaUsuario(3, Integer.valueOf(_jtf4.getText()));}
    }//GEN-LAST:event__jtf4FocusLost

    private void _jtf5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event__jtf5FocusLost
        // TODO add your handling code here:
        if(!_jtf5.getText().isEmpty()){
        _controlador.agregarRespuestaUsuario(4, Integer.valueOf(_jtf5.getText()));}
    }//GEN-LAST:event__jtf5FocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _jlbl1;
    private javax.swing.JLabel _jlbl2;
    private javax.swing.JLabel _jlbl3;
    private javax.swing.JLabel _jlbl4;
    private javax.swing.JLabel _jlbl5;
    private javax.swing.JPanel _jpnImagen1;
    private javax.swing.JPanel _jpnImagen2;
    private javax.swing.JPanel _jpnImagen3;
    private javax.swing.JPanel _jpnImagen4;
    private javax.swing.JPanel _jpnImagen5;
    private javax.swing.JTextField _jtf1;
    private javax.swing.JTextField _jtf2;
    private javax.swing.JTextField _jtf3;
    private javax.swing.JTextField _jtf4;
    private javax.swing.JTextField _jtf5;
    private javax.swing.JLabel _pregunta;
    private javax.swing.JButton _regresar;
    private javax.swing.JButton avanzar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton terminarExamen;
    // End of variables declaration//GEN-END:variables
    private ControladorColumnas _controlador = null;
}