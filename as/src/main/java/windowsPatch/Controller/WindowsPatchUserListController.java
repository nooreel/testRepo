package windowsPatch.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Paging.WindowsPatchUserPaging;
import windowsPatch.Model.WindowsPatchUserBean;
import windowsPatch.Service.WindowsPatchService;

@Controller
public class WindowsPatchUserListController {

	@Autowired
	WindowsPatchService windowspatchservice;
	
	@RequestMapping("WindowsPatchUserList.wp")
	public void WindowsPatchUserList(
			@RequestParam(value="swnumber",required=false) String swnumber,
			@RequestParam(value="pageNumber",required=false) String textPageNumber,
			HttpServletResponse response
			) {
		System.out.println("�������");
		int ajaxTotalCount=windowspatchservice.getAjaxTotalCount(swnumber);
		WindowsPatchUserPaging paging=new WindowsPatchUserPaging(textPageNumber, ajaxTotalCount, "WindowsPatchUserList.wp", null, swnumber);
		
		List<WindowsPatchUserBean> windowsuserlist=windowspatchservice.getWindowsPatchUserList(paging,swnumber);
		System.out.println("����Ʈ������:"+windowsuserlist.size());
		
		
		response.setContentType("text/html; charset=UTF-8");
		try {
			PrintWriter out=response.getWriter();
			out.println("<table class='table table-bordered'>");
			out.println("<tr>");
			out.println("<td>�ǿ�</td>");
			out.println("<td>����</td>");
			out.println("<td>�μ�</td>");
			out.println("<td>�����</td>");
			out.println("<td>���ID</td>");
			out.println("<td>IP</td>");
			out.println("<td>������ġ�Ͻ�</td>");
			out.println("<td>��ġ��</td>");
			out.println("</tr>");
			for(int i=0;i<windowsuserlist.size();i++) {
				out.println("<tr>");
				out.println("<td>"+windowsuserlist.get(i).getAreaname()+"</td>");
				out.println("<td>"+windowsuserlist.get(i).getOfficename()+"</td>");
				out.println("<td>"+windowsuserlist.get(i).getDepartmentname()+"</td>");
				out.println("<td>"+windowsuserlist.get(i).getEmployeename()+"</td>");
				out.println("<td>"+windowsuserlist.get(i).getEquipmentid()+"</td>");
				out.println("<td>"+windowsuserlist.get(i).getEquipmentip()+"</td>");
				out.println("<td>"+windowsuserlist.get(i).getModified()+"</td>");
				out.println("<td>"+windowsuserlist.get(i).getPatch_percent()+"%</td>");
				out.println("</tr>");
				
				
			}
			out.println("<tr>");
			out.println("<td colspan=4>"+paging.getPagingHtml()+"</td>");
			out.println("<td colspan=4 style='text-align:right;'></td>");
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
