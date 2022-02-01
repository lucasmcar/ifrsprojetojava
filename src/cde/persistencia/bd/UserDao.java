
package cde.persistencia.bd;

import cde.connection.MyConnection;
import cde.vo.ComponentVo;
import cde.vo.UserVo;
import com.mysql.cj.jdbc.ClientPreparedStatement;
import com.mysql.cj.jdbc.result.*;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
    
    Connection conn = null;
    ClientPreparedStatement pstm = null;
    
    public boolean salvar(UserVo user) throws SQLException{
        
        String sql = "INSERT INTO usuario(nome, senha) values (?, ?)";
        
        try{
            conn = MyConnection.getConnection();
            pstm = (ClientPreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, user.getUserName());
            pstm.setString(2, user.getPassword());
            pstm.execute();
            
        }catch(SQLException e){
            e.getMessage();
            return false;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            if(pstm != null && conn != null){
                pstm.close();
                conn.close();
            }
        }
        return true;
    }
    
    public boolean carregaUsuario(UserVo user) throws SQLException{
        
        ResultSetImpl rs = null;
        Connection conn = null;
        ClientPreparedStatement pstm = null;
        
        String sql = "Select usuario, senha FROM usuario"
                + " where usuario = ? AND senha = ?";
        
        try{
            
            conn = MyConnection.getConnection();
            pstm = (ClientPreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, user.getUserName());
            pstm.setString(2, user.getPassword());
            rs = (ResultSetImpl) pstm.executeQuery();
            while(rs.next()){
      
                user.setUserName(rs.getString("usuario"));
                user.setPassword(rs.getString("senha"));
            }
            pstm.execute();
            return true;
          
        }catch(SQLException e){
            e.getMessage();
            return false;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
            
        }finally{
            if(pstm != null && conn != null){
                pstm.close();
                conn.close();
            }
        }
    }
}
