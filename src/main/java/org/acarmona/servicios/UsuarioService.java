package org.acarmona.servicios;

import org.acarmona.modelo.Usuario;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listar();
    Optional<Usuario> porId(Long id);

    void guardar(Usuario usuario) throws SQLException;
}
