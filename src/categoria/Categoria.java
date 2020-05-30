package categoria;

import controlador.CategoriaDAO;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import modelo.ResultSetTableModel;

public class Categoria extends javax.swing.JPanel {

    public Categoria() {
        initComponents();
        iniciar();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiqueta = new javax.swing.JLabel();
        cajaTexto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnLimpiar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(800, 400));
        setMinimumSize(new java.awt.Dimension(800, 400));
        setPreferredSize(new java.awt.Dimension(800, 400));

        etiqueta.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqueta.setText("Buscar:");

        cajaTexto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cajaTexto.setToolTipText("Nombre Categoria");
        cajaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaTextoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaTextoKeyTyped(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Categorias");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clean.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setNextFocusableComponent(btnAgregar);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id Proveedor", "Nombre", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(etiqueta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cajaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregar))
                            .addComponent(etiqueta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(13, 13, 13)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cajaTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaTextoKeyTyped
        if (cajaTexto.getText().length() == 45) 
            evt.consume();
        else
            soloLetras(evt);
    }//GEN-LAST:event_cajaTextoKeyTyped

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        actualizarTabla(MOSTRAR_TODOS_LOS_DATOS);
        id = 0;
        nom = desc = "";
        cajaTexto.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregar = new AgregarCategoria(null, true);
        agregar.setVisible(true);
        agregar.dispose();
        btnLimpiar.doClick();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseReleased
        try {
            id = Integer.parseInt(String.valueOf((tabla.getValueAt(tabla.getSelectedRow(), 0))));
            nom = (String) tabla.getValueAt(tabla.getSelectedRow(), 1);
            desc = (String) tabla.getValueAt(tabla.getSelectedRow(), 2);

            eliminarOEditar = new EliminarOEditarCategoria(null, true, id, nom, desc);
            eliminarOEditar.setVisible(true);
            btnLimpiar.doClick();
        } catch (NumberFormatException e) {}
    }//GEN-LAST:event_tablaMouseReleased

    private void cajaTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaTextoKeyReleased
        buscar();
    }//GEN-LAST:event_cajaTextoKeyReleased
 
    public void buscar(){
        if(!cajaTexto.getText().equals(""))
            actualizarTabla("SELECT * FROM Categorias WHERE nombre LIKE '%"+cajaTexto.getText()+"%'");
        else
            actualizarTabla(MOSTRAR_TODOS_LOS_DATOS);
    }
    
    public void soloLetras(KeyEvent evt) {
        char c = evt.getKeyChar();
        if( (c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && c != KeyEvent.VK_SPACE && c != KeyEvent.VK_PERIOD)
            evt.consume();
    }
    
    public void limpiarTabla(){
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id Categoria", "Nombre", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
    
    public final void actualizarTabla(String consulta){
        String controlador = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost/Ferreteria?useTimezone=true&serverTimezone=UTC";
        ResultSetTableModel modeloDatos = null;

        try {
            modeloDatos = new ResultSetTableModel(controlador, url, consulta);
        } catch (ClassNotFoundException | SQLException e) {}

        tabla.setModel(modeloDatos);
    }
    
    public final void iniciar(){
        actualizarTabla(MOSTRAR_TODOS_LOS_DATOS);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JTextField cajaTexto;
    private javax.swing.JLabel etiqueta;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    private String nom, desc;
    private int id;
    final static CategoriaDAO CATEGORIA_DAO = new CategoriaDAO();
    final static String MOSTRAR_TODOS_LOS_DATOS = "SELECT * FROM Categorias";
    AgregarCategoria agregar;
    EliminarOEditarCategoria eliminarOEditar;
}