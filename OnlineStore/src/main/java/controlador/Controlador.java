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
            case 2 -> mostrarArticulos();
            case 3 -> editarArticulo();
            case 4 -> eliminarArticulo();

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

                try{
                //Creamos un nuevo objeto artículo y le pasamos los parámetros obtenidos en la vista
                Articulo articulo = new Articulo(parametros.get(0).toString(),parametros.get(1).toString(),
                (Double)parametros.get(2), (Double)parametros.get(3), (Integer)parametros.get(4));
                //Utilizamos la instancia de ArticuloControlador que hemos hecho arriba y lo utilizamos para crear
                ac.crear(articulo);
                creado = true;
                }catch(Exception e){
                    e.printStackTrace();
                }
        }
            vista.articuloCreado(creado);
    }

    public  void mostrarArticulos() {
        // Crear una array temporal para recibir articulos
        // Llenar la array con los articulos
        List<Articulo> lista = ac.getArticulos();

        // Llamar a la vista para mostrar los articulos
        vista.printMostrarArticulos(lista);
    }

    public void editarArticulo(){
        boolean editado = false;
        List parametros = new ArrayList<>();


        parametros = vista.printAgregarArticulo();

        //si la información no está vacia
        if (!parametros.isEmpty()){
            //NO HAY QUE HACER COMPROBACION DE QUE EXISTA
            //EL JPA YA TE IMPIDE CREAR UN ARTICULO CON UNA LLAVE PRIMARIA DUPLICADA

                try {
                    //Creamos un nuevo objeto artículo y le pasamos los parámetros obtenidos en la vista
                    Articulo articulo = new Articulo(parametros.get(0).toString(),parametros.get(1).toString(),
                            (Double)parametros.get(2), (Double)parametros.get(3), (Integer)parametros.get(4));

                    //Ahora editamos
                    ac.editar(articulo);
                    editado = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }
        vista.articuloEditado(editado);
    }



    public void eliminarArticulo(){
        boolean eliminado = false;
        List parametros = new ArrayList<>();

        vista.recordatorioEliminarArticulo();

        //TODO Hacer un nuevo recoger datos en vista
        parametros = vista.printAgregarArticulo();


        //si la información no está vacia
        if (!parametros.isEmpty()){
            //NO HAY QUE HACER COMPROBACION DE QUE EXISTA
            //EL JPA YA TE IMPIDE CREAR UN ARTICULO CON UNA LLAVE PRIMARIA DUPLICADA Y TE AVISA

            try{
                //TODO articulo sea un articulo pasado por buscarArticuloPorId

                //Creamos un nuevo objeto artículo y le pasamos los parámetros obtenidos en la vista
                Articulo articulo = new Articulo(parametros.get(0).toString(), parametros.get(1).toString(),
                        (Double)parametros.get(2), (Double)parametros.get(3), (Integer)parametros.get(4));
                //Utilizamos la instancia de ArticuloControlador que hemos hecho arriba y lo utilizamos para crear
                ac.eliminar(articulo);
                eliminado = true;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        vista.articuloEliminado(eliminado);
    }


}
