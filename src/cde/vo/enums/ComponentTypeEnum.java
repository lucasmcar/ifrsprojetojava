package cde.vo.enums;


public enum ComponentTypeEnum {
    
    RAM("Memória Ram"),
    GC("Placa de vídeo"), 
    MB("Placa mãe"),
    PROC("Processador"),
    FONT("Fonte"),
    COOLER("Cooler");
    
    private String componentType;
    
    private ComponentTypeEnum(String componentType){
        this.componentType = componentType;
    }
            
    public String getType()
    {
        return this.componentType;
    }
    
}
