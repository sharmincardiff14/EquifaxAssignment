package Framework;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataProvider {
	
	
	protected static String project_path = System.getProperty("user.dir").replace("\\","/") + "/src/TestData/";
	
	
	@SuppressWarnings("rawtypes")
	public static String getData(List sheetData,String Column,Integer Row){
		 Integer colno=-1;
		 List row1 = (List) sheetData.get(0); 
		 for(int i=0;i<row1.size();i++){			 
			 if(row1.get(i).toString().equals(Column))
				 colno = i;			 
		 }
		 
		 if(colno==-1)
			 System.out.println("Issue while accessing Excel Data - Column name incorrect");
		 		 
		  List listrow = (List) sheetData.get(Row);
		  String data = listrow.get(colno).toString();		 
	  return data;
	 }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List readExcelFile(String filename) throws Exception {   
		
    		List sheetData = new ArrayList();	    

		    String inputFile = project_path + filename;
		    
		    File inputWorkbook = new File(inputFile);
		    Workbook w;
		    try {
		      w = Workbook.getWorkbook(inputWorkbook);
		      Sheet sheet = w.getSheet(0);
		      for (int i = 0; i < sheet.getRows(); i++) {
		    	  List data = new ArrayList();
		        for (int j = 0; j < sheet.getColumns(); j++) {
		       	Cell cell = sheet.getCell(j,i);
		          if(cell.getContents()!=null)
		        	data.add(cell.getContents().toString());
		          else
		        	  data.add("");		       
		          }
		        sheetData.add(data);
		      }		      
		    } catch (BiffException e) {
		      e.printStackTrace();
		    }		    
		    return sheetData;		   
		}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getExcel(String filename,String Sheetname) throws Exception {   
		
    		List sheetData = new ArrayList();	
		    String inputFile = project_path + filename;
		    
		    File inputWorkbook = new File(inputFile);
		    Workbook w;
		    try {
		      w = Workbook.getWorkbook(inputWorkbook);
		      Sheet sheet = w.getSheet(Sheetname);
		      for (int i = 0; i < sheet.getRows(); i++) {
		    	  List data = new ArrayList();
		        for (int j = 0; j < sheet.getColumns(); j++) {
		       	Cell cell = sheet.getCell(j,i);
		          if(cell.getContents()!=null)
		        	data.add(cell.getContents().toString());
		          else
		        	  data.add("");		       
		          }
		        sheetData.add(data);
		      }		      
		    } catch (BiffException e) {
		      e.printStackTrace();
		    }		    
		    return sheetData;		   
		}
	
	
}

