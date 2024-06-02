package org.acarmona.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.acarmona.modelo.Usuario;
import org.acarmona.servicios.UsuarioService;
import org.acarmona.servicios.UsuarioServiceJdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/usuario/actualizar")
public class ActualizarUsuario extends HttpServlet {

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
        int edad = Integer.parseInt(req.getParameter("edad"));
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
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Registro Exitoso</title></head><body>");
        try {
            usuarioService.guardar(usuario);
            out.println("<h1>¡Cita agendada exitosamente!</h1>");
            out.println("<p>La cita para " + nombre + " ha sido agendada correctamente.</p>");
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
            out.println("<h1>Error</h1>");
            out.println("<p>Ha ocurrido un error al agendar la cita.</p>");
        }

    }
}
