package com.grupo.integrador.persistence;

import com.grupo.integrador.logic.Libro;
import com.grupo.integrador.logic.Usuario;
import java.util.List;

public class ControladorPersistencia {

    private UsuarioJpaController usuarioJpaController;
    private LibroJpaController libroJpaController;

    public ControladorPersistencia() {
        this.usuarioJpaController = new UsuarioJpaController();
        this.libroJpaController = new LibroJpaController();
    }

    public void addLibroToDB(Libro libro) {
        libroJpaController.create(libro);
    }

    public void addUsuarioToDB(Usuario usuario) {
        usuarioJpaController.create(usuario);
    }

    public List<Libro> getLibrosFromDB() {
        return libroJpaController.findLibroEntities();
    }

    public List<Usuario> getUsuariosFromDB() {
        return usuarioJpaController.findUsuarioEntities();
    }

    public void removeLibroFromDB(Libro libro) {
        try {
            libroJpaController.destroy(libro.getTitulo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setReservadoLibroToDB(Libro libro, boolean reservado) {
        try {
            libro.setReservado(reservado);
            libroJpaController.edit(libro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSolicitadoLibroToDB(Libro libro, boolean solicitado) {
        try {
            libro.setSolicitado(solicitado);
            libroJpaController.edit(libro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
