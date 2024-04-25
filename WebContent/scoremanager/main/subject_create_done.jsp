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
			<%-- タイトル --%>
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報登録</h2>

			<%-- メッセージ --%>
			<p>登録が完了しました</p>

			<%-- 戻るリンクと学生一覧に遷移するリンク --%>
			<a href="SubjectList.action">科目一覧</a><br> <a
				href="SubjectCreate.action">戻る</a>

		</section>
	</c:param>
</c:import>