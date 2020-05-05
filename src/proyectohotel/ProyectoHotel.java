package proyectohotel;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;
import java.util.Scanner;

public class ProyectoHotel {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int opcionMenu = 0;
        int habitacion = 0;
        int opcionMenuHabitacion = 0;
        int opcionReserva = 0;
        int opcionMenuCliente = 0;
        int Nhabitacion = 3;
        int NCliente = 3;
        int cantHabitacion = 0;
        int cantCliente = 0;

        int[] idHabitacion = new int[Nhabitacion];
        String[] tipoHabitacion = new String[Nhabitacion];
        int[] cantidadCama = new int[Nhabitacion];
        int[] habitacionDisponible = new int[Nhabitacion];
        int[] idClienteHabitacion = new int[NCliente];
        int[] cantidadDeDias = new int[Nhabitacion];
        int TipoDeHabitacion = 0;
        int indice = 0;
        int indiceCliente = 0;
        int[] idCliente = new int[NCliente];
        String[] nombreCliente = new String[NCliente];
        String[] CiCliente = new String[NCliente];
        String[] ApellidoCliente = new String[NCliente];
        int[] TelefonoCliente = new int[NCliente];
        String[] EmailCliente = new String[NCliente];
        boolean clientePago = true;
        int intentoComprobarCliente = 0;
        int cantidadDias = 0;
        String PagoTipoHabitacion = "";
        String PagoTipoHabitacionContado = "";
        int total = 0;
        int precioEconomica = 300;
        int precioDeluxe = 600;
        int precioSuit = 1200;
        do {
            System.out.println("");
            System.out.println("Reserva en tu hotel\n1-Habitación\n2-Cliente\n3-Reserva\n4-Forma de pago\n0-Salir");

            System.out.println("Ingrese una opcion");
            opcionMenu = leer.nextInt();

            switch (opcionMenu) {

                case 1:
                    System.out.println("");
                    System.out.println("Habitacion\n1-Registrar\n2-Modificar\n3-Eliminar\n4-Listar todo\n5-Buscar\n0-Volver");
                    do {
                        opcionMenuHabitacion = leer.nextInt();
                        switch (opcionMenuHabitacion) {
                            case 1:
                                System.out.println("-----Registrar------");

                                if (cantHabitacion < Nhabitacion) {
                                    idHabitacion[indice] = ++cantHabitacion;
                                    System.out.println("Tipo de habitacion\n1-Economica\n2-Delux\n3-Suit");
                                    TipoDeHabitacion = leer.nextInt();
                                    switch (TipoDeHabitacion) {

                                        case 1:
                                            tipoHabitacion[indice] = "Economica";
                                            break;
                                        case 2:
                                            tipoHabitacion[indice] = "Delux";
                                            break;
                                        case 3:
                                            tipoHabitacion[indice] = "Suit";
                                            break;
                                        default:
                                            System.out.println("Ingrese una opcion valida!!!");
                                    }
                                    System.out.println("Ingrese cantidad de camas, maximo 4 camas");
                                    cantidadCama[indice] = leer.nextInt();
                                    while (cantidadCama[indice] > 4) {
                                        System.out.println("Ingrese una cantidad valida!!");
                                        cantidadCama[indice] = leer.nextInt();
                                    }
                                    habitacionDisponible[indice] = 0;
                                    indice++;
                                } else {
                                    System.out.println("Ya estan todas las habitaciones registradas");

                                }
                                break;

                            case 2:
                                System.out.println("-----Modificar------");
                                for (int i = 0; i < Nhabitacion; i++) {
                                    if (tipoHabitacion[i] != null) {//cuando la habitacion todavia no se registro no se muestra
                                        System.out.println("Numero habitación " + idHabitacion[i] + " Tipo de habitacion " + tipoHabitacion[i] + " Cantidad de camas " + cantidadCama[i]);
                                    }
                                }

                                System.out.println("ingrese el numero de la habitacion");
                                int modificar = leer.nextInt();
                                while (modificar > Nhabitacion) {
                                    System.out.println("Ingrese un numero valido!!");
                                    modificar = leer.nextInt();
                                }
                                System.out.println("Tipo de habitacion\n1-Economica\n2-Delux\n3-Suit");
                                TipoDeHabitacion = leer.nextInt();
                                switch (TipoDeHabitacion) {

                                    case 1:
                                        tipoHabitacion[modificar - 1] = "Economica";
                                        break;
                                    case 2:
                                        tipoHabitacion[modificar - 1] = "Delux";
                                        break;
                                    case 3:
                                        tipoHabitacion[modificar - 1] = "Suit";
                                        break;
                                    default:
                                        System.out.println("Ingrese una opcion valida!!!");
                                }
                                System.out.println("Ingrese cantidad de camas, maximo 4 camas");
                                cantidadCama[modificar - 1] = leer.nextInt();
                                while (cantidadCama[modificar - 1] > 4) {
                                    System.out.println("Ingrese una cantidad valida!!");
                                    cantidadCama[modificar - 1] = leer.nextInt();
                                }

                                break;
                            case 3:
                                System.out.println("-----Eliminar------");
                                for (int i = 0; i < Nhabitacion; i++) {
                                    if (tipoHabitacion[i] != null) {//cuando la habitacion todavia no se registro no se muestra
                                        System.out.println(" Numero habitación " + idHabitacion[i] + " Tipo de habitacion " + tipoHabitacion[i] + " Cantidad de camas " + cantidadCama[i]);
                                    }
                                }
                                System.out.println("ingrese el numero de la habitacion");
                                int eliminar = leer.nextInt();
                                while (eliminar > Nhabitacion) {
                                    System.out.println("Ingrese un numero valido!!");
                                    eliminar = leer.nextInt();
                                }
                                idHabitacion[eliminar - 1] = 0;
                                tipoHabitacion[eliminar - 1] = null;
                                cantidadCama[eliminar - 1] = 0;
                                indice--;

                                break;
                            case 4:
                                System.out.println("-----Listar todo------");
                                for (int i = 0; i < Nhabitacion; i++) {
                                    if (tipoHabitacion[i] != null) {//cuando la habitacion todavia no se registro no se muestra
                                        System.out.println(" Numero habitación " + idHabitacion[i] + " Tipo de habitacion " + tipoHabitacion[i] + " Cantidad de camas " + cantidadCama[i]);
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("-----buscar------");
                                for (int i = 0; i < Nhabitacion; i++) {
                                    if (tipoHabitacion[i] != null) {//cuando la habitacion todavia no se registro no se muestra
                                        System.out.println(" Numero habitación " + idHabitacion[i] + " Tipo de habitacion " + tipoHabitacion[i] + " Cantidad de camas " + cantidadCama[i]);
                                    }
                                }
                                int buscar = leer.nextInt();
                                while (buscar > Nhabitacion) {
                                    System.out.println("Ingrese un numero valido!!");
                                    buscar = leer.nextInt();
                                }
                                if (idHabitacion[buscar] != 0) {
                                    System.out.println(" Numero habitación " + idHabitacion[buscar] + " Tipo de habitacion " + tipoHabitacion[buscar] + " Cantidad de camas " + cantidadCama[buscar]);

                                } else {
                                    System.out.println("La habitacion no fue ingresada aun");

                                }
                                break;

                            case 0:
                                opcionMenuHabitacion = 0;
                        }

                        break;
                    } while (opcionMenuHabitacion != 0);
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Cliente\n1-Registrar\n2-Modificar\n3-Eliminar\n4-Listar todo\n5-Buscar\n0-Volver");
                    do {
                        opcionMenuCliente = leer.nextInt();
                        switch (opcionMenuCliente) {
                            case 1:
                                System.out.println("1-Registrar");
                                if (NCliente > cantCliente) {
                                    idCliente[indiceCliente] = ++cantCliente;
                                    System.out.println("Ingrese Cedula");
                                    CiCliente[indiceCliente] = leer.next();
                                    System.out.println("Ingrese Nombre");
                                    nombreCliente[indiceCliente] = leer.next();
                                    System.out.println("Ingrese Apellido");
                                    ApellidoCliente[indiceCliente] = leer.next();
                                    System.out.println("Ingrese su Telefono");
                                    TelefonoCliente[indiceCliente] = leer.nextInt();
                                    System.out.println("Ingrese Mail");
                                    EmailCliente[indiceCliente] = leer.next();

                                    indiceCliente++;

                                } else {
                                    System.out.println("Ya estan todos los clientes registrados");
                                }
                                break;
                            case 2:
                                System.out.println("2-Modificar");
                                for (int i = 0; i < idCliente.length; i++) {
                                    if (idCliente[i] != 0) {
                                        System.out.println(" Numero cliente " + idCliente[i] + " Ci " + CiCliente[i] + " Nombre  " + nombreCliente[i] + " Apellido " + ApellidoCliente[i] + " Telefono " + TelefonoCliente[i] + " Email " + EmailCliente[i]);
                                    }
                                }
                                System.out.println("ingrese el numero del cliente");
                                int modificar = leer.nextInt();
                                while (modificar > NCliente) {
                                    System.out.println("Ingrese un numero valido!!");
                                    modificar = leer.nextInt();
                                }

                                System.out.println("Ingrese numero de cliente");
                                int id = leer.nextInt();
                                System.out.println("Ingrese un nuevo numero de CI");
                                CiCliente[id - 1] = leer.next();
                                System.out.println("Ingrese un nuevo nombre");
                                nombreCliente[id - 1] = leer.next();
                                System.out.println("Ingrese un nuevo apellido");
                                ApellidoCliente[id - 1] = leer.next();
                                System.out.println("Ingrese un nuevo telefono");
                                TelefonoCliente[id - 1] = leer.nextInt();
                                System.out.println("Ingrese un nuevo email");
                                EmailCliente[id - 1] = leer.next();

                                break;
                            case 3:
                                System.out.println("3-Eliminar");
                                for (int i = 0; i < idCliente.length; i++) {
                                    if (idCliente[i] != 0) {
                                        System.out.println(" Numero cliente " + idCliente[i] + " Ci " + CiCliente[i] + " Nombre  " + nombreCliente[i] + " Apellido " + ApellidoCliente[i] + " Telefono " + TelefonoCliente[i] + " Email " + EmailCliente[i]);
                                    }
                                }
                                System.out.println("ingrese el numero del cliente");
                                int eliminar = leer.nextInt();
                                while (eliminar > NCliente) {
                                    System.out.println("Ingrese un numero valido!!");
                                    eliminar = leer.nextInt();
                                }

                                CiCliente[eliminar - 1] = null;
                                nombreCliente[eliminar - 1] = null;
                                ApellidoCliente[eliminar - 1] = null;
                                TelefonoCliente[eliminar - 1] = 0;
                                EmailCliente[eliminar - 1] = null;
                                indiceCliente--;
                                break;
                            case 4:
                                System.out.println("4-Listar todo");
                                for (int i = 0; i < idCliente.length; i++) {
                                    if (idCliente[i] != 0) {
                                        System.out.println("Numero cliente " + idCliente[i] + " Ci " + CiCliente[i] + " Nombre  " + nombreCliente[i] + "Apellido " + ApellidoCliente[i] + " Telefono " + TelefonoCliente[i] + " Email " + EmailCliente[i]);
                                    }
                                }
                            case 5:
                                System.out.println("5-Buscar");
                                for (int i = 0; i < NCliente; i++) {
                                    if (CiCliente[i] != null) {//cuando la habitacion todavia no se registro no se muestra
                                        System.out.println("Numero cliente " + idCliente[i] + " Ci " + CiCliente[i] + " Nombre  " + nombreCliente[i] + "Apellido " + ApellidoCliente[i] + " Telefono " + TelefonoCliente[i] + " Email " + EmailCliente[i]);
                                    }
                                }
                                int buscar = leer.nextInt();
                                while (buscar > NCliente) {
                                    System.out.println("Ingrese un numero valido!!");
                                    buscar = leer.nextInt();
                                }
                                if (idCliente[buscar] != 0) {
                                    System.out.println("Numero cliente " + idCliente[buscar] + " Ci " + CiCliente[buscar] + " Nombre  " + nombreCliente[buscar] + "Apellido " + ApellidoCliente[buscar] + " Telefono " + TelefonoCliente[buscar] + " Email " + EmailCliente[buscar]);

                                } else {
                                    System.out.println("El cliente no fue ingresada aun");

                                }
                                break;
                            case 0:
                                System.out.println("0-Volver");
                        }

                        break;
                    } while (opcionMenuCliente != 0);
                    break;
                case 3:

                    do {
                        System.out.println("");
                        System.out.println("Reserva\n1-Reserva\n2-Listar Habitaciones y clientes\n3-Consultar Estado\n0-Volver");
                        opcionReserva = leer.nextInt();
                        switch (opcionReserva) {
                            case 1:
                                System.out.println("Reserva");
                                System.out.println("Lista de habitaciones Disponibles");
                                for (int i = 0; i < Nhabitacion; i++) {
                                    if (habitacionDisponible[i] == 0 && idHabitacion[i] != 0) {//muestro las habitaciones disponibles
                                        System.out.println(" Numero habitación " + idHabitacion[i] + " Tipo de habitacion " + tipoHabitacion[i] + " Cantidad de camas " + cantidadCama[i]);
                                    }
                                }
                                System.out.println("Ingrese la habitacion que desea reservar");
                                int reserva = leer.nextInt();

                                System.out.println("ingrese el cliente que la reserva ");
                                int clienteReserva = leer.nextInt();
                                System.out.println("Cuantos dias quiere reservar ");
                                cantidadDeDias[reserva - 1] = leer.nextInt();

                                habitacionDisponible[reserva - 1] = 1;
                                idClienteHabitacion[reserva - 1] = clienteReserva;

                                break;
                            case 2:
                                System.out.println("Listar Habitaciones y clientes");
                                for (int i = 0; i < Nhabitacion; i++) {
                                    if (idClienteHabitacion[i] != 0) {

                                        System.out.println("El cliente es: " + idClienteHabitacion[i] + " La Hbitacion es : " + idHabitacion[i] + " El tipo de habitacion es: " + tipoHabitacion[i] + " Cantidad de dias reservados: " + cantidadDeDias[i]);
                                    }

                                }

                                break;
                            case 3:
                                System.out.println("Consultar Estado");
                                System.out.println("habitacion disponibles");
                                for (int i = 0; i < Nhabitacion; i++) {
                                    if (habitacionDisponible[i] == 0 && idHabitacion[i] != 0) {//muestro las habitaciones disponibles                                      
                                        System.out.println("Numero habitación " + idHabitacion[i] + " Tipo de habitacion " + tipoHabitacion[i] + " Cantidad de camas " + cantidadCama[i]);
                                    }

                                }
                                System.out.println("habitaciones ocupadas");
                                for (int i = 0; i < Nhabitacion; i++) {
                                    if (habitacionDisponible[i] == 1 && idHabitacion[i] != 0) {//muestro las habitaciones disponibles                                      
                                        System.out.println("Numero habitación " + idHabitacion[i] + " Tipo de habitacion " + tipoHabitacion[i] + " Cantidad de camas " + cantidadCama[i] + "Numero cliente " + idClienteHabitacion[i]);
                                    }

                                }
                                break;
                            case 0:
                                System.out.println("Volver");
                                break;
                        }
                    } while (opcionReserva != 0);
                    break;
                case 4:
                    System.out.println("-----Forma de pago------");
                    System.out.println("");
                    for (int i = 0; i < Nhabitacion; i++) {
                        if (idClienteHabitacion[i] != 0) {

                            System.out.println(" El cliente es: " + idClienteHabitacion[i] + " La Hbitacion es: " + idHabitacion[i] + " El tipo de habitacion es: " + tipoHabitacion[i] + " Cantidad de dias reservados: " + cantidadDeDias[i]);
                        }

                    }
                    System.out.println("Ingrese cliente a pagar");
                    int clienteAPagar = leer.nextInt();
                    while (clienteAPagar > NCliente || idCliente[clienteAPagar - 1] == 0 ) {
                        if (intentoComprobarCliente < 3) {
                            intentoComprobarCliente++;
                            System.out.println("Ingrese un cliente valido!!");
                            clienteAPagar = leer.nextInt();
                        }
                        else
                        {
                            System.out.println("Vuelva a intentarlo mas tarde!!");
                            clientePago = false;
                            break;
                        }
                    }
                    if (clientePago) {
                               System.out.println("Ingrese forma de pago: ");
                    System.out.println("1-Credito");
                    System.out.println("2-Contado");
                    int formaDePago = leer.nextInt();
                    switch (formaDePago) {
                        case 1:

                            System.out.println("Elija cantidad de cuotas de 1 hasta 6 ");
                            int catidadCoutas = leer.nextInt();
                            while (catidadCoutas > 6) {
                                System.out.println("Ingrese una cantidad de cuotas correcta");
                                catidadCoutas = leer.nextInt();
                            }
                            for (int i = 0; i < Nhabitacion; i++) {
                                if (idClienteHabitacion[i] == clienteAPagar) {
                                    cantidadDias = cantidadDeDias[i];
                                    PagoTipoHabitacion = tipoHabitacion[i];
                                }
                            }
                            switch (PagoTipoHabitacion) {
                                case "Economica":
                                    total = cantidadDias * precioEconomica;
                                    System.out.println("El total de su estadia es " + total + "en " + catidadCoutas + "cuotas de " + total / catidadCoutas);
                                    System.out.println("Esperamos que halla disfrutado su estadia...en kalindor");
                                    break;
                                case "Delux":
                                    total = cantidadDias * precioDeluxe;
                                    System.out.println("El total de su estadia es " + total + "en " + catidadCoutas + "cuotas de " + total / catidadCoutas);
                                    System.out.println("Esperamos que halla disfrutado su estadia...en kalindor");
                                    break;
                                case "Suit":
                                    total = cantidadDias * precioSuit;
                                    System.out.println("El total de su estadia es " + total + "en " + catidadCoutas + "cuotas de " + total / catidadCoutas);
                                    System.out.println("Esperamos que halla disfrutado su estadia...en kalindor");
                                    break;
                                default:
                                    System.out.println("no tiene cargos para abonar aun");

                            }

                            break;
                        case 2:
                            for (int i = 0; i < Nhabitacion; i++) {
                                if (idClienteHabitacion[i] == clienteAPagar) {
                                    cantidadDias = cantidadDeDias[i];
                                    PagoTipoHabitacionContado = tipoHabitacion[i];
                                }
                            }
                            System.out.println("contado");
                            switch (PagoTipoHabitacionContado) {
                                case "Economica":
                                    total = cantidadDias * precioEconomica;
                                    System.out.println("El total de su estadia es " + total);
                                    System.out.println("Esperamos que halla disfrutado su estadia...en kalindor");
                                    break;
                                case "Delux":
                                    total = cantidadDias * precioDeluxe;
                                    System.out.println("El total de su estadia es " + total);
                                    System.out.println("Esperamos que halla disfrutado su estadia...en kalindor");
                                    break;
                                case "Suit":
                                    total = cantidadDias * precioSuit;
                                    System.out.println("El total de su estadia es " + total);
                                    System.out.println("Esperamos que disfrute su estadia...en kalindor");
                                    break;
                                default:
                                    System.out.println("no tiene cargos para abonar aun");

                            }
                            break;
                    }
                    }
                    else
                    {
                        
                    }
             
                    break;
                default:
                    System.out.println("Ingrese una opcion valida!!!");
            }

        } while (opcionMenu != 0);

    }

}
