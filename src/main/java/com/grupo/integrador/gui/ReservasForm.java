package com.grupo.integrador.gui;

import com.grupo.integrador.logic.Biblioteca;
import com.grupo.integrador.logic.Libro;
import com.grupo.integrador.logic.LibrosTableModel;
import com.grupo.integrador.logic.Usuario;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableModel;

public class ReservasForm extends javax.swing.JFrame {

    public ReservasForm(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;
        this.libroSeleccionado = null;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        btnCancelarReserva = new javax.swing.JButton();
        btnCancelarTodas = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTable.setFont(new java.awt.Font("Noto Sans Mono", 0, 12)); // NOI18N
        jTable.setModel(getTableModel());
        listener();
        jScrollPane.setViewportView(jTable);

        btnCancelarReserva.setText("Cancelar Reserva");
        btnCancelarReserva.setEnabled(false);
        btnCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservaActionPerformed(evt);
            }
        });

        btnCancelarTodas.setText("Cancelar todas las Reservas");
        btnCancelarTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTodasActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Noto Sans Mono", 1, 12)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Reservados");
        lblTitulo.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(495, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelarTodas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(210, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                .addComponent(btnCancelarReserva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarTodas)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservaActionPerformed

        if (libroSeleccionado == null) return;

        biblioteca.cancelarReserva(libroSeleccionado);
        libroSeleccionado = null;
        buttonEnabler(libroSeleccionado);
        jTable.setModel(getTableModel());
    }//GEN-LAST:event_btnCancelarReservaActionPerformed

    private void btnCancelarTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTodasActionPerformed
        biblioteca.resetLibrosReservados();
        libroSeleccionado = null;
        buttonEnabler(libroSeleccionado);
        jTable.setModel(getTableModel());
        if (biblioteca.getLibrosReservados().isEmpty()) btnCancelarTodas.setEnabled(false);
    }//GEN-LAST:event_btnCancelarTodasActionPerformed

    private TableModel getTableModel() {
        return biblioteca.getReservadosTableModel();
    }
    
    private void listener(){
        this.jTable.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = this.jTable.getSelectedRow();
                if (selectedRow != -1) {
                    LibrosTableModel modelo = biblioteca.getReservadosTableModel();
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
            btnCancelarReserva.setEnabled(true);
        } else {
            btnCancelarReserva.setEnabled(false);
        }
    }

    private Libro libroSeleccionado;
    private final Biblioteca biblioteca;
    private final Usuario usuario;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarReserva;
    private javax.swing.JButton btnCancelarTodas;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
