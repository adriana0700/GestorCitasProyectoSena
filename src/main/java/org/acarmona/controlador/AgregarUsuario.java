import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.acarmona.modelo.Usuario;
import org.acarmona.servicios.UsuarioService;
import org.acarmona.servicios.UsuarioServiceJdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/usuario/agregar")
public class AgregarUsuario extends HttpServlet {

    private UsuarioService usuarioService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Inicializar el servicio de usuario
        Connection conn = (Connection) getServletContext().getAttribute("conn");
        usuarioService = new UsuarioServiceJdbc(conn);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Extraer los datos del nuevo usuario desde la solicitud
        String nombre = req.getParameter("nombre");
        String edadStr = req.getParameter("edad");
        String tipoDocumento = req.getParameter("tipoDocumento");
        String numeroDocumento = req.getParameter("numeroDocumento");
        String fechaCita = req.getParameter("fechaCita");

        int edad = 0;
        if (edadStr != null && !edadStr.isEmpty()) {
            try {
                edad = Integer.parseInt(edadStr);
            } catch (NumberFormatException e) {
                // Manejo del error si la edad no es un número válido
                e.printStackTrace();
            }
        }

        // Crear una nueva instancia de Usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEdad(edad);
        usuario.setTipoDocumento(tipoDocumento);
        usuario.setNumeroDocumento(numeroDocumento);
        usuario.setFechaCita(fechaCita);

        // Guardar el nuevo usuario usando el servicio
        try {
            usuarioService.guardar(usuario);
            resp.sendRedirect(req.getContextPath() + "/usuario/ver");
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al agregar usuario.");
        }
    }
}
