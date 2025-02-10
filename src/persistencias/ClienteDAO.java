package persistencias;

import java.util.ArrayList;
import java.util.List;

import dto.ClienteEstanciaDTO;

public class ClienteDAO extends DAO {
  public List<ClienteEstanciaDTO> buscarTodosClientesEstancia() throws Exception {
    List<ClienteEstanciaDTO> clienteEstanciaLista = new ArrayList<>();
    String sql = "SELECT c.id_cliente, c.nombre, c.email, " +
        "e.id_estancia, " +
        "ca.id_casa, ca.calle, ca.numero, ca.codigo_postal, ca.ciudad, ca.pais, " +
        "com.id_comentario, com.comentario " +
        "FROM clientes c " +
        "JOIN estancias e ON c.id_cliente = e.id_cliente " +
        "JOIN casas ca ON e.id_casa = ca.id_casa " +
        "JOIN comentarios com ON ca.id_casa = com.id_casa;";
    consultarDataBase(sql);
    try {
      ClienteEstanciaDTO clienteEstanciaDTO = null;
      
      while (resultSet.next()) {
        clienteEstanciaDTO = new ClienteEstanciaDTO();
        clienteEstanciaDTO.setIdCliente(resultSet.getInt("id_cliente"));
        clienteEstanciaDTO.setNombre(resultSet.getString("nombre"));
        clienteEstanciaDTO.setEmail(resultSet.getString("email"));
        clienteEstanciaDTO.setIdEstancia(resultSet.getInt("id_estancia"));
        clienteEstanciaDTO.setIdCasa(resultSet.getInt("id_casa"));
        clienteEstanciaDTO.setCalle(resultSet.getString("calle"));
        clienteEstanciaDTO.setNumero(resultSet.getInt("numero"));
        clienteEstanciaDTO.setCodigoPostal(resultSet.getString("codigo_postal"));
        clienteEstanciaDTO.setCiudad(resultSet.getString("ciudad"));
        clienteEstanciaDTO.setPais(resultSet.getString("pais"));
        clienteEstanciaDTO.setIdComentario(resultSet.getInt("id_comentario"));
        clienteEstanciaDTO.setComentario(resultSet.getString("comentario"));
        clienteEstanciaLista.add(clienteEstanciaDTO);
      }

      desconectarDataBase();
      return clienteEstanciaLista;

    } catch (Exception e) {
      e.printStackTrace();
      desconectarDataBase();
      throw e;
    }
  }
}
