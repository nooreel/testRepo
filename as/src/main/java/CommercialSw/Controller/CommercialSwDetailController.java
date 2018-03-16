package CommercialSw.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import CommercialSw.Model.CommercialSwDetailBean;
import CommercialSw.Service.CommercialSwDetailService;
import CommercialSw.Service.CommercialSwService;
import Paging.CommercialSwDetailPaging;

@Controller
public class CommercialSwDetailController {

	@Autowired
	CommercialSwService commercialSwService;
	
/*	@RequestMapping("cswDetailList.csw")
	public void cswDetailList(
			@RequestParam(value="swname",required=false) String swname,
			@RequestParam(value="pageNumber",required=false) String textpageNumber,
			HttpServletResponse response
			) {
		
		int totalCount=commercialSwService.cswGetDetailTotal(swname);
		
		CommercialSwDetailPaging paging=new CommercialSwDetailPaging(textpageNumber, totalCount, "cswDetailList.csw", null, swname);
		
		List<CommercialSwDetailBean> cswDetaillist=commercialSwService.cswGetDetailList(paging,swname);
		
		response.setContentType("text/html; charset=UTF-8"); 
		try {
			PrintWriter out=response.getWriter();
		
			out.println("<table class='table table-bordered'");
			
			out.println("<tr>");
				out.println("<td>기관명</td>");
				out.println("<td>조직경로명</td>");
				out.println("<td>사번</td>");
				out.println("<td>사용자</td>");
				out.println("<td>직위</td>");
				out.println("<td>설치일자</td>");
				out.println("<td>장비ID</td>");
				out.println("<td>로컬IP</td>");
			out.println("</tr>");
			
			for(int i=0;i<cswDetaillist.size();i++) {

				out.println("<tr>");
					out.println("<td>"+cswDetaillist.get(i).getOrg()+"</td>");
					out.println("<td>"+cswDetaillist.get(i).getAreaname()+"/"+cswDetaillist.get(i).getOfficename()+"/"+cswDetaillist.get(i).getDepartmentname()+"</td>");
					out.println("<td>"+cswDetaillist.get(i).getEmployeenumber()+"</td>");
					out.println("<td>"+cswDetaillist.get(i).getEmployeename()+"</td>");
					out.println("<td>"+cswDetaillist.get(i).getEmployeeposition()+"</td>");
					out.println("<td>"+cswDetaillist.get(i).getCreated()+"</td>");
					out.println("<td>"+cswDetaillist.get(i).getEquipmentID()+"</td>");
					out.println("<td>"+cswDetaillist.get(i).getEquipmentIP()+"</td>");
			}
			out.println("</table>");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	@ResponseBody
	@RequestMapping("cswDetailJson.csw")
	public Map<String, Object> jsontest(
			@RequestParam(value="swname",required=false) String swname,
			@RequestParam(value="pageNumber",required=false) String textpageNumber){
		System.out.println("detailtotal-csw");
		int totalCount=commercialSwService.cswGetDetailTotal(swname);
		
		System.out.println("swname:"+swname);
		System.out.println("pageNumber:"+textpageNumber);
		
		
		CommercialSwDetailPaging paging=new CommercialSwDetailPaging(textpageNumber, totalCount, "cswDetailList.csw", null, swname);
		
		List<CommercialSwDetailBean> cswlist=commercialSwService.cswGetDetailList(paging,swname);
		
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("cswlist", cswlist);
		map.put("paging", paging);
		
		
		return map;
	}
	
}
