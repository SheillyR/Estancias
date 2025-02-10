package servicios;

import java.util.List;

import entidades.Casa;
import persistencias.CasaDAO;

public class CasaServicio { 
  private CasaDAO cd;

  public CasaServicio() {
    this.cd = new CasaDAO();
  }

  public List<Casa> listarCasasServ() throws Exception {
    List<Casa> casas = cd.listarCasas();

    if (casas == null || casas.isEmpty()) {
      throw new Exception("No existen casas en la base de datos.");
    }

    return casas;
  }

  public List<Casa> buscarCasasPorPeriodoServ() throws Exception {
    String pais = "Reino Unido";
    String fecha_desde = "2020-08-01";
    String fecha_hasta = "2020-08-31"; 

    List<Casa> casas = cd.listarCasasPorPeriodo(pais, fecha_desde, fecha_hasta);

    if(casas == null || casas.isEmpty()) {
      throw new Exception("No se encontraron casas en " + pais + 
      " en el perido del " + fecha_desde + " y " + fecha_hasta);
    }

    return casas;
  }
}
