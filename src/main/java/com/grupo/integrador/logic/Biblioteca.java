package com.grupo.integrador.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Biblioteca {
    
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private Queue<Libro> colaEspera;
    private Stack<Libro> eliminados;
    private ControllerLogic ctrl;

    public Biblioteca() {

        ctrl = new ControllerLogic();

        this.colaEspera = new LinkedList<Libro>();
        this.eliminados = new Stack();

        List<Libro> tempLibros = ctrl.getLibrosFromDB();
        this.libros = tempLibros != null ? tempLibros : new LinkedList<Libro>();

        List<Usuario> tempUsuarios = ctrl.getUsuariosFromDB();
        this.usuarios = tempUsuarios != null ? tempUsuarios : new LinkedList<Usuario>();

    }

    public List<Libro> getLibros() {
        return libros;
    }
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public Queue<Libro> getColaEspera() {
        return colaEspera;
    }
    public Stack<Libro> getEliminados() {
        return eliminados;
    }
    public List<Libro> getLibrosReservados() {
        List<Libro> reservados = new LinkedList<>();

        for (Libro libro : libros) {
            if (libro.isReservado()) {
                reservados.add(libro);
            }
        }
        return reservados;
    }

    public void resetLibrosReservados() {
        List<Libro> librosReservados = getLibrosReservados();

        for (Libro librosReservado : librosReservados) {
            librosReservado.setReservado(false);
            ctrl.setReservadoLibroToDB(librosReservado, false);
        }
    }

    public void resetLibrosSolicitados() {
        List<Libro> librosReservados = getLibrosSolicitados();

        for (Libro librosReservado : librosReservados) {
            librosReservado.setSolicitado(false);
            ctrl.setSolicitadoLibroToDB(librosReservado, false);
            colaEspera.remove(librosReservado);
        }
    }

    public List<Libro> getLibrosSolicitados() {
        List<Libro> solicitados = new LinkedList<>();

        for (Libro libro : libros) {
            if (libro.isSolicitado()) {
                solicitados.add(libro);
            }
        }

        return solicitados;
    }


    public boolean agregarLibro(Libro libro){
        if (!libros.contains(libro)){
            libros.add(libro);
            ctrl.addLibroToDB(libro);
            return true;
        }
        return false;
    }
    public boolean eliminarLibro(Libro libro){
        if (libros.contains(libro)){
            libros.remove(libro);
            eliminados.push(libro);
            ctrl.removeLibroFromDB(libro);
            return true;
        }
        return false;
    }
    public boolean deshacerEliminacion() {
        if (!eliminados.isEmpty()) {
            ctrl.addLibroToDB(eliminados.peek());
            libros.add(eliminados.pop());
            return true;
        }
        return false;
    }

    public boolean reservarLibro(Libro libro) {
        if (libros.contains(libro)) {
            libro.setReservado(true);
            ctrl.setReservadoLibroToDB(libro, true);
            return true;
        }
        return false;
    }
    public boolean cancelarReserva(Libro libro) {
        if (libros.contains(libro)) {
            libro.setReservado(false);
            ctrl.setReservadoLibroToDB(libro, false);
            return true;
        }
        return false;
    }

    public boolean solicitarLibro(Libro libro) {
        if (libros.contains(libro)) {
            libro.setSolicitado(true);
            colaEspera.add(libro);
            ctrl.setSolicitadoLibroToDB(libro, true);
            return true;
        }
        return false;
    }
    public boolean cancelarSolicitud(Libro libro){
        if (libros.contains(libro)){
            libro.setSolicitado(false);
            colaEspera.remove(libro);
            ctrl.setSolicitadoLibroToDB(libro, false);
            return true;
        }
        return false;
    }

    public boolean agregarUsuario(Usuario usuario){
        if (!usuarios.contains(usuario)){
            usuarios.add(usuario);
            ctrl.addUsuarioToDB(usuario);
            return true;
        }
        return false;
    }
    public boolean usuarioExiste(String id) {
        for (Usuario usuario : usuarios){
            if (usuario.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean usuarioExiste(String nombre, String id){
        for (Usuario usuario : usuarios){
            if (usuario.getNombre().equals(nombre) && usuario.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public Usuario getUsuario(String nombre, String id){
        for (Usuario usuario : usuarios){
            if (usuario.getNombre().equals(nombre) && usuario.getId().equals(id)){
                return usuario;
            }
        }
        return null;
    }

    public LibrosTableModel getLibrosTableModel() {
        return new LibrosTableModel(this.libros);
    }

    public LibrosTableModel getReservadosTableModel() {
        return new LibrosTableModel(getLibrosReservados());
    }

    public LibrosTableModel getSolicitadosTableModel() {
        return new LibrosTableModel(getLibrosSolicitados());
    }

}
