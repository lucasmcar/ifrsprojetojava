
package cde.persistencia.bd;

import cde.connection.MyConnection;
import cde.vo.TypeVo;
import com.mysql.cj.jdbc.ClientPreparedStatement;
import com.mysql.cj.jdbc.result.*;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDao {
    
    Connection conn = null;
    ClientPreparedStatement pstm = null;
    ResultSetImpl rs;
    
    public List<TypeVo> carregaDados() throws SQLException{
        
        List<TypeVo> types = new ArrayList<>();
        
        String sql = "Select cdtipo, tipo FROM tipo ORDER BY tipo";
        
        try{
            conn = MyConnection.getConnection();
            pstm = (ClientPreparedStatement) conn.prepareStatement(sql);
            rs = (ResultSetImpl) pstm.executeQuery();
            while(rs.next()){
                TypeVo type = new TypeVo();
               
                type.setCdType(rs.getInt("cdtipo"));
                type.setType(rs.getString("tipo"));
                
                types.add(type);
            }
            pstm.execute();
            
        }catch(SQLException e){
            e.getMessage();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            if(pstm != null && conn != null){
                pstm.close();
                conn.close();
            }
        }
        return types;
    }
}
