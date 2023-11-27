/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author Damian
 */
public class modelo_registro {
    String nombre ;
        String apellido;
        String cedula;
        String usuario; 
        String contrasena; 
        String valContrasena; 
        String respuesta ;

    public modelo_registro() {
    }

    public modelo_registro(String nombre, String apellido, String cedula, String usuario, String contrasena, String valContrasena, String respuesta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.valContrasena = valContrasena;
        this.respuesta = respuesta;
    }
    @Override
    public String toString() {
    return "Cliente Registrado {" +
            "Nombre='" + nombre + '\'' +
            ", Apellido='" + apellido + '\'' +
            ", Cédula='" + cedula + '\'' +
            ", Usuario='" + usuario + '\'' +
            ", Contraseña='" + contrasena + '\'' +
            ", Respuesta='" + respuesta + '\'' +
            // Agrega otros campos según sea necesario
            '}';
}
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getValContrasena() {
        return valContrasena;
    }

    public void setValContrasena(String valContrasena) {
        this.valContrasena = valContrasena;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
        
}
