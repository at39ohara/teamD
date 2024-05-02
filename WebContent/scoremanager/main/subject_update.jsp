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

			<form action="SubjectUpdateExecute.action" method="post"
				onsubmit="return vaildataForm()">
				<div class="form-group" style="border: none">
					<label for="cd">科目コード</label> <input type="text"
						class="form-control" id="subject_cd" name="subject_cd"
						value="${subject.cd}" readonly style="border: none;">
				</div>

				<div class="form-group">
					<label for="name">科目名</label> <input type="text"
						class="form-control" id="subject_name" name="subject_name"
						value="${subject.name}" required>
				</div>
			</form>
			<br>
			<%-- 変更（ボタン） --%>
			<button type="submit" class="btn btn-primary">変更</button>
			<br> <a href="SubjectList.action">戻る</a> <br>
		</section>
	</c:param>
</c:import>