package nclientInfo.Model;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelBuilder extends AbstractExcelView{


	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("엑셀빌더 들어옴");
		List<NclientInfoByAreaBean> list=(List<NclientInfoByAreaBean>) model.get("list");
		
		HSSFSheet sheet=workbook.createSheet("newsheet");
		sheet.setDefaultColumnWidth(30);
		
		CellStyle style=workbook.createCellStyle();
		Font font=workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		
		HSSFRow header=sheet.createRow(0);
		
		header.createCell(0).setCellValue("권역");
		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("자산대상");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("자산수신");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("비자산대상");
		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("비자산수신");
		header.getCell(4).setCellStyle(style);
		
		for(int i=0;i<list.size();i++) {
			int rownum=i+1;
			HSSFRow arow=sheet.createRow(rownum);
			
			arow.createCell(0).setCellValue(list.get(i).getAreaname());
			arow.createCell(1).setCellValue(list.get(i).getAssetcount());
			arow.createCell(2).setCellValue(list.get(i).getAssetrecevingcount());
			arow.createCell(3).setCellValue(list.get(i).getNotassetcount());
			arow.createCell(4).setCellValue(list.get(i).getNotassetrecevingcount());
		}
		
		String filename="ExcelTest.xls";
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		
	}
	
}
