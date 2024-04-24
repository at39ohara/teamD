<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title" value="削除完了ページ" />
	<c:param name="content">
		<h2>削除完了</h2>
		<p>削除が完了しました。</p>
		<a href="SubjectList.action" class="btn">科目一覧に戻る</a>
	</c:param>
</c:import>