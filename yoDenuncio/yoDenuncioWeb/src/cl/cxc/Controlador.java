package cl.cxc;

import cl.cxc.persistencia.DenunciaBD;

import java.io.IOException;

import java.util.LinkedList;

public class Controlador {
    private static Controlador instance=null;
    private LinkedList<Denuncia> denuncias;
    private LinkedList<Municipio> municipios;
    public Controlador() throws IOException, ClassNotFoundException {
        denuncias=YoDenuncioSerializa.obtieneDenuncias();
        municipios=YoDenuncioSerializa.obtieneMunicipios();
    }
    
    public static Controlador getInstance() throws IOException,
                                                   ClassNotFoundException {
        if(instance==null){
            instance= new Controlador();
        }
        return instance;
    }
    
    public void agregaDenuncia(Denuncia denuncia){
        denuncias.add(denuncia);
    }
    
    public LinkedList<Denuncia> obtieneDenunciasAlaRedonda(double lat, double lng){
        
        //SOLO PARA PRUEBA
        LinkedList<Denuncia> lista= new LinkedList<Denuncia>();
        /* lista.add(new Denuncia(1,-33.4492362, -70.654778, "denuncia1", "foto1",null, ""));
        lista.add(new Denuncia(2,-33.442909, -70.65387, "denuncia2", "foto2",null,""));
           return lista; */
        DenunciaBD db= new DenunciaBD();
       return db.obtieneDenuncias();
    }
}
