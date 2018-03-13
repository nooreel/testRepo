package nclientInfo.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Paging.NClientInfoByAreaPaging;
import nclientInfo.Model.NclientInfoByAreaBean;
import nclientInfo.Model.NclientInfoByAreaToDepartmentBean;
import nclientInfo.Service.NclientInfoService;

@Controller
public class NclientInfoByAreaToDepartmentViewController {

	@Autowired
	NclientInfoService nclientinfoservice;
	
	@RequestMapping("NclientInfoByAreaToDepartment")
	public void getNclientInfoByAreaToDepartment(
			@RequestParam(value="area_seq",required=false) String area_seq,
			@RequestParam(value="pageNumber",required=false) String textpageNumber,
			HttpServletResponse response
			) {
		
		int totalCount=nclientinfoservice.getAreaToDepartmentTotalCount(area_seq);
		
		NClientInfoByAreaPaging paging=new NClientInfoByAreaPaging(textpageNumber, totalCount, "NclientInfoByAreaToDepartment", null, area_seq);
		
		List<NclientInfoByAreaToDepartmentBean> ablist=nclientinfoservice.getAreaToDepartmentList(paging,area_seq);
		
		response.setContentType("text/html; charset=UTF-8"); 
		try {
			PrintWriter out=response.getWriter();
		
			out.println("<table class='table table-bordered'");
			out.println("<tr>");
				out.println("<td colspan=3>구분</td>");
				out.println("<td colspan=3>자산</td>");
				out.println("<td colspan=3>비자산</td>");
				out.println("<td colspan=3>합계</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>권역</td>");
				out.println("<td>지점</td>");
				out.println("<td>부서</td>");
				out.println("<td>대상</td>");
				out.println("<td>수신</td>");
				out.println("<td>표시율</td>");
				out.println("<td>대상</td>");
				out.println("<td>수신</td>");
				out.println("<td>표시율</td>");
				out.println("<td>대상</td>");
				out.println("<td>수신</td>");
				out.println("<td>표시율</td>");
			out.println("</tr>");
			
			for(int i=0;i<ablist.size();i++) {
				out.println("<tr>");
					out.println("<td>"+ablist.get(i).getAreaname()+"</td>");
					out.println("<td>"+ablist.get(i).getOfficename()+"</td>");
					out.println("<td>"+ablist.get(i).getDepartmentname()+"</td>");
					
					out.println("<td>"+ablist.get(i).getAssetcount()+"</td>");
						out.println("<td>"+ablist.get(i).getAssetrecevingcount()+"</td>");
						double dbAssetRecevingCount=(double)ablist.get(i).getAssetrecevingcount();
						double assetresult=dbAssetRecevingCount/ablist.get(i).getAssetcount()*100;
						if(Double.isNaN(assetresult)) {
							assetresult=0;
						}
					out.println("<td>"+assetresult+"%</td>");
					
					out.println("<td>"+ablist.get(i).getNotassetcount()+"</td>");
						out.println("<td>"+ablist.get(i).getNotassetrecevingcount()+"</td>");
						double dbNotAssetRecevingCount=(double)ablist.get(i).getNotassetrecevingcount();
						double notassetresult=dbNotAssetRecevingCount/ablist.get(i).getNotassetcount()*100;
						if(Double.isNaN(notassetresult)) {
							notassetresult=0;
						}
					out.println("<td>"+notassetresult+"%</td>");
					
					out.println("<td>"+(ablist.get(i).getAssetcount()+ablist.get(i).getNotassetcount())+"</td>");
					out.println("<td>"+(ablist.get(i).getAssetrecevingcount()+ablist.get(i).getNotassetrecevingcount())+"</td>");
						double sumReceving=(double)(ablist.get(i).getAssetrecevingcount()+ablist.get(i).getNotassetrecevingcount());
						System.out.println("sumReceving:"+sumReceving);
						double sumresult=(sumReceving/(ablist.get(i).getAssetcount()+ablist.get(i).getNotassetcount())*100);
						if(Double.isNaN(sumresult)) {
							sumresult=0;
						}
					out.println("<td>"+sumresult+"%</td>");
					out.println("</tr>");
			}
			out.println("<tr>");
				out.println("<td colspan=6>"+paging.getPagingHtml()+"</td>");
				out.println("<td colspan=6>"+paging.getBeginRow()+"-"+paging.getEndRow()+" of "+paging.getTotalCount()+" items"+"</td>");
			out.println("</tr>");
			out.println("</table>");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
