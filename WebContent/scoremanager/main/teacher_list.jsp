<%-- 教師一覧JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- taglibディレクティブの記述 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">得点管理システム</c:param>
	<c:param name="scripts"></c:param>
	<c:param name="content">
		<section class="me-4">
			<h2 class="h2 fw-normal bg-secondary bg-opacity-10 py-2 px-4 mb-0">教員一覧</h2>
			<table class="table table-hover">
				<tr>
					<th>学校コード</th>
					<th>氏名</th>
				</tr>
				<c:choose>
					<%-- teachersが空でない場合は教員リストを表示 --%>
					<c:when test="${not empty teachers}">
						<c:forEach var="teacher" items="${teachers}">
							<tr>
								<td>${teacher.school.cd}</td>

								<td><c:if test="${not empty teacher.name}">${teacher.name}</c:if></td>
							</tr>
						</c:forEach>
					</c:when>
					<%-- teachersが空の場合はメッセージを表示 --%>
					<c:otherwise>
						<tr>
							<td colspan="2">教員が見つかりません。</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</section>
	</c:param>
</c:import>