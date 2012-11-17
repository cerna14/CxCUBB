package cl.cxc;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.LinkedList;

import javax.servlet.*;
import javax.servlet.http.*;

public class DenunciasServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            YoDenuncioSerializa.serializaTodosMunicipiosDesdeArchivo("D:/municipios.dat", "D:/municipiosSerializados.ser");
            YoDenuncioSerializa.serializaDenuncia(new Denuncia(1,-33.4492362, -70.654778, "denuncia1", "foto1", null, ""));

        } catch (IOException e) {
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double lat, lon;
        try {

            lat = 0.0; //Long.parseLong(request.getParameter("lat"));
            lon = 0.0; //Long.parseLong(request.getParameter("lng"));
            Controlador cont = Controlador.getInstance();
            LinkedList<Denuncia> denuncias = cont.obtieneDenunciasAlaRedonda(lat, lon);
            ListaDenuncias l = new ListaDenuncias();
            l.setMaps(denuncias);
            Gson gson = new Gson();

            String retorno = gson.toJson(l);
            response.setContentType(CONTENT_TYPE);
            PrintWriter out = response.getWriter();
            out.println(retorno);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            ListaDenuncias l = new ListaDenuncias();
            l.setSucess(false);
            l.setMessage("Error ..." + e);
            Gson gson = new Gson();

            String retorno = gson.toJson(l);
            response.setContentType(CONTENT_TYPE);
            PrintWriter out = response.getWriter();
            out.println(retorno);
            out.close();
        }


    }

}
