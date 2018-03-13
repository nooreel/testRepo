package stswtb.Controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSpinnerUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Paging.SwAllVersionPaging;
import stswtb.Model.SwVersionManagementBean;
import stswtb.Service.StswtbService;

@Controller
public class SwAllVersionViewController {

	@Autowired
	StswtbService stswtbservice;
	
	@RequestMapping(value="GetSwAllVersion.stswtb")
	public void GetSwAllVersion(@RequestParam(value="swname") String swname
			, HttpServletResponse response
			,@RequestParam(value="pageNumber",required=false) String textpageNumber) {
		
		
		System.out.println("들어온 swname:"+swname);
		System.out.println("들어온  pageNumber:"+textpageNumber);
		
		Map<String, String> map=new HashMap<String,String>();
		map.put("swname", swname);
		
		
		int totalCount=stswtbservice.getTotalCountFromSwAllVersion(map);
		
		SwAllVersionPaging paging=new SwAllVersionPaging(textpageNumber, totalCount, "GetSwAllVersion.stswtb", null,swname);
		
		List<SwVersionManagementBean> swalist=stswtbservice.getSwAllVersion(paging,map);
		
		response.setContentType("text/html;charset=UTF-8"); 
		
		try {
			PrintWriter out=response.getWriter();
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr>\r\n" + 
				"			<td rowspan=2>S/W명</td>\r\n" + 
				"			<td rowspan=2>BIT</td>\r\n" + 
				"			<td rowspan=2>버전</td>\r\n" + 
				"			<td colspan=2>자산</td>\r\n" + 
				"			<td colspan=2>비자산</td>\r\n" + 
				"		</tr>");	
		out.println("<tr>\r\n" + 
				"			<td>설치</td>\r\n" + 
				"			<td>율</td>\r\n" + 
				"			<td>설치</td>\r\n" + 
				"			<td>율</td>\r\n" + 
				"		</tr>");	
		for(int i=0;i<swalist.size();i++) {
			out.println("<tr>");
			out.println("<td>"+swalist.get(i).getSwname()+"</td>");
			out.println("<td>"+swalist.get(i).getBit()+"</td>");
			out.println("<td>"+swalist.get(i).getSwversion()+"</td>");
			out.println("<td>"+swalist.get(i).getAssetsetupcount()+"</td>");
			double doubleassetsetupcount=swalist.get(i).getAssetsetupcount();
			out.println("<td>"+
					String.format("%.2f", doubleassetsetupcount/swalist.get(i).getAssetdaesang()*100)
					+"%</td>");
			out.println("<td>"+swalist.get(i).getNotassetsetupcount()+"</td>");
			double doublenotassetsetupcount=swalist.get(i).getNotassetsetupcount();
			out.println("<td>"+
			String.format("%.2f", doublenotassetsetupcount/swalist.get(i).getNotassetdaesang()*100)
					+"%</td>");
			out.println("</tr>");
			
		}
		out.println("<tr>");
		out.println("<td colspan=4>"+paging.getPagingHtml()+"</td>");
		out.println("<td colspan=3 align='right'>"+paging.getBeginRow()+"-"+paging.getEndRow()+" of "+paging.getTotalCount()+" items"
			+"</td>");
		out.println("</tr>");
		out.println("</table>");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
