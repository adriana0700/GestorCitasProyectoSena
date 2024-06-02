package org.acarmona.util;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.acarmona.servicios.ServicioJdbcExcepcion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.LogRecord;


@WebFilter("/*") //Anotación que indica que este filtro se aplicará a todas las solicitudes (/*).
public class ConexionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try (Connection conn = ConexionBD.getConnection()){
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);

            }

            try{
                request.setAttribute("conn", conn);
                chain.doFilter(request, response);
                conn.commit();

            }catch (SQLException | ServicioJdbcExcepcion e){

                conn.rollback();
                ((HttpServletResponse)response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }
        }catch (SQLException throwables){

            throwables.printStackTrace();

        }
    }
}

