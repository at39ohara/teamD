<%-- 科目情報削除JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title" value="得点管理システム - 科目情報削除" />
	<c:param name="scripts"></c:param>
	<c:param name="content">
		<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報削除</h2>
		<form action="StudentDeleteExecute.action" method="post"
			onsubmit="return confirm('本当に削除してもよろしいですか');">
			<p><label for="confirmation_message">を削除してもよろしいですか</label></p>
			<button type="submit" class="btn btn-danger">削除</button><br><br>
			<br> <a href="../studentlist.jsp">戻る</a> <br>
		</form>
	</c:param>
</c:import>