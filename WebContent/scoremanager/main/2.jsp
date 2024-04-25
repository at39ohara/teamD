<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>
	<c:param name="content">
		<!-- スタイルやスクリプトのリンクが必要な場合はここに追加 -->
		</head>
		<body>
			<h2>科目管理</h2>
			<a href="SubjectCreate.action">新規登録</a>
			<!-- 科目登録画面に遷移するリンク -->

			<table>
				<tr>
					<th>科目コード</th>
					<!-- 一覧のヘッダ(固定値) -->
					<th>科目名</th>
					<!-- 一覧のヘッダ(固定値) -->
				</tr>
				<!-- ログインユーザの学校コードに紐づく科目情報を一覧表示する -->
				<c:forEach var="subject" items="${subjects}">
					<tr>
						<td>${subject.cd}</td>
						<!-- 科目テーブルの「科目コード」カラムの値を表示する -->
						<td>${subject.name}</td>
						<!-- 科目テーブルの「科目名」カラムの値を表示する -->
						<td><a href="editSubject.action?code=${subject.cd}">変更</a></td>
						<!-- 科目変更画面に遷移するリンク -->
						<td><a href="deleteSubject.action?code=${subject.cd}">削除</a></td>
						<!-- 科目削除画面に遷移するリンク -->
					</tr>
				</c:forEach>
			</table>
		</body>
		</html>
		</section>
	</c:param>
</c:import>