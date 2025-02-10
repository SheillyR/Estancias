package dto;

public class ClienteEstanciaDTO {
  private int idCliente;
  private String nombre;
  private String email;
  private int idEstancia;
  private int idCasa;
  private String calle;
  private int numero;
  private String codigoPostal;
  private String ciudad;
  private String pais;
  private int idComentario;
  private String comentario;

  public ClienteEstanciaDTO() {
  }

  public ClienteEstanciaDTO(int idCliente, String nombre, String email, int idEstancia, int idCasa, String calle,
      int numero, String codigoPostal, String ciudad, String pais, String comentario) {
    this.idCliente = idCliente;
    this.nombre = nombre;
    this.email = email;
    this.idEstancia = idEstancia;
    this.idCasa = idCasa;
    this.calle = calle;
    this.numero = numero;
    this.codigoPostal = codigoPostal;
    this.ciudad = ciudad;
    this.pais = pais;
    this.comentario = comentario;
  }

  public int getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getIdEstancia() {
    return idEstancia;
  }

  public void setIdEstancia(int idEstancia) {
    this.idEstancia = idEstancia;
  }

  public int getIdCasa() {
    return idCasa;
  }

  public void setIdCasa(int idCasa) {
    this.idCasa = idCasa;
  }

  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getCodigoPostal() {
    return codigoPostal;
  }

  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public int getIdComentario() {
    return idComentario;
  }

  public void setIdComentario(int idComentario) {
    this.idComentario = idComentario;
  }

  @Override
  public String toString() {
    return "ClienteEstancia [idCliente=" + idCliente + ", nombre=" + nombre + ", email=" + email + ", idEstancia="
        + idEstancia + ", idCasa=" + idCasa + ", calle=" + calle + ", numero=" + numero + ", codigoPostal="
        + codigoPostal + ", ciudad=" + ciudad + ", pais=" + pais + ", idComentario=" + idComentario + ", comentario="
        + comentario + "]";
  }
}
