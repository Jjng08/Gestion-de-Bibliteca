package com.grupo.integrador.logic;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-13T18:39:37", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Libro.class)
public class Libro_ { 

    public static volatile SingularAttribute<Libro, String> codigoReserva;
    public static volatile SingularAttribute<Libro, Boolean> reservado;
    public static volatile SingularAttribute<Libro, String> codigoEntrega;
    public static volatile SingularAttribute<Libro, Boolean> solicitado;
    public static volatile SingularAttribute<Libro, String> titulo;
    public static volatile SingularAttribute<Libro, Date> fechaPublicacion;
    public static volatile SingularAttribute<Libro, String> autor;

}