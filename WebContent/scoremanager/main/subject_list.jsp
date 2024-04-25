<%-- 科目一覧JSP --%>
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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目管理</h2>
			<div class="my-2 text-end px-4">
				<a href="StudentCreate.action">新規登録</a>
			</div>
			<!-- 科目登録画面に遷移するリンク -->

			<table>
				<tr>
					<th style="padding-right: 20px;">科目コード</th>
					<!-- 一覧のヘッダ(固定値) -->
					<th>科目名</th>
					<!-- 一覧のヘッダ(固定値) -->
				</tr>
				<!-- ログインユーザの学校コードに紐づく科目情報を一覧表示する -->
				<c:forEach var="subject" items="${subjects}">
					<tr>
						<td>${subject.code}</td>
						<!-- 科目テーブルの「科目コード」カラムの値を表示する -->
						<td>${subject.name}</td>
						<!-- 科目テーブルの「科目名」カラムの値を表示する -->
						<td><a href="SubjectUpdate.action?no=${subject.code}">変更</a></td>
						<!-- 科目変更画面に遷移するリンク -->
						<td><a href="SubjectDelete.action?no=${subject.code}">削除</a></td>
						<!-- 科目削除画面に遷移するリンク -->
					</tr>
				</c:forEach>
			</table>
		</section>
	</c:param>
</c:import>