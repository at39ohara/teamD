<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="me-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報変更</h2>

			<form action="StudentCreateExecute.action" method="get">

				<form action="SubjectUpdate" method="post">
					<label for="code">科目コード:</label> <input type="text" id="code"
						name="code" value="${code}" readonly><br> <label
						for="name">氏名:</label> <input type="text" id="name" name="name"
						value="${name}" maxlength="20" required><br> <input
						type="submit" value="変更">
				</form>
				<br> <a href="../studentlist.jsp">戻る</a> <br>
			</form>
		</section>
	</c:param>
</c:import>
