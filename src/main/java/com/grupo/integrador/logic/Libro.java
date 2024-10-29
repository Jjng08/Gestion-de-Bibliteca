package com.grupo.integrador.logic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Libro implements Serializable {

    @Id
    private String titulo;
    @Basic
    private String autor;
    private String codigoReserva;
    private String codigoEntrega;
    private boolean reservado;
    private boolean solicitado;
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;

    public Libro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public String getCodigoEntrega() {
        return codigoEntrega;
    }

    public boolean isReservado() {
        return reservado;
    }

    public boolean isSolicitado() {
        return solicitado;
    }

    public String isReservadoString() {
        return this.reservado ? "SI" : "NO";
    }

    public String isSolicitadoString() {
        return this.solicitado ? "SI" : "NO";
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public void setSolicitado(boolean solicitado) {
        this.solicitado = solicitado;
    }

    public Libro(String titulo, String autor, Date fechaPublicacion, String codigoReserva, String codigoEntrega) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.codigoReserva = codigoReserva;
        this.codigoEntrega = codigoEntrega;
        this.reservado = false;
        this.solicitado = false;
    }

}
