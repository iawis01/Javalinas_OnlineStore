package controlador;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import conexion.Conexion;
import entity.Articulo;

import java.util.List;


public class ArticuloControlador {

    public void crear(Articulo articulo){
        //Creamos el entityManager
        EntityManager em = entityManager();


        try{
            //Con el entityManager, creamos la transacción
            em.getTransaction().begin();
            //persist para insertar en la base de datos
            em.persist(articulo);
            //commit para insertar la transaccion
            em.getTransaction().commit();

        }catch(Exception e){
            //Método para regresar al estado anterior si hay errores
            em.getTransaction().rollback();
        }
    }

    public void editar(Articulo articulo){
        //Creamos el entityManager
        EntityManager em = entityManager();

        try{
            //Con el entityManager, creamos la transacción
            em.getTransaction().begin();
            //merge para editar en la base de datos
            em.merge(articulo);
            //commit para insertar la transaccion
            em.getTransaction().commit();

        }catch(Exception e){
            //Método para regresar al estado anterior si hay errores
            em.getTransaction().rollback();
        }
    }

    public List<Articulo> getArticulos(){
        //Creamos una query. El nombre tiene que ser el de la entidad. No el de la base de datos
        Query query = entityManager().createQuery("SELECT a FROM Articulo a");
        return query.getResultList();
    }


    public void eliminar(Articulo articulo){
        //Creamos el entityManager
        EntityManager em = entityManager();

        try{
            //Con el entityManager, creamos la transacción
            em.getTransaction().begin();
            //merge para editar en la base de datos
            em.remove(articulo);
            //commit para insertar la transaccion
            em.getTransaction().commit();

        }catch(Exception e){
            //Método para regresar al estado anterior si hay errores
            em.getTransaction().rollback();
        }
    }

    //Conexion mediante la instancia de la clase Conexion
    private EntityManager entityManager(){

        return Conexion.getInstanciaConexion().getFabrica().createEntityManager();

    }

}
