package servicios;

import entidades.Estancia;
import persistencias.EstanciaDAO;

public class EstanciaServicio {
  private EstanciaDAO ed;

  public EstanciaServicio() {
    this.ed = new EstanciaDAO();
  }

  public void registrarEstanciaServ(Estancia estancia) throws Exception {
    if (estancia == null) {
      throw new IllegalArgumentException("La estancia no puede ser nula");
    }
    ed.guardarEstancia(estancia);
  }
}
