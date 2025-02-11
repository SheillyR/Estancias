package persistencias;

import entidades.Estancia;

public class EstanciaDAO extends DAO {
  public void guardarEstancia(Estancia estancia) throws Exception {
    try {
      // Verificar si existen estancias que se superpongan con las fechas de la nueva
      // estancia
      String sql = "SELECT 1 FROM estancias WHERE id_casa = '" + estancia.getIdCasa()
          + "' AND (fecha_desde <= '" + estancia.getFechaHasta()
          + "' AND fecha_hasta >= '" + estancia.getFechaDesde() + "')";

      consultarDataBase(sql);

      if (resultSet.next()) {
        throw new Exception("La estancia se superpone con una estancia existente");
      }

      // Si no hay conflictos, insertar la nueva estancia
      sql = "INSERT INTO estancias (id_cliente,id_casa,nombre_huesped,fecha_desde,fecha_hasta) VALUES ('"
          + estancia.getIdCliente() + "', '"
          + estancia.getIdCasa() + "', '"
          + estancia.getNombreHuesped() + "', '"
          + estancia.getFechaDesde() + "', '"
          + estancia.getFechaHasta() + "')";
      insertarModificarEliminarDataBase(sql);
    } catch (Exception e) {
      e.printStackTrace();
      desconectarDataBase();
      throw e;
    }
  }
}
