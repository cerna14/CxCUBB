package cl.cxc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
     
    public class ServletImagen extends HttpServlet {
     
        
        
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            
            System.out.println("Recibiendo imagen en servlet");
            File filename = new File(System.getProperty("user.home")+"prueba.jpg");
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


