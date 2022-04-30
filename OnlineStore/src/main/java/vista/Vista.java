package vista;

import entity.Articulo;
import entity.Cliente;
import entity.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vista {

    public Vista() {

    }


    //Vista de menu
    public int printMenu() {
        System.out.println("Seleccione la gestión a realizar");
        System.out.println("1. Gestionar articulos");
        System.out.println("2. Gestionar clientes");
        System.out.println("3. Gestionar pedidos");
        System.out.println("0. Salir");

        return getInput(3);
    }

    //INICIO DE VISTA DE ARTICULOS

    //Vista de submenu para articulos
    public int printMenuArticulos() {
        System.out.println("\nSeleccione la acción a realizar");
        System.out.println("0. Volver al menu principal");
        System.out.println("1. Agregar un articulo");
        System.out.println("2. Mostrar los articulos");
        System.out.println("3. Editar un articulo");
        System.out.println("4. Eliminar un articulo");

        return getInput(4);
    }

    public List<Object> printAgregarArticulo() {

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

    public String printAgregarCodigoArticulo(){
        System.out.println("Introduzca el codigo del articulo a eliminar");
        String codigoArticulo = getString();
        return codigoArticulo;

    }

    public List<Object> printIntroduceCodigoArticulo() {

        String codigo;

        List<Object> parametros = new ArrayList<>();

        //Vamos a llenar esta lista parametros con los diferentes atributos
        System.out.println("Introduce el código del producto.");
        //También podría valer codigo = teclado.nextline(); Mejor modularizarlo más
        codigo = getString();
        parametros.add(codigo);

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

    public void articuloEditado(Boolean editado) {
        if (editado) {
            System.out.println("Se ha editado el articulo");
        } else {
            System.err.println("Ha habido un error al editar el articulo");
        }
    }

    public void articuloEliminado(Boolean editado) {
        if (editado) {
            System.out.println("Se ha eliminado el articulo");
        } else {
            System.err.println("Ha habido un error al eliminar el articulo");
        }
    }

    public void recordatorioEliminarArticulo() {
        System.out.println("\nAcuérdese de insertar todos los campos del articulo a eliminar\n");
        System.out.println("\nCodigo, descripcion, pvp, gastos_envio, tiempo_preparacion.\n");

    }


    public void printMostrarArticulos(List<Articulo> lista) {
        System.out.println("\nLista de articulos");
        System.out.println("---------------------");

        for (Object o : lista) {
            System.out.println(o);
            System.out.println("------------");
        }
    }

    //FIN DE VISTA DE ARTICULOS


    //INICIO DE VISTA DE CLIENTES

    public int printMenuClientes() {
        System.out.println("\nSeleccione la acción a realizar");
        System.out.println("0. Volver al menu principal");
        System.out.println("1. Agregar un cliente");
        System.out.println("2. Mostrar los clientes");
        System.out.println("3. Editar un cliente");
        System.out.println("4. Eliminar un cliente");
        System.out.println("5. Mostrar los clientes estandar");
        System.out.println("6. Mostrar los clientes premium");

        return getInput(6);
    }

    public List<Object> printAgregarCliente() {

        int tipoDeCliente;
        String nombre;
        String domicilio;
        String nif;
        String email;
        int cuota;
        int descuento;

        List<Object> parametros = new ArrayList<>();

        System.out.println("Introduzca el tipo de cliente");
        System.out.println("1. Cliente estandard");
        System.out.println("2. Cliente premium");

        //este parámetro será el parametro 0, es un int con tipo de cliente que hemos metido en vista
        tipoDeCliente = getInput(2);
        parametros.add(tipoDeCliente);


        System.out.println("Introduzca el email");
        email = getString();
        parametros.add(email);

        System.out.println("Introduzca el nombre");
        nombre = getString();
        parametros.add(nombre);

        System.out.println("Introduzca el domicilio");
        domicilio = getString();
        parametros.add(domicilio);

        System.out.println("Introduzca el nif");
        nif = getString();
        parametros.add(nif);


        return parametros;

    }

    public String printAgregarEmailCliente(){
        System.out.println("Introduzca el email del cliente a eliminar");
        String emailCliente = getString();
        return emailCliente;

    }



    public void clienteCreado(Boolean creado) {
        if (creado) {
            System.out.println("Se ha creado el cliente");
        } else {
            System.err.println("Ha habido un error al crear el cliente");
        }
    }

    public void clienteEditado(Boolean editado) {
        if (editado) {
            System.out.println("Se ha editado el articulo");
        } else {
            System.err.println("Ha habido un error al editar el articulo");
        }
    }

    public void clienteEliminado(Boolean editado) {
        if (editado) {
            System.out.println("Se ha eliminado el cliente");
        } else {
            System.err.println("Ha habido un error al eliminar el cliente");
        }
    }


    public void printMostrarClientes(List<Cliente> lista) {
        System.out.println("\nLista de clientes");
        System.out.println("---------------------");

        for (Object o : lista) {
            System.out.println(o);
            System.out.println("------------");
        }
    }

    public void printMostrarClientesEstandar(List<Cliente> lista) {
        System.out.println("\nLista de clientes estandar");
        System.out.println("---------------------");

        for (Object o : lista) {
            System.out.println(o);
            System.out.println("------------");
        }
    }

    public void printMostrarClientesPremium(List<Cliente> lista) {
        System.out.println("\nLista de clientes premium");
        System.out.println("---------------------");

        for (Object o : lista) {
            System.out.println(o);
            System.out.println("------------");
        }
    }
    //FIN DE VISTA DE ARTICULOS


    //INICIO DE VISTA DE PEDIDOS

    public int printMenuPedidos() {
        System.out.println("\nSeleccione la acción a realizar");
        System.out.println("0. Volver al menu principal");
        System.out.println("1. Agregar un pedido");
        System.out.println("2. Mostrar pedidos");
        System.out.println("3. Editar un pedido");
        System.out.println("4. Eliminar un pedido");
        System.out.println("5. Mostrar los pedidos pendientes de envio");
        System.out.println("6. Mostrar los pedidos enviados");

        return getInput(6);
    }

    public int printAgregarNumeroPedido(){

            int numeroPedido;

            System.out.println("Introduzca el numero del pedido");
            numeroPedido = getInt();

            return numeroPedido;

    }


    public String printAgregarEmailPedido(){
        System.out.println("\nIntroduce información del pedido: ");
        System.out.println("Introduzca el email del cliente del pedido");
        String emailCliente = getString();
        return emailCliente;

    }

    public String printAgregarArticuloPedido() {
        String codigoArticulo;

        System.out.println("Introduzca el codigo del articulo del pedido");
        codigoArticulo = getString();

        return codigoArticulo;
    }


    public int printAgregarCantidadPedido(){
        System.out.println("Introduzca la cantidad del pedido");
        int cantidad = getInt();
        return cantidad;

    }

    public void pedidoCreado(Boolean creado) {
        if (creado) {
            System.out.println("Se ha creado el pedido");
        } else {
            System.err.println("Ha habido un error al crear el pedido");
        }
    }

    public void pedidoEditado(Boolean editado) {
        if (editado) {
            System.out.println("Se ha editado el pedido");
        } else {
            System.err.println("Ha habido un error al editar el pedido");
        }
    }

    public void pedidoEliminado(Boolean editado) {
        if (editado) {
            System.out.println("Se ha eliminado el pedido");
        } else {
            System.err.println("Ha habido un error al eliminar el pedido");
        }
    }



    public void printMostrarPedidos(List<Pedido> lista) {
        System.out.println("\nLista de clientes");
        System.out.println("---------------------");

        for (Object o : lista) {
            System.out.println(o);
            System.out.println("------------");
        }
    }

    public void printMostrarPedidosPendientes(List<Pedido> lista) {
        System.out.println("\nLista de clientes estandar");
        System.out.println("---------------------");

        for (Object o : lista) {
            System.out.println(o);
            System.out.println("------------");
        }
    }

    public void printMostrarPedidosEnviados(List<Pedido> lista) {
        System.out.println("\nLista de clientes premium");
        System.out.println("---------------------");

        for (Object o : lista) {
            System.out.println(o);
            System.out.println("------------");
        }
    }
    //FIN DE VISTA DE ARTICULOS



    //METODOS PARA RECIBIR DIFERENTES TIPOS DE INPUT
    //Método para recibir el Input del usuario para el menú
    public static int getInput(int max) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > max) {
            try {
                System.out.print("\nIntroduzca la opcion: \n");
                // recibir input en forma de String y parse a int
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            /*printStackTrace() sirve para excepciones
            //además del error, da detalles de en qué linea
            y en qué clase ha ocurrido la excepción*/
            e.printStackTrace();
        }
        return numero;
    }

}
