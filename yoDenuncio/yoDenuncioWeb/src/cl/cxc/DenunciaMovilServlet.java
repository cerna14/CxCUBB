package cl.cxc;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Date;

import javax.servlet.*;
import javax.servlet.http.*;

public class DenunciaMovilServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double lat;
        double log;
        String descripcion = "";
        try {
            lat = Double.valueOf(request.getParameter("lat")).doubleValue();
            log = Double.valueOf(request.getParameter("log")).doubleValue();
            descripcion = request.getParameter("desc");
             
          
          Controlador cont;
          cont = Controlador.getInstance();
          cont.insertarDenuncia(0, lat, log, descripcion,  new Date( (new java.util.Date()).getTime()), "NO_SOLUCIONADO"); 
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>DenunciaMovilServlet</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a POST. This is the reply.</p>");
        out.println("</body></html>");
        out.close();
        
        
    }
}
