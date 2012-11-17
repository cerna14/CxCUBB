package cl.cxc;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.LinkedList;

import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet1 extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=ISO-8859-1";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
                                                           IOException {
        long lat, lon;
        try {
            lat = Long.parseLong(request.getParameter("lat"));
            lon=Long.parseLong(request.getParameter("lng"));
            Controlador cont= Controlador.getInstance();
            LinkedList<Denuncia> denuncias= cont.obtieneDenunciasAlaRedonda(lat, lon);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Servlet1</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a GET. This is the reply.</p>");
        out.println("</body></html>");
        out.close();
    }
}
