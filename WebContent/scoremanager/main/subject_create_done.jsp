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
			<h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">科目情報登録</h2>

			<%-- メッセージ --%>
			<p class="green-message">登録が完了しました</p>
			<!-- 中央寄せスタイル適用 -->

			<%-- 戻るリンクと学生一覧に遷移するリンク --%>
			<a href="SubjectList.action" style="margin-right: 20px;">科目一覧</a> <a
				href="SubjectCreate.action">戻る</a>


		</section>
	</c:param>
</c:import>