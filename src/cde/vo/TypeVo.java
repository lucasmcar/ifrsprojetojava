
package cde.vo;

import cde.vo.enums.ComponentTypeEnum;

public class TypeVo {
    
    private int cdType;
    private String type;

    public TypeVo() {
    }
    
    public TypeVo(int cdType, String type) {
        this.cdType = cdType;
        this.type = type;
    }

    public int getCdType() {
        return cdType;
    }

    public void setCdType(int cdType) {
        this.cdType = cdType;
    }
   
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Método que retorna um array de dados estaticos caso não tenha conexão
     * @return types 
     */
    public String[] getStaticTypes(){
        
        String[] types = new String[ComponentTypeEnum.values().length];
        for(ComponentTypeEnum typeEnum : ComponentTypeEnum.values()){
            types[typeEnum.ordinal()] = typeEnum.getType();
        }
        return types;
    }
    
    @Override
    public String toString() {
        return this.getType();
    }
}
