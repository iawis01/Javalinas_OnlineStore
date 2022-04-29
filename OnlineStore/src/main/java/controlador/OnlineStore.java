package controlador;

import entity.Articulo;
import entity.Cliente;
import entity.Pedido;
import controlador.*;
import vista.Vista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class OnlineStore {

    static boolean salir = false;

    public static void main(String[] args) throws Exception {
        Vista vista = new Vista();
        //Datos modelo = new Datos();
        Controlador controlador = new Controlador( vista);

        //Inicio del menu
        while(!salir){
            controlador.mostrarMenuPrincipal();
        }
    }

    public static void salirAplicacion(){

        salir = true;
    }















        /*
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            //Para agregar un articulo
            Articulo articulo = new Articulo();
            articulo.setCodigo("4a");
            articulo.setDescripcion("altavoz2");
            articulo.setPvp(30.22);
            articulo.setGastosEnvio(5.2);
            articulo.setTiempoPreparacion(5);

            entityManager.persist(articulo);

            //Para agregar un cliente
            Cliente cliente = new Cliente();
            cliente.setEmail("iaguito2@gmail.com");
            cliente.setNombre("Iaguito2");
            cliente.setDomicilio("Calle de la estrella");
            cliente.setNif("12345678A");
            cliente.setCuota(30);
            cliente.setDescuento(20);

            entityManager.persist(cliente);

            Date date = new Date();
            java.sql.Timestamp dateSQL = new java.sql.Timestamp(date.getTime());

            //Para agregar un pedido
            Pedido pedido = new Pedido();
            pedido.setClientesByEmailCliente(cliente);
            pedido.setArticulosByCodigoArticulo(articulo);
            pedido.setCantidad(3);
            pedido.setFecha(dateSQL);
            pedido.setProcesado(false);

            entityManager.persist(pedido);
/*


           /* TypedQuery<Articulo> empByDeptQuery = entityManager.createNamedQuery("Employee.byDept", Articulo.class);
            empByDeptQuery.setParameter(1, "Java Advocacy");
            for (Employee employee : empByDeptQuery.getResultList()) {
                System.out.println(employee);
            }

            Query countEmpByDept = entityManager.createNativeQuery("SELECT COUNT(*) FROM Employee INNER JOIN Department D on Employee.department_id = D.id WHERE D.name=:deptName");
            countEmpByDept.setParameter("deptName", "Java Advocacy");
            System.out.println("There are " + countEmpByDept.getSingleResult() + " Java Advocates.");
             */


            /*transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }*/


}

