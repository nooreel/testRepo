package nclientInfo.Controller;

import static org.junit.Assert.assertThat;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nclientInfo.Model.NclientInfoByAreaBean;
import nclientInfo.Service.NclientInfoService;


@Controller
public class NclientInfoDownload {

	@Autowired
	NclientInfoService nclientinfoservice;
	
	@RequestMapping("excelDownload.ni")
	public ModelAndView excelTransForm(HttpServletResponse response) {
		System.out.println("¿¢¼¿ ´Ù¿î·Îµå µé¾î¿È");
		List<NclientInfoByAreaBean> list=nclientinfoservice.exceltest();
		
		ModelAndView mav=new ModelAndView("excelView","list",list);
		
		
		return mav;

		
		
	}




}
