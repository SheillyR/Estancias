package persistencias;

import java.util.ArrayList;
import java.util.List;

import entidades.Casa;

public class CasaDAO extends DAO {
  public List<Casa> listarCasas() throws Exception {
    try {
      String sql = "SELECT * FROM casas";
      consultarDataBase(sql);

      Casa casa = null;
      List<Casa> casas = new ArrayList<>();

      while(resultSet.next()) {
        casa = new Casa();
        casa.setIdCasa(resultSet.getInt("id_casa"));
        casa.setCalle(resultSet.getString("calle"));
        casa.setNumero(resultSet.getInt("numero"));
        casa.setCodigoPostal(resultSet.getString("codigo_postal"));
        casa.setCiudad(resultSet.getString("ciudad"));
        casa.setPais(resultSet.getString("pais"));
        casa.setFechaDesde(resultSet.getDate("fecha_desde"));
        casa.setFechaHasta(resultSet.getDate("fecha_hasta"));
        casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
        casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
        casa.setPrecioHabitacion(resultSet.getDouble("precio_habitacion"));
        casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));
        casas.add(casa);
      }

      desconectarDataBase();
      return casas;
    } catch (Exception e) {
      e.printStackTrace();
      desconectarDataBase();
      throw e;
    }
  }

  public List<Casa> listarCasasPorPeriodo(String pais, String fecha_desde, String fecha_hasta) throws Exception {
    List<Casa> casas = new ArrayList<>();
    String sql = "SELECT * FROM casas WHERE pais = ? AND fecha_desde <= ? AND fecha_hasta >= ?";
    
    try {
      consultaPreparadaDataBase(sql, pais, fecha_desde, fecha_hasta);
      Casa casa = null;

      while(resultSet.next()) {
        casa = new Casa();
        casa.setIdCasa(resultSet.getInt("id_casa"));
        casa.setCalle(resultSet.getString("calle"));
        casa.setNumero(resultSet.getInt("numero"));
        casa.setCodigoPostal(resultSet.getString("codigo_postal"));
        casa.setCiudad(resultSet.getString("ciudad"));
        casa.setPais(resultSet.getString("pais"));
        casa.setFechaDesde(resultSet.getDate("fecha_desde"));
        casa.setFechaHasta(resultSet.getDate("fecha_hasta"));
        casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
        casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
        casa.setPrecioHabitacion(resultSet.getDouble("precio_habitacion"));
        casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));
        casas.add(casa);
      }
      desconectarDataBase();
      return casas;
    } catch (Exception e) {
      e.printStackTrace();
      desconectarDataBase();
      throw e;
    }
  }
}
