
package cde.persistencia.excel;

import cde.vo.ComponentVo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class Excel {
    
    private String fileName;
    
    public Excel(String fileName){
        this.fileName = fileName;
    }
   
    public boolean createExcelFile(List<ComponentVo> c)throws IOException{
        
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet componentSheet =  wb.createSheet("Components");
       
        String titulo[] = {
            "ID",
            "Nome do componente", 
            "Modelo", 
            "Nº Serial", 
            "Preço"
        };
        
        int rowNum = 0;
        
        Row row = componentSheet.createRow(rowNum);
        for(int i = 0; i < titulo.length; i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(titulo[i]);
        }
        
        rowNum ++;
        
        for(int i = 0; i < c.size(); i++){
            Row r = componentSheet.createRow(rowNum);
            ComponentVo vo = c.get(i);
            Cell cellCompId = r.createCell(0);
            cellCompId.setCellValue(vo.getIdComponent());
            Cell cellCompName = r.createCell(1);
            cellCompName.setCellValue(vo.getName());
            Cell cellCompModel = r.createCell(2);
            cellCompModel.setCellValue(vo.getModel());
            Cell cellCompSn = r.createCell(3);
            cellCompSn.setCellValue(vo.getSerialNumber());
            //Cell cellCompType = r.createCell(cellNum++);
            //cellCompType.setCellValue(c.getType().toString());
            Cell cellCompPrice = r.createCell(4);
            cellCompPrice.setCellValue(vo.getPrice());
            
            rowNum++;
        }
        
        
        try {
            
            FileOutputStream out = new FileOutputStream(new File(this.fileName));
            wb.write(out);
            out.close();
            
            return true;
            
        } catch (FileNotFoundException fnfex){
            fnfex.printStackTrace();
            return false;
        } catch (IOException ioex){
            ioex.printStackTrace();
            return false;
        }
    }
}
