package controlador;


import vista.Vista;


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



}

