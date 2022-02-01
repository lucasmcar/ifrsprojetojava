
package cde.persistencia.bd;

import cde.connection.MyConnection;
import cde.vo.ComponentVo;
import com.mysql.cj.jdbc.ClientPreparedStatement;
import com.mysql.cj.jdbc.result.*;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ComponentDao implements IComponentDao {
    
    Connection conn = null;
    ClientPreparedStatement pstm = null;
    
    public boolean salvar(ComponentVo component) throws SQLException{
        
        String sql = "INSERT INTO component (cdcomponent, nome, modelo, nrserial, marca, preco, cdtipo) values (?,?,?,?,?,?,?)";
        
        try{
            conn = MyConnection.getConnection();
            pstm = (ClientPreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, component.getIdComponent());
            pstm.setString(2, component.getName());
            pstm.setString(3, component.getModel());
            pstm.setString(4, component.getSerialNumber());
            pstm.setString(5, component.getManufacturer());
            pstm.setDouble(6, component.getPrice());
            pstm.setInt(7, component.getType().getCdType());
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
    
    public List<ComponentVo> carregaDados() throws SQLException{
        
        List<ComponentVo> components = new ArrayList<>();
        
        ResultSetImpl rs = null;
        Connection conn = null;
        ClientPreparedStatement pstm = null;
        
        String sql = "Select cdcomponent, nome, modelo, nrserial, tipo, marca, preco, tipo FROM component c"
                + " INNER JOIN tipo t on c.cdtipo = t.cdtipo";
        
        try{
            conn = MyConnection.getConnection();
            pstm = (ClientPreparedStatement) conn.prepareStatement(sql);
            rs = (ResultSetImpl) pstm.executeQuery();
            while(rs.next()){
                ComponentVo component = new ComponentVo();
               
                component.setName(rs.getString("nome"));
                component.setModel(rs.getString("modelo"));
                component.setSerialNumber(rs.getString("nrserial"));
                component.setManufacturer(rs.getString("marca"));
                component.setPrice(rs.getDouble("preco"));
                components.add(component);
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
        return components;
    }

    @Override
    public List<ComponentVo> carregarDados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
