package com.grupo.integrador.logic;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Basic
    private String nombre;
    private boolean administrador;

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public boolean isAdministrador() {
        return this.administrador;
    }


    public Usuario(String nombre, String id, boolean admin) {
        this.nombre = nombre;
        this.id = id;
        this.administrador = admin;
    }

}
