package org.acarmona.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.acarmona.modelo.Usuario;
import org.acarmona.servicios.UsuarioServiceJdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/agregar")
public class AgregarUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener la conexión del atributo de la solicitud
        Connection conn = (Connection) req.getAttribute("conn");
        if (conn == null) {
            throw new ServletException("La conexión a la base de datos no está disponible");
        }

        // Inicializar el servicio de usuario con la conexión obtenida
        UsuarioServiceJdbc usuarioService = new UsuarioServiceJdbc(conn);

        // Extraer los datos del nuevo usuario desde la solicitud
        String nombre = req.getParameter("nombre");
        String edadParam = req.getParameter("edad");

        // Valor predeterminado en caso de que "edadParam" sea nulo
        int edad = 0;
        if (edadParam != null && !edadParam.isEmpty()) {
            edad = Integer.parseInt(edadParam);
        }
        String tipoDocumento = req.getParameter("tipoDocumento");
        String numeroDocumento = req.getParameter("numeroDocumento");
        String fechaCita = req.getParameter("fechaCita");

        // Crear una nueva instancia de Usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEdad(edad);
        usuario.setTipoDocumento(tipoDocumento);
        usuario.setNumeroDocumento(numeroDocumento);
        usuario.setFechaCita(fechaCita);

        // Guardar el nuevo usuario usando el servicio
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        try {
            usuarioService.guardar(usuario);
            out.println("{");
            out.println("\"status\": \"Registro Exitoso\",");
            out.println("\"message\": \"¡Cita agendada exitosamente!\"");
            out.println("}");

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("{");
            out.println("\"status\": \"Error\",");
            out.println("\"message\": \"¡No se pudo agendar la cita!\"");
            out.println("}");
        } finally {
            out.println("</body></html>");
            out.close();
        }
    }
}