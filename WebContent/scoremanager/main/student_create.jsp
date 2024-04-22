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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生情報登録</h2>

			<form action="StudentCreateExecute.action" method="get">

			<%-- 入学年度 --%>
				<label class="form-label" for="student-f1-select">入学年度 </label> <select
					class="form-select " id="student-f1-select" name="f1">
					<option value="0">--------</option>
					<c:forEach var="year" items="${ent_year_set}">
						<%-- 現在のyearと選択されていたf1が一致していた場合selectedを追記 --%>
						<option value="${year}" <c:if test="${year==f1}">selected</c:if>>${year}</option>
					</c:forEach>
				</select>
				<br>
			<%-- 学生番号 --%>
				<label for="student_num" class="form-label">学生番号</label>
				<input type="text" class="form-control" id="student_num" name="student_num" placeholder="学生番号を入力してください" required>
				<br>
			<%-- 氏名 --%>
				<label for="student_name" class="form-label">氏名</label>
				<input type="text" class="form-control" id="student_name" name="student_name" placeholder="氏名を入力してください" required>
				<br>
			<%-- クラス --%>
				<label class="form-label" for="student-f2-select">クラス</label> <select
					class="form-select " id="student-f2-select" name="f2">
					<option value="0">--------</option>
					<c:forEach var="num" items="${class_num_set}">
						<%-- 現在のnumと選択されていたf2が一致していた場合selectedを追記 --%>
						<option value="${num}" <c:if test="${num==f2}">selected</c:if>>${num}</option>
					</c:forEach>
				</select>
				<br>
			<%-- 登録して終了（ボタン） --%>
				<button type="submit" class="btn btn-primary">登録して終了</button>
				<br>
			<%-- 戻る（リンク） --%>
			<%-- .jspで戻っていいんか知らん --%>
				<br>
				<a href="../studentlist.jsp">戻る</a>
				<br>
			</form>
		</section>
	</c:param>

</c:import>