package persistencias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
  protected Connection conexion = null;
  protected ResultSet resultSet = null;
  protected Statement statement = null;
  protected PreparedStatement preparedStatement = null;

  private final String HOST = "127.0.0.1";
  private final String PORT = "3306"; // por defecto es el puerto que utiliza
  private final String USER = "root"; // usuario de la base de datos
  private final String PASSWORD = "rootroot"; // password de la base de datos
  private final String DATABASE = "estancias_exterior"; // nombre de la base de datos recien creada
  private final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private final String ZONA = "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

  protected void conectarDataBase() throws SQLException, ClassNotFoundException {
    try {
      Class.forName(DRIVER);

      String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false" + ZONA;
      conexion = DriverManager.getConnection(url, USER, PASSWORD);
      System.out.println("Conexión exitosa a la base de datos.\n");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw e;
    }
  }

  protected void desconectarDataBase() throws SQLException, ClassNotFoundException {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (conexion != null) {
        conexion.close();
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw e;
    }
  }

  protected void insertarModificarEliminarDataBase(String sql) throws Exception {
    try {
      conectarDataBase();
      statement = conexion.createStatement();
      statement.executeUpdate(sql);
      System.out.println("Dato OK en BBDD");

    } catch (SQLException | ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
      throw ex;
    } finally {
      desconectarDataBase();
    }
  }

  protected void consultarDataBase(String sql) throws Exception {
    try {
      conectarDataBase();
      statement = conexion.createStatement();
      resultSet = statement.executeQuery(sql);
    } catch (SQLException | ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
      throw ex;
    }
  }

  protected void consultaPreparadaDataBase(String sql, Object... parametros) throws Exception {
    try {
      conectarDataBase();
      preparedStatement = conexion.prepareStatement(sql);
      for (int i = 0; i < parametros.length; i++) {
        preparedStatement.setObject(i + 1, parametros[i]);
      }
      resultSet = preparedStatement.executeQuery();
    } catch (ClassCastException ex) {
      System.out.println(ex.getMessage());
      throw ex;
    }
  }
}