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

			<form action="SubjectUpdateExecute.action" method="post">
				<label for="subject_cd">科目コード</label> <input type="text"
					class="form-control" id="subject_cd" name="subject_cd"
					value="${subject_cd}" readonly style="border: none;"> <br>
				<label for="subject_name">科目名</label> <input type="text"
					class="form-control" id="subject_name" name="subject_name"
					placeholder="科目名を入力してください" required> <br>
				<button type="submit" class="btn btn-primary">変更</button>
				<br> <a href="SubjectList.action">戻る</a> <br>
			</form>
		</section>
	</c:param>
</c:import>