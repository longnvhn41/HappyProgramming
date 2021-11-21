
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBContext {
    
    private static final String URL = "jdbc:mysql://localhost:3306/happyprogramming?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    
    public  Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc.Driver
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException ex) {
            System.err.println("FAIL at ClassNotFoundException");
        } catch (SQLException ex) {
            System.err.println("FAIL at SQLException" + ex);
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        try{
            System.out.println(new DBContext().getConnection());
        }catch (Exception e){
            System.err.println("conntion Fail");
        }
    }
}
