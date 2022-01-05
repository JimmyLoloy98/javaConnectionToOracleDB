package SQL_JAVA;

import java.sql.*;

class ConnectOracle {
    public static void main(String args[]) {
      //System.out.println(conectar());
      try {
            // Load the JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Create a connection
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xepdb1", "hr", "admin");
            // Create a statement for SQL query
            Statement stmt = con.createStatement();
            // Execute the query
            ResultSet rs = stmt.executeQuery("SELECT employee_id, first_name, last_name FROM employees");
            while (rs.next()) {
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
            }
 
            // Close the connection object  
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



/*public static String conectar(){
      try{
        Connection conn = null;
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xepdb1", "hr", "admin");
        if (conn == null) {
          return "No hay conexion";
        } else {
            return "Conectado";
        }
      } catch (SQLException e){
         return ("No se pudo conectar");
      }*/