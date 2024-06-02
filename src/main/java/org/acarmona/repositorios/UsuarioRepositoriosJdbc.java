package org.acarmona.repositorios;

import org.acarmona.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoriosJdbc implements Repositorio<Usuario>{
    private Connection conn;

    public UsuarioRepositoriosJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();

        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios")){

            while (rs.next()){

                Usuario u = getUsuario(rs);

                usuarios.add(u);
            }
        }
        return usuarios;
    }

    private static Usuario getUsuario(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setNombre(rs.getString("nombre"));
        u.setEdad(rs.getInt("edad"));
        u.setTipoDocumento(rs.getString("tipoDocumento"));
        u.setTipoDocumento(rs.getString("numeroDocumento"));
        u.setTipoDocumento(rs.getString("fechaCita"));
        return u;
    }

    @Override
    public Usuario porId(Long id) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE idUsuario = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    usuario = getUsuario(rs);
                }

            }

        }
        return usuario;
    }

    @Override
    public void guardar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, edad, tipoDocumento, numeroDocumento, fechaCita) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setInt(2, usuario.getEdad());
            stmt.setString(3, usuario.getTipoDocumento());
            stmt.setString(4, usuario.getNumeroDocumento());
            stmt.setString(5, usuario.getFechaCita());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No se pudo guardar el usuario, ninguna fila afectada.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuario.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("No se pudo obtener el ID generado del usuario.");
                }
            }
        }

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }
}
