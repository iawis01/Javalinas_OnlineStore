package controlador;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import conexion.Conexion;

import entity.Pedido;

import java.util.List;


public class PedidoControlador {

    public void crear(Pedido pedido){
        //Creamos el entityManager
        EntityManager em = entityManager();


        try{
            //Con el entityManager, creamos la transacción
            em.getTransaction().begin();
            //persist para insertar en la base de datos
            em.persist(pedido);
            //commit para insertar la transaccion
            em.getTransaction().commit();

        }catch(Exception e){
            //Método para regresar al estado anterior si hay errores
            em.getTransaction().rollback();
        }
    }

    public void editar(Pedido pedido){
        //Creamos el entityManager
        EntityManager em = entityManager();

        try{
            //Con el entityManager, creamos la transacción
            em.getTransaction().begin();
            //merge para editar en la base de datos
            em.merge(pedido);
            //commit para insertar la transaccion
            em.getTransaction().commit();

        }catch(Exception e){
            //Método para regresar al estado anterior si hay errores
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Pedido> getPedidos(){
        //Creamos una query. El nombre tiene que ser el de la entidad. No el de la base de datos
        Query query = entityManager().createQuery("SELECT p FROM Pedido p");
        return query.getResultList();
    }

    public List<Pedido> getPedidosPendientes(){
        //Creamos una query. El nombre tiene que ser el de la entidad. No el de la base de datos
        Query query = entityManager().createQuery("SELECT p FROM Pedido p WHERE p.procesado = false");
        return query.getResultList();
    }

    public List<Pedido> getPedidosEnviados(){
        //Creamos una query. El nombre tiene que ser el de la entidad. No el de la base de datos
        Query query = entityManager().createQuery("SELECT p FROM Pedido p WHERE p.procesado = true");
        return query.getResultList();
    }


    public void eliminar(Pedido pedido){
        //Creamos el entityManager
        EntityManager em = entityManager();

        try{
            //Con el entityManager, creamos la transacción
            em.getTransaction().begin();
            //remove para eliminar en la base de datos
            em.remove(em.merge(pedido));
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