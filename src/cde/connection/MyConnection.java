package cde.connection;

import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    
    protected static Connection conn = null;
    
    public static Connection getConnection(){
        
        
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_cde?serverTimezone=UTC","root","Lucas1990");
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            e.getMessage();
        }
        return conn;
    }
    
    public boolean hasConnection(){
        if(conn != null){
            return true;
        } else {
            return false;
        }
    }
}
