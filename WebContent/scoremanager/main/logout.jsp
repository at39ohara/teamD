<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">得点管理システム</c:param>
	<c:param name="scripts">
	</c:param>
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

		<div class="row border mx-3 mb-3 py-2 align-items-center rounded"
			id="fillter">
			<h2 class="h2 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4"
				style="text-align: center;">ログアウト</h2>
			<p class="green-message">ログアウトしました</p>

			<br> <br> <br>

			<a href="../Login.action">ログイン</a>
		</div>
	</c:param>
</c:import>