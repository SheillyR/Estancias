package persistencias;

import java.util.ArrayList;
import java.util.List;

import entidades.Familia;

public class FamiliaDAO extends DAO {
  public List<Familia> listarFamilias() throws Exception {
    List<Familia> familias = new ArrayList<>();

    String sql = "SELECT id_familia, nombre, edad_minima, edad_maxima, num_hijos, email , id_casa_familia FROM familias";

    try {
      consultarDataBase(sql);

      Familia familia = null;
      while (resultSet.next()) {
        familia = new Familia();
        familia.setIdFamilia(resultSet.getInt("id_familia"));
        familia.setNombre(resultSet.getString("nombre"));
        familia.setEdadMinima(resultSet.getInt("edad_minima"));
        familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
        familia.setNumHijos(resultSet.getInt("num_hijos"));
        familia.setEmail(resultSet.getString("email"));
        familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));
        familias.add(familia);
      }
      desconectarDataBase();
      return familias;
    } catch (Exception e) {
      e.printStackTrace();
      desconectarDataBase();
      throw e;
    }
  }

  public List<Familia> buscarFamiliasCondicion(int num_hijos, int edad_maxima) throws Exception {
    List<Familia> familias = new ArrayList<>();
    String sql = "SELECT * FROM familias WHERE num_hijos >= ? AND edad_maxima < ?";

    try {
      consultaPreparadaDataBase(sql, num_hijos, edad_maxima);
      Familia familia = null;
      
      while (resultSet.next()) {
        familia = new Familia();
        familia.setIdFamilia(resultSet.getInt("id_familia"));
        familia.setNombre(resultSet.getString("nombre"));
        familia.setEdadMinima(resultSet.getInt("edad_minima"));
        familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
        familia.setNumHijos(resultSet.getInt("num_hijos"));
        familia.setEmail(resultSet.getString("email"));
        familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));
        familias.add(familia);
      }
      desconectarDataBase();
      return familias;
    } catch (Exception e) {
      e.printStackTrace();
      desconectarDataBase();
      throw e;
    }
  }
}
