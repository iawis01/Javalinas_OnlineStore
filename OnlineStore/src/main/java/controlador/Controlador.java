package controlador;

import entity.Articulo;
import vista.Vista;
import controlador.ArticuloControlador;

import java.util.ArrayList;
import java.util.List;

public class Controlador {

    ArticuloControlador ac = new ArticuloControlador();

    private final Vista vista;
    private int opcion = 0;

    public Controlador(/*Datos modelo,*/ Vista vista) {
        //this.modelo = modelo;
        this.vista = vista;
    }

    // MENU PRINCIPAL
    // Vista menu general
    public void mostrarMenuPrincipal() throws Exception {
        opcion = vista.printMenu();
        performActionMenu(opcion);
    }


    // Accion del menu principal
    public  void performActionMenu(int choice) throws Exception {
        switch (choice) {
            case 0 -> OnlineStore.salirAplicacion();
            case 1 -> gestionArticulos();
            //case 2 -> gestionClientes();
            //case 3 -> gestionPedidos();
        }
    }

    //Gestion de articulos
    public void gestionArticulos() throws Exception {
        opcion = vista.printMenuArticulos();
        opcionesArticulos(opcion);
    }

    public void opcionesArticulos(int choice) throws Exception{
        switch (choice){
            case 0 -> mostrarMenuPrincipal();
            case 1 -> agregarArticulo();
            //case 2 -> mostrarArticulos();

        }
    }

    public void agregarArticulo(){
        boolean creado = false;
        List parametros = new ArrayList<>();

        parametros = vista.printAgregarArticulo();


        //si la información no está vacia
            if (!parametros.isEmpty()){
                //NO HAY QUE HACER COMPROBACION DE QUE EXISTA
                //EL JPA YA TE IMPIDE CREAR UN ARTICULO CON UNA LLAVE PRIMARIA DUPLICADA

                //Creamos un nuevo objeto artículo y le pasamos los parámetros obtenidos en la vista
                Articulo articulo = new Articulo(parametros.get(0).toString(),parametros.get(1).toString(),
                (Double)parametros.get(2), (Double)parametros.get(3), (Integer)parametros.get(4));
                //Utilizamos la instancia de ArticuloControlador que hemos hecho arriba y lo utilizamos para crear
                ac.crear(articulo);
                creado = true;
        }
            vista.articuloCreado(creado);
    }


}
