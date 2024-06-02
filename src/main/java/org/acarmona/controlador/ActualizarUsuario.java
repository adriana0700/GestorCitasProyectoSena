package org.acarmona.controlador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.acarmona.modelo.Usuario;

import java.io.IOException;


@WebServlet("/usuario/actualizar")
public class ActualizarUsuario extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("usuario") != null) {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            updateUsuario(req, usuario);
        }

        resp.sendRedirect(req.getContextPath() + "/usuario/ver");
    }

    private void updateUsuario(HttpServletRequest request, Usuario usuario) {
        String nombre = request.getParameter("nombre");
        String edadStr = request.getParameter("edad");
        String tipoDocumento = request.getParameter("tipoDocumento");
        String numeroDocumento = request.getParameter("numeroDocumento");
        String fechaCita = request.getParameter("fechaCita");

        if (nombre != null && !nombre.isEmpty()) {
            usuario.setNombre(nombre);
        }

        if (edadStr != null && !edadStr.isEmpty()) {
            try {
                int edad = Integer.parseInt(edadStr);
                usuario.setEdad(edad);
            } catch (NumberFormatException e) {
                // Manejo del error si la edad no es un número válido
                e.printStackTrace();
            }
        }

        if (tipoDocumento != null && !tipoDocumento.isEmpty()) {
            usuario.setTipoDocumento(tipoDocumento);
        }

        if (numeroDocumento != null && !numeroDocumento.isEmpty()) {
            usuario.setNumeroDocumento(numeroDocumento);
        }

        if (fechaCita != null && !fechaCita.isEmpty()) {
            usuario.setFechaCita(fechaCita);
        }
    }
}


