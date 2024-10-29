package com.grupo.integrador.gui;

import com.grupo.integrador.logic.Biblioteca;
import com.grupo.integrador.logic.Libro;
import com.grupo.integrador.logic.LibrosTableModel;
import com.grupo.integrador.logic.Usuario;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableModel;

public class Solicitudesform extends javax.swing.JFrame {

    public Solicitudesform(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;
        this.libroSeleccionado = null;

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelarSolicitud = new javax.swing.JButton();
        btnCancelarTodas = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnCancelarSolicitud.setText("Cancelar Solcitud");
        btnCancelarSolicitud.setEnabled(false);
        btnCancelarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarSolicitudActionPerformed(evt);
            }
        });

        btnCancelarTodas.setText("Cancelar todas las Solicitudes");
        btnCancelarTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTodasActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Noto Sans Mono", 1, 12)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Solicitados");
        lblTitulo.setFocusable(false);

        jTable.setFont(new java.awt.Font("Noto Sans Mono", 0, 12)); // NOI18N
        jTable.setModel(getTableModel());
        listener();
        jScrollPane.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelarTodas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarSolicitud)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarTodas)
                .addGap(7, 7, 7))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarSolicitudActionPerformed

        if (libroSeleccionado == null) return;

        biblioteca.cancelarSolicitud(libroSeleccionado);
        libroSeleccionado = null;
        buttonEnabler(libroSeleccionado);
        jTable.setModel(getTableModel());
    }//GEN-LAST:event_btnCancelarSolicitudActionPerformed

    private void btnCancelarTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTodasActionPerformed
        biblioteca.resetLibrosSolicitados();
        libroSeleccionado = null;
        buttonEnabler(libroSeleccionado);
        jTable.setModel(getTableModel());
        if (biblioteca.getLibrosSolicitados().isEmpty()) btnCancelarTodas.setEnabled(false);
    }//GEN-LAST:event_btnCancelarTodasActionPerformed

    private TableModel getTableModel() {
        return biblioteca.getSolicitadosTableModel();
    }
    
    private void listener(){
        this.jTable.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = this.jTable.getSelectedRow();
                if (selectedRow != -1) {
                    LibrosTableModel modelo = biblioteca.getSolicitadosTableModel();
                    Libro libroTemp = modelo.getLibroAt(selectedRow);
                    System.out.println("libro seleccionado: " + libroTemp.getTitulo() + "\n fila: " + selectedRow);
                    buttonEnabler(libroTemp);
                }
            }
        });
    }
    
    private void buttonEnabler(Libro libro) {
        libroSeleccionado = libro;
        if (libro != null) {
            btnCancelarSolicitud.setEnabled(true);
        } else {
            btnCancelarSolicitud.setEnabled(false);
        }
    }
    private Libro libroSeleccionado;
    private final Biblioteca biblioteca;
    private final Usuario usuario;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarSolicitud;
    private javax.swing.JButton btnCancelarTodas;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
