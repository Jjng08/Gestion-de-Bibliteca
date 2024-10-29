# Proyecto Biblioteca

Este proyecto es una aplicación de gestión de una biblioteca, que permite realizar operaciones como agregar libros, eliminarlos, solicitarlos y reservarlos. La aplicación está construida en Java y utiliza la biblioteca Swing para la interfaz gráfica de usuario.

## Estructura del Proyecto

El proyecto se divide en varias clases clave que gestionan las diferentes funcionalidades de la biblioteca:

- **Biblioteca**: Clase principal que maneja la lógica de la biblioteca.
- **Libro**: Representa un libro en la biblioteca.
- **Usuario**: Representa un usuario de la biblioteca.
- **LibrosTableModel**: Modelo de tabla para mostrar los libros en la interfaz gráfica.
- **ControllerLogic**: Controlador que maneja la interacción con la base de datos.
- **InventarioForm**: Interfaz gráfica para la gestión del inventario de libros.
- **AgregarForm**: Interfaz gráfica para agregar un nuevo libro a la biblioteca.

## Diagrama de Clases

```mermaid
classDiagram
    class Biblioteca {
        - List~Libro~ libros
        - List~Usuario~ usuarios
        - Queue~Libro~ colaEspera
        - Stack~Libro~ eliminados
        - ControllerLogic ctrl

        + Biblioteca()
        + List~Libro~ getLibros()
        + List~Usuario~ getUsuarios()
        + Queue~Libro~ getColaEspera()
        + Stack~Libro~ getEliminados()
        + List~Libro~ getLibrosReservados()
        + void resetLibrosReservados()
        + void resetLibrosSolicitados()
        + List~Libro~ getLibrosSolicitados()
        + boolean agregarLibro(Libro libro)
        + boolean eliminarLibro(Libro libro)
        + boolean deshacerEliminacion()
        + boolean reservarLibro(Libro libro)
        + boolean cancelarReserva(Libro libro)
        + boolean solicitarLibro(Libro libro)
        + boolean cancelarSolicitud(Libro libro)
        + boolean agregarUsuario(Usuario usuario)
        + boolean usuarioExiste(String id)
        + boolean usuarioExiste(String nombre, String id)
        + Usuario getUsuario(String nombre, String id)
        + LibrosTableModel getLibrosTableModel()
        + LibrosTableModel getReservadosTableModel()
        + LibrosTableModel getSolicitadosTableModel()
    }

    class Libro {
        - String titulo
        - String autor
        - Date fechaPublicacion
        - String codigoReserva
        - String codigoEntrega
        - boolean solicitado
        - boolean reservado

        + String getTitulo()
        + String getAutor()
        + Date getFechaPublicacion()
        + String getCodigoReserva()
        + String getCodigoEntrega()
        + boolean isSolicitado()
        + boolean isReservado()
        + void setSolicitado(boolean solicitado)
        + void setReservado(boolean reservado)
    }

    class Usuario {
        - String id
        - String nombre

        + String getId()
        + String getNombre()
    }

    class LibrosTableModel {
        - List~Libro~ libros

        + LibrosTableModel(List~Libro~ libros)
        + int getRowCount()
        + int getColumnCount()
        + Object getValueAt(int rowIndex, int columnIndex)
        + String getColumnName(int columnIndex)
    }

    class ControllerLogic {
        + List~Libro~ getLibrosFromDB()
        + List~Usuario~ getUsuariosFromDB()
        + void addLibroToDB(Libro libro)
        + void removeLibroFromDB(Libro libro)
        + void setReservadoLibroToDB(Libro libro, boolean reservado)
        + void setSolicitadoLibroToDB(Libro libro, boolean solicitado)
        + void addUsuarioToDB(Usuario usuario)
    }

    class InventarioForm {
        - Libro libroSeleccionado
        - Biblioteca biblioteca
        - Usuario usuario

        + InventarioForm(Biblioteca biblioteca, Usuario usuario)
        + void initComponents()
        + void btnSalirActionPerformed()
        + void btnAgregarActionPerformed()
        + void btnSolicitarActionPerformed()
        + void btnReservarActionPerformed()
        + void btnEliminarActionPerformed()
        + void btnDeshacerEliminacionActionPerformed()
        + TableModel getTableModel()
        + void listener()
        + void buttonEnabler(Libro libro)
    }

    class AgregarForm {
        - Biblioteca biblioteca

        + AgregarForm(Biblioteca biblioteca)
        + void initComponents()
        + void lblCancelarActionPerformed()
        + void lblAceptarActionPerformed()
        + boolean validarCampos()
    }

    Biblioteca --> Libro
    Biblioteca --> Usuario
    Biblioteca --> LibrosTableModel
    Biblioteca --> ControllerLogic
    InventarioForm --> Biblioteca
    InventarioForm --> Usuario
    InventarioForm --> Libro
    InventarioForm --> LibrosTableModel
    AgregarForm --> Biblioteca
```

## Descripción de las Clases

### Biblioteca

La clase `Biblioteca` gestiona la colección de libros y usuarios. Permite agregar, eliminar, reservar y solicitar libros, así como agregar usuarios y consultar la existencia de un usuario.

### Libro

La clase `Libro` representa un libro con atributos como título, autor, fecha de publicación, códigos de reserva y solicitud, y estados de reserva y solicitud.

### Usuario

La clase `Usuario` representa a un usuario de la biblioteca con atributos como ID y nombre.

### LibrosTableModel

La clase `LibrosTableModel` es un modelo de tabla para mostrar los libros en una interfaz gráfica, utilizando la lista de libros.

### ControllerLogic

La clase `ControllerLogic` maneja la interacción con la base de datos, incluyendo la recuperación y actualización de información sobre libros y usuarios.

### InventarioForm

La clase `InventarioForm` es una interfaz gráfica para la gestión del inventario de libros, permitiendo operaciones como agregar, eliminar, solicitar y reservar libros.

### AgregarForm

La clase `AgregarForm` es una interfaz gráfica para agregar un nuevo libro a la biblioteca, con validación de los campos de entrada.

## Uso

Para utilizar la aplicación, simplemente ejecute la clase principal que inicia la interfaz gráfica y siga las instrucciones en pantalla para gestionar el inventario de la biblioteca.
