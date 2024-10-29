package com.grupo.integrador.logic;

import com.grupo.integrador.persistence.ControladorPersistencia;
import java.util.List;

public class ControllerLogic {

    private ControladorPersistencia ctrlPers = new ControladorPersistencia();

    public List<Libro> getLibrosFromDB() {
        return ctrlPers.getLibrosFromDB();
    }

    public List<Usuario> getUsuariosFromDB() {
        return ctrlPers.getUsuariosFromDB();
    }

    public void addLibroToDB(Libro libro) {
        ctrlPers.addLibroToDB(libro);
    }

    public void addUsuarioToDB(Usuario usuario) {
        ctrlPers.addUsuarioToDB(usuario);
    }

    public void removeLibroFromDB(Libro libro) {
        ctrlPers.removeLibroFromDB(libro);
    }

    public void setReservadoLibroToDB(Libro libro, boolean reservado) {
        ctrlPers.setReservadoLibroToDB(libro, reservado);
    }

    public void setSolicitadoLibroToDB(Libro libro, boolean solicitado) {
        ctrlPers.setSolicitadoLibroToDB(libro, solicitado);
    }

}
