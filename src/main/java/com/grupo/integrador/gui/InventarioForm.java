package com.grupo.integrador.gui;

import com.grupo.integrador.logic.Biblioteca;
import com.grupo.integrador.logic.Callback;
import com.grupo.integrador.logic.Libro;
import com.grupo.integrador.logic.LibrosTableModel;
import com.grupo.integrador.logic.Usuario;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableModel;

public class InventarioForm extends javax.swing.JFrame implements Callback {


    public InventarioForm(Biblioteca biblioteca, Usuario usuario) {
        this.libroSeleccionado = null;
        this.usuario = usuario;
        this.biblioteca = biblioteca;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnSolicitar = new javax.swing.JButton();
        btnReservar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnDeshacerEliminacion = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario");
        setName("Inventario"); // NOI18N
        setResizable(false);

        jTable.setFont(new java.awt.Font("Noto Sans Mono", 0, 12)); // NOI18N
        jTable.setModel(getTableModel());
        listener();
        jScrollPane1.setViewportView(jTable);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnSolicitar.setText("Solicitar");
        btnSolicitar.setEnabled(false);
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });

        btnReservar.setText("Reservar");
        btnReservar.setEnabled(false);
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnDeshacerEliminacion.setText("Deshacer Eliminacion");
        btnDeshacerEliminacion.setEnabled(false);
        btnDeshacerEliminacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerEliminacionActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Noto Sans Mono", 1, 12)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Inventario");
        lblTitulo.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(btnSolicitar, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(btnReservar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(btnDeshacerEliminacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addGap(18, 18, 18)
                .addComponent(btnSolicitar)
                .addGap(18, 18, 18)
                .addComponent(btnReservar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnDeshacerEliminacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        SwingUtilities.invokeLater(() -> {
            PanelForm panelForm = new PanelForm(biblioteca, usuario);
            this.setVisible(false);
            panelForm.setVisible(true);
        });
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        AgregarForm agregarForm = new AgregarForm(biblioteca, this);
        agregarForm.setVisible(true);
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed
        biblioteca.solicitarLibro(libroSeleccionado);
        System.out.println("se ha solicitado: " + libroSeleccionado.getTitulo());
        libroSeleccionado = null;
        jTable.setModel(getTableModel());
        buttonEnabler(libroSeleccionado);
    }//GEN-LAST:event_btnSolicitarActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed

        String codigoIngresado = JOptionPane.showInputDialog("Ingrese el codigo de solicitud del libro: ");
        if (codigoIngresado == null || !codigoIngresado.equals(libroSeleccionado.getCodigoReserva())) {
            JOptionPane.showMessageDialog(null, "Codigo de solicitud incorrecto");
            return;
        }

        biblioteca.reservarLibro(libroSeleccionado);
        JOptionPane.showMessageDialog(null, "Se ha reservado: " + libroSeleccionado.getTitulo());
        libroSeleccionado = null;
        jTable.setModel(getTableModel());
        buttonEnabler(libroSeleccionado);
    }//GEN-LAST:event_btnReservarActionPerformed
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        biblioteca.eliminarLibro(libroSeleccionado);
        System.out.println("se ha eliminado: " + libroSeleccionado.getTitulo());
        libroSeleccionado = null;
        jTable.setModel(getTableModel());
        buttonEnabler(libroSeleccionado);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnDeshacerEliminacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerEliminacionActionPerformed
        biblioteca.deshacerEliminacion();
        libroSeleccionado = null;
        jTable.setModel(getTableModel());
        buttonEnabler(libroSeleccionado);
    }//GEN-LAST:event_btnDeshacerEliminacionActionPerformed

    private TableModel getTableModel(){
        return biblioteca.getLibrosTableModel();
    }
    private void listener(){
        LibrosTableModel modelo = biblioteca.getLibrosTableModel();
        this.jTable.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = this.jTable.getSelectedRow();
                if (selectedRow != -1) buttonEnabler(modelo.getLibroAt(selectedRow));
            }
        });
    }
    private void buttonEnabler(Libro libro) {
        libroSeleccionado = libro;

        if (libro != null) {
            btnSolicitar.setEnabled(!libro.isSolicitado());
            btnReservar.setEnabled(!libro.isReservado());
            btnEliminar.setEnabled(true);
        } else {
            btnSolicitar.setEnabled(false);
            btnReservar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }

        btnDeshacerEliminacion.setEnabled(!biblioteca.getEliminados().isEmpty());
    }
    
    @Override
    public void updateTableModel() {
        jTable.setModel(getTableModel());
    }

    private Libro libroSeleccionado;
    private final Biblioteca biblioteca;
    private final Usuario usuario;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDeshacerEliminacion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
