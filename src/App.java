import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import dto.ClienteEstanciaDTO;
import entidades.Casa;
import entidades.Estancia;
import entidades.Familia;
import servicios.CasaServicio;
import servicios.ClienteServicio;
import servicios.EstanciaServicio;
import servicios.FamiliaServicio;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    FamiliaServicio familiaServicio = new FamiliaServicio();
    CasaServicio casaServicio = new CasaServicio();
    ClienteServicio clienteServicio = new ClienteServicio();
    EstanciaServicio estanciaServicio = new EstanciaServicio();

    while (true) {
      System.out.println(
          """
              Menú de opciones:
              1. Buscar y listar familias que tienen al menos 3 hijos, con edad máxima inferior a 10 años
              2. Buscar y listar casas disponibles periodo comprendido entre 01/08/2020 - 31/08/2020 en Reino Unido
              3. Buscar y listar familias cuya dirección de email sea Hotmail
              4. Consultar la BD que devuelva casas disponibles a partir de una fecha dada y un número de día específico
              5. Buscar y listar todos los clientes que en algún momento realizaron una estancia y la descripción de la casa.
              6. Buscar y listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y además la información de la casa que reservó.
              7. Incrementar el precio por día de todas las casas del Reino Unido y mostrar los precios actualizados.
              8. Obtener el número de casas que existen para cada uno de los países.
              9. Buscar y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’.
              10. Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.
              11. Salir
              Ingrese el número de la opción seleccionada:
              """);

      try {
        int opcion = keyboard.nextInt();
        keyboard.nextLine();

        switch (opcion) {
          case 1 -> buscarYListarFamilias(familiaServicio);
          case 2 -> buscarCasasPorPeriodo(casaServicio);
          case 5 -> buscarClienteEstancia(clienteServicio);
          case 10 -> registrarNuevaEstancia(keyboard, estanciaServicio);
          case 11 -> {
            System.out.println("Saliendo del programa...");
            keyboard.close();
            return;
          }
          default -> System.out.println("Ingrese un número válido");
        }

      } catch (InputMismatchException e) {
        System.out.println("Error: Solo se aceptan números.\n\n");
        keyboard.nextLine();
      }
    }
  }

  public static void buscarYListarFamilias(FamiliaServicio familiaServicio) throws Exception {
    try {
      List<Familia> familias = familiaServicio.buscarFamiliasCondiServ();
      
      System.out.println("Lista de familias que cumplen la condición: ");
      for (Familia familia : familias) {
        System.out.println(familia.toString());
        System.out.println();
      }

    } catch (Exception e) {
      System.out.println("Error al obtener las familias: " + e.getMessage());
    }
  }

  public static void buscarCasasPorPeriodo(CasaServicio casaServicio) throws Exception {
    try {
      List<Casa> casas = casaServicio.buscarCasasPorPeriodoServ();

      System.out.println("Lista de casas: ");
      for (Casa casa : casas) {
        System.out.println(casa.toString());
        System.out.println();
      }
    } catch (Exception e) {
      System.out.println("Error al obtener las casas: " + e.getMessage());
    }
  }

  public static void buscarClienteEstancia(ClienteServicio clienteServicio) throws Exception {
    try{
      List<ClienteEstanciaDTO> clienteEstanciaLista = clienteServicio.listarClienteEstanciaServ();
      System.out.println("Lista de clientes y comentarios: ");

      for (ClienteEstanciaDTO clienteEstancia : clienteEstanciaLista) {
        System.out.println(clienteEstancia.toString());
        System.out.println();
      }
    } catch (Exception e) {
      System.out.println("Error al obtener los clientes: " + e.getMessage());

    }
  }

  public static void registrarNuevaEstancia(Scanner keyboard, EstanciaServicio estanciaServicio) {
    try {
      System.out.print("Ingrese ID de cliente: ");
      int idCliente = keyboard.nextInt();
      System.out.print("Ingrese ID de casa: ");
      int idCasa = keyboard.nextInt();
      keyboard.nextLine();
      System.out.println("Ingrese el nombre del huesped: ");
      String nombreHuesped = keyboard.nextLine();

      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

      System.out.print("Ingrese fecha de inicio (YYYY-MM-DD): ");
      java.util.Date utilFechaDesde = dateFormat.parse(keyboard.nextLine());
      System.out.print("Ingrese fecha de fin (YYYY-MM-DD): ");
      java.util.Date utilFechaHasta = dateFormat.parse(keyboard.nextLine());

      // Convertir java.util.Date a java.sql.Date
      Date fechaDesde = new Date(utilFechaDesde.getTime());
      Date fechaHasta = new Date(utilFechaHasta.getTime());

      Estancia estancia = new Estancia();

      estancia.setIdCliente(idCliente);
      estancia.setIdCasa(idCasa);
      estancia.setNombreHuesped(nombreHuesped);
      estancia.setFechaDesde(fechaDesde);
      estancia.setFechaHasta(fechaHasta);

      estanciaServicio.registrarEstanciaServ(estancia);
      System.out.println("Estancia registrada exitosamente.");
    } catch (Exception e) {
      System.out.println("Error al registrar la estancia: " + e.getMessage());
    }
  }
}
