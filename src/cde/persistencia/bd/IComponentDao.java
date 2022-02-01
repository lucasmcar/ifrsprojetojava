
package cde.persistencia.bd;

import cde.vo.ComponentVo;
import java.util.List;
import java.sql.SQLException;

public interface IComponentDao {
    
    public boolean salvar(ComponentVo component) throws SQLException;
    public List<ComponentVo> carregarDados();
    
}
