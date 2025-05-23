package com.tfg.koeshiru.DTOS;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tfg.koeshiru.entities.ActorDeVoz;
import com.tfg.koeshiru.entities.Mensaje;
import com.tfg.koeshiru.entities.Usuario;

public class UsuarioDTO implements Serializable {
    private long id_usuario;

    private String nombre;

    private String apellidos;

    private String correo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String contrasenia;

    private Date fecha_nacimiento;

    private List<Mensaje> mensajes;

    private List<ActorDeVoz> actoresDeVoz;

    public UsuarioDTO() {
    }

    public UsuarioDTO(long id_usuario, String nombre, String apellidos, String correo, String contrasenia,
            Date fecha_nacimiento, List<Mensaje> mensajes, List<ActorDeVoz> actoresDeVoz) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.fecha_nacimiento = fecha_nacimiento;
        this.mensajes = mensajes;
        this.actoresDeVoz = actoresDeVoz;
    }

    public UsuarioDTO(Usuario usuario) {
        this.id_usuario = usuario.getId_usuario();
        this.nombre = usuario.getNombre();
        this.apellidos = usuario.getApellidos();
        this.correo = usuario.getCorreo();
        this.contrasenia = usuario.getContrasenia();
        this.fecha_nacimiento = usuario.getFecha_nacimiento();
        this.mensajes = usuario.getMensajes();
        this.actoresDeVoz = usuario.getActoresDeVoz();
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public List<ActorDeVoz> getActoresDeVoz() {
        return actoresDeVoz;
    }

    public void setActoresDeVoz(List<ActorDeVoz> actoresDeVoz) {
        this.actoresDeVoz = actoresDeVoz;
    }

}
