package com.tfg.koeshiru.controller;

import com.tfg.koeshiru.entities.Usuario;
// import com.tfg.koeshiru.services.ActorDeVozService;
import com.tfg.koeshiru.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuarios")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService service;
    // @Autowired
    // private ActorDeVozService actorService;

    @GetMapping
    public ResponseEntity<?> list() {
        try {
            List<Usuario> usuarios = (List<Usuario>) service.findAll();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(Collections.singletonMap("Error", "Error al obtener usuarios: " + e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        try {
            Optional<Usuario> usuarioOptional = service.findById(id);
            if (usuarioOptional.isPresent()) {
                return ResponseEntity.ok(usuarioOptional.get());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("Error", "El usuario no se encontró por el ID"));
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(Collections.singletonMap("Error", "Error al buscar usuario: " + e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Usuario usuario) {
        try {
            Usuario created = service.save(usuario, "POST");
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(Collections.singletonMap("Error", "Error al crear usuario: " + e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            Optional<Usuario> usuarioOptional = service.findById(id);
            if (usuarioOptional.isPresent()) {
                Usuario usuarioBD = usuarioOptional.get();
                usuarioBD.setUsername(usuario.getUsername());
                usuarioBD.setNombre(usuario.getNombre());
                usuarioBD.setApellidos(usuario.getApellidos());
                usuarioBD.setContrasenia(usuario.getContrasenia());
                usuarioBD.setCorreo(usuario.getCorreo());
                usuarioBD.setFecha_nacimiento(usuario.getFecha_nacimiento());
                usuarioBD.setMensajes(usuario.getMensajes());
                usuarioBD.setActoresDeVoz(usuario.getActoresDeVoz());
                usuarioBD.setImagen(usuario.getImagen());

                Usuario updated = service.save(usuarioBD, "PUT");
                return ResponseEntity.ok(updated);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("Error", "Usuario no encontrado"));
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(Collections.singletonMap("Error", "Error al actualizar usuario: " + e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            Optional<Usuario> usuarioOptional = service.findById(id);
            if (usuarioOptional.isPresent()) {
                service.deleteById(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("Error", "Usuario no encontrado"));
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(Collections.singletonMap("Error", "Error al eliminar usuario: " + e.getMessage()));
        }
    }
}
