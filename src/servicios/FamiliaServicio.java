package servicios;

import java.util.List;

import entidades.Familia;
import persistencias.FamiliaDAO;

public class FamiliaServicio {
  private FamiliaDAO fd;

  public FamiliaServicio() {
    this.fd = new FamiliaDAO();
  }

  public List<Familia> listarFamiliasServ() throws Exception {
    List <Familia> familias = fd.listarFamilias();

    if (familias == null || familias.isEmpty()) {
      throw new Exception("No se encontraron familias en la base de datos.");
    }

    return familias;
  }

  public List<Familia> buscarFamiliasCondiServ() throws Exception {
    int numHijosMinimos = 3;
    int edadMaximaPermitida = 10;

    List<Familia> familias = fd.buscarFamiliasCondicion(numHijosMinimos, edadMaximaPermitida);

    if (familias == null || familias.isEmpty()) {
        throw new Exception("No se encontraron familias con al menos " + numHijosMinimos + 
                            " hijos y edad máxima menor a " + edadMaximaPermitida + " años.");
    }

    return familias;
  }
}
