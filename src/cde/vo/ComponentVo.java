package cde.vo;

public class ComponentVo{
    
    private int idComponent;
    private String name;
    private String model;
    private String serialNumber;
    private TypeVo type;
    private String manufacturer;
    private Double price;

    public ComponentVo() {
        type = new TypeVo();
    }
    
    public ComponentVo(int idComponent, String name, String model, String serialNumber, TypeVo type, String manufacturer, Double price) {
        this.idComponent = idComponent;
        this.name = name;
        this.model = model;
        this.serialNumber = serialNumber;
        this.type = type;
        this.manufacturer = manufacturer;
        this.price = price;
    }
    
    public int getIdComponent() {
        return idComponent;
    }

    public void setIdComponent(int idComponent) {
        this.idComponent = idComponent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public void setType(TypeVo type){
        this.type = type;
    }
    
    public TypeVo getType(){
        return type;
    }
    
    /*public void setTypeName(String type){
        this.type.setType(type);
    }
    
    public String getTypeName(){
        return this.type.getType();
    }*/
}
