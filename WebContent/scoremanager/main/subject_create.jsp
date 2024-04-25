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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報登録</h2>

			<form action="StudentCreateExecute.action" method="get">

				<%-- 科目コード --%>
				<label for="student_num" class="form-label">科目コード</label> <input
					type="text" class="form-control" id="student_num"
					name="student_num" placeholder="科目コードを入力してください" required> <br>

					<c:forEach var="subject_cd" items="${subject_cd_set}">
						<%-- 現在のsubject_cdと選択されていたf1が一致していた場合selectedを追記 --%>
						<option value="${subject_cd}"
							<c:if test="${subject_cd==f1}">selected</c:if>>${subject_cd}</option>
					</c:forEach>

				<%-- 科目名 --%>
				<label for="student_num" class="form-label">科目名</label> <input
					type="text" class="form-control" id="student_num"
					name="student_num" placeholder="科目名を入力してください" required> <br>

				<%-- 登録して終了（ボタン） --%>
				<button type="submit" class="btn btn-primary">登録</button>
				<br>
				<%-- 戻る（リンク） --%>
				<%-- .jspで戻っていいんか知らん --%>
				<br> <a href="../subjectlist.jsp">戻る</a> <br>
			</form>
		</section>
	</c:param>


</c:import>