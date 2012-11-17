package cl.cxc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class DenunciaMovilFotoServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
      System.out.println("Recibiendo imagen en servlet");
      File filename = new File("D:/prueba.jpg");
        FileOutputStream out = new FileOutputStream(filename);
        InputStream in = request.getInputStream();
        System.out.println(in.available());
        byte[] buf = new byte[512];
        int nread = 0, total_read = 0;

        while (-1 != (nread = in.read(buf))) {
            total_read += nread;
            out.write(buf, 0, nread);
        }
        System.out.println("bytes leidos " + total_read);
        out.close();
        in.close();
    }
}
