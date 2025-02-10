package servicios;

import java.util.List;

import dto.ClienteEstanciaDTO;
import persistencias.ClienteDAO;

public class ClienteServicio {
  private ClienteDAO cd;

  public ClienteServicio() {
    this.cd = new ClienteDAO();
  }

  public List<ClienteEstanciaDTO> listarClienteEstanciaServ() throws Exception {
    List<ClienteEstanciaDTO> clienteEstanciaLista = cd.buscarTodosClientesEstancia();


    if (clienteEstanciaLista == null || clienteEstanciaLista.isEmpty()) {
      throw new Exception("No se encontraron familias en la base de datos.");
    }

    return clienteEstanciaLista;
  }
}
