<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>
	<c:param name="content">

			<div class="container">
			<%-- 見出し --%>
				<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生情報変更</h2>
				<form action="StudentUpdateExecute.action" method="post">
					<%-- 入学年度 --%>
					<p>入学年度 <br> ${student.getEntYear()}</p>
					<input type="hidden" name="entYear"  value="${student.getEntYear()}" />

					<%-- 学生番号 --%>
					<label class="form-label">学生番号<br>${student.getNo()}</label>
					<input type="hidden" name="student_no" value="${student.getNo()}" />
					<br>

					<%-- 氏名 --%>
					<label class="form-label" for="name">氏名</label><br>
					<input type="text" id="name" name="name" value="${student.getName()}" required />
					<br>

					<%-- クラス --%>
					<label class="form-label" for="student-f2-select">クラス</label>
					<select class="form-select" id="student-f2-select" name="classNum">
						<c:forEach var="num" items="${class_num_set}">
							<option value="${num}"
								<c:if test="${num eq student.getClassNum()}">selected</c:if>>${num}</option>
						</c:forEach>
					</select>
					<br>

					<%-- 在学中ボタン --%>
					<label class="form-label">在学中</label>
					<input type="checkbox"	name="attend" value="true" ${student.isAttend() ? 'checked' : ''} />
					<br>

					<%-- 変更する確定ボタン --%>
					<button type="submit" class="btn btn-primary">変更する</button>
					<br>

					<%-- 戻るボタン --%>
					<br>
					<a href="StudentList.action">戻る</a>
					<br>
				</form>
			</div>
		</body>
	</c:param>
</c:import>