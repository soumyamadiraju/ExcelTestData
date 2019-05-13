package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ExcelUtils(String excelpath) throws IOException {

		try {
			File scr = new File(excelpath);
			//System.out.println("Test File"+scr.canRead());

			FileInputStream fis = new FileInputStream(scr);
			wb = new XSSFWorkbook(fis);

			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public String[][] getDataArray(String sheetName)
	{
		sheet1 = wb.getSheet(sheetName);
		
		int rowCount = sheet1.getLastRowNum();
		int columnCount = 3;
		int ci = 0, ri = 0;
		
		String[][] data = new String[rowCount][columnCount];
		
		for(int i = 0; i < rowCount; i++, ri++)
		{
			ci = 0;
			for(int j = 0; j < columnCount; j++, ci++)
			{
				System.out.println(sheet1.getRow(i).getCell(j).getStringCellValue());
				data[ri][ci] = sheet1.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
}
