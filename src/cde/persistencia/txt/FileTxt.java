
package cde.persistencia.txt;

import cde.vo.ComponentVo;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class FileTxt extends Thread {
    
    private final String path;
    private ComponentVo vo;
    
    public FileTxt(ComponentVo vo, String path){
        this.path = path;
        this.vo = vo;
    }
    
    public boolean salvarDados(){
        start();
        return true;
    }
    
    @Override
    public void run(){
        try{
            OutputStream os = new FileOutputStream(this.path, true);
            Writer wr = new OutputStreamWriter(os);
            try (PrintWriter pw = new PrintWriter(wr)) {
                pw.print(Integer.toString(vo.getIdComponent())+";");
                pw.print(vo.getName()+";");
                pw.print(vo.getModel()+";");
                pw.print(vo.getSerialNumber()+";");
                pw.print(vo.getType().getType()+";");
                pw.print(vo.getManufacturer()+";");
                pw.print(Double.toString(vo.getPrice())+";");
                
                pw.println();
                pw.flush();
            }
        }catch(Exception ex){
            ex.getMessage();
        }
    }
    
}
