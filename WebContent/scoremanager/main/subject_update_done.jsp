<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
	<style>
.green-message {
	background-color: #c8e6c9; /* より薄い緑色 */
	color: black; /* 文字色 */
	padding: 10px; /* パディング */
	border-radius: 5px; /* 角の丸み */
	text-align: center; /* テキストを中央寄せ */
}
</style>
		<section class="me-4">
			<%-- タイトル --%>
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報変更</h2>

			<%-- メッセージ --%>
			<p class="green-message">変更が完了しました</p>

			<br> <br> <br>

			<%-- 科目一覧に遷移するリンク --%>

			<a href="SubjectList.action">科目一覧</a>


		</section>
	</c:param>
</c:import>