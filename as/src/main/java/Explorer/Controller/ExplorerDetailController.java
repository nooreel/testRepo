package Explorer.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Explorer.Model.ExplorerDetailBean;
import Explorer.Service.ExplorerService;
import Paging.SwAllVersionPaging;

@Controller
public class ExplorerDetailController {

	@Autowired
	ExplorerService ExService;

	@RequestMapping(value = "exDetail.exp")
	public void exdetail(@RequestParam(value = "pageNumber", required = false) String textpageNumber,
			@RequestParam(value = "swnumber") int swnumber, HttpServletResponse response) {
		
		System.out.println("컨트롤러 페이지넘버:"+textpageNumber);
		// ModelAndView mav= new ModelAndView();
		System.out.println("swnumber" + swnumber);
		int totalCount = ExService.ExdetailListCount(swnumber);
		String swnumber2 =Integer.toString(swnumber);
		SwAllVersionPaging paging = new SwAllVersionPaging(textpageNumber, totalCount, "exDetail.exp", null, swnumber2);
		List<ExplorerDetailBean> list = ExService.getDetailList(swnumber,paging);

		/*
		 * mav.addObject("list", list); mav.addObject("pageNumber", textpageNumber);
		 * mav.addObject("totalCount", totalCount); mav.addObject("paginghtml",
		 * paging.getPagingHtml()); mav.addObject("beginrow",paging.getBeginRow());
		 * mav.addObject("endrow",paging.getEndRow()); mav.setViewName("exDetailList");
		 * 
		 */
		response.setContentType("text/html;charset=UTF-8");

		try {

			PrintWriter out = response.getWriter();
			out.println("<table class='table table-bordered table-striped'");
			out.println("<tr>\r\n" + "<td>Explorer </td>\r\n" + "<td>권역 </td>\r\n" + "<td>지점 </td>\r\n"
					+ "<td>부서 </td>\r\n" + "<td>사용자 </td>\r\n" + "<td>장비종류 </td>\r\n" + "<td>장비ID </td>\r\n" + "</tr>");

			for (int i = 0; i < list.size(); i++) {
				out.println("<tr>");
				out.println("<td>" + list.get(i).swversion + "</td>");
				out.println("<td>" + list.get(i).areaname + "</td>");
				out.println("<td>" + list.get(i).officename + "</td>");
				out.println("<td>" + list.get(i).departmentname + "</td>");
				out.println("<td>" + list.get(i).employeename + "</td>");
				out.println("<td>" + list.get(i).equipmenttype + "</td>");
				out.println("<td>" + list.get(i).equipmentid + "</td>");
				out.println("</tr>");

			}

			out.println("<tr>");
			out.println("<td colspan=4>" + paging.getPagingHtml() + "</td>");
			out.println("<td colspan=3 align='right'>" + paging.getBeginRow() + "-" + paging.getEndRow() + " of "
					+ paging.getTotalCount() + " items" + "</td>");
			out.println("</tr>");
			out.println("</table>");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
