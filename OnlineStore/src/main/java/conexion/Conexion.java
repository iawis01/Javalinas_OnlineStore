package conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {


    private static Conexion instanciaConexion = new Conexion();

    private EntityManagerFactory fabrica;

    //En el nombre de default hay que poner el persistence Name que está en persistence.xml
    private Conexion(){
        fabrica = Persistence.createEntityManagerFactory("default");
    }

    public static Conexion getInstanciaConexion() {
        return instanciaConexion;
    }

    public static void setInstanciaConexion(Conexion instanciaConexion) {
        Conexion.instanciaConexion = instanciaConexion;
    }

    public EntityManagerFactory getFabrica() {
        return fabrica;
    }

    public void setFabrica(EntityManagerFactory fabrica) {
        this.fabrica = fabrica;
    }
}
