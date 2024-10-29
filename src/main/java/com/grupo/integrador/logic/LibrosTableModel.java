package com.grupo.integrador.logic;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class LibrosTableModel extends AbstractTableModel {

    private final List<Libro> libros;
    private final String[] nombreColumnas;

    public LibrosTableModel(List<Libro> libros) {
        this.nombreColumnas = new String[]{"Titulo", "Autor", "Fecha de Publicacion", "Reservado", "Solicitado"};
        this.libros = libros;
    }

    @Override
    public int getRowCount() {
        return libros.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Libro libro = libros.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                libro.getTitulo();
            case 1 ->
                libro.getAutor();
            case 2 ->
                libro.getFechaPublicacion();
            case 3 ->
                libro.isReservadoString();
            case 4 ->
                libro.isSolicitadoString();
            default ->
                null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Libro getLibroAt(int rowIndex) {
        return libros.get(rowIndex);
    }

}
