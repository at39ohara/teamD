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
					<label for="student_num" class="form-label">科目コード</label>
					<p id="subject_code">${code}</p>

					<br> <label for="name">科目名</label> <input type="text"
						class="form-control" id="student_num" name="student_num"
						placeholder="科目名を入力してください" required>
				</form>
				<br>
				<%-- 変更（ボタン） --%>
				<button type="submit" class="btn btn-primary">変更</button>
				<br> <a href="../subjectlist.jsp">戻る</a> <br>
			</form>
		</section>
	</c:param>
</c:import>
