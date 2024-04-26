[14:47] 玉岡　叶多
package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import bean.Subject;

import bean.Teacher;

import dao.SubjectDAO;

import tool.Action;

public class SubjectListAction extends Action {

	// オーバーライド

	@Override

	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		Teacher teacher = (Teacher) session.getAttribute("user");

		// 科目リスト

		List<Subject> subjects = null;

		// 科目Dao

		SubjectDAO sDao = new SubjectDAO();

		// 全件取得

		subjects = sDao.filter(teacher.getSchool());

		// レスポンス値をセット

		request.setAttribute("subjects", subjects);

		// JSPへフォワード

		request.getRequestDispatcher("subject_list.jsp").forward(request, response);

	}

}
[14:48] 玉岡　叶多
<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/common/base.jsp">

	<c:param name="title">得点管理システム</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">

		<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">メニュー</h2>

		<div class="container">

			<div class="row justify-content-center">

				<div

					class="col d-flex align-items-center justify-content-center mx-2 rounded shadow"

					style="height: 10rem; background-color: #dbb;">

					<a href="StudentList.action" class="mx-2">学生管理</a>

				</div>

				<div

					class="col d-flex flex-column align-items-center justify-content-center mx-2 rounded shadow"

					style="height: 10rem; background-color: #c8e6c9;">

					<span class="mx-2">成績管理</span> <a href="GradeRegistration.action"

						class="mx-2">成績登録</a> <a href="test_list_student.jsp" class="mx-2">成績参照</a>

				</div>

				<div

					class="col d-flex align-items-center justify-content-center mx-2 rounded shadow"

					style="height: 10rem; background-color: #dbcdf0;">

					<a href="SubjectList.action" class="mx-2">科目管理</a>

				</div>

			</div>

		</div>

	</c:param>

</c:import>