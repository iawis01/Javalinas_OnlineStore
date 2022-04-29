package vista;

import entity.Articulo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vista {

    public Vista(){

    }


    //Vista de menu
    public int printMenu(){
        System.out.println("Seleccione la gestión a realizar");
        System.out.println("1. Gestionar articulos");
        System.out.println("2. Gestionar clientes");
        System.out.println("3. Gestionar pedidos");
        System.out.println("0. Salir");

        return getInput(3);
    }
    //Vista de submenu para articulos
    public int printMenuArticulos(){
        System.out.println("\nSeleccione la acción a realizar");
        System.out.println("0. Volver al menu principal");
        System.out.println("1. Agregar un articulo");
        System.out.println("2. Mostrar los articulos");

        return getInput(2);
    }


    public List<Object> printAgregarArticulo(){

        String codigo;
        String descripcion;
        double precioVenta;
        double gastosEnvio;
        int tiempoPrepEnvio;

        List<Object> parametros = new ArrayList<>();

        //Vamos a llenar esta lista parametros con los diferentes atributos
        System.out.println("Introduce el código del producto.");
        //También podría valer codigo = teclado.nextline(); Mejor modularizarlo más
        codigo = getString();
        parametros.add(codigo);

        System.out.println("Introduzca la descripcion del articulo:");
        descripcion = getString();
        parametros.add(descripcion);

        System.out.println("Introduzca el precio de venta. Digito con decimal (ej.: 2.2):");
        precioVenta = getDouble();
        parametros.add(precioVenta);

        System.out.println("Introduzca los gastos de envio. Digito con decimal (ej.: 2.2):");
        gastosEnvio = getDouble();
        parametros.add(gastosEnvio);

        System.out.println("Introduzca el tiempo de preparacion en minutos. Numero entero:");
        tiempoPrepEnvio = getInt();
        parametros.add(tiempoPrepEnvio);


        //Devolver al controlador los parametros para crear el articulo
        return parametros;
    }

    public void articuloCreado(Boolean creado) {
        if (creado) {
            System.out.println("Se ha creado el articulo");
        } else {
            System.err.println("Ha habido un error al crear el articulo");
        }
    }


    public void printMostrarArticulos(List<Articulo> lista) {
        System.out.println("\nLista de articulos");
        System.out.println("---------------------");

        for (Object o : lista){
            System.out.println(o);
            System.out.println("------------");
        }
    }








    //Método para recibir el Input del usuario para el menú
    public static int getInput(int max){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while(choice < 0 || choice > max){
            try {
                System.out.print("\nIntroduzca la opcion: \n");
                // recibir input en forma de String y parse a int
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch(NumberFormatException e){
                // todo error personalizado en la clase de errores
                System.err.println("Introduzca un numero valido\n");
            }
        }
        return choice;
    }
    // metodo para recibir un input en forma de string
    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    // metodo para recibir un input en forma de int
    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        try {
            numero = Integer.parseInt(scanner.nextLine());
        } catch (Exception e){
            e.printStackTrace();
        }
        return numero;
    }

    // metodo para recibir un double
    public static double getDouble() {
        Scanner scanner = new Scanner(System.in);
        double numero = 0;
        try {
            numero = Double.parseDouble(scanner.nextLine());
        } catch (Exception e){
            /*printStackTrace() sirve para excepciones
            //además del error, da detalles de en qué linea
            y en qué clase ha ocurrido la excepción*/
            e.printStackTrace();
        }
        return numero;
    }

}
