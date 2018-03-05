<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../TopBottom/Top.jsp" %>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">장비에 SW를 등록하세요</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel panel-heading">
					SW는 여러개(checkbox), OS와 Explorer는 한개씩(radio)
				</div>
				<div class="panel panel-body">
				<form action="EquipSwInsert.es" method="post">
					<table class="table table-bordered">
						<tr>
							<td>SW목록</td>
							<td colspan=3>
							<c:set var="count" value="0"></c:set>
							<c:forEach var="s" items="${standardswlist}" varStatus="staus">
								${s.swname }&nbsp <input type="checkbox" name="sw" value="${s.swnumber}"
								<c:if test="${fn:contains(sumSwname,s.swname)}">
								checked
								</c:if>
								> &nbsp
								<c:set var="count" value="${count+1}"></c:set>
								<c:if test="${count==5}">
								<br><c:set var="count" value="0"></c:set>
								</c:if>
							</c:forEach>
							</td>
						</tr>
						<tr>
							<td>OS목록</td>
							<td>
							<c:forEach var="o" items="${oslist}">
								${o.swname }&nbsp <input type="radio" name="os" value="${o.swnumber}"
								<c:if test="${fn:contains(sumSwname,o.swname)}">
								checked
								</c:if>
								> &nbsp
							</c:forEach>	
							</td>
							<td>패치율</td>
							<td>
							<select name="patch_percent" class="form-control">
								<option value="50">50%</option>
								<option value="60">60%</option>
								<option value="70">70%</option>
								<option value="80">80%</option>
								<option value="90">90%</option>
								<option value="100">100%</option>
							</select>
							</td>
						</tr>
						<tr>
							<td>Explorer목록</td>
							<td colspan=3>
							<c:forEach var="e" items="${explorerlist }">
								${e.swversion } &nbsp<input type="radio" name="explorer" value="${e.swnumber}"
								<c:if test="${fn:contains(sumSwname,e.swversion)}">
								checked
								</c:if>
								> &nbsp
							</c:forEach>
							</td>
						</tr>
						<tr>
							<td colspan=4>
								<input type="submit" value="장비에 SW등록하기" class="btn btn-primary">
							</td>
						</tr>
					</table>
					<input type="hidden" name="equipmentid" value="${equipmentid}">
				</form>	
				</div>
			</div>
		</div>
	</div>
equipswinsert 폼입니다.
equipmentid:${equipmentid}
<c:forEach	var="s" items="${standardswlist}">
${s.swname }/
</c:forEach>
<br><br>
<c:forEach	var="o" items="${oslist}">
${o.swname }/
</c:forEach>
<br><br>
<c:forEach	var="e" items="${explorerlist}">
${e.swname }/
</c:forEach>
patch_percent 칼럼 추가할 수 있도록 해야함
</div>

<%@ include file="../TopBottom/Bottom.jsp" %>
