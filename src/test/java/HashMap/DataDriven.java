package HashMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getdata(String testcaseName) throws IOException
	{
		ArrayList<String> a=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("https://onedrive.live.com/edit.aspx?resid=DC235CE0713C18BE!105&ithint=file%2cxlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		int sheets=workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++) 
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				
				Iterator<Row> rows=sheet.iterator();
				Row firstrow=rows.next();
				
				Iterator<Cell> ce=firstrow.cellIterator();
				int k=0;
				int column = 0;
				
				while(ce.hasNext())
				{
					Cell value=ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("testcaseName"))
					{
						column=k;
						
						
					}
					k++;
				}
				System.out.println(column);
				
				while(rows.hasNext())
				{
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase"))
					{
						Iterator<Cell> cv=r.cellIterator();
						while (cv.hasNext())
						{
							Cell c=cv.next();
						     if(c.getCellTypeEnum()==CellType.STRING)
						     {
							a.add(cv.next().getStringCellValue());
							
						}
							
						     else
						     {
						      a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						     
						    	
						     }
						
					
					}
					
					
				}
			}
			
		}
		
		
	}
		return a;
	}
}

