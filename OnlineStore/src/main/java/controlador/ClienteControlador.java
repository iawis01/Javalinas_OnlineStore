package controlador;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import conexion.Conexion;

import entity.Articulo;
import entity.Cliente;

import java.util.List;


public class ClienteControlador {

    public void crear(Cliente cliente){
        //Creamos el entityManager
        EntityManager em = entityManager();


        try{
            //Con el entityManager, creamos la transacción
            em.getTransaction().begin();
            //persist para insertar en la base de datos
            em.persist(cliente);
            //commit para insertar la transaccion
            em.getTransaction().commit();

        }catch(Exception e){
            //Método para regresar al estado anterior si hay errores
            em.getTransaction().rollback();
        }
    }

    public void editar(Cliente cliente){
        //Creamos el entityManager
        EntityManager em = entityManager();

        try{
            //Con el entityManager, creamos la transacción
            em.getTransaction().begin();
            //merge para editar en la base de datos
            em.merge(cliente);
            //commit para insertar la transaccion
            em.getTransaction().commit();

        }catch(Exception e){
            //Método para regresar al estado anterior si hay errores
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Cliente> getClientes(){
        //Creamos una query. El nombre tiene que ser el de la entidad. No el de la base de datos
        Query query = entityManager().createQuery("SELECT c FROM Cliente c");
        return query.getResultList();
    }

    public List<Cliente> getClientesEstandar(){
        //Creamos una query. El nombre tiene que ser el de la entidad. No el de la base de datos
        Query query = entityManager().createQuery("SELECT c FROM Cliente c WHERE c.cuota = 0");
        return query.getResultList();
    }

    public List<Cliente> getClientesPremium(){
        //Creamos una query. El nombre tiene que ser el de la entidad. No el de la base de datos
        Query query = entityManager().createQuery("SELECT c FROM Cliente c WHERE c.cuota = 30");
        return query.getResultList();
    }


    public void eliminar(Cliente cliente){
        //Creamos el entityManager
        EntityManager em = entityManager();

        try{
            //Con el entityManager, creamos la transacción
            em.getTransaction().begin();
            //remove para eliminar en la base de datos
            em.remove(em.merge(cliente));
            //commit para insertar la transaccion
            em.getTransaction().commit();

        }catch(Exception e){
            //Método para regresar al estado anterior si hay errores
            em.getTransaction().rollback();
        }
    }

    public Cliente buscarClientePorEmail(String email) {
        EntityManager em = entityManager();
        try {
            return em.find(Cliente.class, email);
        } finally {
            em.close();
        }

    }

    //Conexion mediante la instancia de la clase Conexion
    private EntityManager entityManager(){

        return Conexion.getInstanciaConexion().getFabrica().createEntityManager();

    }

}