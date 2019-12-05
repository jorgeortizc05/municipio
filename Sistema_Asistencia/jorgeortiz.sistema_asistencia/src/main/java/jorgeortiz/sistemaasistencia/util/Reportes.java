package jorgeortiz.sistemaasistencia.util;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lowagie.text.BadElementException;

import com.lowagie.text.Document;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;

import com.lowagie.text.Image;

import com.lowagie.text.PageSize;

import com.lowagie.text.Paragraph;

import com.lowagie.text.Phrase;

@ManagedBean
@RequestScoped
public class Reportes {

	public void postProcessXLS(Object document) {

		XSSFWorkbook wb = (XSSFWorkbook) document;

		XSSFSheet sheet = wb.getSheetAt(0);

		XSSFRow header = sheet.getRow(0);

		XSSFCellStyle cellStyle = wb.createCellStyle();

		for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {

			XSSFCell cell = header.getCell(i);

			cell.setCellValue(cell.getStringCellValue().toUpperCase());

			cell.setCellStyle(cellStyle);

			sheet.autoSizeColumn(i);

		}

	}

	public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {

		Document pdf = (Document) document;

		pdf.open();

		pdf.setPageSize(PageSize.A4);

		pdf.setPageCount(1000000);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "images"

				+ File.separator + "alcpdf.png";

		pdf.add(Image.getInstance(logo));

		pdf.add(new Paragraph("reporte",

				FontFactory.getFont(FontFactory.HELVETICA, 22, Font.BOLD, new Color(0, 0, 0))));

		SimpleDateFormat formato = new SimpleDateFormat("d MMMM yyyy HH:mm:ss");

		pdf.add(new Phrase("Fecha: " + formato.format(new Date())));

	}

}
