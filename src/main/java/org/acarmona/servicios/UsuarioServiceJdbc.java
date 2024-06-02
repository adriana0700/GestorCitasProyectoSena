package org.acarmona.servicios;

import org.acarmona.modelo.Usuario;
import org.acarmona.repositorios.UsuarioRepositoriosJdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsuarioServiceJdbc implements UsuarioService{
    private UsuarioRepositoriosJdbc repositorioJdbc;

    public UsuarioServiceJdbc(Connection connection) {

        this.repositorioJdbc = new UsuarioRepositoriosJdbc(connection);
    }

    @Override
    public List<Usuario> listar() {
        try {
            return repositorioJdbc.listar();
        } catch (SQLException throwables) {
            throw  new ServicioJdbcExcepcion(throwables.getMessage(), throwables.getCause());
        }

    }

    @Override
    public Optional<Usuario> porId(Long id) {
        try {
            return Optional.ofNullable(repositorioJdbc.porId(id));
        }catch (SQLException throwables){
            throw  new ServicioJdbcExcepcion(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void guardar(Usuario usuario) throws SQLException {
        try {
            repositorioJdbc.guardar(usuario);
        } catch (SQLException throwables) {
            throw new ServicioJdbcExcepcion(throwables.getMessage(), throwables.getCause());
        }
    }
}
