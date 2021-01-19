package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import controllers.ConstantUI;
import models.entities.DensityDataPeriod;
import models.entities.Person;

public class ExccelManager {

	private static String pathFile = "";

	
	public static void write(ArrayList<Person> personsDistance, ArrayList<Person> personsVolumen, ArrayList<DensityDataPeriod> personsDensity) throws IOException{
		String hojaDistance = ConstantUI.NAME_WINDOW_DISTANCE;
		String hojaVolumen = ConstantUI.NAME_WINDOW_VOlUMEN;
		String hojaDensity = ConstantUI.NAME_WINDOW_DENSITY;
		
		XSSFWorkbook libro= new XSSFWorkbook();
		XSSFSheet hojaXlsxDistance = libro.createSheet(hojaDistance);
		XSSFSheet hojaXlsxVolumen = libro.createSheet(hojaVolumen);
		XSSFSheet hojaXlsxDensity = libro.createSheet(hojaDensity);
		
		CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);
        
        
		generateCellsDistance(personsDistance, hojaXlsxDistance, style);
		generateCellsVolumen(personsVolumen, hojaXlsxVolumen, style);
		generateCellsDensity(personsDensity, hojaXlsxDensity, style);
		
		writeFile(libro);

	}

	public static void writeFile(XSSFWorkbook libro) {
		File file;
		file = new File(pathFile);
		try (FileOutputStream fileOuS = new FileOutputStream(file)){						
			if (file.exists()) {
				file.delete();
			}
			libro.write(fileOuS);
			fileOuS.flush();
			fileOuS.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void generateCellsDistance(ArrayList<Person> persons, XSSFSheet hoja1, CellStyle style) {
		for (int i = 0; i <= persons.size(); i++) {
			XSSFRow row = hoja1.createRow(i);
			for (int j = 0; j < ConstantUI.COLUMS_EXCELL.length; j++) {
				if (i==0) {
						XSSFCell cell= row.createCell(j);
						cell.setCellStyle(style); 
						cell.setCellValue(ConstantUI.COLUMS_EXCELL[j]);					
				}else{
					XSSFCell cell= row.createCell(j);
					cell.setCellValue(String.valueOf(persons.get(i-1).toObjectVectorDistance()[j]));
				}				
			}
		}
	}
	
	public static void generateCellsVolumen(ArrayList<Person> persons, XSSFSheet hoja1, CellStyle style) {
		for (int i = 0; i <= persons.size(); i++) {
			XSSFRow row = hoja1.createRow(i);
			for (int j = 0; j < ConstantUI.COLUMS_EXCELL_VOLUMEN.length; j++) {
				if (i==0) {
						XSSFCell cell= row.createCell(j);
						cell.setCellStyle(style); 
						cell.setCellValue(ConstantUI.COLUMS_EXCELL_VOLUMEN[j]);					
				}else{
					XSSFCell cell= row.createCell(j);
					cell.setCellValue(String.valueOf(persons.get(i-1).toObjectVectorVolumen()[j]));
				}				
			}
		}
	}
	
	public static void generateCellsDensity(ArrayList<DensityDataPeriod> persons, XSSFSheet hoja1, CellStyle style) {
		int controlNumberFormat = 0;
		for (DensityDataPeriod data : persons) {
			String[] firstColum = new String[]{"hora", "Parte 1", "", "Parte 2", "", "Parte 3", ""};
			for (int i = 0; i <= data.getNumbers().size() -32; i++) {
				XSSFRow row = hoja1.createRow(i+controlNumberFormat);
				for (int j = 0; j < firstColum.length; j++) {
					if (i==0) {
						XSSFCell cell= row.createCell(j);
						cell.setCellStyle(style); 
						cell.setCellValue(firstColum[j]);					
					}else{
						XSSFCell cell= row.createCell(j);
						cell.setCellValue(String.valueOf(new Object[] {data.getHour(),
								ConstantUI.VECTOR_ALL_TYPES_PERSONS_TX_FIELDS[(i)-1], data.getNumbers().get((i)-1),
								ConstantUI.VECTOR_ALL_TYPES_PERSONS_TX_FIELDS[(i)-1], data.getNumbers().get(((i)-1)+16),
								ConstantUI.VECTOR_ALL_TYPES_PERSONS_TX_FIELDS[(i)-1], data.getNumbers().get(((i)-1)+32)}[j]));
					}				
				}
			}
			controlNumberFormat += 14;
		}
	}
	
	public static void setPath(String path) {
		if (!pathFile.contains(".xlsx")) {
			pathFile = path + ".xlsx";
		}else {
			pathFile = path;
		}
	}	
	
	public static String getPathFile() {
		return pathFile;
	}
}